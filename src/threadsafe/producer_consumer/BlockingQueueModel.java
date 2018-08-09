package threadsafe.producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import threadsafe.producer_consumer.base.AbstractConsumer;
import threadsafe.producer_consumer.base.AbstractProducer;
import threadsafe.producer_consumer.base.IProducerConsumerModel;
import threadsafe.producer_consumer.base.Task;

/**
 * 借助 BlockingQueue 实现。
 * 将并发和容量控制封装在缓冲区中
 * */
public class BlockingQueueModel implements IProducerConsumerModel {

    private BlockingQueue<Task> mBlockingQueue;
    private AtomicInteger mTaskNoCounter;

    public BlockingQueueModel(int capacity) {
        mBlockingQueue = new LinkedBlockingQueue<>(capacity);
        mTaskNoCounter = new AtomicInteger();
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    class ConsumerImpl extends AbstractConsumer {

        @Override
        public void consume() throws InterruptedException {
            Task task = mBlockingQueue.take();
            //模拟相对稳定的处理过程
            Thread.sleep((long) (600 + Math.random() * 600));
            System.out.println("consumer consume task " + task.getSequenceNum());
        }
    }

    class ProducerImpl extends AbstractProducer {

        @Override
        public void produce() throws InterruptedException {
            Thread.sleep((long) (Math.random() * 1000));
            Task task = new Task(mTaskNoCounter.getAndIncrement());
            System.out.println("producer produce task " + task.getSequenceNum());
            mBlockingQueue.put(task);
        }
    }

    public static void main(String[] args) {
        BlockingQueueModel blockingQueueModel = new BlockingQueueModel(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            executorService.submit(blockingQueueModel.newRunnableConsumer());
        }
        for (int i = 0; i < 6; i++) {
            executorService.submit(blockingQueueModel.newRunnableProducer());
        }
    }
}
