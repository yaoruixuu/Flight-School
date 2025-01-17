/**
 * Checkout
 *adds user checkout to a list to be printed out and to a reciept
 * Yaorui Xu
 * version: 2024-1-18
 */

//import java util package
import java.util.*;
public class Checkout
{
    //field to store users final checkout list
    ArrayList<String> userFinal = new ArrayList <>();

    //default constructor
    public Checkout()
    {

    }

    //items method: method to add arraylist items to the final checkout list
    public void items(ArrayList<String> a)
    {
        ArrayList<String> checkout = a;
        for (String item : checkout) {
            userFinal.add(item);

        }
        //return when finished
        return;
    }
    //reciept method: creates a PrintReciept object
    //takes in an arraylist and calls writeCheckoutToFile for reciept
    public void reciept (ArrayList<String> r){
        PrintReciept f = new PrintReciept();
        f.writeCheckoutToFile(r);
    }
}
