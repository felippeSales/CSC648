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
        String name;
        Payment payType;
        ArrayList <Product> custProductList;
        ProductsFile productDB = new ProductsFile("products.txt");
        ArrayList <Product> productDBList = productDB.parse();
        int hasOrderForm = 1;   //1 to read from a transaction file else to manually input
        TransactionFile orderForm;
        
	ArrayList <Product> productList1 = new ArrayList();
        ArrayList <Product> productList2 = new ArrayList();
        ArrayList <Product> productList3 = new ArrayList();

	for (int i = 0; i < 10; i++)
	{
		Product p = new Product("1234", "Toilet", 50.50);
		Product p1 = new Product("0987", "Sink", 100.00);
		Product p2 = new Product("7889", "tub", 500.00);

		productList1.add(p);
		productList2.add(p1);
		productList3.add(p2);
	}



	/*Payment payCredit = new Credit();
	Payment payCheck = new Check();
	Payment payCash = new Cash();*/

	Transaction t1 = new Transaction();
	Transaction t2 = new Transaction();
	Transaction t3 = new Transaction();

        //Greeting and intro
        System.out.println("Welcome to Point of Sale Terminal!");
        System.out.println("Enter your name, the UPC numbers and " + 
                            "your method of payment");
        System.out.println("Afterwards a receipt will be printed for you");
        System.out.println("Please enter 1 if you have an order form");
        System.out.println("If not enter 0");
        Scanner inputScan = new Scanner(System.in);
                    
        hasOrderForm = inputScan.nextInt();
        
        if(hasOrderForm == 1)
        {
           
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
 
    /**
     * Test print method to ensure correct
     * method functions
     * @param t
     */
     void printTransactionRecords(Transaction t)
    {

    }
    
}

