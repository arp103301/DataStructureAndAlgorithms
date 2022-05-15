package Z.com.anup.utilities;

import java.util.ArrayList;

public class ArrayListInsideArrayList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		  
        // Here aList is an ArrayList of ArrayLists
        ArrayList<ArrayList<Integer> > aList = 
                  new ArrayList<ArrayList<Integer> >(n);// n size does not matter in the end if we keep addding row/column
  
        // Create n lists one by one and append to the 
        // master list (ArrayList of ArrayList)
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        aList.add(a1);
       
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(5);
        a2.add(51);
        a2.add(1635);
        aList.add(a2);
  
        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(10);
        a3.add(20);
        a3.add(30);
        a3.add(40);
        aList.add(a3);
        
        ArrayList<Integer> a4 = new ArrayList<Integer>();
        a4.add(10);
        a4.add(20);
        a4.add(30);
        a4.add(40);
        aList.add(a4);
  
        for (int i = 0; i < aList.size(); i++) {// outer arraylist 
            
        	for (int j = 0; j < aList.get(i).size(); j++) {
               
        		System.out.print(aList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
