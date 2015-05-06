/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

import java.lang.reflect.InvocationTargetException;

/**
 * This interface may be used to create a class that can convert other classes
 * to an observable subject. It provides a means to access the converted object
 * in its original form.
 * @author Roy
 * @param <T> Any object to be wrapped with support for observing it
 */
public interface ISubjectWrapper<T> extends ISubject {

    /**
     * Accessor to retrieve the base object that has been wrapped to provide
     * support as an observable subject
     * @return - T the original object wrapped to add support as an observable 
     * subject
     */
    T getWrappedObject();
    
    /**
     * Use this method to invoke a method of the wrapped object and trigger a call
     * to any observers update() method after the method completes.
     * 
     * NOTE: The method signature may not contain any arguments which are primitive
     * data types or this method will fail throwing a NoSuchMethodException. This
     * is due to a bug in the java framework see http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6176992
     * and http://stackoverflow.com/questions/1894740/any-solution-for-class-getmethod-reflection-and-autoboxing
     * 
     * @param methodName - String being the name of the method to invoke
     * @param args - A comma seperated list of arguments that match the requested methods signature
     * @return - An Object of the type returned by the requested method (may be Void)
     * @throws NoSuchMethodException - if a matching method is not found or if the name is "init" or "clinit".
     * @throws NullPointerException - if name is null
     * @throws SecurityException - If a security manager, s, is present and the 
     * caller's class loader is not the same as or an ancestor of the class loader 
     * for the current class and invocation of s.checkPackageAccess() denies 
     * access to the package of this class.
     * @throws IllegalAccessException - if this Method object is enforcing Java 
     * language access control and the underlying method is inaccessible.
     * @throws InvocationTargetException - if the underlying method throws an exception.
     */
    Object invoke(String methodName, Object... args) throws NoSuchMethodException, NullPointerException, SecurityException, IllegalAccessException, InvocationTargetException;
    
}
