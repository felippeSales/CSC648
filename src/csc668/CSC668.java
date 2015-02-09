/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668;

/**
 *
 * @author moseslee
 */
import csc668.UI.ProductsFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class CSC668 {

    public static void main(String args[]) throws IOException
    {
        //Variables tat the entire program needs
        ProductsFile productDB = new ProductsFile("products.txt");
        ArrayList <Product> productDBList = productDB.getProducts();
        ArrayList <Product> custProductList;
        ArrayList <Transaction> currentTransaction = null;
        
        //Variables if the user reads from order file
        int hasOrderForm = 1;   //1 to read from a transaction file else to manually input
        String fileName;        //User specified order file
        TransactionFile orderForm = null; //Class to process the order

        //Variables if the user manually inputs
        String name;
        Payment payType;

        //Greeting and intro
        System.out.println("Welcome to Point of Sale Terminal!");
        System.out.println("Enter your name, the UPC numbers and " + 
                            "your method of payment");
        System.out.println("Afterwards a receipt will be printed for you");
        Scanner inputScan = new Scanner(System.in);

        //Begin the user interaction
        while(hasOrderForm >= 0)
        {
            System.out.println("Please enter 1 if you have an order form");
            System.out.println("If not enter 0 or -1 to exit: ");

            hasOrderForm = inputScan.nextInt();
            //Reads the order form
            if(hasOrderForm == 1)
            {
               System.out.println("Enter in the order file name: ");
               fileName = inputScan.next();
               //try
               //{
                   orderForm = new TransactionFile(fileName, productDBList);
               
             //  }
//               catch (Exception e)
//               {
//                   System.out.println("Invalid File Try Again");
//                   break;
//               }
               
               
               currentTransaction = orderForm.getTransactions();
               for(Transaction t : currentTransaction)
               {
                   System.out.println("Name: " + t.getName());
                   System.out.println("total price: " + t.getTotalPrice());
                   if(t.getPayType() instanceof CreditPayment)
                   {
                       System.out.println("Paid by credit card");
                       System.out.println("Credit Number:" + ((CreditPayment )t.getPayType()).getCreditNumber());
                       System.out.println("Is valid: " + t.getPayType().isValid());
                   }
                   else if(t.getPayType() instanceof CheckPayment)
                   {
                       System.out.println("Paid by check");
                       System.out.println("Check Number:" + ((CheckPayment )t.getPayType()).getCheckNumber());
                       System.out.println("Is valid: " + t.getPayType().isValid());
                       System.out.println("Amount tendered: " + t.getAmountTendered());
                       System.out.println("Amount returned: " + t.getAmountReturned());
                   }
                   else if(t.getPayType() instanceof CashPayment)
                   {
                       System.out.println("Paid by cash");
                       System.out.println("Amount tendered: " + t.getAmountTendered());
                       System.out.println("Amount returned: " + t.getAmountReturned());
                   }
                   for(Product p : t.getProducts())
                   {
                       System.out.println(p.getName());
                   }
               }
            }
            //User manualy inputs order
            else if(hasOrderForm == 0)
            {

                System.out.println("Enter your name: ");
                name = inputScan.next();
                while(true)
                {
                    System.out.println("Enter the UPC of your item (Enter -1 to if done): ");
                    int upc = inputScan.nextInt();
                    if(upc == -1) break;
                }
            }
        }
    }   
}

