package csc668.UI;

import csc668.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felipesales
 */
public class ProductsFile {

    private ArrayList<Product> products;
    private String fileName;

    public ProductsFile(String fileName) {
        products = new ArrayList();
        this.fileName = fileName;
        
        parse();
    }

    public ArrayList<Product> getProducts(){
        return products;
    }
    
    private void parse() {
        BufferedReader buffer = null;
        String upc, description;
        double price;

        try {

            String sCurrentLine;
            Product newProduct = null;

            buffer = new BufferedReader(new FileReader(fileName));

            while ((sCurrentLine = buffer.readLine()) != null) {
                
                try {
                    upc = sCurrentLine.substring(0,4);
                    description = sCurrentLine.substring(9, 29);
                    price = Double.parseDouble(sCurrentLine.substring(35));

                    newProduct = new Product(upc, description, price);

                    products.add(newProduct);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
