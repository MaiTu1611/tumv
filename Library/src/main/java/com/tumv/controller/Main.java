package com.tumv.controller;

public class Main {

    static void main(String[] args) {
        GenericMethod<String, String> genericMethod = new GenericMethod<String, String>("fst", "snd");
        GenericMethod<String, Integer> genericMethod2 = new GenericMethod<String, Integer>("fst", 2018);
        GenericMethod<Integer, Integer> genericMethod3 = new GenericMethod<Integer, Integer>(0254, 2018);
        genericMethod.print();
        genericMethod2.print();
        genericMethod3.print();
    }
}
