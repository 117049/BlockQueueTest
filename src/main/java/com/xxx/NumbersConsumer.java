package com.xxx;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class NumbersConsumer implements Runnable {

    private BlockingQueue<Integer> queue;
    public NumbersConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Integer number = queue.take ();
                log.info ("消费者-{}号,消费-编号:{}", Thread.currentThread ().getId (), number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread ().interrupt ();
        }
    }
}
