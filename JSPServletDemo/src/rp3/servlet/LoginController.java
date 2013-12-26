package rp3.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
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
		message = "Hello";
	}
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" doGet()... ");
	    // Set response content type
	    response.setContentType("text/html");
	 
	    String userId = request.getParameter("USER_ID");
	    
	    //PrintWriter out = response.getWriter();
	    //out.println("<h1> GET: "+ message +" "+userId+"</h1>");
	    
	    request.setAttribute("MESSAGE", message);
	    request.setAttribute("USER_ID", userId);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("fromget");
	    dispatcher.forward(request, response);
	}
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" doPost() starts... ");
		String dispatch_type_str = null;
		try{
			
////////////// Radio test
			if(request.getParameterValues("dispatch_type_radio") != null){
				String dispatch_type_radio[] = request.getParameterValues("dispatch_type_radio");
				for (int i = 0; i < dispatch_type_radio.length; i++) {
					dispatch_type_str = dispatch_type_radio[i];
					System.out.println(" dispatch_type_radio  "+i+" : "+dispatch_type_radio[i]);
				}
			}
			
////////////// Checkbox test
			if(request.getParameterValues("dispatch_type_checkbox") != null){
				String dispatch_type_checkbox[] = request.getParameterValues("dispatch_type_checkbox");
				for (int i = 0; i < dispatch_type_checkbox.length; i++) {
					System.out.println(" dispatch_type_checkbox  "+i+" : "+dispatch_type_checkbox[i]);
				}
			}
			
		    //PrintWriter out = response.getWriter();
		    //out.println("<h1> POST: "+ message +" "+userId+"</h1>");
			
			String userId = request.getParameter("USER_ID");
		    request.setAttribute("MESSAGE", message);
		    request.setAttribute("USER_ID", userId);
		    
////////////// Request dispatcher-forward / response-sendredirect test
		    if(dispatch_type_str != null && dispatch_type_str.equalsIgnoreCase("RequestForward")){
		    	System.out.println(" Request Forward ... ");
			    RequestDispatcher dispatcher = request.getRequestDispatcher("frompost");
			    dispatcher.forward(request, response);
		    }else if(dispatch_type_str != null && dispatch_type_str.equalsIgnoreCase("SendRedirect")){
		    	System.out.println(" Send redirect ... ");
		    	response.sendRedirect("http://www.google.com");
		    }else{
		    	System.out.println(" Error ... ");
		    	response.sendError(400, "Please select dispatch type.");
		    }
		    
////////////// Internationalization
		    
		    
		    
////////////// Localization - NumberFormat, DateFormat		    
		    Locale locales[] = Locale.getAvailableLocales();
		    /*
		    Locale locale = request.getLocale();
		    // NumberFormat
		    double numberToFormat = 52.56;
		    for (int i = 0; i < locales.length; i++) {
		    	NumberFormat nf = NumberFormat.getNumberInstance(locales[i]);
			    String formattedStr = nf.format(numberToFormat);
			    System.out.println("NumberToFormat: "+numberToFormat+", Locale: "+locales[i].getDisplayName()+", FormattedStr >> "+formattedStr);	
			}
		    */
		    /* 
		    // DateFormat
		    for (int i = 0; i < locales.length; i++) {
		    	DateFormat dt = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
		    	System.out.println("DateToFormat: "+new Date()+", Locale: "+locales[i].getDisplayName()+", FormattedDateStr >> "+dt.format(new Date()));
		    }
		    */
		    
////////////// env variable from web.xml or context test
		    /*
		    InitialContext ctx = new InitialContext();
		    String adminEmailId = (String)ctx.lookup("java:comp/env/ADMIN_EMAIL_ID");
		    System.out.println("ADMIN_EMAIL_ID : "+ adminEmailId);
		    Hashtable<Object, Object> env = (Hashtable<Object, Object>)ctx.getEnvironment();
		    Iterator<Map.Entry<Object, Object>> it = env.entrySet().iterator();
		    while(it.hasNext()){
		    	Map.Entry<Object, Object> entry = it.next();
		    	System.out.println(" KEY: "+entry.getKey()+", VALUE: "+entry.getValue());
		    }
		    */
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
