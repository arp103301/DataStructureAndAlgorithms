package Z.com.anup.companiesSamples;

import java.util.HashMap;
import java.util.Map;

public class ColorMap {

	
	
	 public class Color {
		 private String name;
		 public Color (String name ) {
			 this.name= name;
		 }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Color,String> map = new HashMap<>();
map.put(new Color("Red"),"Red");
map.put(new Color("Blue"),"Blue");
map.put(new Color("Green"),"Green");

System.out.println(map.get(new Color("Blue")));
	}

}
// null is the answer
