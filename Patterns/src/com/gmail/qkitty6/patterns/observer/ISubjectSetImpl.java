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

/**
 * Concrete implementation of the ISubjectSet interface. Every call to notify
 * observers will generate a call to the update method of each registered 
 * observer. 
 * @author Roy
 */
public class ISubjectSetImpl extends ISubjectImpl implements ISubjectSet {

    @Override
    public int size() {
        int result = 0;
        if (null != this.observers) {
            result = this.observers.size();
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        boolean result = true;
        if (null != this.observers) {
            result = this.observers.isEmpty();
        }
        return result;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        if (null != this.observers) {
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
        if (null != this.observers) {
            result = this.observers.toArray();
        } else {
            result = new Object[0];
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] result;
        if(null != a && this.observers.size() >= a.length){
            Iterator<IObserver> iterator = this.observers.iterator();
            int i = 0;
            while(iterator.hasNext()){
                IObserver currObserver = iterator.next();
                a[i] = (T)currObserver;
                i++;
            }
            result = a;
        }else{
            result = (T[])this.createBackingList().toArray(new IObserver[this.observers.size()]);
        }
        return result;
    }

    @Override
    public boolean add(IObserver e) {
        return this.registerObserver(e);
    }

    @Override
    public boolean remove(Object o) {
        boolean result = false;
        if (null != this.observers && null != o) {
            if (o instanceof IObserver) {
                result = this.removeObserver((IObserver) o);
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = false;
        if (null != this.observers && null != c) {
            result = this.observers.containsAll(c);
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends IObserver> c) {
        boolean result = false;
        if (null != this.observers && null != c) {
            result = this.observers.addAll(c);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        if (null != this.observers && null != c) {
            result = this.observers.retainAll(c);
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        if (null != this.observers && null != c) {
            result = this.observers.removeAll(c);
        }
        return result;
    }

    @Override
    public void clear() {
        this.removeAllObservers();
    }

    private Set<IObserver> createBackingList() {
        Set<IObserver> result;
        if (null != this.observers) {
            result = new HashSet<>(this.observers);
        } else {
            result = new HashSet<>();
        }
        return result;
    }
}
