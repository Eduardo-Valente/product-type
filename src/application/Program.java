package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ImportedProduct;
import model.entities.Product;
import model.entities.UsedProduct;


/* The program displays labels for three types of products:
 * Common, Imported and Used 
 */


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		List<Product> products = new ArrayList<>();
		
		Integer numberOfProducts;
		char option;
		String productName;
		Float productPrice, customsFee;
		
		Date manufactureDate = null;
		
		System.out.print("Enter the number of products: ");
		numberOfProducts = sc.nextInt();
		
		for(int i = 1; i <= numberOfProducts; i++)
		{
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			option = sc.next().toLowerCase().charAt(0);
			
			switch(option)
			{
			    case 'c': 
			    
			    	System.out.print("Name: ");
			    	sc.nextLine();
			    	productName = sc.nextLine();
			    	System.out.print("Price: ");
			    	productPrice = sc.nextFloat();
			    	
			    	products.add(new Product(productName, productPrice));
			    	
			    break;
			    
			    case 'u': 
				    
			    	System.out.print("Name: ");
			    	sc.nextLine();
			    	productName = sc.nextLine();
			    	System.out.print("Price: ");
			    	productPrice = sc.nextFloat();
			    	System.out.print("Manufacture date (dd/mm/yyyy): ");
			    	
			    	try {
			    		manufactureDate = sdf.parse(sc.next());
			    		products.add(new UsedProduct(productName, productPrice, manufactureDate) );
			    	}
			    	catch(ParseException pe)
			    	{
			    		System.out.println("Please enter a valid date next time.");
			    	}	
			    	
			    break;
			    
			    case 'i':
			    	
			    	System.out.print("Name: ");
			    	sc.nextLine();
			    	productName = sc.nextLine();
			    	System.out.print("Price: ");
			    	productPrice = sc.nextFloat();
			    	System.out.print("Customs fee: ");
			    	customsFee = sc.nextFloat();
			    	
			    	products.add(new ImportedProduct(productName, productPrice, customsFee) );
			    	
			    break;	
			    
			    default: 
			    	
			    	System.out.println("Please, choose one of the options available next time.");
			    
			    break;
			}
		}
		
		System.out.println("PRICE TAGS: ");
		
		for(Product prod : products)
		{
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}
}
