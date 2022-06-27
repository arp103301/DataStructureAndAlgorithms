package Z.com.anup.java8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//HashMap<Integer,Integer>  hm = new HashMap<>();
		ConcurrentHashMap<Integer,Integer>  hm = new ConcurrentHashMap<>();
		
		hm.put(1, 1);hm.put(2, 2);hm.put(3, 3);
		Iterator hmItr = hm.keySet().iterator();
		while (hmItr.hasNext()) {
			 int nextKey = (int) hmItr.next();
			 System.out.println( "the key is "+nextKey);
			 if (nextKey==2) { hm.put(4, 4);}
			 
			
		}
		
		
	}

}
