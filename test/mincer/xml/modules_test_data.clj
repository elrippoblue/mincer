(ns mincer.xml.modules-test-data)
; cmu/modules data
(def abstract-unit {:attrs {:id "P-IAA-L-BMLS1a"
                      :semester "1,2"
                      :title "Grammar 1 (Übung)"
                      :type "m"}
              :content nil
              :tag :abstract-unit})

(def module {:attrs {:elective-units "4"
                     :id "P-IAA-M-BMLS1"
                     :title "Module Language Skills 1"
                     :pordnr "1"
                     :type "m"}
             :content [abstract-unit]
             :tag :module})

(def module2 {:attrs {:elective-units "4"
                     :id "P-IAA-M-BMLS1"
                     :title "Module Language Skills 1"
                     :type "m"}
             :content [abstract-unit]
             :tag :module})

(def module3 {:attrs {:elective-units "4"
                     :id "P-IAA-M-BMLS1"
                     :title "Module Language Skills II"
                     :pordnr "3"
                     :type "m"}
             :content [abstract-unit]
             :tag :module})

(def modules {:attrs nil :content  [module module3 module3] :tag :modules})

(def course {:attrs  {:id "ba-aua-KF-2013"
                      :title "Bachelor Anglistik und Amerikanistik Kernfach PO 2013"}
             :content  [modules]
             :tag :course})

(def cmu {:attrs nil :content  [course] :tag :course-module-units})


; units/groups/sessions data

(def session {:attrs {:day "tue" :duration "2" :rhythm "0" :time "1"}
              :content nil
              :tag :session})

(def session2 {:attrs {:day "mon" :duration "1" :rhythm "2" :time "3"}
              :content nil
              :tag :session})

(def group {:attrs nil :content  [session session2] :tag :group})

(def abstract-unit-ref  {:attrs  {:id "P-Phil-L-BPPKb"} :content nil :tag :abstract-unit})

(def unit {:attrs  {:id "120281"
                    :semester "1,3,5"
                    :title "Aristoteles: Politik (Basisseminar)"}
            :content  [group abstract-unit-ref]
            :tag :unit})
