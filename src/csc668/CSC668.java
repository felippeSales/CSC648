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
import java.util.ArrayList;
public class CSC668 {

 public static void main(String args[])
{
	ArrayList <Product> productList1 = new ArrayList();
        ArrayList <Product> productList2 = new ArrayList();
        ArrayList <Product> productList3 = new ArrayList();

	for (int i = 0; i < 10; i++)
	{
		Product p = new Product();
		Product p1 = new Product();
		Product p2 = new Product();

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

