

public class Processor extends Thread{
	public TokenRingAgent tokenringagent;
	private DSM dsm;
	private int id;
	private int n;						//number of processors

	public Processor(int id, int n, DSM dsm){
		this.id = id;
		this.n = n;
		this.dsm = dsm;
	}
	public void lock(){
		for(int level = 0; level < n - 2; level++){

			dsm.store("flag"+ id, level);
			System.out.println("Process "+ id + " is in level "+ level);
			dsm.store("turn"+ level, id);
			while(check(level,n));
		}
	}
	public void unlock(){
		dsm.store("flag"+ id, -1);
	}
	public boolean check(int level, int n){ //n is the number of levels 
		boolean exist;
		do{
			exist = false;
			for(int j = 0; j < n; j++){
				if(j!=id){
					if(dsm.load("flag"+ j) >= level){
						exist = true;
						break;
					}
				}
			}
		}while(exist && dsm.load("turn"+ level)== id);
		return exist;
	}
	public void run(){
		lock();
		System.out.println("Process "+ id +" enters the critical section");
		unlock();
	}
}
