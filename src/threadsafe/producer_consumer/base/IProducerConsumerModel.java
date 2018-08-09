package threadsafe.producer_consumer.base;

public interface IProducerConsumerModel {
    Runnable newRunnableConsumer();

    Runnable newRunnableProducer();
}
