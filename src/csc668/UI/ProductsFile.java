package csc668.UI;

import csc668.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
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

    List<Product> products;
    String fileName;

    public ProductsFile(String fileName) {
        products = new ArrayList<Product>();
        this.fileName = fileName;
    }

    public List<Product> parse() {
        BufferedReader buffer = null;

        try {

            String sCurrentLine;
            Product newProduct = null;

            buffer = new BufferedReader(new FileReader(fileName));

            while ((sCurrentLine = buffer.readLine()) != null) {
                String[] parts = sCurrentLine.split(";");
                newProduct = new Product(parts[0], parts[1], Double.parseDouble(parts[2]));
                
                products.add(newProduct);
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

        return products;
    }
}