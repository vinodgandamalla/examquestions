(ns examquestions.core
  (:require-macros [secretary.core :refer [defroute]])
  (:require [goog.events :as events]
            [goog.dom :as dom]
            [goog.history.EventType :as EventType]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [secretary.core :as secretary]
            [reagent.core :as reagent :refer [atom render]])
  (:import goog.History))


(def questions [{:qn "Question1" :A 1 :B 2 :C 3 :D 4} {:qn "Question2" :A 11 :B 22 :C 33 :D 44} {:qn "Question3" :A 111 :B 222 :C 333 :D 444}])


;;GET        /salesagent/exam/new


(def response
  {
 "id" : "8b5642df-2cac-4a62-adc2-b242161a1325",
 "questions" : [
                {
                 "id" : 43,
                 "question" : "Question43",
                 "options" : [
                              "Option1",
                              "Option2",
                              "Option3",
                              "Option4"
                              ]
                 },
                {
                 "id" : 65,
                 "question" : "Question65",
                 "options" : [
                              "Option1",
                              "Option2",
                              "Option3",
                              "Option4"
                              ]
                 },
                {
                 "id" : 81,
                 "question" : "Question81",
                 "options" : [
                              "Option1",
                              "Option2",
                              "Option3",
                              "Option4"
                              ]
                 }
                ]
 })



(defn home2 []
  [:div.container
   [:div.form-group
    [:div.row [:h1 [:label "Generic Test"]]]
    (for [x (:questions response)]
      [:div
       [:div.row (:question x)]
       [:div.row
        (let [[A B C D] (:options x)]
          [:div.col-md-3 [:input {:type "radio" :name "options" } A]]
          [:div.col-md-3 [:input {:type "radio" :name "options" } B]]
          [:div.col-md-3 [:input {:type "radio" :name "options"} C]]
          [:div.col-md-3 [:input {:type "radio" :name "options"} D]])]])]])


(defn home1 []
  [:div.container
   [:div.form-group
    [:div.row [:h1 [:label "Generic Test"]]]
    (for [x questions]
      [:div
      [:div.row (:qn x)]
      [:div.row
       [:div.col-md-3  [:input {:type "radio" :value "A." :name "q1"} (:A x)]]
       [:div.col-md-3  [:input {:type "radio" :value "B." :name "q1"} (:B x)]]
       [:div.col-md-3  [:input {:type "radio" :value "C." :name "q1"} (:C x)]]
       [:div.col-md-3  [:input {:type "radio" :value "D." :name "q1"} (:D x)]]]])]])





(reagent/render-component [home2]
                          (.getElementById js/document "app"))
