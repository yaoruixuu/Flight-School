/**
 * Print Reciept
 *Prints reciept to a file for the user
 * Yaorui Xu
 * version: 2024-1-18
 */

//import java util package
import java.util.*;
//import io package
import java.io.*;

public class PrintReciept
{

    //default constructor
    public PrintReciept()
    {

    }
    //writeCheckoutToFile method: creates new buffered writter and writes arraylist to a file
    public void writeCheckoutToFile(ArrayList<String> a){
        //try catch to handle exceptions
        try{
            //new buffered writer object
            BufferedWriter writer = new BufferedWriter(new FileWriter("reciept.txt"));
            //for loop to iterate through arraylist
            for(int i=0; i<a.size(); i++){
                //write index i
                writer.write(a.get(i));
                //new line every row of the array
                writer.newLine();
            }
            //close writer
            writer.close();
            System.out.println("File saved in reciept.txt");
        }catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for writing");
        } catch (IOException e) {
            System.out.println("Error: Cannot write to file");
        }}  
}
