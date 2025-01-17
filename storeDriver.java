/**
 * Driver Store
 *greets user with shop items and adds them to a shoping cart
 * Yaorui Xu
 * version: 2024-1-18
 */

//import java util package
import java.util.*;
public class storeDriver extends Store
{
    //Private Fields
    private boolean bolErrorTrap;
    private byte bytResponse;

    //default constructor
    public storeDriver()
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
            System.out.println("1. Flight School Launcher\nOur highest launching, highest spinning driver"
                +" designed for lower swing speeds");
            System.out.println("2. Flight School Hammer\n Long and Forgiving");
            System.out.println("3. Flight School F5\n Smaller head for maximum workability\npreferred by top touring professionals"
                +"for maximum ball flight control");
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
                shoppingCart.add("Flight School Launcher-$400");
                System.out.println("You've added: Flight School Launcher-$400");
            }
            //add item to shopping cart
            if(bytResponse==2){
                shoppingCart.add("Flight School Hammer-$500");
            }
            //add item to shopping cart
            if(bytResponse==3){
                shoppingCart.add("Flight School F5-$700");
            }
        }while(bytResponse!=0);
        //if 0, return user
        if(bytResponse==0){
            return;
        }
    }

}
