package ik.com.anup.sorting;
//R,G, B 

//three pointers.. low, pointer,high indices and Idea is to leave the G middle one left untouched and only move the pointer otherwise swap R and B 

import java.util.ArrayList;
import java.util.Collections;

/*Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, 
 * then green and then blue ones.

Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.

This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. 
Dutch national flag has three colors (albeit different from ones used in this problem).

Example
{
"balls": ["G", "B", "G", "G", "R", "B", "R", "G"]
}
Output:

["R", "R", "G", "G", "G", "G", "B", "B"]
There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.*/


public class Dutch_flag_sort {
	
	static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
		   
        int low=0, pointer=0, high=balls.size()-1;
        
        
        // Idea is to leave the G middle one left untouched and only move the pointer otherwise swap R and B 
        
        while(pointer<=high){
            
            if(balls.get(pointer).equals('R')){
                Collections.swap(balls, low, pointer);
                low++;
                pointer++;
            } else if(balls.get(pointer).equals('B')){
                Collections.swap(balls, high, pointer);
                high--;
            } else {
                //case --> balls.get(g) == "G"
            	pointer++;
            }   
        }
        return balls;
	}	
}	

