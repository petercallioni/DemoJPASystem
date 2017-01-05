package com.callioni.assignment1;
public class Main
{
	
	public static void main(String[] args)
	{
		DBControl control = new DBControl("com.callioni_Assignment1");	//presistance unit
		// persist test entities
		control.test(); 
		//retrieve test entities
		System.out.println("Customers");
		for (Customer customer : control.getCustomers())
		{
			System.out.println(customer.toString());
		}
		System.out.println("Orders");
		for (EOrder order : control.getEOrders())
		{
			System.out.println(order.toString());
		}
		System.out.println("Lines");
		for (Order_Line line : control.getLines())
		{
			System.out.println(line.toString());
		}
		
		System.out.println("Cars");
		for (Car car : control.getCars())
		{
			System.out.println(car.toString());
		}
		control.close();
	}
}
