package com.solvd.zoo.interfaces;

@FunctionalInterface
public interface ICompareAttributes<T> {
    int compare(T a, T b);
}