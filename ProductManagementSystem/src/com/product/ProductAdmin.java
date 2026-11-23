package com.product;

public class ProductAdmin {
	public static void main(String[] args) {
		ProductDetails pd=new ProductDetails();
		Product p1=pd.addProduct();
		System.out.println(p1.pid+" "+p1.pname+" "+p1.price);
		Order o1=pd.addOrder();
		System.out.println(o1.oid+" "+o1.name+" "+o1.address);
		Customer c1=pd.addCustomer();
		System.out.println(c1.cid+" "+c1.name+" "+c1.email+" "+c1.contact);
		
	}

}
