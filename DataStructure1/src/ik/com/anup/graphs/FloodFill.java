package ik.com.anup.graphs;

import java.util.ArrayList;

/*One pixel on a grayscale image changes color. Recolor all the adjacent pixels of the same color to the same new color.

Grayscale colors are simply numbers.

Example One
{
"pixel_row": 0,
"pixel_column": 1,
"new_color": 2,
"image": [
[0, 1, 3],
[1, 1, 1],
[1, 5, 4]
]
}
I.e. the pixel at row 0 and column 1 changes to color 2.

Output:

[
[0, 2, 3],
[2, 2, 2],
[2, 5, 4]
]
Example Two
{
"pixel_row": 1,
"pixel_column": 0,
"new_color": 9,
"image": [
[0, 2, 1],
[1, 1, 2],
[2, 5, 4]
]
}
I.e. the pixel at row 1 and column 0 changes to color 9.

Output:

[
[0, 2, 1],
[9, 9, 2],
[2, 5, 4]
]
Notes
Two pixels are considered adjacent if they share a side; sharing a diagonal is not enough.

Constraints:

1 <= image width <= 1000
1 <= image height <= 1000
0 <= pixel color <= 1000*/
public class FloodFill {

    static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color, ArrayList<ArrayList<Integer>> image) {
        
        
    	// only call helper if the pixel is not new color
    	if (image.get(pixel_row).get(pixel_column) != new_color) {
            helper(image, image.get(pixel_row).get(pixel_column), new_color, pixel_row, pixel_column);   
        }
        
        return image;
    }
    
    static void helper(ArrayList<ArrayList<Integer>> image, int oldColor, int newColor, int row, int column) {
     
    	//only set new color if the pixel is old color
        if (image.get(row).get(column) == oldColor) {
            
        	image.get(row).set(column, newColor);
            
            //top
            if (row > 0) helper(image, oldColor, newColor, row - 1, column); 
            //bottom
            if (row < image.size() - 1) helper(image, oldColor, newColor, row + 1, column);
            //left
            if (column > 0) helper(image, oldColor, newColor, row, column - 1);
            //right
            if (column < image.get(row).size() - 1) helper(image, oldColor, newColor, row, column + 1);
        }
        
    }
}
