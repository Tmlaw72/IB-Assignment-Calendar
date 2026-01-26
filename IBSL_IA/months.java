//all methods for each month of the year
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.Color;
import java.awt.*; 
import java.awt.Font;

public class months extends JFrame{
private static JButton[] decButtons = new JButton[31];
private static JButton[] janButtons = new JButton[31];
private static JButton[] febButtons = new JButton[28];
private static JButton[] marButtons = new JButton[31];
private static JButton[] aprButtons = new JButton[30];
private static JButton[] mayButtons = new JButton[31];

private static int cur;  //current month
private static JPanel dec = new JPanel();
private static JLabel n;

    public static void monthChoose(JFrame fr, int m, int prev){
        cur = m;
        //prev is previous month, cur is current
        
        if(m == 0){ 
        December(fr, prev); }
        
        else if(m == 1){
        January(fr, prev);   }
        
        else if(m == 2){
        February(fr, prev);  }
        
        else if(m == 3){
        March(fr, prev);     }
        
        else if(m == 4){
        April(fr, prev);     }
        
        else if(m == 5){
        May(fr, prev);       }
        //which month does user want to see?
    }

//1. make an array of buttons for each month
//2. in month method, create buttons, add to array as usual
//3. make alternate method where you set the month's buttons visibility to false
//boom!

//below is method for each month
    public static void December(JFrame fr, int prev){
        if(prev < cur){
     removeMay();}
     
     else if(prev > cur){
     removeJanuary(); }
        
        int x1 = 20;
        int y1 = 85;
        int width = 50;
        int height = 32;
    
        for(int i = 1; i <= 31; i++){
            
            String date = i + "";
            JButton button = new JButton(date);
            button.setBackground(Color.white);
                if(i == 1 || i == 7 || i == 8 || i == 14 || i == 15 || i == 21 || i == 22 || i == 28 || i == 29){
                    button.setBackground(Color.lightGray);
                }
            fr.add(button);
            
            decButtons[i - 1] = button;
            
            button.setBounds(x1, y1, width, height);
            x1 += 58;
                
                if(x1 > 400){
                    x1 = 20;
                    y1 += 50;
                }
 
        } //end of for */
     dec.setLayout(new BorderLayout());
     
     n = new JLabel("December");
        //dec.setBackground(Color.white);
        n.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        dec.add(n);
        
        dec.setBounds(150, 10, 250, 50);
        fr.add(dec);
       
        fr.setVisible(true);
 
    }
    
    private static void removeDecember(){
        
        for(int i = 0; i <= 30; i++){
            decButtons[i].setVisible(false);
        }
        n.setVisible(false);
    }
    
     public static void January(JFrame fr, int prev){
      if(prev < cur){
     removeDecember();}
     
     else if(prev > cur){
     removeFebruary();
     }
        
        int x1 = 194;
        int y1 = 85;
        int width = 50;
        int height = 32;
        for(int i = 1; i <= 31; i++){
            
            String date = i + "";
            JButton b = new JButton(date);
            if(i != 4 && i != 11 && i != 18 && i != 25 && i != 5 && i != 12 && i != 19 && i != 26){
                b.setBackground(Color.white);
                }
            
            fr.add(b);
            janButtons[i - 1] = b;
            
            b.setBounds(x1, y1, width, height);
            x1 += 58;
                
                if(x1 > 400){
                    x1 = 20;
                    y1 += 50;
                }

        } //end of for 
        
        dec.setLayout(new BorderLayout());
     
     n = new JLabel("January");
        //dec.setBackground(Color.white);
        n.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        dec.add(n);
        
        dec.setBounds(155, 10, 250, 50);
        fr.add(dec);
       
        fr.setVisible(true);
    }
    
    private static void removeJanuary(){
        
        for(int i = 0; i <= 30; i++){
            janButtons[i].setVisible(false);
        }
        n.setVisible(false);
    }
    
    public static void February(JFrame fr, int prev){
        if(prev < cur){
     removeJanuary();}
     
     else if(prev > cur){
     removeMarch();
     }
        
        
        int x1 = 368;
        int y1 = 85;
        int width = 50;
        int height = 32;
        for(int i = 1; i <= 28; i++){
            
            String date = i + "";
            JButton but = new JButton(date);
            but.setBackground(Color.white);
                if(i == 1 || i == 2 || i == 8 || i == 9 || i == 15 || i == 16 || i == 22 || i == 23){
                    but.setBackground(Color.lightGray);
                }
            fr.add(but);
            febButtons[i - 1] = but;
            
            but.setBounds(x1, y1, width, height);
            x1 += 58;
                
                if(x1 > 400){
                    x1 = 20;
                    y1 += 50;
                }
 
        } //end of for 
        
        dec.setLayout(new BorderLayout());
     
     n = new JLabel("February");
        //dec.setBackground(Color.white);
        n.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        dec.add(n);
        
        dec.setBounds(160, 10, 250, 50);
        fr.add(dec);
       
        fr.setVisible(true);
        
    } 
    
