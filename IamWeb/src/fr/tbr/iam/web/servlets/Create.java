package fr.tbr.iam.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOInitializationException;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.service.dao.IdentityDAOFactory;
import fr.tbr.iamcore.service.dao.IdentityDAOInterface;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(Create.class);

	/**
	 * Default constructor.
	 */
	public Create() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Received a post request");
		IdentityDAOInterface dao;
		PrintWriter writer = response.getWriter();
		try {
			dao = IdentityDAOFactory.getIdentityDAO();
			String displayName = request.getParameter("displayName");
			String email = request.getParameter("email");
			logger.info("displayName {} : email {}",displayName,email);
			dao.save(new Identity(displayName, email, ""));
			logger.info("success!");
			writer.println("successfully added the identity");
		} catch (DAOInitializationException | DAOSaveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			writer.println("problem : " + e.getMessage());
		}
	

	}

}
