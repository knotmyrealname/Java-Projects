package food.program;

import java.util.ArrayList;

public class ButtonFunctions {
    
        
        //does most of the logic behind the calculate button
    public void calculate(String hotDogString, String bratString, String burgerString, String friesString, String sodaString, String waterString){
        
        //creates an arraylist with everything in the order of hotdog, brat, burger, fries, soda, water
        ArrayList<Integer> orderList = new ArrayList<>();
        orderList.add(getNums(hotDogString));
        orderList.add(getNums(bratString));
        orderList.add(getNums(burgerString));
        orderList.add(getNums(friesString));
        orderList.add(getNums(sodaString));
        orderList.add(getNums(waterString));
        
        //creates the receipt if the fields are not blank
        if(!arrayListIsEmpty(orderList)){
            Receipt r = new Receipt();
            r.createReceipt(orderList, 0, false);
        }
        
    }
    
    //parses the string into an usuable integer, if it is blank, it returns 0
    private int getNums(String string){
        int num = 0;
        try{
            if(string.isEmpty()){
                num = 0;
            }
            else{
                num = Integer.parseInt(string);
            }
        }
        catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        return num;
    }
    
    private boolean arrayListIsEmpty(ArrayList<Integer> list){
        int nums = 0;
        
        for (int x = 0; x < 6; x++){
            if(list.get(x).equals(0)){
                nums++;
            }
            else{
                
            }
        }
        return nums == 6;
    }
}
