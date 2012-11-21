(ns abjure.models.blog
  (:require [markdown :as md]
            [cheshire.core :as json])
  (:use [clojure.java.io]))

;; Utility for opening post related files.

(defn get-md-file [filename]
  (md/md-to-html-string (slurp filename)))

(defn get-json-file [filename]
  (json/parse-string (slurp filename) true))

;; this is for testing -- not sure what this should actually look like
(def blog-path "/home/hannah/")


(defn process-post-files [pname]
  "Takes a name from the route and converts the associated files to a map"
  (let [files (map #(str blog-path pname %) [".json" ".md"])
        meta-data (get-json-file (first files))
        content (get-md-file (second files))]
    (assoc meta-data :content content)))


;; On startup of the server, build up our data-model

(defn init-model [top-dir]
  (let [post-dir (str top-dir "/posts/")
        post-files (map #(.getName %) (.listFiles  (file post-dir)))
        json-files (filter #(re-matches #".*\.json" %) post-files)
        mapping {}]
    (loop [j-files json-files json-map mapping]
      (if (nil? (seq j-files))
        json-map
        (let [j-file (first j-files)
              post-name (clojure.string/replace j-file #"\.json" "")]
          (recur (rest j-files)
                 (assoc json-map
                    (keyword post-name)
                    (assoc (get-json-file (str post-dir j-file))
                           :name
                           post-name))))))))
