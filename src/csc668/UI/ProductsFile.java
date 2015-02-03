package csc668.UI;

import csc668.Product;
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
    
    public ProductsFile(String fileName){
        products = new ArrayList<Product>();
        this.fileName = fileName;
    }
    
    public List<Product> parse(){
        
        
        return products;
    }
}
