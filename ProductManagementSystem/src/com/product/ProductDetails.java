package com.product;

public class ProductDetails {
	public Product addProduct()
	{
		Product p=new Product();
		p.pid=1;
		p.pname="Hair Dryer";
		p.price=2000;
		return p;
	}
	public Order addOrder()
	{
		Order o=new Order();
		o.oid=2;
		o.name="polo";
		o.address="pune";
		return o;
		
	}
	public Customer addCustomer()
	{
		Customer c=new Customer();
		c.cid=100;
		c.name="pranav";
		c.email="pranav11@gmail.com";
		c.contact=8390199127l;
		return c;
		
	}

}
