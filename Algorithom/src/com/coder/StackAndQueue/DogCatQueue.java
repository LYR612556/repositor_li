package com.coder.StackAndQueue;

import com.source.Cat;
import com.source.Dog;
import com.source.Pet;
import com.source.PetEnterQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列,包装类添加时间戳
 * created by liyurong
 **/
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;//用于按插入顺序保存狗的信息
    private Queue<PetEnterQueue> catQ;//用于按插入顺序保存猫的信息
    private long count;//时间戳，用于表示插入的时间
    public DogCatQueue(){
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }
    public void add(Pet pet){
        if (pet.getPetType().equals("dog")){
            this.dogQ.offer(new PetEnterQueue(pet,this.count ++));
        }else if (pet.getPetType().equals("cat")){
            this.catQ.offer(new PetEnterQueue(pet,this.count ++));
        }else {
            throw new RuntimeException("err,not dog or cat");
        }
    }
    public Pet pollAll(){
        if (! this.dogQ.isEmpty() && ! this.catQ.isEmpty()){
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                return this.dogQ.poll().getPet();
            }else {
                return this.catQ.poll().getPet();
            }
        }else if (! this.dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }else if (! this.catQ.isEmpty()){
            return this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("err,queue id empty!");
        }
    }
    public Dog pollDog(){
        if (! this.isDogQueueEmpty()){
            return (Dog) this.dogQ.poll().getPet();
        }else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }
    public Cat pollCat(){
        if (! this.isDogQueueEmpty()){
            return (Cat) this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("cat queue is Empty!");
        }
    }
    public boolean isEmpty(){
        return this.catQ.isEmpty() && this.dogQ.isEmpty();
    }
    public boolean isDogQueueEmpty(){
        return this.dogQ.isEmpty();
    }
    public boolean isCatQueueEmpty(){
        return this.catQ.isEmpty();
    }
}