package csc668;
import java.util.Random;

public class Payment {
    Payment()
    {
    }
    
     public boolean isValid(){
         Random rand = new Random();
         int randomInt = rand.nextInt(100);
         if (randomInt%10 == 0){
             return false;
         }
         else return true;
    }
     
}
