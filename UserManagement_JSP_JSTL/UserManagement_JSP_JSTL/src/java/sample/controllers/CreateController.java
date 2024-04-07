/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

/**
 *
 * @author PC
 */
public class CreateController extends HttpServlet {
    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.html";
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
        UserError userError = new UserError();
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            boolean checkValidation = true;
            //Check existed userID
            UserDAO dao = new UserDAO();
//            boolean checkExist = dao.checkDuplicate(userID);
//            if(checkExist){
//                checkValidation = false;
//                userError.setUserIDError("Duplicate userID!");
//            }
            if(userID.length() > 10 || userID.length() < 2){
                checkValidation = false;
                userError.setUserIDError("User ID 1 < size < 10");
            }
            if(fullName.length() > 20 || fullName.length() < 2){
                checkValidation = false;
                userError.setFullNameError("Full Name 1 < size < 20");
            }
            if(!password.equals(confirm)){
                checkValidation = false;
                userError.setConfirmError("Password do not match!");
            }
            if(checkValidation){
                UserDTO user = new UserDTO(userID, fullName, roleID, password);
                //boolean checkInsert = dao.create(user);
                boolean checkInsert = dao.createV2(user);
                if(checkInsert){
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR", "Unknown ERROR");
                }
            }else{
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
            if(e.toString().contains("duplicate")){
                userError.setUserIDError("Duplicate Primary Key!");
                request.setAttribute("USER_ERROR", userError);
            }
            
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
