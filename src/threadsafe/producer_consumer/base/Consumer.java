package threadsafe.producer_consumer.base;

interface Consumer {
    void consume() throws InterruptedException;
}
