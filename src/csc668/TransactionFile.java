/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csc668;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Optimus Prime
 */
public class TransactionFile
{
    String fileName;
    String custName;
    ArrayList<String> names = new ArrayList();
    ArrayList <String> USBNS = new ArrayList ();
    ArrayList <String> proNames = new ArrayList ();
    String methodOfPay;
    ArrayList <Integer> quant = new ArrayList(); 
    String checkOrCreditNum;
    boolean newCustomer = true;
    
    TransactionFile ()
    {
    fileName = "";
    }
    
    
    ///////////////////////////////////////////////
    // Constructor... Calls Method To start Parsing
    ///////////////////////////////////////////////
    TransactionFile (String a) throws FileNotFoundException, IOException
    {
        fileName = a;
        Go();
    }
    
    
    ////////////////////////////////////////
    // This Methid Parses and Reads The File
    /////////////////////////////////////////
    void Go () throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader (fr);
        String temp = "";
        int count = 0;
        boolean start = true;
        newCustomer = true;
        while ( (temp = br.readLine()) != null )
        {   
            
        // Checks if the String is Empty Starting a New Transaction...
      //  if(temp == null || temp.isEmpty())
      //  {
      //  newCustomer = true;
      //  }
     //   System.out.println("This is Current Temp: " + temp);
        
        ///////////////////////////////////////////////
        //At the end Of File checking method of payment
        ///////////////////////////////////////////////
         if( (newCustomer == true))
        {
            System.out.println("Found a new Customer...");
            //custName = temp;
            names.add(temp);
            newCustomer = false;
        }
         
       else if(temp.contains("Payment") == true  &&  newCustomer == false)
        {
            String[] str_array = temp.split("\\s+");
         //   System.out.println("This is in here...");
            for(int i = 0; i < str_array.length; i++)
            {
        //    System.out.println(str_array[i]);
            }
            methodOfPay = str_array[1];
            if(methodOfPay.equalsIgnoreCase("credit") || methodOfPay.equalsIgnoreCase("check"))
            {
             checkOrCreditNum = str_array[2];   
            }
           else
            {
            checkOrCreditNum = "N/A";
            }
            newCustomer = true;
            br.readLine();
        }
        /////////////
        // GetName
        /////////////
        
        ///////////////////////////
        // Get USBN and Name Quant
        ///////////////////////////
       else if (count >= 1 && newCustomer == false)
        {
            String[] str_array = temp.split("\\s+");
            USBNS.add(str_array[0]);
            if(str_array.length == 1)
            {
             quant.add(1);
            }
            else
            {
             int tempInt = Integer.parseInt(str_array[1]);
             quant.add(tempInt);
             }
        }
       
        count++;
        System.out.print("Here ");
        } // End of the While loop for Looking Through A File...
        fr.close();
    } ///////////////// END OF THE GO METHOD ///////////////////////
    
    /////////////
    
    void printAllData ()
    {
        int count = 0;
        for(String s: USBNS)
        {
            System.out.println("USBNS: " + s + "...at: " + count);
            count++;
        }
        count = 0;
        /*
         for(String s: proNames)
        {
            System.out.println("ProductNames: " + s + "...at: " + count);
            count++;
        }
                */
        
        for(String s: names)
        {
        System.out.println("Names: " + s);
        }
        count = 0;
        for( Integer i: quant)
        {
             System.out.println("Quant: " + i + "...at: " + count);
             count++;
        }
    }
    
    //////////////////////
    // Getters For Data
    /////////////////////
    ArrayList<String> getArrayListOfUPC (){return USBNS;}
    ArrayList<String> getArrayListOfProductNames(){return proNames;}
    ArrayList<Integer> getArrayListOfQuantity () {return quant;}
    ArrayList<String> getNamesList (){return names;}
    String getName (){return custName;} 
}
