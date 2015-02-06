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
import java.util.ArrayList;
import java.util.Scanner;
public class CSC668 {

    public static void main(String args[])
    {
        //Variables tat the entire program needs
        ProductsFile productDB = new ProductsFile("products.txt");
        ArrayList <Product> productDBList = productDB.getProducts();
        ArrayList <Product> custProductList;
        Transaction t;
        
        //Variables if the user reads from order file
        int hasOrderForm = 1;   //1 to read from a transaction file else to manually input
        String fileName;
        TransactionFile orderForm;

        //Variables if the user manually inputs
        String name;
        Payment payType;

        //Greeting and intro
        System.out.println("Welcome to Point of Sale Terminal!");
        System.out.println("Enter your name, the UPC numbers and " + 
                            "your method of payment");
        System.out.println("Afterwards a receipt will be printed for you");

        //Begin the user interaction
        while(hasOrderForm >= 0)
        {
            System.out.println("Please enter 1 if you have an order form");
            System.out.println("If not enter 0 or -1 to exit");
            Scanner inputScan = new Scanner(System.in);

            hasOrderForm = inputScan.nextInt();
            //Reads the order form
            if(hasOrderForm == 1)
            {
               System.out.println("Enter in the order file name: ");
               fileName = inputScan.next();
               try
               {
                orderForm = new TransactionFile(fileName);
               }
               catch (Exception e){
                   System.out.println("Invalid File Try Again");
               }
               
               
            }
            //User manualy inputs order
            else
            {

                System.out.println("Enter your name: ");
                name = inputScan.next();
                while(true)
                {
                    System.out.println("Enter the UPC of your item (Enter -1 to if done): ");
                    int upc = inputScan.nextInt();
                }
            }
        }
    }   
}

