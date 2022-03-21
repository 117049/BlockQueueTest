package com.xxx;


import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class NumbersProducer implements Runnable {

    private BlockingQueue<Integer> numbersQueue;
    public NumbersProducer(BlockingQueue<Integer> numbersQueue) {
        this.numbersQueue = numbersQueue;
    }
    @Override
    public void run() {
        try {
            generateNumbers ();
        } catch (InterruptedException e) {
            Thread.currentThread ().interrupt ();
        }
    }
    private void generateNumbers() throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            numbersQueue.add (i);
            log.info ("生产者-{}号,生产！", i);
        }
    }
}