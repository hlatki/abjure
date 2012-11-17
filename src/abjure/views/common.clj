(ns abjure.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "abjure"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))
