(ns mincer.xml.tree-test
  (:require [clojure.test :refer :all]
            [mincer.xml.tree-test-data :refer :all]
            [mincer.xml.tree :refer :all]))

(def result-module {:type :module
                    :name "Logik I"
                    :id "29381"
                    :pordnr "29381"
                    :mandatory true})

(def result-module-2 {:type :module
                    :name "Grundlagen"
                    :id "29380"
                    :pordnr "29380"
                    :mandatory false})

(def result-level {:type :level :min 4 :max 6 :name  "Basiswahlpflichtmodule"
                   :tm nil
                   :art nil
                   :children [
                              {:type :level
                               :min 1
                               :max 2
                               :name  "Theoretische Philosophie"
                               :tm  nil
                               :art nil
                               :children [result-module]}
                              {:type :level
                               :min 1
                               :max 2
                               :name "Praktische Philosophie"
                               :tm "TM"
                               :art nil
                               :children [result-module result-module-2]
                               }
                              {:type :level
                               :min 2
                               :max 4
                               :name "Geschichte der Philosophie"
                               :tm nil
                               :art "ART"
                               :children [result-module]}
                              ]})

(def result-course {"phiH2011" {:type :course
                    :degree "bk"
                    :kzfa "H"
                    :name "Kernfach Philosophie"
                    :po "2011"
                    :course "phi"
                    :children [result-level]}})

(deftest test-parse-m-tag
  (is (= result-module (parse-tree m-tag)))
  (is (= result-module-2 (parse-tree m-tag-2))))


(deftest test-parse-l-tag (is (= (parse-tree nested-l-tag) result-level)))
(deftest test-parse-b-tag (is (= (parse-tree b-tag) result-course)))
(deftest test-parse-modulbaum (is (= (parse-tree modulbaum-tag)
                                    ; result is a dict of the merged dicts for each course
                                     result-course)))
(deftest test-ignored-tags-in-b
  (let [course (parse-tree b-tag-with-regeln)
        children (:children (get course "phiH2011"))]
    (is (= 1 (count children)))
    (is (not-any? nil? children))))
