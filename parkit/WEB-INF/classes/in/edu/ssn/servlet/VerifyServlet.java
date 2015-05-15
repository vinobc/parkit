/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.edu.ssn.servlet;

import in.edu.ssn.model.Car;
import in.edu.ssn.store.CarStoreMock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;

/**
 *
 * @author Sasi
 */
public class VerifyServlet extends HttpServlet {

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
            String numplate = request.getParameter("nplate");
            System.out.println(numplate);
            
            Client client;
        client = ClientBuilder.newClient();
        WebTarget target  = client.target("https://api.idolondemand.com/1/api/sync/querytextindex/v1?text="+numplate+"&indexes=&indexes=parkinglot&print=reference&apikey=fa64dd8c-6193-47fd-a4ba-052939805fa4");
        
        String response1 = target.request().get(String.class);
        
        org.json.JSONObject jsonObject = new org.json.JSONObject(response1);
		JSONArray newJSON = jsonObject.getJSONArray("documents");
		
		String c1n = new String();
		if(newJSON.isNull(0)) {
			response.sendRedirect("error1.html");
		} else {
        jsonObject = newJSON.getJSONObject(0);
        
		c1n = jsonObject.getString("title");
                //Object c=c1n;
                System.out.println("hi"+c1n);
                
        CarStoreMock csm = new CarStoreMock();
        
        List<Car> allcars=csm.findAllCars();
      //  List<String> list = new ArrayList<String>();
        //list.add(c1n);
        for(Car car : allcars){
           System.out.println("Hello"+car);
           if(car.getCarNumber().equalsIgnoreCase(c1n))
           {
           System.out.print("success");       
             //out.println("Booking confirm");
             RequestDispatcher rd=request.getRequestDispatcher("/allow.jsp");  
             rd.forward(request, response);     
           // out.println("<div>"+response1+"<div>");
            }
            else
        {
        
        RequestDispatcher rd=request.getRequestDispatcher("/error1.html");  
        rd.forward(request, response);  
                }
                   } 
        
      // System.out.println(allcars.toArray(new String[0]));
       //         System.out.println("string value"+allcars.toString());
              
		}
        }
		finally {
		
		
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
