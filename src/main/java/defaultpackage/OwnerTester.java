/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Feb 21, 2023
 */
package defaultpackage;

import java.util.ArrayList;
import java.util.List;

//import controller.OwnerHelper;
import controller.OwnerListDetailsHelper;
import model.Owner;
import model.OwnerListDetails;
import model.Pets;

public class OwnerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Owner john = new Owner("John", "Smith");
		
		OwnerListDetailsHelper oldh = new OwnerListDetailsHelper();
		
		Pets sammy = new Pets("Sammy", "Dog");
		Pets chloe = new Pets("Chloe", "Cat");
		
		List<Pets> johnsPets = new ArrayList<Pets>();
		johnsPets.add(sammy);
		johnsPets.add(chloe);
		
		OwnerListDetails johnsList = new OwnerListDetails("John's Pet List", john);
		johnsList.setListOfPets(johnsPets);
		
		oldh.insertNewOwnerListDetails(johnsList);
		
		List<OwnerListDetails> allLists = oldh.getLists();
		for(OwnerListDetails a: allLists) {
			System.out.println(a.toString());
		}
		//Owner mark = new Owner("Mark", "Davis");
		//OwnerHelper oh = new OwnerHelper();
		
		//oh.insertOwner(john);
		//oh.insertOwner(mark);
		
		//List<Owner> allOwners = oh.showAllOwners();
		//for(Owner a: allOwners) {
			//System.out.println(a.toString());
		//}
	}

}
