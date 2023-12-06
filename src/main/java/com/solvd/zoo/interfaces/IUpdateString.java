package com.solvd.zoo.interfaces;

@FunctionalInterface
public interface IUpdateString<T> {
    void update(T entity, String attribute);
}