public class Ex1_2 {

    public static class Calculator implements Runnable {
        private int number;

        public Calculator(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s : %d * %d = %d\n", Thread.currentThread().getName(), number, i, number * i);
            }
        }

    }

    public static class Calculator2 extends Thread {
        private int number;

        public Calculator2(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Thread thread = Thread.currentThread();
                System.out.printf("%s : %d * %d = %d\n",
                        String.valueOf(thread.getId()) + ":" +
                                thread.getName() + ":" +
                                String.valueOf(thread.getPriority()) + ":" +
                                thread.getState()
                        , number, i, number * i);
            }
        }

    }

    public static class Calculator3 implements Runnable {
        private int number;

        public Calculator3(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            for (; this.number > 0; this.number--) {
                System.out.printf("%s : %d\n", Thread.currentThread().getName(), this.number);
            }
        }

    }

    public static class Calculator4 extends Thread {
        private int number;

        public Calculator4(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            for (; number > 0; number--) {
                Thread thread = Thread.currentThread();
                System.out.printf("%s : %d\n", Thread.currentThread().getName(), number);
            }
        }

    }

    public static void main(String[] args) {
        /*
        for (int i = 0; i < 3; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
        System.out.println("main thread wait...");
        */
        
        /*
        for (int i = 0; i < 3; i++) {
            Calculator2 calculator2 = new Calculator2(i);
            calculator2.start();
        }
        System.out.println("main thread wait...");
        */

        /*
        Calculator3 calculator = new Calculator3(5);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(calculator);
            thread.start();
        }
        System.out.println("main thread wait...");
        */

        for (int i = 0; i < 3; i++) {
            Calculator4 calculator = new Calculator4(5);
            calculator.start();
        }
        System.out.println("main thread wait...");
    }
}