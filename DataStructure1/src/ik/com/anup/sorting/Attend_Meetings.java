package ik.com.anup.sorting;

import java.util.ArrayList;

/*Given a list of meeting intervals where each interval consists of a start 
and an end time, check if a person can attend all the given meetings 
such that only one meeting can be attended at a time.

Example One
{
"intervals": [[1, 5], [5, 8], [10, 15]]
}
Output:

1*/
public class Attend_Meetings {


    static Integer can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {
       
        int lastEnd = 0;
        int lastStart = 0;

        for(ArrayList<Integer> interval:intervals){
            int currentStart = interval.get(0);
            int currentEnd = interval.get(1);
            
            if(currentStart < lastEnd && currentEnd > lastStart){
                return 0;
            }

            lastStart = currentStart;
            lastEnd = currentEnd;
        }

        return 1;

    }


}
