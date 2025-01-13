(ns dnd-character-generator)

(def random-abilities [:strength :dexterity :charisma :wisdom :intelligence :constitution])

(defn- transform-character-test-case [test-case]
  (map
   (fn [ability]
     (assoc (update test-case :path #(conj % (name ability))) :ability ability)) random-abilities))

(defn- transform-test-case [test-case]
  (if (= "character" (:property test-case))
    (transform-character-test-case test-case)
    [test-case]))

(defn transform [test-cases]
  (mapcat #(transform-test-case %) test-cases))
