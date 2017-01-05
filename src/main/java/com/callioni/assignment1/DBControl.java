package com.callioni.assignment1;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Class to manage entities in the database
 * @author Peter
 */
public class DBControl
{

	private EntityManager em;
	private EntityManagerFactory emf;
	private EntityTransaction tx;

	/**
	 * Creates a DBControl object with a EntityManager based on passed String. Begins a EntityTransaction.
	 * @param PU 
	 */
	public DBControl(String PU)
	{
		emf = Persistence.createEntityManagerFactory(PU); //Persistence unit
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	/**
	 * Tests database persistence. Creates two Customers, two Cars, two Orders (for each customer)
	 * and four Order_Lines (two for each order).
	 */
	public void test()
	{
		//makes two new customers
		//firstname, lastname, phone number, address, post code, state, email
		createCustomer("Jon", "Doe", 3243214, "21 Cloverfield lane", 2222, "QLQ", "email@fakeemail.net");
		createCustomer("Jane", "Smith", 5463365, "53 Springfield Dr", 3333, "NSW", "1234@hotmail.com");

		//makes two new cars
		//Boolean turboCharger, Boolean sportsPackage, Boolean launchAssist, String colour, Integer yearOfManufacture, String transmission, Double price, Integer hp, String make, String model, Long rego
		createSportsCar(true, false, true, "Red", 2014, "Manual", 3100000.0, 300, "Nissan", "Sportage", 321821318293L);;
		//Boolean sunRoof, Boolean airCon, Boolean gps, String colour, Integer yearOfManufacture, String transmission, Double price, Integer hp, String model, String make, Long rego
		createFamilyCar(true, true, false, "White", 2010, "Automatic", 50000.0, 150, "Subaru", "Forester", 7899183413143l);

		//makes new orders
		EOrder order1 = new EOrder(findCustomer("Jon", "Doe", 3243214), new Date());
		EOrder order2 = new EOrder(findCustomer("Jane", "Smith", 5463365), new Date());

		//creates Order_Lines
		//quantity, order, Car
		createOrderLine(1, order1, findCar("Nissan", "Sportage", 2014));
		createOrderLine(2, order1, findCar("Subaru", "Forester", 2010));
		createOrderLine(1, order2, findCar("Subaru", "Forester", 2010));
		createOrderLine(2, order2, findCar("Nissan", "Sportage", 2014));

		tx.commit();
		System.out.println("Data is persisted");
	}

	/**
	 * Returns all Car entities in database
	 *
	 * @return
	 */
	public List<Car> getCars()
	{
		List<Car> results;
		TypedQuery<Car> query = em.createQuery("SELECT c FROM Car c", Car.class);
		results = query.getResultList();
		return results;
	}

	/**
	 * Returns all Customer entities in database
	 *
	 * @return 
	 */
	public List<Customer> getCustomers()
	{
		List<Customer> results;
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
		results = query.getResultList();
		return results;
	}

	/**
	 * Returns all EOrder entities in database
	 *
	 * @return
	 */
	public List<EOrder> getEOrders()
	{
		List<EOrder> results;
		TypedQuery<EOrder> query = em.createQuery("SELECT c FROM EOrder c", EOrder.class);
		results = query.getResultList();
		return results;
	}

	/**
	 * Returns all Order_Line entities in database
	 *
	 * @return
	 */
	public List<Order_Line> getLines()
	{
		List<Order_Line> results;
		Query query = em.createQuery("SELECT c FROM Order_Line c");
		results = query.getResultList();
		return results;
	}

	/**
	 * Closes the EntityManager connection to the database
	 */
	public void close()
	{
		em.close();
		emf.close();
	}

	//methods to create entities
	/**
	 * Creates a new Order_Line
	 * @param quantity
	 * @param order
	 * @param car 
	 */
	public void createOrderLine(Integer quantity, EOrder order, Car car)
	{
		Order_Line line = new Order_Line();
		line.setQuantity(quantity);
		line.setCar(car);
		line.setEorder(order);
		em.persist(line);
	}

	/**
	 * Creates a new Customer
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param address
	 * @param postCode
	 * @param _state
	 * @param email 
	 */
	public void createCustomer(String firstName, String lastName, Integer phone, String address, Integer postCode, String _state, String email)
	{
		Customer customer = new Customer(firstName, lastName, phone, address, postCode, _state, email);
		em.persist(customer);
	}

	/**
	 * Creates a new SportsCar
	 * @param turboCharger
	 * @param sportsPackage
	 * @param launchAssist
	 * @param colour
	 * @param yearOfManufacture
	 * @param transmission
	 * @param price
	 * @param hp
	 * @param make
	 * @param model
	 * @param rego 
	 */
	public void createSportsCar(Boolean turboCharger, Boolean sportsPackage, Boolean launchAssist, String colour, Integer yearOfManufacture, String transmission, Double price, Integer hp, String make, String model, Long rego)
	{
		Car sc = new SportsCar(turboCharger, sportsPackage, launchAssist, colour, yearOfManufacture, transmission, price, hp, make, model, rego);
		em.persist(sc);
	}

	/**
	 * Creates a new FamilyCar
	 * @param sunRoof
	 * @param airCon
	 * @param gps
	 * @param colour
	 * @param yearOfManufacture
	 * @param transmission
	 * @param price
	 * @param hp
	 * @param make
	 * @param model
	 * @param rego 
	 */
	public void createFamilyCar(Boolean sunRoof, Boolean airCon, Boolean gps, String colour, Integer yearOfManufacture, String transmission, Double price, Integer hp, String make, String model, Long rego)
	{
		Car fc = new FamilyCar(sunRoof, airCon, gps, colour, yearOfManufacture, transmission, price, hp, make, model, rego);
		em.persist(fc);
	}

	//example methods to search
	/**
	 * Finds a Customer based on arguments
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @return 
	 */
	public Customer findCustomer(String firstName, String lastName, Integer phone)
	{
		String jpqlQuery = "SELECT c FROM Customer c WHERE c.firstName = :fname AND c.lastName =:lname AND c.phone = :phone";
		TypedQuery query = em.createQuery(jpqlQuery, Customer.class);
		query.setParameter("fname", firstName);
		query.setParameter("lname", lastName);
		query.setParameter("phone", phone);
		return (Customer) query.getSingleResult();
	}

	/**
	 * Finds a Car based on arguments
	 * @param make
	 * @param model
	 * @param year
	 * @return 
	 */
	public Car findCar(String make, String model, Integer year)
	{
		String jpqlQuery = "SELECT c FROM Car c WHERE c.make = :make AND c.model =:model AND c.yearOfManufacture = :year";
		TypedQuery query = em.createQuery(jpqlQuery, Car.class);
		query.setParameter("make", make);
		query.setParameter("model", model);
		query.setParameter("year", year);
		return (Car) query.getSingleResult();
	}
}
