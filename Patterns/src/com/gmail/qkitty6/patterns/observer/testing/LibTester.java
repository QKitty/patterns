/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer.testing;

import com.gmail.qkitty6.patterns.observer.IObserver;

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
    }
    
}
