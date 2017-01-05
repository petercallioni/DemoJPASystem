package com.callioni.assignment1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Describes a generic car entity
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Car implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String colour;

	private Integer yearOfManufacture;

	private String transmission;

	private Double price;

	private Integer hp;

	private String model;

	private String make;

	private Long rego;
	public Car()
	{

	}

	public Car(String colour, Integer yearOfManufacture, String transmission, Double price, Integer hp, String make, String model, Long rego)
	{
		this.colour = colour;
		this.yearOfManufacture = yearOfManufacture;
		this.transmission = transmission;
		this.price = price;
		this.hp = hp;
		this.model = model;
		this.make = make;
		this.rego = rego;
	}
	

	public String getColour()
	{
		return this.colour;
	}

	public void setColour(String colour)
	{
		this.colour = colour;
	}

	public Integer getYearOfManufacture()
	{
		return this.yearOfManufacture;
	}

	public void setYearOfManufacture(Integer yearOfManufacture)
	{
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getTransmission()
	{
		return this.transmission;
	}

	public void setTransmission(String transmission)
	{
		this.transmission = transmission;
	}

	public Double getPrice()
	{
		return this.price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Integer getHp()
	{
		return this.hp;
	}

	public void setHp(Integer hp)
	{
		this.hp = hp;
	}

	public String getModel()
	{
		return this.model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getMake()
	{
		return this.make;
	}

	public void setMake(String make)
	{
		this.make = make;
	}

	public Long getRego()
	{
		return this.rego;
	}

	public void setRego(Long rego)
	{
		this.rego = rego;
	}

	@Override
	public String toString()
	{
		return "Car{" + "id=" + id + ", colour=" + colour + ", yearOfManufacture=" + yearOfManufacture + ", transmission=" + transmission + ", price=" + price + ", hp=" + hp + ", model=" + model + ", make=" + make + ", rego=" + rego + '}';
	}
	
}