    private static void removeFebruary(){
        
        for(int i = 0; i <= 27; i++){
            febButtons[i].setVisible(false);
        }
        n.setVisible(false);
    }
    
    public static void March(JFrame fr, int prev){
        if(prev < cur){
     removeFebruary();}
     
     else if(prev > cur){
     removeApril();
     }
        
        
        int x1 = 368;
        int y1 = 85;
        int width = 50;
        int height = 32;
        
        for(int i = 1; i <= 31; i++){
            
            String date = i + "";
            JButton button = new JButton(date);
            if(i != 1 && i != 2 && i != 8 && i != 9 && i != 15 && i != 16 && i != 22 && i != 23 && i != 29 && i != 30){
                button.setBackground(Color.white);
                }
            fr.add(button);
            marButtons[i - 1] = button;
            
            button.setBounds(x1, y1, width, height);
            x1 += 58;
                
                if(x1 > 400){
                    x1 = 20;
                    y1 += 50;
                }
 
        } //end of for 
       
       dec.setLayout(new BorderLayout());
     
     n = new JLabel("March");
        //dec.setBackground(Color.white);
        n.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        dec.add(n);
        
        dec.setBounds(170, 10, 250, 50);
        fr.add(dec);
       
        fr.setVisible(true);
        
    }
    
    
    private static void removeMarch(){
        
        for(int i = 0; i <= 30; i++){
            marButtons[i].setVisible(false);
        }
        
        n.setVisible(false);
    }
    
    public static void April(JFrame fr, int prev){
        if(prev < cur){
     removeMarch();}
     
     else if(prev > cur){
     removeMay();
     }
        
        int x1 = 136;
        int y1 = 85;
        int width = 50;
        int height = 32;
        for(int i = 1; i <= 30; i++){
            
            String date = i + "";
            JButton but = new JButton(date);
            but.setBackground(Color.white);
            if(i == 5 || i == 6 || i == 12 || i == 13 || i == 19 || i == 20 || i == 26 || i == 27){
                    but.setBackground(Color.lightGray);
                }
            fr.add(but);
            aprButtons[i - 1] = but;
            
            but.setBounds(x1, y1, width, height);
            x1 += 58;
                
                if(x1 > 400){
                    x1 = 20;
                    y1 += 50;
                }
 
        } //end of for 
       
       dec.setLayout(new BorderLayout());
     
     n = new JLabel("April");
        //dec.setBackground(Color.white);
        n.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        dec.add(n);
        
        dec.setBounds(170, 10, 250, 50);
        fr.add(dec);
       
        fr.setVisible(true);
        
    }
    
    private static void removeApril(){
        
        for(int i = 0; i <= 29; i++){
            aprButtons[i].setVisible(false);
        }
        
        n.setVisible(false);
    }
    
    public static void May(JFrame fr, int prev){
        if(prev < cur){
     removeApril();
        }
     
     else if(prev > cur){
     removeDecember();
     }
        
        int x1 = 252;
        int y1 = 85;
        int width = 50;
        int height = 32;
        for(int i = 1; i <= 31; i++){
            
            String date = i + "";
            JButton but = new JButton(date);
            if(i != 3 && i != 4 && i != 10 && i != 11 && i != 17 && i != 18 && i != 24 && i != 25 && i != 31){
                but.setBackground(Color.white);
                }
            
            fr.add(but);
            mayButtons[i - 1] = but;
            
            but.setBounds(x1, y1, width, height);
            x1 += 58;
                
                if(x1 > 400){
                    x1 = 20;
                    y1 += 50;
                }
 
        } //end of for 
       
       dec.setLayout(new BorderLayout());
     
     n = new JLabel("May");
        //dec.setBackground(Color.white);
        n.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        dec.add(n);
        
        dec.setBounds(170, 10, 250, 50);
        fr.add(dec);
       
        fr.setVisible(true);
       
        
    }
    
    private static void removeMay(){
        
        for(int i = 0; i <= 30; i++){
            mayButtons[i].setVisible(false);
        }
        
        n.setVisible(false);
    }
    
    
}