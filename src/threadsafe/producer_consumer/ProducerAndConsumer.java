package threadsafe.producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class ProducerAndConsumer {
    /**
     * #. 生产者消费者问题
     * 生产者生成1到100的随机整数，消费者消费打印出这些数字；
     * 生产者有三个，分别以1s~2s, 2s~3s, 5s的速度生产；
     * 消费者有两个，分别以1s~2s, 3s~4s的速度消费。
     */
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        doProduce(producer1,1);
        doProduce(producer2,2);
        Thread producer3Thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5* 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    producer1.produce();
                }
            }
        });
        producer3Thread.start();

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                Thread.sleep(random.nextFloat() +);
                consumer1.consume();
            }
        });
        consumerThread.start();


        while (true) {

            producer2.produce();
            producer3.produce();

            consumer1.consume();
            consumer2.consume();

        }
    }

    private static void doProduce(Producer producer1, int i) {
        Thread producer1Thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    try {
                        Thread.sleep((long) ((random.nextFloat() + i) * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    producer1.produce();
                }
            }
        });
        producer1Thread.start();
    }

    static class Consumer {
        BlockingQueue<Integer> mQueue;

        Consumer(BlockingQueue<Integer> queue) {
            this.mQueue = queue;
        }

        void consume() {
            System.out.println("Consumer consume " + mQueue.remove());
        }
    }

    static class Producer {

        BlockingQueue<Integer> mQueue;
        Random mRandom = new Random();

        Producer(BlockingQueue<Integer> queue) {
            mQueue = queue;
        }

        void produce() {
            mQueue.add(mRandom.nextInt(100));
        }

    }

    class Producer2 {

        abstract class BaseProducer {
            Random mRandom = new Random();

            abstract Integer produce();
        }

        Integer produce() {
            return mRandom.nextInt(100);
        }
    }
}
