package threadsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {
    /**
     * synchronized 方式
     */
    //sychronized 的对象最好选择引用不会变化的对象（例如被标记为final,或初始化后永远不会变）,
    // 虽然synchronized是在对象上加锁, 但是它首先要通过引用来定位对象,
    // 如果引用是可变的, 可能带来意想不到的后果
    //Such statements are unlikely to have useful semantics, as different threads may be locking
    // on different objects even when operating on the same object.
    // 这样的语句（这里指的是使用没有声明为final 的对象作为锁）不太可能具有有用的语义，
    // 因为即使在同一对象上操作，不同的线程也可能锁定在不同的对象上。
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (deadLockDemo.lock1) {
                        System.out.println("thread1 get lock1 waiting to get lock2");
                        try {
                            Thread.sleep(500);//此处等待是增加 Thread2 获取 lock2 的机会
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (deadLockDemo.lock2) {
                            System.out.println("thread1 get lock1 and lock2");
                        }
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (deadLockDemo.lock2) {

                        System.out.println("thread2 get lock2 waiting to get lock1");
                        try {
                            Thread.sleep(500);//此处等待是增加 Thread1 获取 lock1 的机会
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (deadLockDemo.lock1) {
                            System.out.println("thread2 get lock1 and lock2");
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

/**
 * 使用Lock显式锁
 */
class LockDeadDemo {

    public static void main(String[] args) {
        final DeadLockBean deadLockBean = new DeadLockBean();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    deadLockBean.productDeadLock();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }, "threadA");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(310);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    deadLockBean.productDeadLock();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }, "threadB");
        threadA.start();
        threadB.start();
        try {
            System.out.println("main线程即将被join");
            threadA.join();
            threadB.join();
            System.out.println("main线程从join中恢复");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class DeadLockBean {
        private Lock lock = new ReentrantLock();

        void productDeadLock() throws Throwable {
            System.out.println(Thread.currentThread().getName() + "   进入了方法！");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "   已经执行了！");
                throw new Throwable("人为抛出异常Throwable");//关键代码行1，
                //throw new Exception("人为抛出异常Exception");//关键代码行2，不会死锁，会在catch(Exception e中被捕获)，嵌套lock.unlock()并释放
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "   发生异常catch！");
                lock.unlock();//关键代码行3，不建议在这里释放，假如发生【关键代码行1】会产生死锁
            } finally {
                System.out.println(Thread.currentThread().getName() + "   发生异常finally！");
//                lock.unlock();//关键代码行4，无论发生何种异常，均会释放锁。
            }
            //lock.unlock();//关键代码行5，假如发生不能捕获异常，将跳出方法体，不执行此处
            System.out.println(Thread.currentThread().getName() + "   tryCatch外释放锁！");
        }
    }
}
