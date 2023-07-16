package study.runnable;

// GitBranch: hot-fix
/**
 * @author Casey Gao
 * @version 1.0
 */
public class ImitateRunnablePractice {
    public static void main(String[] args) {
        Dog dog = new Dog();
        ThreadProxy threadProxy = new ThreadProxy(dog);
        threadProxy.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 上边执行结束，才执行该句话
        System.out.println("主线程要退出了！！！！");
    }
}

// 线程代理类，仅用于理解，并不是真正的多线程
class ThreadProxy implements Runnable{

    private Runnable runnable = null;

    public ThreadProxy(Runnable runnable){
        this.runnable = runnable;
    }

    @Override
    public void run() {
        if (runnable != null){
            runnable.run(); // 动态绑定
        }
    }

    public void start(){
        start0(); // 这个方法是真正实现多线程方法
    }

    public void start0(){
        run();
    }
}

class Animal{}

class Dog extends Animal implements Runnable{

    @Override
    public void run() {
        int times = 0;
        while (true){
            System.out.println("汪汪汪叫~~~"+(++times));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times==10){
                break;
            }
        }
    }
}


