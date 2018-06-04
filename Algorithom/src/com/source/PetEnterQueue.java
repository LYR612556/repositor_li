package com.source;

/**
 * 对Pet类进行封装，在不改变用户类的基础上添加时间戳
 * created by liyurong
 **/
public class PetEnterQueue {
    private Pet pet;
    private long count;
    public PetEnterQueue(Pet pet,long count){
        this.pet = pet;
        this.count = count;
    }
    public Pet getPet(){
        return this.pet;
    }
    public long getCount(){
        return this.count;
    }
    public String getEnterPetType(){
        return this.pet.getPetType();
    }
}