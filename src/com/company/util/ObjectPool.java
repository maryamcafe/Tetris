package com.company.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class ObjectPool<T> {

    private Set<T> available = new HashSet<>();
    private final List<T> inTheGame;

    public ObjectPool(List<T> inTheGame){
        this.inTheGame = inTheGame;
    }

    protected abstract T create();

    public synchronized T checkout(){
        if(available.isEmpty()){
            available.add(create());
        }
        Iterator<T> iterator = available.iterator();
        T instance = iterator.next();
        iterator.remove();
        synchronized (inTheGame){
            inTheGame.add(instance);
        }
        return instance;
    }

}
