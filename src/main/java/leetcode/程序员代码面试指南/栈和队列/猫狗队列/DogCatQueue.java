package leetcode.程序员代码面试指南.栈和队列.猫狗队列;

import java.util.LinkedList;
import java.util.Queue;


public class DogCatQueue {
    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;

    public DogCatQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            dogQueue.add(new PetEnterQueue(pet, count++));
        } else if (pet.getPetType().equals("cat")) {
            catQueue.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("error, not dog or cat.");
        }
    }

    public Pet pollAll() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            throw new RuntimeException("error, queue is empty.");
        }
        if (dogQueue.isEmpty()) {
            return catQueue.poll().getPet();
        }

        if (catQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        }


        if (catQueue.peek().getCount() > dogQueue.peek().getCount()) {
            return dogQueue.poll().getPet();
        }
        return catQueue.poll().getPet();
    }

    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            throw new RuntimeException("Dog queue is emtpy");
        }
        return (Dog) dogQueue.poll().getPet();
    }

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            throw new RuntimeException("Cat queue is empty.");
        }

        return (Cat) catQueue.poll().getPet();
    }


    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return catQueue.isEmpty();
    }


    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Dog());
        while (!dogCatQueue.isCatQueueEmpty()) {
            System.out.println(dogCatQueue.pollCat());
        }

        while (!dogCatQueue.isDogQueueEmpty()) {
            System.out.println(dogCatQueue.pollDog());
        }

        while (!dogCatQueue.isEmpty()) {
            System.out.println(dogCatQueue.pollAll());
        }
    }
}
