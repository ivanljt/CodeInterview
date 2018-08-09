package jvm.memory_error_sample;

class VirtualStackOverFlow {
    private int mStackDepth;

    /**
     * -Xss参数减少栈内存的容量
     * -Xss128k
     */
    public static void main(String[] args) {
        VirtualStackOverFlow virtualStackOverFlow = new VirtualStackOverFlow();
        virtualStackOverFlow.sof();
    }

    void sof() {
        try {
            recursiveCall();
        } catch (StackOverflowError e) {
            System.out.println("stack depth:" + mStackDepth);
            throw e;
        }
    }

    private void recursiveCall() {
        mStackDepth++;
        recursiveCall();
    }
}
