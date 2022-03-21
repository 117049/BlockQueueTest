package com.xxx;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        for (int i = 0; i < 1; i++) {
            new Thread(new NumbersProducer(queue)).start();
        }

        for (int j = 0; j < 1; j++) {
            new Thread(new NumbersConsumer(queue)).start();
        }
    }
}