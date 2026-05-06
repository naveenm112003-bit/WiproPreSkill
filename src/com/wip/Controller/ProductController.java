package com.wip.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.wip.dao.ProductDao;
import com.wip.model.Product;

public class ProductController implements ProductInterface {

	Product pr; // Class Instantiation
	Scanner sc = new Scanner(System.in);
	List<Product> prList = new ArrayList<>();
	ProductDao dao = new ProductDao();

	public void addProduct() {
		pr = new Product();
		System.out.println("Enter the Prod ID:");
		int prid = sc.nextInt();
		pr.setPid(prid);

		System.out.println("Enter the Prod Name:");
		String prName = sc.next();
		pr.setPname(prName);
		// pr = new Product(prid,prName);

		prList.add(pr);
		dao.insertProduct(pr);
		System.out.println("Product Added Successfully !!!");

	}

	public void viewProduct() {
//		System.out.println(pr.getPid() + " -- " + pr.getPname());
		System.out.println(prList);
//		Iterator itlist  = prList.iterator();
//		while(itlist.hasNext()) {
//			System.out.println(itlist.next());
//		}
		dao.retrieveProducts();
	}

	public void updateProduct() {
		System.out.println("Enter product ID:");
		int id = sc.nextInt();
		System.out.println("Enter new name");
		String name = sc.next();
		Product pr = new Product();
		pr.setPid(id);
		pr.setPname(name);
		dao.updateProduct(pr);
	}

	public void deleteProduct() {
		System.out.println("Enter product ID:");
		int id = sc.nextInt();
		dao.deleteProduct(id);
	}
	
	
	public void addProductUsingProcedure() {
		pr = new Product();
		System.out.println("Enter the Prod ID:");
		int prid = sc.nextInt();
		pr.setPid(prid);

		System.out.println("Enter the Prod Name:");
		String prName = sc.next();
		pr.setPname(prName);
		dao.addProductUsingProcedure(pr);
		System.out.println("Product Added Successfully via Procedure!!!");
	}
	public void findProductNameById() {
		System.out.println("Enter product ID:");
		int id = sc.nextInt();
		dao.getProductNameById(id);

}
}
