import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BroadcastAgent extends Thread{
	protected BlockingQueue<BroadcastAgent> agentqueue = null;
	protected BlockingQueue<Package> systemqueue = null;
	public BlockingQueue<Package> store = null;
	private LocalMemory locMem = null;
	private boolean shutdown;


	public BroadcastAgent(){
		this.agentqueue = Global.agentqueue;
		this.systemqueue = Global.systemqueue;
		this.store = new ArrayBlockingQueue<Package>(1024);
		shutdown = false;
	}
	public void broadcast(Package msg){
		try{
		systemqueue.put(msg);
		agentqueue.put(this);
		Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("Failed to broadcast the message to the System!");
			return;
		}
	}
	public Package receive(){
		Package msg = null;
		try{
			msg = store.take();
		}catch(Exception e){
			System.out.println("Failed to retrieve an element");
		}
		return msg;
	}
	public void kill(){
		shutdown = true;
	}
	public void run(){
		Package msg;	
		while(!shutdown){
			msg = receive();
			try{
			Thread.sleep(1000);
			}catch(Exception e){
				System.out.println("Error sleeping!");
			}
			try{
			locMem.store(msg.getkey(), msg.getvalue());
			}catch(Exception e){
				System.out.println("Storing package for DSM failed!");
			}
		}
	}
}
