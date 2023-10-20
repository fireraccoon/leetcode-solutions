// @algorithm @lc id=100228 lang=java 
// @title animal-shelter-lcci
package _____03_06_Animal_Shelter_LCCI;
import java.util.LinkedList;
import java.util.Queue;

class AnimalShelf {

    int day = 0;

    Queue<AnimalWithBirthday> queueForCats = new LinkedList<>();

    Queue<AnimalWithBirthday> queueForDogs = new LinkedList<>();

    public AnimalShelf() {

    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            queueForCats.offer(new AnimalWithBirthday(animal[0], day++));
        } else {
            queueForDogs.offer(new AnimalWithBirthday(animal[0], day++));
        }
    }

    public int[] dequeueAny() {
        if (queueForCats.isEmpty()) {
            return dequeueDog();
        }
        if (queueForDogs.isEmpty()) {
            return dequeueCat();
        }
        if (queueForCats.peek().birthday < queueForDogs.peek().birthday) {
            return dequeueCat();
        } else {
            return dequeueDog();
        }
    }

    public int[] dequeueDog() {
        if (queueForDogs.isEmpty()) {
            return new int[] { -1, -1 };
        }
        return new int[] { queueForDogs.poll().id, 1 };
    }

    public int[] dequeueCat() {
        if (queueForCats.isEmpty()) {
            return new int[] { -1, -1 };
        }
        return new int[] { queueForCats.poll().id, 0 };
    }

    private class AnimalWithBirthday {

        public int id, birthday;

        public AnimalWithBirthday(int id, int birthday) {
            this.id = id;
            this.birthday = birthday;
        }
    }
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */