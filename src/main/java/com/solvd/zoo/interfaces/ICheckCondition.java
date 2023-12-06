package com.solvd.zoo.interfaces;

@FunctionalInterface
public interface ICheckCondition<T> {
    boolean check(T candidate);
}