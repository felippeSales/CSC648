package csc668;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

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
        ArrayList<Product> foundProducts = new ArrayList();
        try{
            if (fileName.equalsIgnoreCase("ReceiptList.txt"))
            {
        out = new PrintWriter(new FileWriter(fileName, true));
            }
<<<<<<< HEAD
            else{
                out = new PrintWriter(new FileWriter("Receipts/"+fileName, true));
=======

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
                    //receipt += "Paid by Credit Card " + ((CreditPayment) transaction.getType()).getCheckNumber();
                }

                receipt += "Amount Returned: " + transaction.getAmountReturned();
                
            //Invalid transaction
            } else {
                receipt += "Invalid transaction";
>>>>>>> 2593c046df929d61d797b630336192458c6385f1
            }
        out.println("--------------------");
        out.println("STORE NAME \n");
        out.println("");
        out.println(currTrans.getName() + " " + currTrans.getDate() +
                " " + currTrans.getTime());
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
        if (currTrans.getPayType()=="cash")
        {
            out.println(currTrans.getAmountTendered());
        }
        else if (currTrans.getPayType()=="check"){
            out.println("Paid by " + currTrans.getPayType());
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

