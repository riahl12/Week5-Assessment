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
 * Servlet implementation class EditOwnerListDetailsServlet
 */
@WebServlet("/editOwnerListDetailsServlet")
public class EditOwnerListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOwnerListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OwnerListDetailsHelper dao = new OwnerListDetailsHelper();
		PetsHelper ph = new PetsHelper();
		OwnerHelper oh = new OwnerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		OwnerListDetails listToUpdate = dao.searchForOwnerListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String ownerFirstName = request.getParameter("firstName");
		String ownerLastName = request.getParameter("lastName");
		
		Owner newOwner1 = oh.findOwner(ownerFirstName, ownerLastName);
		//Owner newOwner2 = oh.findOwner(ownerLastName);
		
		try {
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Pets> selectedPetsInList = new ArrayList<Pets>();
			
			for(int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Pets p = ph.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedPetsInList.add(p);
			}
			listToUpdate.setListOfPets(selectedPetsInList);
		}catch(NullPointerException ex) {
			List<Pets> selectedPetsInList = new ArrayList<Pets>();
			listToUpdate.setListOfPets(selectedPetsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setOwner(newOwner1);
		//listToUpdate.setOwner(newOwner2);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
		
		
		doGet(request, response);
	}

}
