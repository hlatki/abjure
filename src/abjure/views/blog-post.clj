(ns abjure.views.blog-post
  (:use noir-core
        hiccup.core
        hiccup.page-helpers))

;; Page structure 

(defpartial single-post [{:keys [title author date body]}]
  ([:h1 title]
   [:div.author "by " author]
   [:div.datetime "on " date]
   [:div.conteny body]))  
