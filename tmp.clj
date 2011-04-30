(use 'clojure.core.logic.minikanren)

(run* [q] u#)                           ;10 => ()
(run* [q] (== true q))                  ;11 => (true)
(run* [q] u# (== true q))               ;12 => ()
(run* [q] s# (== true q))               ;13 => (true)
(run* [r] s# (== 'corn r))              ;14 => (corn)
(== false true)

(s#)