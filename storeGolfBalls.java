
/**
 * Golf Balls Store
 *greets user with shop items and adds them to a shoping cart
 * Yaorui Xu
 * version: 2024-1-18
 */

//import java util package
import java.util.*;
public class storeGolfBalls extends Store
{
    //Private Fields
    private boolean bolErrorTrap;
    private byte bytResponse;

    //default constructor
    public storeGolfBalls()
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
            System.out.println("1. Long and Soft\n Our softest and longest ball ");
            System.out.println("2. Flight School G-5\n Quality ball providing distance off the tee, and greenside control");
            System.out.println("3. Flight School-Flight School\n our premium golf ball, providing maximum approach and greenside control");
            System.out.println("Enter 0 to exit");
            bytResponse = scanner.nextByte();
            System.out.println("Enter the number which corresponds to your answer");
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
                shoppingCart.add("Dozen: Flight School long and Soft-$30");
            }
            //add item to shopping cart
            if(bytResponse==2){
                shoppingCart.add("Dozen: Flight School G-5-$45");
            }
            //add item to shopping cart
            if(bytResponse==3){
                shoppingCart.add("Dozen: Flight School-Flight School-$60");
            }
        }while(bytResponse!=0);
        //if 0, return user
        if(bytResponse==0){
            return;
        }
    }
}