package com.source;

/**
 * 猫狗队列的父类
 * created by liyurong
 **/
public class Pet {
    private String type;
    public Pet(String type){
        this.type = type;
    }
    public String getPetType(){
        return this.type;
    }
}