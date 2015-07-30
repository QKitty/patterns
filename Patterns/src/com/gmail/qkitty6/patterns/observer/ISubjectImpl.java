/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Base implementation of the ISubject interface. Compose this class with your
 * own to add the functionality for the ISubject interface to any class you
 * create.
 * @author rtucker
 */
public class ISubjectImpl implements ISubject {

    /**
     * A set of observers that are 'watching' this subject object
     */
    protected Set<IObserver> observers;

    @Override
    public boolean registerObserver(IObserver o) {
        boolean result = false;
        if (null != o) {
            if (null == this.observers) {
                this.observers = new HashSet<>();
            }
            //This check ensures an observer can only be added once!
            if (!this.observers.contains(o)) {
                result = this.observers.add(o);
            } else {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean removeObserver(IObserver o) {
        boolean result = false;
        if (null != o) {
            if (null != this.observers) {
                if (this.observers.contains(o)) {
                    result = this.observers.remove(o);
                    //If the observer list is empty save memory by freeing the unused variable
                    if (0 == this.observers.size()) {
                        this.observers = null;
                    }
                } else {
                    result = true;
                }
            } else {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void notifyObservers() {
        if (null != this.observers) {
            this.observers.stream().forEach((IObserver currObserver) -> {
                currObserver.update();
            });
        }
    }

    @Override
    public <T> void notifyObservers(T data) {
        if (null != this.observers) {
            this.observers.stream().forEach((IObserver currObserver) -> {
                currObserver.update(data);
            });
        }
    }

    @Override
    public Set<IObserver> removeAllObservers() {
        HashSet<IObserver> arlResult = new HashSet<>();
        if (null != this.observers) {
            observers.stream().map((currObserver) -> {
                arlResult.add(currObserver);
                return currObserver;
            }).forEach((currObserver) -> {
                observers.remove(currObserver);
            });
            if (0 == this.observers.size()) {
                this.observers = null;
            }
        }
        return arlResult;
    }

    @Override
    public boolean registerObserver(Collection<? extends IObserver> observerCollection) {
        boolean result = false;
        if (null == this.observers) {
            this.observers = new HashSet<>();
        }
        if (null != observerCollection && 0 < observerCollection.size()) {
            observerCollection.stream().forEach((currObserver) -> {
                this.registerObserver(currObserver);
            });
            if (this.observers.containsAll(observerCollection)) {
                result = true;
            }
        }
        return result;
    }

}
