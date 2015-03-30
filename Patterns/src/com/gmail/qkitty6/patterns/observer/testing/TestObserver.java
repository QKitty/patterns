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
class TestObserver implements IObserver {

    @Override
    public void update() {
        System.out.println("An update was received");
    }

    @Override
    public void update(Object data) {
        System.out.println("A parametarised update was received");
    }
}
