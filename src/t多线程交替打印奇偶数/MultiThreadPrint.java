package t多线程交替打印奇偶数;

import java.util.concurrent.Executor;

/**
 * 题目:2个线程交替打印1-100内数字,其中t1线程打印奇数,t2线程打印偶数
 * 主要考察对多线程创建以及多线程执行顺序的应用,难点是通过对一个对象的加锁,避免多线程随机打印,用一个开关控制打印奇数还是偶数
 */
class MultiThreadPrint {
    final static Object sLock = new Object();

    public static void main(String[] args) {
        new Thread(new Run1()).start();
        new Thread(new Run2()).start();
    }


    public static class Run1 implements Runnable {
        int i = -2;

        @Override
        public void run() {
            while (i <= 98) {
                synchronized (MultiThreadPrint.sLock) {
                    System.out.println("Thread1: " + (i += 2));
                    MultiThreadPrint.sLock.notify();
                    try {
                        MultiThreadPrint.sLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Run2 implements Runnable {
        int i = -1;

        @Override
        public void run() {
            while (i <= 98) {
                synchronized (MultiThreadPrint.sLock) {
                    System.out.println("Thread2: ----" + (i += 2));
                    MultiThreadPrint.sLock.notify();//释放锁，唤醒 Thread1
                    try {
                        MultiThreadPrint.sLock.wait();//等待锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

/**
 * 关键：同一把锁，一个处于 wait 状态，另一个处于 notify 状态。交替执行
 */
class BySynchronize {
    private int mNum = 1;
    private boolean mIsOdd = true;//是否是奇数。从1 开始,所以是 true

    public static void main(String[] args) {
        BySynchronize bySynchronize = new BySynchronize();
        Thread t1 = new Thread(new OddRunnable(bySynchronize));
        Thread t2 = new Thread(new EvenRunnable(bySynchronize));

        t1.start();
        t2.start();
    }

    static class OddRunnable implements Runnable {//奇数
        final BySynchronize mBySynchronize;

        public OddRunnable(BySynchronize bySynchronize) {
            mBySynchronize = bySynchronize;
        }

        @Override
        public void run() {
            while (mBySynchronize.mNum <= 99) {//循环
                synchronized (mBySynchronize) {
                    if (mBySynchronize.mIsOdd) {//是奇数
                        System.out.println("ThreadOdd " + mBySynchronize.mNum++);
                        mBySynchronize.mIsOdd = false;
                    }
                    mBySynchronize.notify();
                    if (mBySynchronize.mNum == 99) {
                        break;
                    }
                    try {
                        mBySynchronize.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class EvenRunnable implements Runnable {//偶数
        final BySynchronize mBySynchronize;

        public EvenRunnable(BySynchronize bySynchronize) {
            mBySynchronize = bySynchronize;
        }

        @Override
        public void run() {
            while (mBySynchronize.mNum <= 100) {
                synchronized (mBySynchronize) {
                    if (!mBySynchronize.mIsOdd) {//是偶数
                        System.out.println("ThreadEven --- " + mBySynchronize.mNum++);//是偶数
                        mBySynchronize.mIsOdd = true;//
                    }
                    mBySynchronize.notify();
                    if (mBySynchronize.mNum == 100) {
                        break;
                    }
                    try {
                        mBySynchronize.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}