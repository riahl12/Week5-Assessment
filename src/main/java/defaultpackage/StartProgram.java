package defaultpackage;
/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Feb 5, 2023
 */

import java.util.List;
import java.util.Scanner;

import controller.PetsHelper;
import model.Pets;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static PetsHelper lih = new PetsHelper();

		private static void addAnItem() {
			System.out.print("Enter your pets name: ");
			String petName = in.nextLine();
			System.out.print("Enter your pets species: ");
			String petSpecies = in.nextLine();
			Pets toAdd = new Pets(petName,petSpecies);
			lih.insertPet(toAdd);

		}

		private static void deleteAnItem() {
			System.out.print("Enter the pet name to delete: ");
			String petName = in.nextLine();
			System.out.print("Enter the pet species to delete: ");
			String petSpecies = in.nextLine();
			Pets toDelete = new Pets(petName, petSpecies);
			lih.deletePet(toDelete);

		}

		private static void editAnItem() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Pet Name");
			System.out.println("2 : Search by Pet Species");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Pets> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the pet name: ");
				String petName = in.nextLine();
				foundItems = lih.searchForItemByPetName(petName);
			} else {
				System.out.print("Enter the pet species: ");
				String petSpecies = in.nextLine();
				foundItems = lih.searchForItemByPetSpecies(petSpecies);
				

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (Pets l : foundItems) {
					System.out.println(l.getPetId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Pets toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getPetSpecies() + " from " + toEdit.getPetName());
				System.out.println("1 : Update Pet Name");
				System.out.println("2 : Update Pet Species");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Pet Name: ");
					String newPetName = in.nextLine();
					toEdit.setPetName(newPetName);
				} else if (update == 2) {
					System.out.print("New Pet Species: ");
					String newPetSpecies = in.nextLine();
					toEdit.setPetSpecies(newPetSpecies);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to my Pet Info list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a pet");
				System.out.println("*  2 -- Edit a pet");
				System.out.println("*  3 -- Delete a pet");
				System.out.println("*  4 -- View the pet list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Pets> allPets = lih.showAllPets();
			for(Pets singleItem : allPets) {
				System.out.println(singleItem.returnPetDetails());
			}

		}

	}
