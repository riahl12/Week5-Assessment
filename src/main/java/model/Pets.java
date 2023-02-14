/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Feb 5, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="petInfo")
public class Pets {
	@Id
	@GeneratedValue
	@Column(name="PetID")
	private int petId;
	@Column(name="PetName")
	private String petName;
	@Column(name="PetSpecies")
	private String petSpecies;
	
	public Pets() {
		super();
	}
	
	public Pets(String petName, String petSpecies) {
		super();
		this.petName = petName;
		this.petSpecies = petSpecies;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetSpecies() {
		return petSpecies;
	}

	public void setPetSpecies(String petSpecies) {
		this.petSpecies = petSpecies;
	}
	
	public String returnPetDetails() {
		return this.petName + ": " + this.petSpecies;
	}
	
	
}
