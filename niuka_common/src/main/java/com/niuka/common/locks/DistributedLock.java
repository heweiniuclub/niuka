package com.niuka.common.locks;

/**
 * 分布式锁
 *
 * @author hewei
 */
public abstract class DistributedLock {

    /**
     * 尝试获得锁，一直阻塞，直到获得锁为止
     */
    public abstract void lock();

    /**
     * 尝试获得锁，能获得就立马获得锁，如果不能获得就立马返回
     */
    public abstract boolean tryLock();

    /**
     * 释放锁
     */
    public abstract void unlock();
}


//~ Formatted by Jindent --- http://www.jindent.com
