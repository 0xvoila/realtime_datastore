/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.amit.realdb;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author unbxd
 */
public class Main extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    InMemory<String,Object> inMemory = null;
    
    @Override
    public void init(ServletConfig config){
         
        this.inMemory = new InMemory<>();
    }
    
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
        try{
            String key = request.getParameter("key");
            Object value = this.inMemory.get(key);

            PrintWriter printWriter = response.getWriter();
            printWriter.print(value);
        }
        catch(Exception exception){

            PrintWriter printWriter = response.getWriter();
            printWriter.print("");
        }
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
        try{
            
            String key = request.getParameter("key");
            Object value = request.getParameter("value");
            this.inMemory.put(key, value);

            PrintWriter printWriter = response.getWriter();
            printWriter.print("Done");
        }
        catch(Exception exception){
            PrintWriter printWriter = response.getWriter();
            printWriter.print("Fail");
        }

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
