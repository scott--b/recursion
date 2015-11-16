(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll) (product (rest coll)))))

(defn singleton? [coll]
  (and (not (nil? (first coll))) (empty? (rest coll))))

(defn my-last [coll]
  (let [remaining (rest coll)]
    (if (empty? remaining)
        (first coll)
        (my-last remaining))))

(defn max-element [a-seq]
  (let [cur (first a-seq) remaining (rest a-seq)]
    (if (empty? remaining)
        cur
        (max cur (max-element remaining)))))

(defn seq-max [seq-1 seq-2]
  (if (> (count seq-1) (count seq-2))
    seq-1
    seq-2))

(defn longest-sequence [a-seq]
  (if (empty? a-seq)
      nil
      (seq-max (first a-seq)
               (longest-sequence (rest a-seq)))))

(defn my-filter [pred? a-seq]
  (let [cur (first a-seq) remaining (rest a-seq)]
    (if (empty? a-seq)
      '()
      (if (pred? cur)
          (cons cur (my-filter pred? remaining))
          (my-filter pred? remaining)))))

(defn sequence-contains? [elem a-seq]
  (cond (empty? a-seq) false
        (= elem (first a-seq)) true
        :else (sequence-contains? elem (rest a-seq))))

(defn my-take-while [pred? a-seq]
  (let [cur (first a-seq)]
    (if (empty? a-seq)
        '()
        (if (pred? cur)
            (cons cur (my-take-while pred? (rest a-seq)))
            '()))))

(defn my-drop-while [pred? a-seq]
  (if (empty? a-seq)
      '()
      (if (not (pred? (first a-seq)))
          (sequence a-seq)
          (my-drop-while pred? (rest a-seq)))))

(defn seq= [a-seq b-seq]
  (cond
     (and (empty? a-seq) (empty? b-seq)) true
     (or (empty? a-seq) (empty? b-seq)) false
     (not= (first a-seq) (first b-seq)) false
     :else (seq= (rest a-seq) (rest b-seq))))

(defn my-map [f seq-1 seq-2]
  (if
     (or (empty? seq-1) (empty? seq-2))
     '()
     (cons (f (first seq-1) (first seq-2)) (my-map f (rest seq-1) (rest seq-2)))))

(defn power [n k]
  (if (= 0 k )
      1
      (* n (power n (dec k)))))

(defn fib [n]
  (cond
     (= 0 n) 0
     (= 1 n) 1
     :else (+ (fib (dec n)) (fib (- n 2)))))

(defn my-repeat [how-many-times what-to-repeat]
  (if (<= how-many-times 0)
      '()
      (cons what-to-repeat (my-repeat (dec how-many-times) what-to-repeat))))

(defn my-range [up-to]
  (if (<= up-to 0)
      '()
       (cons (dec up-to) (my-range (dec up-to)))))

(defn tails [a-seq]
  (if (empty? a-seq)
      (cons '() '())
      (cons (seq a-seq) (tails (rest a-seq)))))

(defn inits [a-seq]
   (reverse (map reverse (tails (reverse a-seq)))))

(defn rotations [a-seq]
   (seq (set (map concat (tails a-seq) (inits a-seq)))))

(defn my-frequencies-helper [freqs a-seq]
  (if (empty? a-seq)
      freqs
      (let [cur (first a-seq)
        cnt (get freqs cur)
        new-cnt (inc (if cnt
                         cnt
                         0))]
        (my-frequencies-helper (assoc freqs cur new-cnt) (rest a-seq)))))

(defn my-frequencies [a-seq]
  (my-frequencies-helper {} a-seq))

(defn un-frequencies [a-map]
  (if (empty? a-map)
    {}
    (let [cur (first a-map)]
      (concat (repeat (second cur) (first cur)) (un-frequencies (rest a-map)))
  )))

(defn my-take [n coll]
  [:-])

(defn my-drop [n coll]
  [:-])

(defn halve [a-seq]
  [:-])

(defn seq-merge [a-seq b-seq]
  [:-])

(defn merge-sort [a-seq]
  [:-])

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])

