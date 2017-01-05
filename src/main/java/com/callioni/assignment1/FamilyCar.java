
package com.callioni.assignment1;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class FamilyCar extends Car implements Serializable
{

	private Boolean sunRoof;
	private Boolean airCon;
	private Boolean gps;

	public FamilyCar()
	{

	}

	public FamilyCar(Boolean sunRoof, Boolean airCon, Boolean gps, String colour, Integer yearOfManufacture, String transmission, Double price, Integer hp, String make, String model, Long rego)
	{
		super(colour, yearOfManufacture, transmission, price, hp, make, model, rego);
		this.sunRoof = sunRoof;
		this.airCon = airCon;
		this.gps = gps;
	}
	
	public Boolean isSunRoof()
	{
		return this.sunRoof;
	}

	public void setSunRoof(Boolean sunRoof)
	{
		this.sunRoof = sunRoof;
	}

	public Boolean isAirCon()
	{
		return this.airCon;
	}

	public void setAirCon(Boolean airCon)
	{
		this.airCon = airCon;
	}

	public Boolean isGps()
	{
		return this.gps;
	}

	public void setGps(Boolean gps)
	{
		this.gps = gps;
	}

	@Override
	public String toString()
	{
		return super.toString()+" FamilyCar{" + "sunRoof=" + sunRoof + ", airCon=" + airCon + ", gps=" + gps + '}';
	}
	
}
