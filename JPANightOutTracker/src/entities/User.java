package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "number_of_drinks")
	private int numberOfDrinks;
	
	@Column(name = "number_of_hours")
	private int numberOfHours;
	
	@Column(name = "total_calories")
	private int totalCalories;
	
	@Column(name = "number_of_hookups")
	private int numberOfHookups;
	
	@Column(name = "did_puke")
	private boolean didPuke;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfDrinks() {
		return numberOfDrinks;
	}

	public void setNumberOfDrinks(int numberOfDrinks) {
		this.numberOfDrinks = numberOfDrinks;
	}

	public int getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public int getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(int totalCalories) {
		this.totalCalories = totalCalories;
	}

	public int getNumberOfHookups() {
		return numberOfHookups;
	}

	public void setNumberOfHookups(int numberOfHookups) {
		this.numberOfHookups = numberOfHookups;
	}

	public boolean getDidPuke() {
		return didPuke;
	}

	public void setDidPuke(boolean didPuke) {
		this.didPuke = didPuke;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", numberOfDrinks=" + numberOfDrinks + ", numberOfHours="
				+ numberOfHours + ", totalCalories=" + totalCalories + ", numberOfHookups=" + numberOfHookups
				+ ", didPuke=" + didPuke + "]";
	}
	
}
