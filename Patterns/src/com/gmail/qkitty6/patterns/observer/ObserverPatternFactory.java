/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

/**
 * This factory creates objects that can be either observers, the subject of 
 * an observer or both. It should be used to add the observer pattern to your
 * own classes.
 * @author Roy
 */
public class ObserverPatternFactory {
    
    //Prevents insansiation of the class all factory methods should be static
    private ObserverPatternFactory(){
    }
    
    /**
     * Accepts any object as a parameter and creates an ISubjectWrapper that wraps
     * the provided object, decorates it with support for the ISubject interface,
     * provides a means to invoke the wrapped objects methods and get notifications
     * to update sent to any observers when the wrapped objects methods complete.
     * @param <T> - The type of object for which the ISubjectWrapper is required
     * @param targetObject - The Java Object to be wrapped
     * @return - An ISubjectWrapper interface to the wrapped object
     */
    public static <T> ISubjectWrapper<T> wrapObject(T targetObject){
        return new SubjectWrapper<>(targetObject);
    }
    
}
