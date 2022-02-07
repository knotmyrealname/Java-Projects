package grade.program;

import java.util.ArrayList;

public class ArraySort {
    
       //returns the max value of an array
    public double getMax(ArrayList<Double> list){
        double max = 0;
            //compares the old max and the new number, replacing the old max with the new number if the new number is greater
        for (int x = 0; x < list.size(); x++){
            if (max < list.get(x)){
                max = list.get(x);
            }
        }
        return max;
    }
    
        //returns the smallest value of an array
    public double getMin(ArrayList<Double> list){
        double min = 100;
        if(list.size() == 0){
            min = 0;
        }
            //compares the old min (set at 100 as the maximum) with a new number, replacing the old min if the new number is smaller
        for (int x = 0; x < list.size();x++){
            if (min > list.get(x)){
                min = list.get(x);
            }
        }
        return min;
    }
    
        //gets the average of the array
    public int average(ArrayList<Double> list){
        double average = 0;
        double total = 0;
            //adds up the array
        for (int x = 0; x < list.size();x++){
            total += list.get(x);
        }
        
            //divides and rounds the total value of the array
        average = total / list.size();
        int intAverage = (int)Math.round(average);
        
        return intAverage;
    }
}
