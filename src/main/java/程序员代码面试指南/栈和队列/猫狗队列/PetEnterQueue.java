package 程序员代码面试指南.栈和队列.猫狗队列;


public class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType() {
        return pet.getPetType();
    }
}