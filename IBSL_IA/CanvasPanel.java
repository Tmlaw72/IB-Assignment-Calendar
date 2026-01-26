//this it to "clear the screen" for the months, where separate screen and action events for date generator are located
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.IOException;
import java.util.*;
import java.time.LocalDate;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

//just figure out how to add month names and reset buttons
public class CanvasPanel extends JPanel{
       
private static boolean clicked = false;
private static boolean exit = false;   
    
    public static void dateGeneratorScreen(String due, String assign){
    JFrame gen = new JFrame();
        
        JLabel g = new JLabel("Date Generator!");
        gen.add(g);
        g.setVisible(true);
        
        gen.setSize(500, 450);
        gen.setLayout(null);
        gen.setVisible(true);

        JButton back = new JButton("<");
        back.setBounds(65, 25, 45, 25);
        gen.add(back);
    
    back.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                infoSort.main(null);
                }
                
        }); 
    
        JButton generate = new JButton("Generate Dates");
        generate.setBounds(160, 325, 160, 40);
        gen.add(generate);
         
        
          String first = dateGenThink(due, assign);
          String second = dateGenThink(due, assign);
          String third = dateGenThink(due, assign);
          //call method to generate appropriate dates
        
            JButton f = new JButton(first);
            f.setBounds(140, 60, 200, 42);
            gen.add(f);
            
            JButton s = new JButton(second);
            s.setBounds(140, 140, 200, 42);
            gen.add(s);
            
            JButton t = new JButton(third);
            t.setBounds(140, 220, 200, 42);
            gen.add(t);
            
        
        generate.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                dateGeneratorScreen(due, assign); 
                }
                
        }); 
    
        
        f.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){ 
                    addFile(first, assign);
                    infoSort.main(null);
                    
                    System.out.print("\033[H\033[2J");
	   System.out.println("Your assignment has been inputted");
                    
                }
        });         
                
        s.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){ 
                    addFile(second, assign);
                    infoSort.main(null);
                    
       System.out.print("\033[H\033[2J");
	   System.out.println("Your assignment has been inputted");
                }
        });
        
        
        t.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    addFile(third, assign);
                    
                    infoSort.main(null);
                    
       System.out.print("\033[H\033[2J");
	   System.out.println("Your assignment has been inputted");
                } 
        });
        
 
    }
    
    private static String dateGenThink(String due, String assignment){
       LocalDate current = LocalDate.now(); 
       int dayReturn = current.getDayOfMonth();
       int monthReturn = current.getMonthValue();
       
        //character 0 - 5 is day + month
        int dash = due.indexOf("-");
        int dayDue = Integer.parseInt(due.substring(0, dash));
        int curDay = current.getDayOfMonth();
        
        String getMonth = due.substring(dash + 1);
        int dash2 = getMonth.indexOf("-");
        int monthDue = Integer.parseInt(getMonth.substring(0, dash2));
        
        
        if(dayDue > curDay && monthDue == current.getMonthValue()){
            //if due date is within same month, after current date
            dayReturn = (int)(Math.random() * (dayDue - curDay + 1) + (curDay + 1));  
            
            monthReturn = current.getMonthValue();
        }
        
        else if(monthDue != current.getMonthValue() && monthDue > current.getMonthValue()){
            //if due date is after current date but in different month
            monthReturn = (int)(Math.random() * (monthDue - current.getMonthValue()) + current.getMonthValue());
            
            if(monthReturn == current.getMonthValue()){
                dayReturn = (int)(Math.random() * (current.lengthOfMonth() - curDay + 1) + (curDay + 1));
            } //if gen month is current month
            
            else if(monthReturn < monthDue){
                dayReturn = (int)(Math.random() * 29 + 1);
            }   //if gen month is less than due date but after current month 
            
            else if(monthReturn == monthDue){
                dayReturn = (int)(Math.random() * (dayDue - 1) + 1);
            } //if gen month is due month
                    
        }
            
    String returning = dayReturn + "-" + monthReturn + "-" + "2025";    
    
    return returning;    
    } //string returned is a random date that is before due date
    
    
    private static void addFile(String date, String assign){
        File check = new File(date);
    	   
    	   try{
    	        if(check.createNewFile()){
    	            //if file doesnt exist
    	            try{
    	            FileWriter f = new FileWriter(check, true);
    	            f.write(assign); 
    	           
    	            f.write("\n");    
    	            f.close(); 
    	            }
    	        
    	            catch(IOException e){}
    	        }
    	        
    	        else{
    	            //if file exists
    	            FileWriter f = new FileWriter(check, true);
    	            f.write(assign);
    	           
    	            f.write("\n");    
    	            f.close(); 
    	        }
            }
            
            catch(IOException e){}
        
    }  
    
     
}