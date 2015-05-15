/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.edu.ssn.servlet;

import in.edu.ssn.model.Car;
import in.edu.ssn.store.CarStore;
import in.edu.ssn.store.CarStoreMock;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.json.JSONArray;

/**
 *
 * @author Sasi
 */
public class BookingServlet extends HttpServlet {

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
        	 //Car[] car = new Car[10];
        	 CarStore carStore = new CarStoreMock(); 
             String numplate = request.getParameter("nplate");
            String reference1 = request.getParameter("reference");
            int content1 = (Integer.parseInt(request.getParameter("content")));
            System.out.println(numplate+reference1+content1);
            
            Client client;
        client = ClientBuilder.newClient();
         WebTarget target  = client.target("https://api.idolondemand.com/1/api/sync/addtotextindex/v1?json=%7B%22document%22%3A%7B%22title%22%3A%22"+numplate+"%22%2C%22reference%22%3A%22"+reference1+"%22%2C%22content%22%3A%22"+content1+"%22+%7D%7D&index=parkinglot&additional_metadata=&reference_prefix=&apikey=fa64dd8c-6193-47fd-a4ba-052939805fa4");
          String response1 = target.request().get(String.class);
           org.json.JSONObject jsonObject = new org.json.JSONObject(response1);
		//JSONArray newJSON = jsonObject.getJSONArray("documents");
		String c1n = new String();
                //jsonObject = newJSON.getJSONObject(0);
                
		c1n = jsonObject.getString("index");
                System.out.println(c1n);
               System.out.println(response);
    if (!(response1.isEmpty()))
        {
             //out.println("Booking confirm");
    		 Car car = new Car();
    	     if(carStore.findAllCars().size()==10) {
    	    	 RequestDispatcher rd=request.getRequestDispatcher("/error.html");  
    	         rd.forward(request, response);  
    	     }else {
    	    	 
    	    	 car.setCarNumber(numplate);
    	    	 car.setDuration(content1);
    	    	 carStore.create(car);
    	     }
             RequestDispatcher rd=request.getRequestDispatcher("/book.jsp");  
             rd.forward(request, response);     
           // out.println("<div>"+response1+"<div>");
            }
            else
        {
        
        RequestDispatcher rd=request.getRequestDispatcher("/error.html");  
        rd.forward(request, response);  
                }
         
         /*TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(response1);
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
