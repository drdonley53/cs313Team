/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.forumproject;
import com.mycompany.forumproject.model.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daviddonley
 */
@WebServlet(name = "ListPosts", urlPatterns = {"/ListPosts"})
public class ListPosts extends HttpServlet {

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
        
        
        Entry temp2 = new Entry();
        BufferedReader br = new BufferedReader(new FileReader("/tempText/ForumData.txt"));
        List<Entry> entry = new ArrayList<Entry>();
        
        
        if(request.getParameter("newPost").equals("")){
        }
        
        else{  
        String NewPost = request.getParameter("newPost");
       
        String user = (String)request.getSession().getAttribute("username");
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(cal.getTime());
        
        temp2.setEntry(NewPost);
        temp2.setUser(user);
        temp2.setTime(time);
        entry.add(temp2);
        }
        
        Entry temp = new Entry();
        
        Integer i = 0;
        String line;
        Boolean use = false;
        Boolean time = false;
        Boolean enter = false;
        
        while((line = br.readLine()) != null){
            if(i % 3 == 0)
            {
                temp.setUser(line);
                use = true;
            }
            else if(i % 3 == 1)
            {
                temp.setTime(line);
                time = true;
            }
            else
            {
                temp.setEntry(line);
                enter = true;
            }
            if(time && use && enter)
            {
                entry.add(temp);
                use = false;
                time = false;
                enter = false;
            }
            i++;
        }
        br.close();
        request.setAttribute("entry", entry);
        
        PrintWriter writer = new PrintWriter("/tempText/ForumData.txt", "UTF-8");
        for(int j = 0; j < entry.size(); j++){
            writer.println(entry.get(j).getUser());
            writer.println(entry.get(j).getTime());
            writer.println(entry.get(j).getEntry());
        }
        request.getRequestDispatcher("AllPosts.jsp").forward(request, response);
        writer.close();
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
