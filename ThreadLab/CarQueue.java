import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	private Random rand;
	private Queue<Integer> queue;
	
	public CarQueue() {
		rand = new Random();
		queue = new ArrayDeque<Integer>();
		
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
	}
	
	public void addToQueue() {
		class QueueAddRunnable implements Runnable {
			@Override
			public void run() {
				try {
					while(true) {
						queue.add(rand.nextInt(4));
						Thread.sleep(100);
					}
				}
				catch (InterruptedException x) {
					x.printStackTrace();
				}
				
			}
		}
		QueueAddRunnable myRun = new QueueAddRunnable();
		Thread runThread = new Thread(myRun);
		runThread.start();
	}
	
	public int deleteQueue() {
		return queue.remove();
	}
}
