import java.util.function.IntConsumer;
class FizzBuzz {
    private int n;
    private volatile int current = 1; // Use volatile for visibility across threads

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                // Wait if it's not our turn (not divisible by 3, or IS divisible by 5)
                while (current <= n && (current % 3 != 0 || current % 5 == 0)) {
                    wait();
                }

                if (current > n) {
                    break;
                }

                printFizz.run();
                current++;
                notifyAll(); // Wake up other threads
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                // Wait if it's not our turn (not divisible by 5, or IS divisible by 3)
                while (current <= n && (current % 5 != 0 || current % 3 == 0)) {
                    wait();
                }

                if (current > n) {
                    break;
                }

                printBuzz.run();
                current++;
                notifyAll(); // Wake up other threads
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                // Wait if it's not our turn (not divisible by both 3 and 5)
                while (current <= n && (current % 3 != 0 || current % 5 != 0)) {
                    wait();
                }

                if (current > n) {
                    break;
                }

                printFizzBuzz.run();
                current++;
                notifyAll(); // Wake up other threads
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                // Wait if it's our turn (divisible by 3 or 5)
                while (current <= n && (current % 3 == 0 || current % 5 == 0)) {
                    wait();
                }

                if (current > n) {
                    break;
                }

                printNumber.accept(current);
                current++;
                notifyAll(); // Wake up other threads
            }
        }
    }
}