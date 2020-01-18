package io.github.ahenteti.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Storage implementation based java.util.concurrent.ArrayBlockingQueue implementation
 */
public class StorageImpl<E> implements Storage<E> {

    private final Queue<E> queue;
    private final Lock lock;
    private final int maxSize;
    private final Condition notFull;
    private final Condition notEmpty;

    public StorageImpl(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
        this.lock = new ReentrantLock(true);
        this.notFull = this.lock.newCondition();
        this.notEmpty = this.lock.newCondition();
    }

    @Override
    public void add(E e) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                this.notFull.await();
            }
            queue.add(e);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E remove() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            E e = queue.remove();
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }
}
