
package com.callioni.assignment1;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class SportsCar extends Car implements Serializable
{

	private Boolean turboCharger;

	private Boolean sportsPackage;

	private Boolean launchAssist;

	public SportsCar()
	{

	}

	public SportsCar(Boolean turboCharger, Boolean sportsPackage, Boolean launchAssist, String colour, Integer yearOfManufacture, String transmission, Double price, Integer hp, String make, String model, Long rego)
	{
		super(colour, yearOfManufacture, transmission, price, hp, make, model, rego);
		this.turboCharger = turboCharger;
		this.sportsPackage = sportsPackage;
		this.launchAssist = launchAssist;
	}
	
	public Boolean isTurboCharger()
	{
		return this.turboCharger;
	}

	public void setTurboCharger(Boolean turboCharger)
	{
		this.turboCharger = turboCharger;
	}

	public Boolean isSportsPackage()
	{
		return this.sportsPackage;
	}

	public void setSportsPackage(Boolean sportsPackage)
	{
		this.sportsPackage = sportsPackage;
	}

	public Boolean isLaunchAssist()
	{
		return this.launchAssist;
	}

	public void setLaunchAssist(Boolean launchAssist)
	{
		this.launchAssist = launchAssist;
	}

	@Override
	public String toString()
	{
		return super.toString()+" SportsCar{" + "turboCharger=" + turboCharger + ", sportsPackage=" + sportsPackage + ", launchAssist=" + launchAssist + '}';
	}

}
