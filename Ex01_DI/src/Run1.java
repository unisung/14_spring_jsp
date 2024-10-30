
class Run1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("첫번째 스레드 i : "+ i);
        }
    }
}

class Run2 extends Thread {
    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            System.out.println("두번째 스레드 j : "+ j);
        } 
    }
}