package producer_consumer.base;

/**
 * 生产/消费的单位
 * */
public class Task {
    private final int mSequenceNum;

    public Task(int sequenceNum) {
        mSequenceNum = sequenceNum;
    }

    public int getSequenceNum() {
        return mSequenceNum;
    }

}
