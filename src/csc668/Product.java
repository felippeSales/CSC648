/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
}
