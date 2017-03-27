import java.util.concurrent.*;
public class BroadcastSystem extends Thread{
	private int numAgents;
	private boolean shutdown;
	protected BlockingQueue<BroadcastAgent> agentqueue = null;
	protected BlockingQueue<Package> systemqueue = null;

public BroadcastSystem(int numAgents){
	this.agentqueue = Global.agentqueue;
	this.systemqueue = Global.systemqueue;
	this.numAgents = numAgents;
	this.shutdown = false;
}
public void run(){
	while(!shutdown){
		Package msg = null;
		BroadcastAgent agent = null;
		try{
			msg = systemqueue.take();
			agent = agentqueue.take();
		}catch(Exception e){
			System.out.println("System failed to retrieve msg from the queue");
			return;
		}
		for(int i = 0; i < numAgents; i++){
			try{
				agent.store.put(msg);
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println("System failed to load msg to the queue");
				return;
			}
		}
	}
}
}
