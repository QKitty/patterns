/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * This interface must be implemented by any class (and therefore object) that 
 * will be the "subject" to be "observed" by another object. It provides the
 * basic ISubject methods but also supports the Set interface
 * @author Qkitty
 */
public interface ISubjectSet extends Set<IObserver>, Serializable {
    
    /**
     * This method registers a new observer with the subject. After this method 
     * completes successfully the newly registered object will receive notifications
     * to update when the state of this subject object is changed.
     * @param o - The object that needs to receive notification of changes to this
     * subjects state
     * @return - Boolean True if the provided object has been added to the list 
     * of observers and will receive notification when this subject changes state,
     * False otherwise.
     */
    boolean registerObserver(IObserver o);
    
    /**
     * This method removes an object from the list of objects receiving notification
     * of state changes to this subject object.
     * @param o - The object that no longer needs to receive notification of 
     * changes to this subjects state.
     * @return - Boolean True if this object will not receive notification of changes
     * to this subjects state, False otherwise.
     */
    boolean removeObserver(IObserver o);
    
    /**
     * This method informs all currently registered observers that this subject
     * has changed its state and they need to update as a result.
     */
    void notifyObservers();
    
    /**
     *This method informs all currently registered observers that this subject
     * has changed its state and they need to update as a result.
     * @param <T> Any type. This allows any object to be passed as a parameter
     * to this method
     * @param data An object to be used by each observers update(T data) method
     */
    <T> void notifyObservers(T data);
    
    /**
     * Removes all observers so that no observers are registered to receive
     * notifications of state changes in this subject
     * @return A List of the removed observers (maybe empty never NULL)
     */
    Set<IObserver> removeAllObservers();
    
    /**
     * Registers a list of observer objects as observers for this subject
     * @param observerCollection - A collection of IObserver objects to register
     * as observers
     * @return boolean True if all observers in the provided list are 'observing'
     * this subject, False otherwise
     */
    boolean registerObserver(Collection<? extends IObserver> observerCollection);
    
}
