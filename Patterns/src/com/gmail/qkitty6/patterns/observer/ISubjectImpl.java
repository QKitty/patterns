/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class ISubjectImpl implements ISubject {
    
    private Set<IObserver> observers;

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
            for (IObserver currObserver : observers) {
                arlResult.add(currObserver);
                observers.remove(currObserver);
            }
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
            for (IObserver currObserver : observerCollection) {
                this.registerObserver(currObserver);
            }
            if (this.observers.containsAll(observerCollection)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int size() {
        int result = 0;
        if(null != this.observers){
            result = this.observers.size();
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        boolean result = true;
        if(null != this.observers){
            result = this.observers.isEmpty();
        }
        return result;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        if(null != this.observers){
            result = this.observers.contains(o);
        }
        return result;
    }

    @Override
    public Iterator<IObserver> iterator() {
        return this.createBackingList().iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] result;
        if(null != this.observers){
            result = this.observers.toArray();
        } else {
            result = new Object[0];
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.createBackingList().toArray(a);
    }

    @Override
    public boolean add(IObserver e) {
        return this.registerObserver(e);
    }

    @Override
    public boolean remove(Object o) {
        boolean result = false;
        if(null != this.observers && null != o){
            if(o instanceof IObserver){
                result = this.removeObserver((IObserver)o);
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = false;
        if(null != this.observers && null != c){
            result = this.observers.containsAll(c);
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends IObserver> c) {
        boolean result = false;
        if(null != this.observers && null != c){
            result = this.observers.addAll(c);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        if(null != this.observers && null != c){
            result = this.observers.retainAll(c);
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        if(null != this.observers && null != c){
            result = this.observers.removeAll(c);
        }
        return result;
    }

    @Override
    public void clear() {
        this.removeAllObservers();
    }
    
    private Set<IObserver> createBackingList(){
        Set<IObserver> result;
        if(null != this.observers){
            result = new HashSet<>(this);
        }else{
            result = new HashSet<>();
        }
        return result;
    }

    
    
}
