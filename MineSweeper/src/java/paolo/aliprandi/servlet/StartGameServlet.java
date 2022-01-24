/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paolo.aliprandi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paolo.aliprandi.obj.Griglia;

/**
 *
 * @author paoloaliprandi
 */
public class StartGameServlet extends HttpServlet {
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         doPost(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        System.out.println ("------------"+username);
       
        Griglia g = new Griglia();
        
        g.username=username;
        request.setAttribute("username", username);
        request.getServletContext().setAttribute("griglia"+username, g);
        
        request.getRequestDispatcher("game.jsp?username="+username).forward(request, response);
        
    }
}
