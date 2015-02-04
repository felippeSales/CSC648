package csc668;


public class CreditPayment extends Payment
{
        private int creditNumber;
        private String type;
    
    public CreditPayment(int newCreditNumber){
        this.creditNumber=newCreditNumber;
        this.type = "Credit";
    }
    
    public void setCreditNumber(int newCreditNumber){
        this.creditNumber = newCreditNumber;
    }
    public int getCheckNumber(){
        return this.creditNumber;
    }
    public String getType(){
        return type;
    }
    
    
}
