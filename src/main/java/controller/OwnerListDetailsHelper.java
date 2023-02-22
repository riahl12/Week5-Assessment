/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Feb 21, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.OwnerListDetails;

public class OwnerListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPetInfo");
	
	public void insertNewOwnerListDetails(OwnerListDetails o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<OwnerListDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<OwnerListDetails> allDetails = em.createQuery("SELECT d FROM OwnerListDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(OwnerListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<OwnerListDetails> typedQuery = em.createQuery("SELECT detail FROM OwnerListDetails detail WHERE detail.id = :selectedId", OwnerListDetails.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		//typedQuery.setMaxResults(1);
		
		OwnerListDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public OwnerListDetails searchForOwnerListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		OwnerListDetails found = em.find(OwnerListDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(OwnerListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	
	
	
	
}
