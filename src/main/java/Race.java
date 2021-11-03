public class Race implements Runnable{

    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");

             boolean b = gameOver(i);
             if(b){
                 break;
             }

         if (Thread.currentThread().getName().equals("兔子") && i%10==0){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
     }
    }
    //判断是否完成比赛
    private boolean gameOver(int steps){

        if(winner!=null){
            return true;
        }else{
            if(steps>=100){
                winner = Thread.currentThread().getName();
                System.out.println("胜利者是"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
