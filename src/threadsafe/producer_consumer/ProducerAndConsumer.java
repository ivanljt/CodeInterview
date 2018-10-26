package threadsafe.producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * #. 生产者消费者问题
 * 生产者生成1到100的随机整数，消费者消费打印出这些数字；
 * 生产者有三个，分别以1s~2s, 2s~3s, 5s的速度生产；
 * 消费者有两个，分别以1s~2s, 3s~4s的速度消费。
 */
class ProducerAndConsumer {

    /**
     * 思路：一个生产者、消费者分别是运行在各自的线程
     * 然后产生的速度 利用 Thread.sleep + Random 来实现。
     */
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        doProduce(producer1, 1);
        doProduce(producer2, 2);
        Thread producer3Thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                producer3.produce();
            }
        });
        producer3Thread.start();

        doConsume(consumer1, 1);
        doConsume(consumer2, 3);
    }

    private static void doProduce(Producer producer, int leftBound) {
        Thread producer1Thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    try {
                        Thread.sleep((long) ((random.nextFloat() + leftBound) * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    producer.produce();
                }
            }
        });
        producer1Thread.start();
    }

    private static void doConsume(Consumer consumer, int leftBound) {
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep((long) (Math.random() + leftBound));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    consumer.consume();
                }
            }
        });
        consumerThread.start();
    }

    static class Consumer {
        BlockingQueue<Integer> mQueue;

        Consumer(BlockingQueue<Integer> queue) {
            this.mQueue = queue;
        }

        void consume() {
            System.out.println("Consumer consume " + mQueue.poll());
        }
    }

    static class Producer {

        BlockingQueue<Integer> mQueue;
        Random mRandom = new Random();

        Producer(BlockingQueue<Integer> queue) {
            mQueue = queue;
        }

        void produce() {
            System.out.println("producer produce");
            mQueue.add(mRandom.nextInt(100));
        }

    }
}
