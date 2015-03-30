/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

/**
 * This interface represents the abstract concept of an observer that can
 * 'watch' a subject and receive notification of updates / state changes
 * in the observed subject object
 * @author Qkitty
 * @param <T> Any type of object used to parameterise the call to update
 */
public interface IObserver <T> {
    
    /**
     * This method executes when the object receives a notification that the observed
     * subjects state has changed. Override this method to respond to an update.
     */
    default void update()
    {
    }
    
    /**
     * This method executes when the object receives a notification that the observed
     * subjects state has changed. This update accepts an object that should
     * contain data about the changes in the subjects state. Override this method
     * to respond to an update.
     * @param data
     */
    default void update(T data)
    {
        this.update();
    }
    
}
