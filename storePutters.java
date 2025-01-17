
/**
 * Putter Store
 *greets user with shop items and adds them to a shoping cart
 * Yaorui Xu
 * version: 2024-1-18
 */

//import java util package
import java.util.*;
public class storePutters extends Store
{
    //Private Fields
    private boolean bolErrorTrap;
    private byte bytResponse;

    //default constructor
    public storePutters()
    {

    }

    //greeet method: greets the user with items and prices of the store
    //error catches invalid input
    //adds items to a shopping cart
    public void greet()
    {
        //do while until user wants ot exit
        do{
            //new scanner
            Scanner scanner = new Scanner (System.in);
            //display to user
            System.out.println("1. Flight School A380\n Large Mallet putter designed to give you the most consistent roll-$100 ");
            System.out.println("2. Your Perfect Fit: Flight School Slick Back\n Sleek design, giving you confidence with every roll-$250");
            System.out.println("3. Your Perfect Fit: Flight School Softest Touch\n Sleek blade design, maximum insert feedback-$500");
            System.out.println("Enter 0 to exit");
            //do while error trapping
            do{
                //set errorTrap to true
                bolErrorTrap=true;
                //try catch if invalid input type
                try{
                    bytResponse = scanner.nextByte();
                    //if outside of range
                    if(bytResponse<0||bytResponse>3){
                        System.out.println("Please enter a valid number");
                        bolErrorTrap=false;
                    }
                }catch(Exception e){
                    System.out.println("Please enter a valid number");
                    scanner.nextLine();
                    bolErrorTrap=false;
                }

            }while(bolErrorTrap==false);
            //add item to shopping cart
            if(bytResponse==1){
                shoppingCart.add("Flight School A380-$100");
            }
            //add item to shopping cart
            if(bytResponse==2){
                shoppingCart.add("Flight SlickBack-$250");
            }
            //add item to shopping cart
            if(bytResponse==3){
                shoppingCart.add("Flight School Softest Touch-$500");
            }
        }while(bytResponse!=0);
        //if 0, return user
        if(bytResponse==0){
            return;
        }
    }
}
