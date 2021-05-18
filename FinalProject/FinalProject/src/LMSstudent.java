package FinalProject.FinalProject.src;
//imports:
import java.io.*;
import java.util.*;
public class LMSstudent {
    //declare instance variables
    public int idNum;
    public int idPassword;
    public String firstName;
    public String lastName;

    //getter methods (Accesors):
    public int getId(){
        return idNum;
    }
    public int getPassword(){
        return idPassword;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    //setter methods (Mutators):
    public void setId(int id){
        idNum = id;
    }
    public void setPassword(int password){
        idPassword = password;
    }
    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }
    public void setId(String newLastName){
        lastName = newLastName;
    }

    //constructor:
    public LMSstudent(int idNum, int idPassword,String firstName, String lastName){ //constructor for creating object
        //assigns constructor values to instance variables so can be used throughout the program
        this.idNum = idNum;
        this.idPassword = idPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    //methods:
    //finds book off ISBN number
    public String findBook(int isbn) throws FileNotFoundException{
        File catalog = new File("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\catalog.txt");
        Scanner input = new Scanner(catalog); //scanner of catalog file
        while(input.hasNextLine()){ //while another line
            String temp = input.nextLine(); //temp includes the entire line from the catalog
            Scanner line = new Scanner(temp).useDelimiter(","); //scan this line
            if(line.nextInt() == isbn){  //if book is in this line
                return temp; //return whole line (whole line is needed)
            }
        }
        return null; //if temp isn't returned, this indicates book wasn't found
    }
    public static String getBookName(String catalogInfo){ //gets name of books from catalog line
        Scanner line = new Scanner(catalogInfo).useDelimiter(","); //scan line of catalog info
        String trash = line.next(); //trash first two values
        String trash2 = line.next();
        if(line.hasNext()){
            return line.next(); //give value
        }
        else{
            return null; //otherwise, if there is no other value, just return null
        }
    }
    public void checkout(Scanner input) throws FileNotFoundException{ //checkout function
        if(!booksOut(input)){ //if the user doesn't already have a book checked out
            System.out.print("Please enter the ISBN of the book you would like to checkout. \nThis is found on the backside or spine of the book: "); //ui
            int isbn = input.nextInt(); //gets isbn of book from user
            String catalogInfo = findBook(isbn); //info of book - line from catalog is stored here
            if(catalogInfo != null){ //if book is found
                File log = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\log.txt");
                Scanner lScanner = new Scanner(log); 
                int numLines = 0;
                while(lScanner.hasNextLine()){ //scan log to see how many lines there are 
                    if(lScanner.nextLine().length() != 0){ //lines that actually have info
                        numLines++;
                    }  
                }
                String info[][] = new String [6][numLines+1]; //create 2d array with log size but one spot bigger, for us to enter our user info
                lScanner.close();
                lScanner = new Scanner(log);
                int y = 1; //start assigning values to 2d array at y = 1, this way we have extra space at begining to fill with more recent logs [top is most recent, bottom is later]
                while(lScanner.hasNextLine()){ //cycle through the lines
                    Scanner line = new Scanner (lScanner.nextLine()).useDelimiter(","); //scan line
                    int x = 0; //x refers to the position data in a row. Ie 0 would be the first value, 1 would be the second, etc.
                    String dp = ""; //dp -> data point
                    while(line.hasNext()){ //cycles through rest of data points
                        dp = line.next(); //assigns data point temporaraly to dp
                        info [x][y]=dp; //then assigns straight to 2d array. We don't go direct as when adding more lines to the program, it is much better to have stored data to troubleshoot with
                        x++; //cycle to next x value
                    }
                    y++;//when columns in the row are finished being stored into array, cycle to the next one              
                }
                lScanner.close();
                //store needed info of the book into the log
                info[0][0] = Integer.toString(isbn);
                info[1][0] = getBookName(catalogInfo);
                info[2][0] = "out";
                info[3][0] = firstName;
                info[4][0] = lastName;
                info[5][0] = Integer.toString(idNum);
                //printing section - now we reprint the array, this time with the new data
                PrintStream override = new PrintStream("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\log.txt");
                for(int y2 = 0; y2 < numLines+1; y2++){ //cycle through lines of the array
                    for(int x2 = 0; x2 < 6; x2++){ //cycle through the columns of the array
                        override.print(info[x2][y2]); //print the data points into the log file
                        if(x2 != 5){ //dont print ',' for end values - makes file look better
                            override.print(",");
                        }
                    }
                    if(y2 != numLines){ //dont print enter after last line - makes file look better
                        override.println();
                    }
                }
                override.close();
                System.out.println(getBookName(catalogInfo)+" was checked out."); //notifies user that check out was complete

            }
            else{
                System.out.println("Error: book not found"); //if the book isn't found
                studentCommands(); //reprint commands so they know their options
            }
        }
        else{ //if the user already has a book checked out
            System.out.println("You are only permitted to checkout one book at a time."); //ui
            studentCommands();//reprints commands so user can know their options
        }
    }
    public boolean booksOut(Scanner input) throws FileNotFoundException{ //returns wether or not a book is in or not.
        File log = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\log.txt");
            Scanner lScanner = new Scanner(log); //scans log file
            boolean noBookOut = false; //variable to represent wether or not a book is out or not
            while(lScanner.hasNextLine()){ //cycle through lines
                String temp = lScanner.nextLine(); //put line in temp variable
                Scanner line = new Scanner(temp).useDelimiter(","); //scan it seperated by ','s
                line.next(); //trash values except the user's clearence level and idNum
                line.next();
                String status = line.next();
                line.next();
                line.next();
                if(line.nextInt() == idNum && status.equals("out")){ //if the book was checked out by the student's id and is infact Checked out:
                    noBookOut = true; //yes, the book is checkout
                    line.close();
                    line = new Scanner(temp).useDelimiter(","); //reopen scanner to rescan the line but this time we store diff values
                    int outBookIsbn = line.nextInt();//store these
                    String outBookName = line.next(); //store these
                    System.out.println("You have the book "+outBookName+" out. ISBN: "+outBookIsbn+".");  //print findings
                    return true; //return that a book was found
                }
                else{
                    noBookOut = false; //if book was not found
                }
            }
            if(!noBookOut){
                System.out.println("You have no books out.");
            }
            return false; //since method would already end after first return, no if statement is needed as we know the book
    }
    public void checkIn(Scanner input) throws FileNotFoundException{ //return books
        if(booksOut(input)){ //if you have a book out
            System.out.println("Would you like to return it?");
            String inReturn = input.next(); //ask wether or not they want to retun the book
            if(inReturn.contains("y")){ //if contains y - then probalby means yes
            File log = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\log.txt");
            Scanner lScanner = new Scanner(log); //scan log
            int numLines = 0; 
            while(lScanner.hasNextLine()){ //count number of lines in the log
                if(lScanner.nextLine().length() != 0){ //*with text on it
                    numLines++;
                }  
            }
            String info[][] = new String [6][numLines]; //create 2d array to store all the values. big enough to store
            lScanner.close();
            lScanner = new Scanner(log);
            int y = 0;
            while(lScanner.hasNextLine()){
                Scanner line = new Scanner (lScanner.nextLine()).useDelimiter(","); //scan line by line again
                int x = 0;
                String dp = "";
                while(line.hasNext()){
                    dp = line.next();
                    info [x][y]=dp; //assign values to 2d array
                    x++;
                }
                y++;              
            }
            lScanner.close();
            lScanner = new Scanner(log); 
            int changeLine = 0;
            while(lScanner.hasNextLine()){ //cycle through lines again to see which line the return is on.
                changeLine++; //increments to demonstrate which line we need to make return on
                String temp = lScanner.nextLine(); //once against store as temp
                Scanner line = new Scanner(temp).useDelimiter(","); //check through temp
                line.next(); //trash not needed values
                line.next();
                line.next();
                line.next();
                line.next();
                if(line.nextInt() == idNum){ //if we are on the correct line
                    break; //leave
                }
            }
            info[2][changeLine-1] = "in"; //change to in
            PrintStream override = new PrintStream("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\FinalProject\\FinalProject\\src\\log.txt");
            for(int y2 = 0; y2 < numLines; y2++){//print info back into file - lines
                for(int x2 = 0; x2 < 6; x2++){ //rows
                    override.print(info[x2][y2]); //printing values back to log document
                    if(x2 != 5){
                         override.print(","); //prints commas
                    }
                }
                if(y2 != numLines-1){
                     override.println(); //print old info and modified return info back into file
                }
            }
            System.out.println("Book returned."); //let user know return is complete
            studentCommands(); //restate the student commands
            override.close();
        }
        else if(inReturn.contains("n")){ //if user says no and doesn't want to return
            System.out.println("Boook not returned."); //lets user know
            studentCommands(); //prints student commands
        }
        else{
            System.out.println("Please enter yes or no. Boook not returned.");
            studentCommands(); //prints student commands
        }
    }
        else{ //if it was found you don't have a book, just restates student commmands
            studentCommands();
        }
}

    public static void studentCommands(){ //quick way to reference these. also static as we don't need any reference to the instance variables
        System.out.println("\nPlease choose from the following student commands: \nCheckout - to check out a book \nReturn - to return a book\nInfo - for account info\nExit - to exit the program.");
    }
    public void info(Scanner input) throws FileNotFoundException{ //basically a toString method - prints info of user, but not password as that is more private
        System.out.println("Name: "+firstName+" "+lastName+"\nID Num: "+idNum+"");
        booksOut(input); //calls method to print which books are out
    }

}
