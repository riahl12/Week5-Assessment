package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;
import model.OwnerListDetails;
import model.Pets;

/**
 * Servlet implementation class CreateNewPetListServlet
 */
@WebServlet("/createNewPetListServlet")
public class CreateNewPetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewPetListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PetsHelper pe = new PetsHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		String [] selectedPets = request.getParameterValues("allPetsToAdd");
		List<Pets> selectedPetsInList = new ArrayList<Pets>();
			if(selectedPets != null && selectedPets.length > 0) {
				for(int i = 0; i < selectedPets.length; i++) {
					System.out.println(selectedPets[i]);
					Pets p = pe.searchForItemById(Integer.parseInt(selectedPets[i]));
					selectedPetsInList.add(p);
				}
			}
			
			Owner owner = new Owner(firstName, lastName);
			OwnerListDetails old = new OwnerListDetails(listName,owner);
			
			old.setListOfPets(selectedPetsInList);
			OwnerListDetailsHelper oldh = new OwnerListDetailsHelper();
			oldh.insertNewOwnerListDetails(old);
			
			System.out.println("Success!");
			System.out.println(old.toString());
			
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
