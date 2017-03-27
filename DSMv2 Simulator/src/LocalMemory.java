import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public class LocalMemory {

	private ConcurrentMap<String,Integer> key = new ConcurrentHashMap<String,Integer>(1000);
	public int load(String name){
		return key.get(name);
	}
	public void store(String name, int value){
		key.put(name, value);
	}
}