/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

/**
 * This provides a base class that can be extended from or composed with your
 * own classes to create an object which is both an observer and a subject
 * @author Qkitty
 * @param <T>
 */
public class SubjectObserverBaseClass<T> extends SubjectBaseClass implements IObserver<T>{

    @Override
    public void update() {
        this.notifyObservers();
    }

    @Override
    public void update(T data) {
        this.notifyObservers(data);
    }
}
