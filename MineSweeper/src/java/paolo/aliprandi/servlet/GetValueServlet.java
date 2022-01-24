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
import paolo.aliprandi.obj.Cella;
import paolo.aliprandi.obj.Griglia;

/**
 *
 * @author paoloaliprandi
 */
public class GetValueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String username = (String) request.getParameter("username");
        Griglia g = (Griglia) request.getServletContext().getAttribute("griglia"+username);
        
        int riga = Integer.parseInt(id.substring(0,1));
        int colonna = Integer.parseInt(id.substring(1,2));
        
        System.out.println("--------GetValueServlet---------");
        System.out.println("riga: "+riga+" colonna: "+colonna + " username: " + username);
                
        String s="{";
        
        Cella c = (Cella) g.griglia[riga-1][colonna-1];
        
        String isBomba="false";
        if (c.tipo.equals("bomba")) {
            isBomba="true";
        };
        String v = String.valueOf(c.valore);
        
        System.out.println(c);
        System.out.println("Bomba? "+isBomba+"Valore? "+v);
        
        String obj = "{ \"isBomba\": "+isBomba+", \"valore\": "+v+" }";
        System.out.println(obj);
        
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/plain;charset=UTF-8");
            
            out.println(obj);
        }
    }

}
