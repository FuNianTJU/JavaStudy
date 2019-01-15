package _并发_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class HorseRace {
	  static final int FINISH_LINE = 75;
	  private List<Horse> horses = new ArrayList<Horse>();
	  private ExecutorService exec =
	  Executors.newCachedThreadPool();
	  private CyclicBarrier barrier;
	  private final AtomicInteger counter = new AtomicInteger(0);
	  public HorseRace(int nHorses, final int pause) {
		//定义同步点和同步动作
	    barrier = new CyclicBarrier(nHorses, new Runnable() {
	      public void run() {
	        StringBuilder s = new StringBuilder();
	        for(int i = 0; i < FINISH_LINE; i++)
	          s.append("="); // The fence on the racetrack
	        System.out.println(s);
	        for(Horse horse : horses)
	          System.out.println(horse.tracks());
	        counter.incrementAndGet();
	        for(Horse horse : horses)
	          if(horse.getStrides() >= FINISH_LINE) {
	            System.out.println(horse + "won!");
	            System.out.println("比赛进行"+counter+"次");
	            exec.shutdownNow();
	            return;
	          }
	        try {
	          TimeUnit.MILLISECONDS.sleep(pause);
	        } catch(InterruptedException e) {
	          System.out.println("barrier-action sleep interrupted");
	        }
	      }
	    });
	    
	    for(int i = 0; i < nHorses; i++) {
	      Horse horse = new Horse(barrier);
	      horses.add(horse);
	      exec.execute(horse);
	    }
	  }
	  public static void main(String[] args) {
	    int nHorses = 7;
	    int pause = 200;
	    if(args.length > 0) { // Optional argument
	      int n = new Integer(args[0]);
	      nHorses = n > 0 ? n : nHorses;
	    }
	    if(args.length > 1) { // Optional argument
	      int p = new Integer(args[1]);
	      pause = p > -1 ? p : pause;
	    }
	    new HorseRace(nHorses, pause);
	  }

}

class Horse implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0; //步数
	private static Random random = new Random(47);
	private static CyclicBarrier barrier;//同步点
	
	public Horse(CyclicBarrier b){
		barrier = b;
	}
	
	public synchronized int getStrides(){
		return strides;
	}
	
	public void run(){
		try {
			while(!Thread.interrupted()){
				synchronized (this) {
					strides += random.nextInt(10);
				}
				barrier.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return "Horse " + id + " "; 
	}
	
	public String tracks() {
	    StringBuilder s = new StringBuilder();
	    for(int i = 0; i < getStrides(); i++)
	      s.append("*");
	    s.append(id);
	    return s.toString();
	}
	
}
























