//this class is to set up MAIN screen, button action events
import javax.swing.*;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;  
import java.io.FileNotFoundException;

public class GraphicalIn extends JFrame{
public static int mCount = 0;
    //dec is 0, jan is 1, etc.
    
    public static void showGUI(){
        Scanner sc = new Scanner(System.in);
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        
        f.setSize(500, 450);
        f.setLayout(null);
        f.setVisible(true);
    
        //months.December(f);
        JButton b1 = new JButton("Input Assignment");
            //if clicked, this allows the user to input an assignment name, time (optional), and date manually
        
        JButton b2 = new JButton("Date Generator");
            //if clicked, allows user to input name of assignment, and estimated time that it will take to complete it. 
            //will give three options, if user clicks one, add clicked option into a file
            
            //add bounds? such as time and days available
            
        JButton b3 = new JButton("Weekly List");
            //for a certain week, list out assignment name, time (if applicable), and date
        
        JButton help = new JButton("?");
            //help button. describes button actions
        
        b1.setBounds(5, 375, 158, 40);
        f.add(b1); //input assin.
        
        b2.setBounds(173, 375, 148, 40);
        f.add(b2); //date gen.
        
        b3.setBounds(331, 375, 148, 40);
        f.add(b3); //weekly list

        help.setBounds(440, 5, 41, 39);
        help.setBackground(Color.white);
        f.add(help);
        
        
        JButton forward = new JButton(">");
        JButton backward = new JButton("<"); //month indicator
        
            
        forward.setBounds(365, 20, 45, 24);
        f.add(forward);
        
        backward.setBounds(20, 19, 45, 24);
        f.add(backward);
        
        months.December(f, 0);
        
        
        help.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                System.out.print("\033[H\033[2J");    
                    System.out.println("You've clicked the help button!");
              
              System.out.println("Input Assignment: Here, you can manually input the name of your event, time (optional), and date.");
              
              System.out.println("\nDate Generator: Feeling indecisive? Use the date generator here! Input assignment information and three random dates will give you an idea of when to complete it.");
              
              System.out.println("\nWeekly List: Forgot what is due this week? Click this, and all your events will show up.");
                }
                
        });
            
        
        forward.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int temp = mCount;
                mCount++;
                    if(mCount > 5){
                        mCount = 0;
                        temp = -1;
                    }
                    
                months.monthChoose(f,mCount, temp);
            }
        });  //shifts months forward (dec -> jan -> feb)
        
        backward.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int temp = mCount;
                mCount--;
                    if(mCount < 0){
                        mCount = 5;
                        temp = 6;
                    }
                    
                months.monthChoose(f,mCount, temp);
            }
        });  //shifts months backward (dec <- jan <- feb)
    	
    	
    	
    	
    	b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              infoSort.inputAssignment();  
            }
        }); //when inputAssignment is pressed,
            //user is prompted to manually input
          
            
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              infoSort.dateGenerator();  
            }
        }); 
        
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                System.out.print("\033[H\033[2J");    
                infoSort.weeklyList();  }
                
                catch(FileNotFoundException f){}
            }
        }); 
    	    
    }

    

}