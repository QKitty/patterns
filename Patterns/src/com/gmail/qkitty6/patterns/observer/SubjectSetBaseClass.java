/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * This class should be extended to create your own classes that support the
 ISubjectSet interface functionality allowing them to act as "subjects" of an
 observer object. 
 * Alternatively if you cannot extend this class but require the functionality
 you should compose an instance of this class with your class. Have your class
 implement the ISubjectSet interface but delegate all method calls to an
 instance of this class.
 * @author Qkitty
 */
public class SubjectSetBaseClass implements ISubjectSet {
    
    /**
     * Instance of the basic ISubjectSet implementation. The subjectBaseClass
 delegates functionality to this implementation for the methods of the
 ISubjectSet interface. This composes the subject base class with the 
 provided ISubjectSet implementation class.
     */
    protected ISubjectSet observers;
    
    /**
     * Creates a default implementation with the ISubjectSet implementation class
 providing support for the ISubjectSet interface.
     */
    public SubjectSetBaseClass(){
        observers = new ISubjectSetImpl();
    }
    
    /**
     * Creates a SubjectBaseClass where the implementation to use for the 
 ISubjectSet interface is provided by the user
     * @param aISubjectImplementation - A class that provides a concrete implementation 
 of the ISubjectSet interface. This implementation will be used by the created
 SubjectBaseClass object rather than the default implementation.
     */
    public SubjectSetBaseClass(ISubjectSet aISubjectImplementation){
        observers = aISubjectImplementation;
    }

    @Override
    public boolean registerObserver(IObserver o) {
        return this.observers.registerObserver(o);
    }

    @Override
    public boolean removeObserver(IObserver o) {
        return this.observers.removeObserver(o);
    }

    @Override
    public void notifyObservers() {
        this.observers.notifyObservers();
    }
    
    @Override
    public <T> void notifyObservers(T data) {
        this.observers.notifyObservers(data);
    }

    @Override
    public Set<IObserver> removeAllObservers() {
        return this.observers.removeAllObservers();
    }

    @Override
    public boolean registerObserver(Collection<? extends IObserver> observerCollection) {
        return this.observers.registerObserver(observerCollection);
    }

    @Override
    public int size() {
        return this.observers.size();
    }

    @Override
    public boolean isEmpty() {
        return this.observers.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.observers.contains(o);
    }

    @Override
    public Iterator<IObserver> iterator() {
        return this.observers.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.observers.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[])this.observers.toArray(a);
    }

    @Override
    public boolean add(IObserver e) {
        return this.observers.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return this.observers.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.observers.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends IObserver> c) {
        return this.observers.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.observers.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.observers.removeAll(c);
    }

    @Override
    public void clear() {
        this.observers.clear();
    }
}
