package csc668;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RussellLeong
 */
package csc668;

import java.util.ArrayList;


public class Receipt {
    Transaction currTrans;
    ArrayList <Transaction> transList;
    
    Receipt(Transaction t)
    {
        currTrans = t;
    }
    
    Receipt(ArrayList<Transaction> t)
    {
        transList = t;
    }
    
    public String print(Transaction transaction) {

        String receipt = "STORE NAME \n \n";

        //Loop through each customer transaction
        for (int i = 0; i < transaction.getProducts().size(); i++) {
            
            receipt += transaction.getName() + "   " + transaction.getDate()
                    + " " + transaction.getTime() + "\n";

            //Loop through each customer's items
            for (int j = 0; j < transaction.products.size(); j++) {
                
                //@TODO Need to fix this to get the correct data
                //I added the needed methods in Transaction class to get the info
                /*receipt += transaction.products.get(i).getName() + ": Quantity:"
                        + transaction.products.get(i) + " @ "
                        + transaction.products.get(i).getPrice() + " subtotal:"
                        + transaction.products.get(i).getQuantity()
                        * transaction.products.get(i).getPrice()
                        + "\n & \n";*/
            }

            //All products of single customer taken care of
            receipt += "------\n"
                    + "Total $" + transaction.getTotalPrice()
                    + "\n Amount Tendered:";

            //Check if transaction is valid
            if ((transaction.validTransaction)) {

                //Check Type if valid
                if (transaction.type.equals("cash")) {
                    receipt += transaction.getAmountTendered();
                    
                } else if (transaction.type.equals("check")) {
                    receipt += "Paid by check";
                    
                } else if (transaction.type.equals("credit")) {
                    receipt += "Paid by Credit Card " + ((CreditPayment) transaction.getType()).getCheckNumber();
                }

                receipt += "Amount Returned: " + transaction.getAmountReturned();
                
            //Invalid transaction
            } else {
                receipt += "Invalid transaction";
            }

            //Get another customer transaction
        }
        return receipt;
    }
}
