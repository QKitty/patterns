/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

/**
 * This provides a base class that can be extended from or composed with your
 * own classes to create an object which is both an observer and a subject.
 * Useful for building data models where a change in one part of the model
 * notifies higher levels of the model to update
 * @author Qkitty
 * @param <T> - A data type that may be passed to the update method of an observer
 * Useful to pass details of the changes made.
 */
public class SubjectObserverBaseClass<T> extends SubjectSetBaseClass implements IObserver<T>{

    @Override
    public void update() {
        this.notifyObservers();
    }

    @Override
    public void update(T data) {
        this.notifyObservers(data);
    }
}
