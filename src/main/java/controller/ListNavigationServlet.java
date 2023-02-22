package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OwnerListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		String act = request.getParameter("doThisToList");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			
		}else if(act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				OwnerListDetails listToDelete = dao.searchForOwnerListDetailsById(tempId);
				dao.deleteList(listToDelete);
			}catch(NumberFormatException e) {
				System.out.println("Forgot to click a button");
			}finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}else if (act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				OwnerListDetails listToEdit = dao.searchForOwnerListDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				
				PetsHelper daoForItems = new PetsHelper();
				
				request.setAttribute("allPets", daoForItems.showAllPets());
				
				if(daoForItems.showAllPets().isEmpty()) {
					request.setAttribute("allPets", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-pet-list.jsp").forward(request, response);
				
			}catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}else if(act.equals("Add")) {
			getServletContext().getRequestDispatcher("/new-pet-list.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
