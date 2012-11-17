(ns abjure.models.blog
  (:require [markdown :as md]
            [cheshire.core :as json]))

(defn get-md-file [filename]
  (md/md-to-html-string (slurp filename)))

(defn get-json-file [filename]
  (json/parse-string (slurp filename) true))
