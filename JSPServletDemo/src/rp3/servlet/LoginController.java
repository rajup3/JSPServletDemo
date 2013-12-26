package rp3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
   
	static{
		System.out.println(" static block ... ");
	}
	
	{
		System.out.println(" non static block ... ");
	}
	
	public LoginController() {
		super();
		System.out.println(" constructor()... ");
	}
	 
	public void init() throws ServletException {
	    // Do required initialization
		System.out.println(" init()... ");
		message = "Hello World";
	}
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" doGet()... ");
	    // Set response content type
	    response.setContentType("text/html");
	 
	    // Actual logic goes here.
	    PrintWriter out = response.getWriter();
	    out.println("<h1>" + message + "</h1>");
	}
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" doPost() starts... ");
	    
		try{
	    
		    System.out.println("  "+message);
		    InitialContext ctx = new InitialContext();
		    
		    String adminEmailId = (String)ctx.lookup("java:comp/env/ADMIN_EMAIL_ID");
		    System.out.println("ADMIN_EMAIL_ID : "+ adminEmailId);
		    
		    Hashtable<Object, Object> env = (Hashtable<Object, Object>)ctx.getEnvironment();
		    Iterator<Map.Entry<Object, Object>> it = env.entrySet().iterator();
		    while(it.hasNext()){
		    	Map.Entry<Object, Object> entry = it.next();
		    	System.out.println(" KEY: "+entry.getKey()+", VALUE: "+entry.getValue());
		    }
		    
		}catch(Exception e){
			e.printStackTrace();
		}
	    
	    
	    
	    System.out.println(" doPost() ends... ");
	}
	  
	public void destroy()
	{
	    System.out.println(" destroy()... ");
	    // do nothing.
	}
}
