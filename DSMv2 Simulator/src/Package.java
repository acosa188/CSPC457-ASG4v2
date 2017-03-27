
public class Package{

	
	//broadcasting info
	private String key;
	private int value;
	private int iD;
	
public Package(int id, String key, int val){
	this.key = key;
	this.value = val;
	this.iD = id;
}
public String getkey(){
	return key;
}
public int getvalue(){
	return value;
}
public int getid(){
	return iD;
}
}
