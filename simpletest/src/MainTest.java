public class MainTest {
    static class NameLessOne implements Runnable {
        int k = 0;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "---" + k);
            k=5;
            try{
                Thread.sleep(2000);
            } catch (Exception e){

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread n1 = new Thread(new NameLessOne());
        n1.start();
        Thread.sleep(2000);
        Thread n2 = new Thread(new NameLessOne());
        n2.start();
    }
}
