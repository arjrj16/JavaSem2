import java.util.*;
import java.io.*;

public class Chapter6ProgrammingProject {
     public static void prob1(File essayFile, Scanner input){
        Scanner line; 
        String word;
        int lines = 0;
        int words = 0;
        int characters = 0;
        while(input.hasNextLine()){ //while there is a line
            line =  new Scanner (input.nextLine()); //consume line
            lines++; //add line to counter
            while(line.hasNext()){ //while line has another token
                words++; //add word to counter 
                word = line.next(); //store word into string
                characters = characters+word.length(); //adds length of word to characters variable
            }
            line.close(); // close sanner
        }
        input.close(); //close scanner
        System.out.println("There are "+lines+", "+words+" words, and "+characters+" characters."); //output amount of words
     }
     public static void prob4(Scanner input2, Scanner sysIn, File nameFile){
        Scanner line; 
        System.out.println("This program allows you to search through the data from the \nSocial Security Administration to see how popular a particular name \nhas been since 1900.");
        System.out.print("Name? ");
        String name = sysIn.nextLine(); //input
        int year = 1900;
        boolean hasName = false; 
        while(input2.hasNextLine()){ //while there is a line
            line =  new Scanner (input2.nextLine()); //consume line
            if(line.next().equalsIgnoreCase(name)){ //if line first word is the name 
                hasName = true; 
                System.out.println("Statistics on \""+name+"\"");
                while(line.hasNext()){
                    System.out.println(year+": "+line.next()); // print years + data
                    year = year+10;
                }
                break; // end 
            }
            else{
                hasName = false;
            }
            line.close(); //close scanner
        }
        input2.close(); //close input
        if(hasName == false){
            System.out.println("Name was not found in database.");// say name wasn't found
        }
     }
    public static void main (String args []) throws FileNotFoundException{
        /*
        Students are often asked to write term papers containing a certain number of words. 
        Counting words in a long paper is a tedious task, but the computer can help.
        Write a program that counts the number of words, lines, and total characters (not including whitespace)
        in a paper, assuming that consecutive words are separated either by spaces or endof-line characters.
        */


        //Declare objects and run functions:
        File essayFile = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\Chp6Prj1ESSAY.txt");
        Scanner input1 = new Scanner(essayFile);
        prob1(essayFile, input1);
        File nameFile = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\Chp6Prj4Names.txt");
        Scanner input2 = new Scanner(nameFile);
        Scanner sysIn = new Scanner (System.in);
        prob4(input2, sysIn, nameFile);
    }
}
