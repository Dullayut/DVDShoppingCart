/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Moviecatalog;
import Model.MoviecatalogTable;
import Model.Shoppingcart;
import Model.ShoppingcartTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thead
 */
public class AddMovieController extends HttpServlet {

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
          int rowInserted;
          int id = Integer.parseInt(request.getParameter("movieid"));
          Moviecatalog selectedMov = MoviecatalogTable.findMovieById(id);
          Shoppingcart itemCart = new Shoppingcart();
          Shoppingcart checkCart = ShoppingcartTable.findIByMovieId(selectedMov);
          if (checkCart == null) {
                itemCart.setMovieId(selectedMov);
                itemCart.setQuantity(1);
                rowInserted = ShoppingcartTable.insertItem(itemCart);
          }
          else {
              itemCart.setItemId(checkCart.getItemId());
              itemCart.setMovieId(selectedMov);
              itemCart.setQuantity(checkCart.getQuantity()+1);
              rowInserted = ShoppingcartTable.updateCart(itemCart);
          }
          request.setAttribute("rowInserted", rowInserted);
          request.getRequestDispatcher("addresult.jsp").forward(request, response);
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
