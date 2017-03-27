
public class Main {

	public static void main(String[] args) {
		int num;										//number of processors
		BroadcastSystem broadcastsystem = null;
		BroadcastAgent agent = null;
		Processor process = null;
		DSM dsm = null;
		
		num = 10;
		broadcastsystem = new BroadcastSystem(num);

		broadcastsystem.start();
		
		for(int i = 0; i < num; i++){
			
			agent = new BroadcastAgent();
			dsm = new DSM(agent);
			process = new Processor(i, num, dsm);

			process.start();
			dsm.start();
			agent.start();
		}
		
	}

}
