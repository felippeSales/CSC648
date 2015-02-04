
package csc668;

public class CheckPayment extends Payment {
    private int checkNumber;
    private String type;
    
    public CheckPayment(int newCheckNumber){
        this.checkNumber=newCheckNumber;
        this.type = "Check";
    }
    
    public void setCheckNumber(int newCheckNumber){
        this.checkNumber = newCheckNumber;
    }
    public int getCheckNumber(){
        return this.checkNumber;
    }
    public String getType(){
        return type;
    }
    
}
