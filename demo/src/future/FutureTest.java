package future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureTest {
	private  String flag = "true";  
	  
    class NotifyThread extends Thread{  
        public NotifyThread(String name) {  
            super(name);  
        }  
        public void run() {       
            try {  
                //sleep(3000);//推迟3秒钟通知  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
              synchronized (flag) {
            	  System.out.println("notify");
            	  //flag = "false";  
            	  flag.notify();  
			}
        }  
    };  
  
    class WaitThread extends Thread {  
        public WaitThread(String name) {  
            super(name);  
        }  
        
        public void run() {  
        	try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
        	synchronized (flag) {
        		System.out.println("enter wait");
        		while (flag!="false") {
        			System.out.println(getName() + " begin waiting!");  
        			long waitTime = System.currentTimeMillis();  
        			try {  
        				flag.wait();  
        			} catch (InterruptedException e) {  
        				e.printStackTrace();  
        			}  
        			waitTime = System.currentTimeMillis() - waitTime;  
        			System.out.println("wait time :"+waitTime);  
        			System.out.println(getName() + " end waiting!");  
        		}  
			}
              
        }  
    }  
  
    public static void main(String[] args) throws InterruptedException {  
        System.out.println("Main Thread Run!");  
        FutureTest test = new FutureTest();  
        NotifyThread notifyThread =test.new NotifyThread("notify01");  
        WaitThread waitThread01 = test.new WaitThread("waiter01");  
        WaitThread waitThread02 = test.new WaitThread("waiter02");  
        WaitThread waitThread03 = test.new WaitThread("waiter03");  
        notifyThread.start();  
        waitThread01.start();  
        waitThread02.start();  
        waitThread03.start();  
    }  
}
