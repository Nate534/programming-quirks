public class ParallelStaticVariables {
    private static int counter = 0;
  
    public static void incrementCounter(String thread, int loops) {
        for (int i = 0; i < loops; i++) {
            int currentValue = counter;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            counter = currentValue + 1;
            System.out.println(threadName + " - Iteration " + (i + 1) + 
                             ", Counter value: " + counter);
        }
    }
    
    public static void main(String[] args) {
        counter = 0;
        safeCounter = 0;
        
        Thread thread1 = new Thread(() -> incrementCounter("Thread-1", 5));
        Thread thread2 = new Thread(() -> incrementCounter("Thread-2", 5));
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\ncounter value: " + counter);
    }
}