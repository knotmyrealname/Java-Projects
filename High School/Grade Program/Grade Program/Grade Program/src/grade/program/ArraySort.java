package grade.program;

import java.util.ArrayList;

public class ArraySort {
    
    public double getMax(ArrayList<Double> list){
        double max = 0;
        for (int x = 0; 0 < list.size(); x++){
            if (max < list.get(x)){
                max = list.get(x);
            }
        }
        return max;
    }
    
    public double getMin(ArrayList<Double> list){
        double min = 100;
        for (int x = 0; 0 < list.size();x++){
            if (min > list.get(x)){
                min = list.get(x);
            }
        }
        return min;
    }
    
    public int average(ArrayList<Double> list){
        double average = 0;
        double total = 0;
        for (int x = 0; 0 < list.size(); x++){
            total += list.get(x);
        }
        average = total / list.size();
        int intAverage = (int)Math.round(average);
        
        return intAverage;
    }
}
