import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Global {
	//systemqueue -----> Queue where to put the agent requests
	public static BlockingQueue<BroadcastAgent> agentqueue = new ArrayBlockingQueue<BroadcastAgent>(1024);
	//agentqueue ------> Where the system puts the broadcast message
	public static BlockingQueue<Package> systemqueue = new ArrayBlockingQueue<Package>(1024);
}
