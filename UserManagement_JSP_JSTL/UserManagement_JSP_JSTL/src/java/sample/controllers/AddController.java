/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.phone.Cart;
import sample.phone.Phone;

/**
 *
 * @author PC
 */
public class AddController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "shopping.jsp";
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
        String url = ERROR;
        try {
            String phoneString = request.getParameter("cmbPhone");
            String phone[] = phoneString.split("-");
            String id = phone[0];
            String name = phone[1];
            double price = Double.parseDouble(phone[2]);
            int quantity = Integer.parseInt(request.getParameter("cmbQuantity"));
            HttpSession session = request.getSession();
            Cart cart = (Cart)session.getAttribute("CART");
            if(cart == null){
                cart = new Cart();
            }
            Phone newPhone = new Phone(id, name, price, quantity);
            cart.add(newPhone);
            session.setAttribute("CART", cart);
            request.setAttribute("MESSAGE", "Added " + name + " - " + quantity + " cái " + price + " triệu ");
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at AddController" + e.toString());
        } finally{
            request.getRequestDispatcher(url).forward(request, response);
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
