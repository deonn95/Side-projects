/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100doorsproblem;

import java.util.*;

/**
 *
 * @author Deon
 */
public class HundredDoors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean loop = true;
        Scanner s = new Scanner(System.in);
        String str;
        
        System.out.println("This is the 100 doors problem.");
        System.out.println("Problem: You have 100 doors in a row that are all initially closed. You make 100 passes by the doors.\nThe first time through, you visit every door and toggle the door (if the door is closed, you open it; if it is open, you close it).\nThe second time you only visit every 2nd door (door #2, #4, #6, ...).\nThe third time, every 3rd door (door #3, #6, #9, ...), etc, until you only visit the 100th door.\nQuestion: What state are the doors in after the last pass? Which are open, which are closed?");
        System.out.println("Type \"GO\" to continue, or \"EXIT\" to quit.");
        
        while(loop){
            str = s.nextLine();
            if(str.equalsIgnoreCase("go")){
                loop = false;
            }
            else if(str.equalsIgnoreCase("exit")){
                System.exit(0);
            }
            else{
                System.out.println("Please enter a valid command");
            }
        }
        
        boolean[] doors = new boolean[101];
        Arrays.fill(doors, false);
        
        
        //open/ close the doors. Use 1 as a start point for a simpler base.
        for(int i = 1; i < doors.length; i++){
            for(int j = 1; j < doors.length; j++){
                if(j % i == 0){
                    doors[j] = !doors[j];
                }
            }
        }
        
        for(int i = 1; i < doors.length; i++){
            if(doors[i]){
                System.out.println("Door #" + i + ": Open");
            }
        }
        System.out.println("All the open doors are perfect squares, ");
    }
}
