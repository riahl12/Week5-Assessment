package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pets;

/**
 * Servlet implementation class EditPetServlet
 */
@WebServlet("/editPetServlet")
public class EditPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PetsHelper dao = new PetsHelper();
		
		String petName = request.getParameter("petName");
		String petSpecies = request.getParameter("petSpecies");
		Integer tempPetId = Integer.parseInt(request.getParameter("id"));
		
		Pets petToUpdate = dao.searchForItemById(tempPetId);
		
		petToUpdate.setPetName(petName);
		petToUpdate.setPetSpecies(petSpecies);
		
		dao.updateItem(petToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
	}

}
