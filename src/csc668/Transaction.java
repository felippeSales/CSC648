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
        
        Transaction()
        {
            products = new ArrayList();
            
        }

	private void calculateTotalPrice()
	{
            for (Product p : products)
            {
                //totalPrice += p.getPrice();
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
            //validTransaction = pay.isValidPayment();
        }


}

