
public class TokenRingAgent {
	private int ID;
	private boolean Active;
	private TokenRingAgent RingPredecessor;
	private TokenRingAgent RingSuccessor;
	
	public TokenRingAgent(){
		RingPredecessor = null;
		RingSuccessor = null;
	}
	
	public int ReceiveToken(){
		return RingPredecessor.ID;
		
	}
	
	public void SendToken(Token t){
		//sends the token to the successor
		//RingSuccessor = t;
	}
	
	public void setPredecessor(TokenRingAgent n){
		this.RingPredecessor = n;
	}
	
	public TokenRingAgent getPredecessor(){
		return this.RingPredecessor;
	}
	
	public void setSuccessor(TokenRingAgent n){
		this.RingSuccessor = n;
	}
	
	public TokenRingAgent getSuccessor(){
		return this.RingSuccessor;
	}
	public boolean getStatus(){
		return Active;
	}
}
