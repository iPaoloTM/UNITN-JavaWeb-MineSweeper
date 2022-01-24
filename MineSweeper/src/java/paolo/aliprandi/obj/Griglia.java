/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paolo.aliprandi.obj;

import java.util.Random;
import javax.servlet.ServletContext;


/**
 *
 * @author paoloaliprandi
 */
public class Griglia {
    
    public Cella[][] griglia;
    public String username;

    public Griglia() {
        
        griglia = new Cella[9][9];
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                Cella c = new Cella();
                c.tipo="normale";
                c.valore=0;
                griglia[i][j]=c;
               
            }
        }         
        
        Random rand = new Random();
        
        for (int i=0; i<10; i++) {
            int a = rand.nextInt(9);
            int b = rand.nextInt(9);
           
            System.out.println(i+" Bomba in ["+a+","+b+"]");
           
            griglia[b][a].tipo="bomba";        
        }
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                
                check(i,j);
            }
        }       
   
    }
    
    public void left(int i, int j) {
        if (i>0) {
           if (griglia[i-1][j].tipo=="bomba") {
          griglia[i][j].valore++;
            }  
        }     
    }   
    public void right(int i, int j) {
        if (i<8) {
            if (griglia[i+1][j].tipo=="bomba") {
            griglia[i][j].valore++;
            } 
        }
    }
    public void up(int i, int j) {
       if (j>0) {
        if (griglia[i][j-1].tipo=="bomba") {
          griglia[i][j].valore++;
        }  
       }
    }
    public void down(int i, int j) {
        if (j<8) {
            if (griglia[i][j+1].tipo=="bomba") {
            griglia[i][j].valore++;
            } 
        }
    }
    public void leftup(int i, int j) {
        if (i>0 && j>0) {
            if (griglia[i-1][j-1].tipo=="bomba") {
            griglia[i][j].valore++;
          }  
        }
    }
    public void rightup(int i, int j) {
        if (i<8 && j>0) {
         if (griglia[i+1][j-1].tipo=="bomba") {
          griglia[i][j].valore++;
          } 
        }
    }
    public void leftdown(int i, int j) {
        if (i>0 && j<8) {
            if (griglia[i-1][j+1].tipo=="bomba") {
            griglia[i][j].valore++;
            }
      } 
    }
    public void rightdown(int i, int j) {
        if (i<8 && j<8) {
            if (griglia[i+1][j+1].tipo=="bomba") {
            griglia[i][j].valore++;
            }
      } 
    }
    
    public void check(int i, int j) {
        left(i,j);
        right(i,j);
        up(i,j);
        down(i,j);
        leftup(i,j);
        rightup(i,j);
        leftdown(i,j);
        rightdown(i,j);
    }
    
}
