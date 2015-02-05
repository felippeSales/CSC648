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
	Payment payType;
	String name;
        String time;
        String date;
        String type;
	ArrayList <Product> products;
        private enum payTypes {CHECK, CREDIT, CASH};
        private final static String checkType = "check";
        private final static String cashType = "cash";
        private final static String creditType = "credit";
        
        //@TODO ADD CONSTRUCTOR TO GET PRODUCT LIST
        Transaction()
        {
            products = new ArrayList();
            
        }
        
        Transaction(Payment pay, ArrayList <Product> payList)
        {
            //@TODO Bryan this is what you should use
            //The java instanceof takes care of checking types for us
           products = new ArrayList();
           if(pay instanceof CreditPayment)
           {
               type = creditType;
           }
           if(pay instanceof CheckPayment)
           {
               type = checkType;
           }
           
           if(pay instanceof CashPayment)
           {
               type = cashType;
           }
           
           
           
           //Check to see if the payment is valid
           setValidTransaction();
           
           //If its cash payment calculate the change
           if(type.equals(cashType))
           {
               calculateAmountReturned();
           }
        }

	public void calculateTotalPrice()
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
            validTransaction = payType.isValid();
        }
        
        


}