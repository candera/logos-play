(use 'clojure.core.logic.minikanren)

(run* [q] u#)                           ;10 => ()
(run* [q] (== true q))                  ;11 => (true)
(run* [q] u# (== true q))               ;12 => ()
(run* [q] s# (== true q))               ;13 => (true)
(run* [r] s# (== 'corn r))              ;14 => (corn)
(== false true)
(run* [r] (==  3 4))                    ;   => ()
(run* [r] (== 1 1))                     ;   => (_.0)
(run 3 [r] (== 1 1))                    ;   => (_.0)
(s#)
(== 4 3)

(run* [q]
      (let [x false]
        (== true x)))                   ;22 => ()

(run* [q]
      (exist [x]
             (== true x)
             (== true q)))              ;23 => (true)

;;; Because the outermost x is the one we're trying to figure out
;;; bindings for, and it's different from the other two x's
(run* [x]
      (let [x false]
        (exist [x]
               (== true x))))           ;29 => (_.0)

(run* [x]
      (conde
       ((== 'olive x) s#)
       ((== 'oil x) s#)
       (:else u#)))                     ;47 => (olive oil)

(run* [x]
     (conde
      ((== 'virgin x) u#)
      ((== 'olive x) s#)
      (s# s#)
      ((== 'oil x) s#)))                ;50 => (olive _.0 oil)


