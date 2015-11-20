/**
 * 
 */
package concurrents.tests;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author lz
 * @date 下午4:40:37
 */
public class BlockingQueueT {
	public static void main(String[] args){
		  BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(0, false);
		     Producer p = new Producer(q);
		     Consumer c1 = new Consumer(q,"c1");
		     Consumer c2 = new Consumer(q,"c2");
		   Thread t1 =  new Thread(c1);
		     Thread t2 = new Thread(c2);
		     t1.setName("c1");
		     t2.setName("c2");
		     t1.start();t2.start();
		    Thread p1 =  new Thread(p);
		    p1.setName("P");
		    p1.start();
		    ConcurrentHashMap<String, String> m = new ConcurrentHashMap<String, String>();
		    DelayQueue< DelayElement> dq = new DelayQueue<DelayElement>();
		    
		    
	}
	public static class DelayElement implements Delayed{

		@Override
		public int compareTo(Delayed paramT) {
			return 0;
		}

		@Override
		public long getDelay(TimeUnit paramTimeUnit) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

	static class Producer implements Runnable {
		   private final BlockingQueue<Integer> queue;
		   private Random r = new Random();
		   Producer(BlockingQueue<Integer> q) { queue = q; }
		   public void run() {
		     try {
		       while (true) { 
		    	   System.out.println("put qian");
		    	   Thread.sleep(1000);
		    	   queue.put(produce()); 
		       }
		     } catch (InterruptedException ex) {} 
		   }
		   Integer produce() {
			   Integer i = r.nextInt();
		    	   System.out.println("Thread "+Thread.currentThread().getName()+"  produce :"+i);
		    	   return i;
		   }
		 }

	static class Consumer implements Runnable {
		   private final BlockingQueue<Integer> queue;
		   Consumer(BlockingQueue q,String name) { queue = q; 
		   Thread.currentThread().setName(name);
		   }
		   public void run() {
		     try {
		       while (true) { consume(queue.take()); }
		     } catch (InterruptedException ex) {
		   }
		   }
		   void consume(Integer x) {
			   
			   System.out.println("Thread "+Thread.currentThread().getName()+" counsume:"+x);
		   }
		 }


}
