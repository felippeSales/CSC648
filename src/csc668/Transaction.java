/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668;

import java.util.ArrayList;

/**
 *
 * @author moseslee
 */
public class Transaction
{
	double totalPrice;
	double amountTendered;
	double amountReturned;
	boolean validTransaction;
	Payment pay;
	String name;
	ArrayList <Product> products;
        private enum payTypes {CHECK, CREDIT, CASH};
        
        Transaction()
        {
            products = new ArrayList();
            
        }
        
        Transaction(Payment p)
        {
            //@TODO Bryan this is what you should use
            //The java instanceof takes care of checking types for us
           products = new ArrayList();
           if(p instanceof CreditPayment)
           {
               
           }
           if(p instanceof CheckPayment)
           {
               
           }
           
           if(p instanceof CashPayment)
           {
               
           }
        }

	private void calculateTotalPrice()
	{
            if(validTransaction){
                for (Product p : products)
                {
                    totalPrice += p.getPrice();
                }
            }
            else{
                totalPrice = 0.0;
            }
	}
        
        double getTotalPrice()
        {
            return totalPrice;
        }
        
        void setAmountTendered(double amount)
        {
            amountTendered = amount;
        }
        
        double getAmountTendered()
        {
            return amountTendered;
        }
        
        private void calculateAmountReturned()
        {
            amountReturned = amountTendered - totalPrice;
        }
        
        double getAmountReturned()
        {
            return amountReturned;
        }

	boolean isValidTransaction()
	{
            return validTransaction;
	}
        
        private void setValidTransaction()
        {
            validTransaction = pay.isValid();
        }


}

