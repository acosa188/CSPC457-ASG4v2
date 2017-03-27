import java.util.ArrayList;

public class TokenRing {
	static ArrayList<TokenRingAgent> tokenList = new ArrayList<TokenRingAgent>();
	private static int processes;
	//Constructor takes in the number of TokenRingAgents that belong to the ring
	TokenRing(int n){
		//create an array of TokenRingAgents
		processes = n;
		for(int i = 0; i < processes; i++){
			TokenRingAgent temp = new TokenRingAgent();
			tokenList.add(temp);
		}
		
		//now that all the tokenRings are created, we can connect them in a ring
		for(int i = 0; i < processes; i++){
			TokenRingAgent TRA = tokenList.get(i);
			TokenRingAgent TRAPredecessor = tokenList.get(((i+1)-1)%n);
			TokenRingAgent TRASuccessor = tokenList.get((i+1)%n);
			TRA.setSuccessor(TRASuccessor);
			TRA.setPredecessor(TRAPredecessor);
		}
		
		//print out token ring for debugging
		printTokenRing();
	}
	
	private static void printTokenRing(){
		System.out.println("Printing token ring...");
		for(int i = 0; i < processes; i++){
			TokenRingAgent TRA = tokenList.get(i);
			TokenRingAgent TRAPredecessor = tokenList.get(((i+processes)-1)%processes);
			TokenRingAgent TRASuccessor = tokenList.get((i+1)%processes);
			System.out.print("Predecessor: ");
			System.out.println(TRAPredecessor.toString());;
			System.out.print("Token: ");
			System.out.println(TRA.toString());
			System.out.print("Successor: ");
			System.out.println(TRASuccessor.toString());
			System.out.println();

		}
	}
}
