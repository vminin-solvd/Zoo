package com.solvd.zoo.interfaces;

import com.solvd.zoo.enums.ZooLocation;

@FunctionalInterface
public interface IUpdateZooLocation<T> {
    void update(T entity, ZooLocation attribute);
}