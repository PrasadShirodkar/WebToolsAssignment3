package pshirodkar.edu.neu.coe.assignment3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pshirodkar.edu.neu.coe.assignment3.bean.LoginBean;
import pshirodkar.edu.neu.coe.assignment3.constants.ReferenceConstants;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.util.AuthenticationException;

/**
 * The purpose of this servlet is to login the user for the given username and
 * password credentials.
 * 
 * @author Prasad
 * 
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CalendarService calendarService = new CalendarService("google-calendar");
		try {
			LoginBean loginBean = createLoginBean(request);
			
			calendarService.setUserCredentials(loginBean.getUserName(), loginBean.getPassword());
			
			// Set user details in session
			request.getSession().setAttribute(ReferenceConstants.USER_INFO, loginBean);
			
			// Set the instance of CalendarService in session
			request.getSession().setAttribute(ReferenceConstants.CALENDAR_SERVICE_INFO, calendarService);
			
			//Forward control to display the list of user's calendar
			request.getRequestDispatcher("/SelectCalendar").forward(request, response);			
			
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private LoginBean createLoginBean(HttpServletRequest request) {
		
		LoginBean loginBean = new LoginBean();
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		loginBean.setUserName(userName);
		loginBean.setPassword(password);
		
		return loginBean;
	}

}
