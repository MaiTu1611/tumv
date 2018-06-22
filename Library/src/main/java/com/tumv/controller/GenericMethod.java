package com.tumv.controller;

public class GenericMethod<T, S> {
    private T first;
    private S second;
    public GenericMethod (T fst, S snd) {
        this.first = fst;
        this.second = snd;
    }
    /**
     * @return the first
     */
    public T getFirst() {
        return first;
    }
    /**
     * @param first the first to set
     */
    public void setFirst(T first) {
        this.first = first;
    }
    /**
     * @return the second
     */
    public S getSecond() {
        return second;
    }
    /**
     * @param second the second to set
     */
    public void setSecond(S second) {
        this.second = second;
    }

    public void print() {
        System.out.println("first:" + this.first);
        System.out.println("second:" + this.second);
    }

}
