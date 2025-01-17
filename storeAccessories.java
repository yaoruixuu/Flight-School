/**
 * Accessories Store
 *greets user with shop items and adds them to a shoping cart
 * Yaorui Xu
 * version: 2024-1-18
 */
//import java util package
import java.util.*;

public class storeAccessories extends Store
{
    //Private Fields
    private boolean bolErrorTrap;
    private byte bytResponse;

    //default constructor
    public storeAccessories()
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
            System.out.println("\n1. Flight School Golf Shirt-$50");
            System.out.println("\n2. Flight School Hat-$25");
            System.out.println("\n3. Flight School Rain Jacket-$300");
            System.out.println("\n4. Flight Rain Pants-$200");
            System.out.println("\n5. Flight School Driver Cover-$30");
            System.out.println("Enter 0 to exit");
            //do while error trapping
            do{
                //set errorTrap to true
                bolErrorTrap=true;
                //try catch if invalid input type
                try{
                    bytResponse = scanner.nextByte();
                    //if outside of range
                    if(bytResponse<0||bytResponse>5){
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
                shoppingCart.add("Flight School Golf Shirt-$50");
            }
            //add item to shopping cart
            if(bytResponse==2){
                shoppingCart.add("Flight School Hat-$25");
            }
            //add item to shopping cart
            if(bytResponse==3){
                shoppingCart.add("Flight School Rain Jacket-$300");
            }
            //add item to shopping cart
            if(bytResponse==4){
                shoppingCart.add("Flight School Rain Pants-$200");
            }
            //add item to shopping cart
            if(bytResponse==5){
                shoppingCart.add("Flight School Driver Cover-$30");
            }
        }while(bytResponse!=0);
        //if 0, return user
        if(bytResponse==0){
            return;
        }
    }
}
