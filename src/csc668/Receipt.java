package csc668;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

public class Receipt {
    Transaction currTrans;
    ArrayList <Transaction> transList;
    private String storeName;
    private String date;
    private String time;
    private String customerName;
    private String productName;
    private double totalPrice;
    private double amountReturned;
    private double amountTendered;
    
    
    Receipt(Transaction t)
    {
        currTrans = t;
    }
    
    Receipt(ArrayList<Transaction> t)
    {
        transList = t;
    }
    
    public void WriteFile(String fileName){
        PrintWriter out;
        File file = new File("Receipts");
        file.mkdir();
        ArrayList<Product> foundProducts = new ArrayList();
        try{
            if (fileName.equalsIgnoreCase("ReceiptList.txt"))
            {
        out = new PrintWriter(new FileWriter(fileName, true));
            }

            else{
                fileName = fileName.replaceAll(" ", "_");
                fileName = fileName.replaceAll("/", "_");
                
                out = new PrintWriter(new FileWriter("Receipts/"+fileName.replaceAll(":", "_")+".txt", true));
            } 
        out.println("--------------------");
        out.println("STORE NAME \n");
        out.println("");
        out.println(currTrans.getName() + " " + currTrans.getDateAndTime());
        out.println("");
        for (Product p : currTrans.getProducts()){
            if (foundProducts.contains(p)==false)
            {
            out.println("Item " + p.getName() + " " + currTrans.getQuantity(p) + " @ " + p.getPrice());
            foundProducts.add(p);
            }
        }
        out.println("Total: " + currTrans.getTotalPrice());
        out.print("Amount Tendered: ");
        if (currTrans.getType().equals("cash"))
        {
            out.println(currTrans.getAmountTendered());
        }
        else if (currTrans.getType().equals("check")){ 
           out.println("Paid by " + currTrans.getType());
        }
        else{
            out.println("num is credit card #");
        }
        out.println("Amount Returned: " + currTrans.getAmountReturned());
        out.println("--------------------");
        out.close();
        }
        catch(Exception e){System.out.println("File not found");}
    }

}

