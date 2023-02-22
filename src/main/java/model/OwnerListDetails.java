/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Feb 21, 2023
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OwnerListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	private List<Pets> listOfPets;
	
	public OwnerListDetails() {
		super();
	}
	
	public OwnerListDetails(int id, String listName, Owner owner, List<Pets> listOfPets) {
		super();
		this.id = id;
		this.listName = listName;
		this.owner = owner;
		this.listOfPets = listOfPets;
	}
	
	public OwnerListDetails(String listName, Owner owner, List<Pets> listOfPets) {
		super();
		this.listName = listName;
		this.owner = owner;
		this.listOfPets = listOfPets;
	}
	
	public OwnerListDetails(String listName, Owner owner) {
		super();
		this.listName = listName;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Pets> getListOfPets() {
		return listOfPets;
	}

	public void setListOfPets(List<Pets> listOfPets) {
		this.listOfPets = listOfPets;
	}

	@Override
	public String toString() {
		return "OwnerListDetails [id=" + id + ", listName=" + listName + ", owner=" + owner + ", listOfPets="
				+ listOfPets + "]";
	}
	
	
}
