(ns abjure.models.blog
  (:require [markdown :as md]
            [cheshire.core :as json]))

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
