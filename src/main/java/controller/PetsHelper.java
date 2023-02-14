/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Feb 5, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Pets;

public class PetsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPetInfo");

	public void insertPet(Pets pe) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pe);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Pets> showAllPets(){
		EntityManager em = emfactory.createEntityManager();
		List<Pets> allPets = em.createQuery("SELECT i FROM Pets i").getResultList();
		return allPets;
	}
	
	public void deletePet(Pets toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pets> typedQuery = em.createQuery("select pe from Pets pe where pe.petName = :selectedPetName and pe.petSpecies = :selectedPetSpecies", Pets.class);
		
		typedQuery.setParameter("selectedPetName", toDelete.getPetName());
		typedQuery.setParameter("selectedPetSpecies", toDelete.getPetSpecies());
		
		typedQuery.setMaxResults(1);
		
		Pets result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Pets searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pets found = em.find(Pets.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(Pets toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Pets> searchForItemByPetName(String petName){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pets> typedQuery = em.createQuery("select pe from Pets pe where pe.petName = :selectedPetName", Pets.class);
		typedQuery.setParameter("selectedPetName", petName);
		
		List<Pets>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public List<Pets> searchForItemByPetSpecies(String petSpecies){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pets> typedQuery = em.createQuery("select pe from Pets pe where pe.petSpecies = :selectedPetSpecies", Pets.class);
		typedQuery.setParameter("selectedPetSpecies", petSpecies);
		
		List<Pets>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
		
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}
