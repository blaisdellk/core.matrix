(ns core.matrix.operators
  (:require [core.matrix :as m])
  (:refer-clojure :exclude [* - + / vector?]))

;; =====================================================================
;; Mathematical operators defined for matrices and vectors as applicable

(defn *
  "Matrix multiply operator"
  ([a] a)
  ([a b]
    (m/mul a b))
  ([a b & more]
    (reduce m/mul (m/mul a b) more)))

(defn +
  "Matrix addition operator"
  ([a] a)
  ([a b]
    (if (and (number? a) (number? b))
      (clojure.core/+ a b)
      (m/add a b)))
  ([a b & more]
    (reduce + (+ a b) more)))

(defn -
  "Matrix subtraction operator"
  ([a] a)
  ([a b]
    (if (and (number? a) (number? b))
      (clojure.core/- a b)
      (m/sub a b)))
  ([a b & more]
    (reduce - (- a b) more)))

(defn vector?
  "Returns true if parameter is a vector (1 dimensional column matrix or equivalent"
  ([m]
    (m/is-vector? m)))

