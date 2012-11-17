(ns abjure.views.blogpost
  (:use [noir.core]))

;; Page structure 

(defpartial single-post [{:keys [title author date body]}]
  ([:h1 title]
   [:div.author "by " author]
   [:div.datetime "on " date]
   [:div.content body]))
