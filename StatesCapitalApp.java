/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.morestatecapitals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author mastermind
 */
public class StatesCapitalApp {
    public static void main(String []args) throws Exception{
        Map <String, Capital> list = new HashMap<>();
       
        Scanner input = new Scanner(new BufferedReader(new FileReader("StateCaptitalsName.txt")));
        while(input.hasNextLine()){
            String[] s = input.nextLine().split("::");
            String word = s[0] + " " + s[1];
             int a = Integer.parseInt(s[2]);
             double b = Double.parseDouble(s[3]);
            var check = new Capital(word,a,b);
            
            list.put(word, check);
            
            
        }
        //Printing out how message on how many States Capital were loaded onto hash map
       System.out.println("This is how many state capital were loaded" + list.size());
       
       //Print out each state and its capitals name, population, and square mileage to the screen.
        Set<String> keys = list.keySet();
        for(String k: keys)
            System.out.println(list.get(k).getName() + " " + list.get(k).getPopulation() + " " + list.get(k).getSquareMileage());
            
// Prompt the user for a population limit, print out all states & their capitals who have a population over that limit
            
        System.out.println("Enter the population limit");
        Scanner in = new Scanner(System.in);
            int limit = in.nextInt();
            
            Set<String> newkeys = list.keySet();
            for(String a: keys){
                if(list.get(a).getPopulation() > limit)
                    System.out.println(list.get(a).getName());
            }
        // Finally, prompt the user for an area limit, print out all states & their capitals who have an area under that limit
                System.out.println("Enter upper limit");
                double upperLimit = in.nextDouble();
                
                Set<String> limitKeys = list.keySet();
                for(String b: limitKeys){
                    if(list.get(b).getSquareMileage() < upperLimit)
                        System.out.println(list.get(b).getName());
                        
                
                    
            }
                
            
        
    }
    
}
