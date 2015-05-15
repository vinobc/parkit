/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.edu.ssn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Sasi
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
              
            String email = request.getParameter("email");
            String password = request.getParameter("password");
        //    System.out.println(numplate+mobileno);
            
            Client client;
        client = ClientBuilder.newClient();
        WebTarget target  = client.target("https://api.idolondemand.com/1/api/sync/adduser/v1?store=myparkinglot&email="+email+"&password="+password+"&apikey=fa64dd8c-6193-47fd-a4ba-052939805fa4");
        

	String response1 = target.request().get(String.class);
         org.json.JSONObject jsonObject = new org.json.JSONObject(response1);
		//JSONArray newJSON = jsonObject.getJSONArray("documents");
		String c1n = new String();
                //jsonObject = newJSON.getJSONObject(0);
                
		c1n = jsonObject.getString("message");
                System.out.println(c1n);
               System.out.println(response);
        if(c1n!=null)
          
        {
      RequestDispatcher rd=request.getRequestDispatcher("/book.html");  
        rd.forward(request, response);  
        }
        else
        {
         RequestDispatcher rd=request.getRequestDispatcher("/home.html");  
        rd.include(request, response);      
                }
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + response1 + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            
            
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
