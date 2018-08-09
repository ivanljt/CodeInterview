package threadsafe.producer_consumer.base;

interface Producer {
    void produce() throws InterruptedException;
}
