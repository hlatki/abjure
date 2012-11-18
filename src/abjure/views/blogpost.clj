(ns abjure.views.blogpost
  (:use [noir.core])
  (:require [abjure.models.blog :as blog]
            [abjure.views.common :as common]))

;; Page structure 

(defpartial single-post [{:keys [title author date content]}]
            [:div 
             [:h2 title]
             [:span.author author]
             [:span.date date]
             [:p.blogpost content]])



(defpage "/posts/:item" {:keys [item]}
         (common/layout 
           (single-post (blog/process-post-files item))))
;; (let [json (f/get-json-file "/home/hannah/t.json")
;;     title (json :title)
;;      author (json :author)
;;     date (json :date)
;;       content (f/get-md-file "/home/hannah/t.md")]
;;      (common/layout 
;;     (single-post [{:title "title" :author "author" :date "date"}])))
