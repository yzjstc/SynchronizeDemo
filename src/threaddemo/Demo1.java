package threaddemo;

public class Demo1 {
    public static final long TIMES = 2000000000;

    public static void main(String[] args) throws InterruptedException {
        concurrent();
        serial();
    }

    public static void concurrent() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < TIMES; i++) {
                    a += 1;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < TIMES; i++) {
            b++;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrent: " + time + "ms,b=" + b);
    }

    public static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < TIMES; i++) {
            i++;
        }
        int b = 0;
        for (long i = 0; i < TIMES; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time + "ms,b=" + b);
    }
}
