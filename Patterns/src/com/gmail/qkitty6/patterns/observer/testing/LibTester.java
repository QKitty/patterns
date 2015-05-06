/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer.testing;

import com.gmail.qkitty6.patterns.observer.IObserver;
import com.gmail.qkitty6.patterns.observer.ISubjectWrapper;
import com.gmail.qkitty6.patterns.observer.ObserverPatternFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Qkitty
 */
class LibTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IObserver observer = new TestObserver();
        TestSubject subject = new TestSubject();
        subject.add(observer);
        subject.notifyObservers();
        subject.notifyObservers(null);
        
        System.out.println("Test 1 Complete");
        
        System.out.println("Test 2 Start - Wrapping a person & calling wrapped method");
        
        TestPerson aPerson = new TestPerson("Roy", "Tucker", 30);
        ISubjectWrapper<TestPerson> aWrappedPerson = ObserverPatternFactory.wrapObject(aPerson);
        aWrappedPerson.registerObserver(observer);
        System.out.println("Person data before update = " + aWrappedPerson.toString());
        try {
            aWrappedPerson.invoke("setNewDetails", "Alan", "Tucker", 42);
        } catch (NoSuchMethodException | NullPointerException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(LibTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Person data after update = " + aWrappedPerson.toString());
        
        System.out.println("Test 2 Complete");
    }
    
}
