//tamera law, 
//12 january 2025
//IBSL Project 

//this class is for methods pertaining to information sorting based on what user is inputting into console.
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.io.FileNotFoundException;
import java.awt.Color;

public class infoSort{
private static String time = "00"; 
private static LocalDate curDate = LocalDate.now();

   public static void main(String[] args){
	
//when running, first check for expired dates	
	    int dateCur = curDate.getDayOfMonth();
	    int monthCur = curDate.getMonthValue();
	    int del;
	    //finding current date

	    if(dateCur > 7){
	        del = dateCur - 7;
	    }
	    
	    else{
	        del = 1;
	    }
	      
	    File p;  
	    for(int i = del; i < dateCur; i++){
	        
	        if(i < 10){
	        
	        if(monthCur < 10){
	            p = new File("0" + i + "-0" + monthCur + "-2025");
	        }
	        
	        else{
	            p = new File("0" + i + "-" + monthCur + "-2025"); }
	            
	        }
	        
	        else{
	        
	            if(monthCur < 10){
	            p = new File("0" + i + "-0" + monthCur + "-2025");}
	        
	            else{
	            p = new File("0" + i + "-" + monthCur + "-2025"); }
	        }
	        
	       if(p.delete()){
	       System.out.println("Success!");
	       }
	            
	    }  //deletes files that have dates of previous week
	        //avoids clutter
	
	
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GraphicalIn.showGUI();
            }
        }); //this runs graphics
	    

	
    }	
	
	public static void inputAssignment(){
	System.out.print("\033[H\033[2J");
	//if clicked, this allows the user to input an assignment name, time (optional), and date manually    
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Please input the name of your assignment");
	        String name = sc.nextLine();    
	    
	   System.out.println("Please indicate day assignment is due by inputting a two digit number");
	        int d = sc.nextInt();
	   System.out.println("Please input the month it is due using a two digit number");
	        int mon = sc.nextInt();
	   System.out.println("Finally, please input the year");
	        int y = sc.nextInt();
	        
	   String date = Integer.toString(d);
	          date += "-";
	          date += Integer.toString(mon);
	          date += "-";
	          date += Integer.toString(y);
	   System.out.println("Would you like to input a time that your assignment is due (Y/N)?");
	        char answer = sc.next().charAt(0);     
	            
	            if(answer == 'y' || answer == 'y'){
	                System.out.println("Please input time (hh:mm am/pm)");
	                sc.nextLine();
	                time = sc.nextLine();  
	            }
	            
	   System.out.print("\033[H\033[2J");
	   System.out.println("Your assignment has been inputted");       
	       //check if date exists    
    	  File check = new File(date);
    	   
    	   try{
    	        if(check.createNewFile()){
    	            //if file doesnt exist
    	            try{
    	            FileWriter f = new FileWriter(check, true);
    	            f.write(name); 
    	                if(!"00".equals(time)){
    	                    f.write(" " + time);
    	                    time = "00";
    	                }
    	           
    	            f.write("\n");    
    	            f.close(); 
    	            }
    	        
    	            catch(IOException e){}
    	        }
    	        
    	        else{
    	            //if file exists
    	            FileWriter f = new FileWriter(check, true);
    	            f.write(name); 
    	                if(!"00".equals(time)){
    	                    f.write(" " + time);
    	                    time = "00";
    	                }
    	           
    	            f.write("\n");    
    	            f.close(); 
    	        }
    	        
    	   } 
    	   
    	   catch(IOException e){}
	} //input assignment function, works!
	
	
	public static void dateGenerator(){
	    Scanner sc = new Scanner(System.in);
	    System.out.print("\033[H\033[2J");
	    
	            
	       System.out.println("Please input name of assignment");
	            String aName = sc.nextLine();
	            
	       System.out.println("Approximately how long will this assignment take (hh:mm)?");
	            String approxTime = sc.nextLine(); 
	            
	       System.out.println("Please enter the due date in dd-mm-yyyy format");
	                String dueDate = sc.nextLine(); 
	            
	       CanvasPanel.dateGeneratorScreen(dueDate, aName);
	       //calls the screen once info has been inputted
	}
	
	
	
	public static void weeklyList() throws FileNotFoundException{
	 System.out.print("\033[H\033[2J");
	 System.out.println("Weekly List (dd/mm/yyyy): \n");
	 ArrayList<String> dates = new ArrayList<String>();
	 ArrayList<String> assignments = new ArrayList<String>();
	 
	 LocalDate curDate = LocalDate.now();
	  String starterDay = Integer.toString(curDate.getDayOfMonth());
	  String curMonth = Integer.toString(curDate.getMonthValue());
	  String curYear = Integer.toString(curDate.getYear());
	    int s = curDate.getDayOfMonth();
	    
	    for(int i = 1; i <= 7; i++){
	       String s2 = Integer.toString(s);
	       File f = new File(s2 + "-" + curMonth + "-" + curYear);
	            
	       if(f.isFile() == true){
	          dates.add(s + "-" + curMonth + "-" + curYear);
	          
            Scanner fileScanner = new Scanner(f);
            String data = "";
                while(fileScanner.hasNextLine()){
                    data += fileScanner.nextLine();
                    data += "\n";
                 }
	       assignments.add(data);
	       fileScanner.close();    
	       }
	       
	        
	       if(s < curDate.lengthOfMonth()){ 
	        s++; }
	        
	        else{
	            s = 1;
	            curMonth = Integer.toString(curDate.getMonthValue() + 1);
	        } 
	
	    } //end of for loop that searches for upcoming assignments
	
	    if(dates.isEmpty()){
	           System.out.println("Empty... \nYou've got nothing due within the next week. "); 
	    }
	    
	    else{
	       for(int L = 0; L < dates.size(); L++){
	               System.out.println(dates.get(L));
	               System.out.println(assignments.get(L));
	           }
	    }
	 
	} //weekly list method, works!
	
	
}