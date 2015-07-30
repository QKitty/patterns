/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * Concrete implementation of the ISubjectWrapper interface allowing any object
 * to be converted into an observable subject.
 *
 * @author Roy
 */
class SubjectWrapper<T> extends SubjectSetBaseClass implements ISubjectWrapper<T> {

    private final T wrappedObject;

    public SubjectWrapper(T target) {
        this.wrappedObject = target;
    }

    @Override
    public final T getWrappedObject() {
        return wrappedObject;
    }

    @Override
    public Object invoke(String methodName, Object... args) throws NoSuchMethodException, NullPointerException, SecurityException, IllegalAccessException, InvocationTargetException {
        Class<? extends Object> myClass = this.wrappedObject.getClass();
        Class<? extends Object>[] paramTypes;
        Method method;
        if (null != args) {
            paramTypes = this.generateClassArray(args);
            method = myClass.getMethod(methodName, paramTypes);
        } else {
            method = myClass.getMethod(methodName);
        }

        Object result = method.invoke(this.wrappedObject, args);
        this.notifyObservers();
        return result;
    }

    @Override
    public String toString() {
        return this.wrappedObject.toString();
    }
    
    //This method generates an array of class types from an array of objects
    private Class<?>[] generateClassArray(Object[] params) {
        Class<?>[] result = null;
        if (null != params && 0 < params.length) {
            result = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                Object currObject = params[i];
                result[i] = currObject.getClass();
            }
        }
        return result;
    }
}
