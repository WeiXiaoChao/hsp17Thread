package study.runnable;

/**
 * @author Casey Gao
 * @version 1.0
 */
public class RunnablePractice {
    public static void main(String[] args) {
        Cat cat = new Cat();
        // 使用了静态代理模式
        Thread thread = new Thread(cat);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程要退出了！！！！");
    }
}

// Runnable本身只有run方法
// 由于java是单继承的，当一个类已有父类且想使用线程的话，只能实现该接口
class Cat implements Runnable{

    @Override
    public void run() {
        int times = 0;
        while (true){
            System.out.println("喵喵喵叫!!!"+(++times));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times==10){
                break;
            }
        }

    }
}
