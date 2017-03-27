
public class DSM extends Thread{
	private LocalMemory locMem = null;
	private BroadcastAgent agent = null;
	private int id;
	
	public DSM(BroadcastAgent agent){
		this.locMem = new LocalMemory();
		this.agent = agent;
	}
	public int load(String name){
		return locMem.load(name);
	}
	public void store(String name, int value){
		Package msg = null;
		
		locMem.store(name, value);
		msg = new Package(id, name, value);
		agent.broadcast(msg);
	}
	public void run(){

	}
}
