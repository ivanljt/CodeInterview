package producer_consumer.base;

public abstract class AbstractConsumer implements Runnable, Consumer {
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
