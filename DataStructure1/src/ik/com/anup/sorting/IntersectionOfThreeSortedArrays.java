package ik.com.anup.sorting;

import java.util.ArrayList;

/*Given three arrays sorted in the ascending order, return their intersection sorted array in the ascending order.

Example One
{
"arr1": [2, 5, 10],
"arr2": [2, 3, 4, 10],
"arr3": [2, 4, 10]
}
Output:

[2, 10]*/
		
		
public class IntersectionOfThreeSortedArrays {

static ArrayList<Integer> find_intersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i =0 , j =0, k= 0;

        
        if( arr1.size() == 0 || arr2.size() == 0 || arr3.size() == 0){
            result.add(-1);
            return result;
        }
        
        while(i< arr1.size() && j < arr2.size() && k < arr3.size()){
            int  val1 = arr1.get(i), val2 = arr2.get(j), val3 = arr3.get(k);
            if(val1 == val2 && val2 == val3) {
                result.add(val1);
                
            }
            
            //which ever index has min value we need to move that pointer
            int min = Math.min( Math.min(val1, val2) , val3);//???
            
            if(val1 == min ) i++;
            if(val2 == min ) j++;
            if(val3 == min ) k++;
        }
        if(result.size() == 0) result.add(-1);
        return result;
    }
}