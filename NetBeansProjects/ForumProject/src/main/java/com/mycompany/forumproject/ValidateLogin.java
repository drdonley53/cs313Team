/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.forumproject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daviddonley
 */
@WebServlet(name = "ValidateLogin", urlPatterns = {"/ValidateLogin"})
public class ValidateLogin extends HttpServlet {

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
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        
        List<String> realUsername = new ArrayList<String>();
        List<String> realPassword = new ArrayList<String>();
        
       BufferedReader br = new BufferedReader(new FileReader("/tempText/UserPassword.txt"));
        
        Integer i = 0;
        String line;
        
        while((line = br.readLine()) != null){
            if(i % 2 == 0)
            {
                realUsername.add(line);
            }
            else{
                realPassword.add(line);
            }
            i++;
        }
        br.close();
        
        Boolean found = false;
        
        for(int j = 0; j < realUsername.size(); j++){
            if(realUsername.get(j).equals(Username) && realPassword.get(j).equals(Password)){
                found = true;
            }
        }
        
        if(found){
           request.getSession().setAttribute("username", Username);
           request.getRequestDispatcher("NewPost.jsp").forward(request, response);
        }
        else{
           request.getRequestDispatcher("IncorrectLogin.jsp").forward(request, response); 
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
