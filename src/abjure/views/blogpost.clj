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


