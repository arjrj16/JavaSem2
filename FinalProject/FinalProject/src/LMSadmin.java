package FinalProject.FinalProject.src;
//imports:
import java.io.*;
import java.util.*;

public class LMSadmin {
    //constructor method:
    public LMSadmin(){
        //since admin is already verified as admin in the main program, there are no instance variables needed for them.
        //they just have control on creating and adding books, users, etc., but none of this uses their names or who they are.
    }
    public void makeCatalog(Scanner input) throws FileNotFoundException
    {
        PrintStream catalog = new PrintStream(new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\catalog.txt")); //store catalog as object
        System.out.println("How many books would you like to log?"); //ui
        int amtBooks = input.nextInt();//gets amount of books
        input.nextLine(); //so nextLine takes the next line and not the nextInt value
        for(int i = 0; i<amtBooks; i++){ //cycles through and gets values
            System.out.println("book "+(i+1)+" name?");
            String bookName = input.nextLine();
            System.out.println("author?");
            String author = input.nextLine();
            System.out.println("Isbn?");
            int ISBN = input.nextInt();
            input.nextLine(); //once again, so next set of next lines gets the nextLine value and not the nextInt for ISBN
            catalog.print(ISBN+","+author+","+bookName); //prints to file
            if(i!=amtBooks-1){ 
                catalog.println(); //doesn't print blank line after last line
            }
        }
        System.out.println("Catalog Made.");
    }
    public void addUser(Scanner input) throws FileNotFoundException{
    System.out.println("Please enter the number of users you wish to add"); //ui
    int numUsers = input.nextInt(); //get number of users
    boolean error = false; //if there is an error stop program variable
    File id = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\id.text"); //location of file
    Scanner idScanner = new Scanner(id); //file in scanner
    int numLines = 0;
    while(idScanner.hasNextLine()){ //counts number of lines with text on it - so we know how big to make 2d array
       if(idScanner.nextLine().length() != 0){ //with text
           numLines++;
       }  
    }
        String info[][] = new String [5][numLines+numUsers]; //create 2d array with all values in file + new ones to be added
        idScanner.close();
        idScanner = new Scanner(id);
        int y = 0; //cycles through the lines
        while(idScanner.hasNextLine()){ 
            Scanner line = new Scanner (idScanner.nextLine());
            int x = 0; //cycles through the rows
            String dp = "";
            while(line.hasNext()){
                dp = line.next();
                info [x][y]=dp; //assigns exisiting values in file to the array values
                x++;
            }
            y++;              
        }
        idScanner.close();
        //gets values of users and adds their values to the array
        for(int aLine = numLines; aLine<numLines+numUsers; aLine++){ 
            System.out.println("Please enter the values for new user "+(aLine-numLines+1)); //says enter values for new user 1, 2, 3 ...
            //get values from user:
            System.out.print("Id: ");
            int idNum = input.nextInt();
            System.out.print("Password: ");
            int password = input.nextInt();
            System.out.print("First Name: ");
            String firstName = input.next();
            System.out.print("Last Name: ");
            String lastName = input.next();
            System.out.print("Student or Admin: ");
            String userLevel = input.next();
            //assign values to 2d array
            info[0][aLine] = Integer.toString(idNum);
            info[1][aLine] = Integer.toString(password);
            info[2][aLine] = firstName;
            info[3][aLine] = lastName;
            //assigns user or admin
            if(userLevel.equalsIgnoreCase("student")){
                info[4][aLine] = "Student";
            }
            else if(userLevel.equalsIgnoreCase("admin")){
                info[4][aLine] = "Admin";
            }
            else{ //incase something other than student or admin is entered
                System.out.println("Error - please enter a valid level: Student or Admin. Please re-run program.");
                error = true;
            }
        }
        if(!error){ //basically if they enter correctly admin or stuent then put into file, otherwise just exit program
            PrintStream override = new PrintStream("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\id.text");
            //prints values of the 2d array into the file.
            for(int y2 = 0; y2 < numLines+numUsers; y2++){ //cycles lines
                for(int x2 = 0; x2 < 5; x2++){
                    override.print(info[x2][y2]);//cycles values of each line
                    if(x2 != 4){ //dont print space after last value
                        override.print(" ");
                    }
                }
                if(y2 != numLines+numUsers-1){ //dont print extra line after last value
                    override.println();
                }
            }
            override.close(); //close scanner
            System.out.println("Users Added."); //ui
        }
    }
    public String toString(int idNum, Scanner input) throws FileNotFoundException{ //toString method to print out a selected student's info
        File idFile = new File("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\id.text");
        Scanner ids = new Scanner(idFile); //scanner of id file
        while(ids.hasNextLine()){ //cycles through lines
            String temp = ids.nextLine(); //stores line incase correct
            Scanner line = new Scanner(temp); //scans line
            if(line.nextInt() == idNum){ //if id matches
                Scanner personInfo = new Scanner(temp); //rescan the line
                personInfo.nextInt();
                int password = personInfo.nextInt(); //store values:
                String firstName = personInfo.next();
                String lastName = personInfo.next();
                if(studentBooksOut(idNum)!=null){ //the student does have a book out
                    Scanner booksOutDecipher = new Scanner(studentBooksOut(idNum)).useDelimiter(","); // can the output of studentBooksOut function to seperate ISBN and name of book out
                //return info in one line:
                    return "Id: "+(idNum)+"\nPassword: "+(password)+"\nName: "+firstName+" "+lastName+"\nRole: "+personInfo.next()+"\nBook out: "+booksOutDecipher.next()+" - ISBN: "+booksOutDecipher.next();
                }
                else{
                    //if no books out, return info and say no books out.
                    return "Id: "+(idNum)+"\nPassword: "+(password)+"\nName: "+firstName+" "+lastName+"\nRole: "+personInfo.next()+"\nNo books out";
                }
            }
        }
        return "user not found"; //if the user wasn't found, return this
    }

    public String studentBooksOut(int idNum) throws FileNotFoundException{ //which books does a given student have out
        File log = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\log.txt");
        Scanner lScanner = new Scanner(log); //scanner of log
        while(lScanner.hasNextLine()){ //cycles through lines of the log
            String temp = lScanner.nextLine(); //stores each line in temp string
            Scanner line = new Scanner(temp).useDelimiter(","); //scans through the line
            line.next(); //don't need some of these values so trash
            line.next();
            String status = line.next(); //store the status of the book - in or out
            line.next();
            line.next();
            if(line.nextInt() == idNum && status.equals("out")){ //if the book is the student's and is out
                line.close();
                line = new Scanner(temp).useDelimiter(","); //rescan the temp line
                int outBookIsbn = line.nextInt(); //store isbn number
                String outBookName = line.next(); //store book name
                return outBookName+","+outBookIsbn; //return them with comma in between for sanner. ends this method
            }
        }
        return null; //if no book was found, we will get here in the program and will return null

    }     
    public static void adminCommands(){ //easier quicker way to print instructions:
        System.out.println("\nPlease choose from the following admin commands: \nCatalog - to make a new catalog \nUser - to add a new user to the system\nInfo - for the account info of a student\nExit - to exit the program.");

    }
}
