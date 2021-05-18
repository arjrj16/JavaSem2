package FinalProject.FinalProject.src;
//imports
import java.util.*;
import java.io.*;


public class LMSmain {
    public static void main (String args []) throws FileNotFoundException   {
        //define variables
        int id;
        int tempId; //temps are needed for id and passoword to croscheck other
        int pswrd;
        int tempPswrd; //temps are needed for to croscheck ids and passwords
        String firstName ="";
        String lastName="";
        String role="";
        boolean uFound = false; //tells program that the username was found
        boolean uLog = false; //tells program user was correctly logged in - password and username
        Scanner input = new Scanner (System.in); //Scanner
        File idFile = new File("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\id.text");//id file
        Scanner ids = new Scanner(idFile);//scanner of id file

        System.out.println("Welcome to the Greenhill Library Management System. \n There are only two rules. \n Please return books by the end of the school year or you will be charged. \n Only one book is permitted to be checked out a time. \n To begin, please enter your user Id and password.");
        System.out.println();
        System.out.print("User ID: ");
        id = input.nextInt();
        System.out.print("Password: ");
        pswrd = input.nextInt();
        //^^UI|UI|UI
        while(ids.hasNextLine() && uFound == false){ //cycles through lines of id database until finds the username
            Scanner user = new Scanner(ids.nextLine()); //puts line into scanner
            if(user.hasNextInt()){
                tempId = user.nextInt();  //get id from line
                if(tempId == id){ //if line id matches with the user's id
                    uFound=true; //no need to repeat another line
                    if(user.hasNextInt()){
                        tempPswrd = user.nextInt(); //get password from line
                        if(tempPswrd == pswrd){ //if paswords match too
                            if(user.hasNext()){
                                firstName = user.next(); //store first name
                                if(user.hasNext()){
                                    lastName = user.next(); //store last name
                                    if(user.hasNext()){
                                        role = user.next(); //store role
                                        uLog = true; //->UserLoggedIn -note that the user credentials have succesfully been found 
                                    }
                                }
                            }
                        }
                        else{ //if passwords dont match:
                            System.out.println("Incorrect password.");
                        }
                    }
                    else{ //if the file isn't formatted correct
                        System.out.println("Error: Fix id file to correct formatting.");
                        break;
                    }
                }
            }
            else{ //if file isn't formatted correctly
                System.out.println("Error: Fix id file to correct formatting.");
                break;
            }
        }
        if(uFound == false){ //if user id was not found
            System.out.println("Error: User ID not found");
        }
        if(uLog==true){//if credentials were succesfully found
            Scanner uInputs = new Scanner (System.in); //new cleared scanner just for interacting with menus -> userInputs
            System.out.println(role+" acces: Hi "+firstName+" "+lastName+". How can the LMS help you today?"); //ui
            if(role.equals("Admin")){ //if user is an admin
                String in = ""; //input string
                LMSadmin admin = new LMSadmin(); //create object of LMSadmin class using constructor. For admin, since nothing is being inputted about admin, no parameters are needed.
                //System.out.println("Please choose from the following admin commands: \nCatalog - to make a new catalog \nUser - to add a new user to the system\nInfo - for the account info of a student\nExit - to exit the program.");
                LMSadmin.adminCommands();
                System.out.println("*Admin users are not able to check out books. These are explicity student resources.*\n   *- If an Admin wishes to checkout a book, with aproval, he/she can create a student account too.*");
                while(!in.equalsIgnoreCase("exit")){ //keeps looping until user types to exit
                    System.out.println();
                    System.out.print("Command: "); //ui
                    in=input.next(); //get command
                    if(in.equalsIgnoreCase("catalog")){ //if catalog is selected, run make catalog method
                        admin.makeCatalog(input);
                        admin.adminCommands();
                    }
                    else if(in.equalsIgnoreCase("user")){ //if user is selected, run add user method
                        admin.addUser(input);
                        admin.adminCommands();
                    }
                    else if(in.equalsIgnoreCase("info")){ //if info is selected
                        System.out.println("Enter the User ID of the info you wish to find");
                        int studentTempId = input.nextInt(); //gets user id wanted
                        System.out.println(admin.toString(studentTempId, input)); //print toString method of info
                        admin.adminCommands();
                    }
                    else if(in.equalsIgnoreCase("exit")){ //exit the program
                        System.out.println("Exiting the program . . .");
                    }
                    else{ //if command isn't found
                        System.out.println("Command not found. Please choose from: \nCatalog - to make a new catalog \nUser - to add a new user to the system\nInfo - for the account info of a student\nExit - to exit the program.");
                    }

                }
            }
            else if (role.equals("Student")){ //if role is a student
                LMSstudent student = new LMSstudent(id, pswrd, firstName, lastName); //create object of LMSstudent class with constructor which asks for the given parameters
                String in = ""; //input String
                LMSstudent.studentCommands(); //static reference student commands method - prints the available commands
                //System.out.println("Please choose from the following student commands: \nCheckout - to check out a book \nReturn - to return a book\nInfo - for account info\nExit - to exit the program.");
                while(!in.equals("exit")){ //while user doesn't input exit
                    System.out.println();
                    System.out.print("Command: "); // ui
                    in = input.next(); //get user input
                    if(in.equalsIgnoreCase("checkout")){ //if users says to checkout
                        student.checkout(input); //run checkout method
                    }
                    else if(in.equalsIgnoreCase("return")){ //if user says to return
                        student.checkIn(input); //run return method
                    }
                    else if(in.equalsIgnoreCase("info")){ //if user says they want their info
                        student.info(input); //run info method
                    }
                    else if(in.equals("exit")){ //if user wants to exit
                        System.out.println("Exiting the program . . .");
                    }
                    else{ //if command isn't recognized
                        System.out.println("Command not found. Please choose from: \nCheckout \nReturn \nInfo");
                    }
                }
            }
            else{ // no role selected
                System.out.println("Error: Role defined incorectly");
            }

        }
    }
}