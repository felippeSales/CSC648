package csc668;


public class Product 
{
    private String upc;
    private String name;
    double price;
    
    public String getUPC(){
        return this.upc;
    }
    public void setUPC(String newUPC){
        this.upc=newUPC;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public double getPrice(){
        return price;
    }
    
}
