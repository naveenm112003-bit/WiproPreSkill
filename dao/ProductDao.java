package com.wip.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wip.model.Product;
import com.wip.util.MyDBConnection;

public class ProductDao {

	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	CallableStatement cs;

	public void insertProduct(Product pr) {
		try {
			con = MyDBConnection.getMyDBConnection();
			ps = con.prepareStatement("insert into product values(?,?)");
			ps.setInt(1, pr.getPid());
			ps.setString(2, pr.getPname());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void retrieveProducts() {
		try {
			con = MyDBConnection.getMyDBConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from product");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void updateProduct(Product pr) {
//update Product set pname=? where pid=?
		try {
			con = MyDBConnection.getMyDBConnection();
			ps = con.prepareStatement("UPDATE product SET pname=? WHERE pid=?");
			ps.setString(1, pr.getPname());
			ps.setInt(2, pr.getPid());
			int noofrows = ps.executeUpdate();
			if (noofrows > 0)
			System.out.println("Product updated successfully !!!!");
			else
				System.out.println("Product not found");

		} catch (SQLException e) {

			e.printStackTrace();
	}
	}

	public void deleteProduct(int pid) {
//delete from product where pid=?;
		try {
			con = MyDBConnection.getMyDBConnection();
			ps = con.prepareStatement("DELETE FROM product WHERE pid=?");
			ps.setInt(1,pid);
			int noofrows = ps.executeUpdate();
			if (noofrows > 0)
			System.out.println("Product deleted successfully !!!!");
			else
				System.out.println("Product not found");

		} catch (SQLException e) {

			e.printStackTrace();
	}
	}
	
	public void addProductUsingProcedure(Product pr) {
		try {
			con = MyDBConnection.getMyDBConnection();
			cs=con.prepareCall("{call createProduct(?,?)}");
			cs.setInt(1, pr.getPid());
			cs.setString(2, pr.getPname());
			int rowsupdated = cs.executeUpdate();
			System.out.println(rowsupdated + " inserted via procedure...");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void getProductNameById(int pid) {
		try {
			con = MyDBConnection.getMyDBConnection();
			cs=con.prepareCall("{call getProductNameById(?)}");
			cs.setInt(1, pid);
			rs= cs.executeQuery();
			if (rs.next()) {
			System.out.println("Product Name: " + rs.getString("pname"));
			} else {
				System.out.println("Product not found!");
			}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}