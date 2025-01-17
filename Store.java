/**
 * Store
 *Shop home, greets user with shop categories
 *When ready for checkout, checkout user
 * Yaorui Xu
 * version: 2024-1-18
 */
//import java util package
import java.util.*;
public class Store
{
    //Superclass field Shopping cart
    ArrayList<String> shoppingCart = new ArrayList<>();
    //Private fields
    private boolean bolErrorTrap;
    private byte bytSelection;

    //default constructor
    public Store()
    {

    }
    //greet method: Greets user with home page and options, when selection is made
    //run subclass method, error trapping for user input
    //when ready for checkout, run checkout method
    public void greet(Checkout checkout, storeDriver userDriver,storeIrons userIrons, storeWedges userWedges, storePutters userPutters, storeGolfBalls userGolfBalls, storeAccessories userAccessories)
    {
        //new scanner
        Scanner scanner = new Scanner(System.in);

        //do while until user quits
        do{
            //dispaly homescreen to user
            System.out.println("\nWelcome to Flight School's shop application!");
            System.out.println("\n1. Drivers");
            System.out.println("\n2. Irons");
            System.out.println("\n3. Wedges");
            System.out.println("\n4. Putters");
            System.out.println("\n5. Gear and Accessories");
            System.out.println("\n6. Golf Balls");
            System.out.println("\nEnter 0 when you are ready for checkout");
            System.out.println("\nEnter 7. To return");

            //do while input error trapping
            do{
                bolErrorTrap=true;
                //try catch invalid input
                try{
                    bytSelection = scanner.nextByte();
                    //if outo f range
                    if(bytSelection<0||bytSelection>7){
                        System.out.println("Please enter a valid number");
                        bolErrorTrap=false;
                    }
                }catch(Exception e){
                    System.out.println("Please enter a valid number");
                    scanner.nextLine();
                    bolErrorTrap=false;
                }

            }while(bolErrorTrap==false);
            //based on user choice, run appropriate method
            if(bytSelection==1){

                userDriver.greet();

            }
            //based on user choice, run appropriate method
            if(bytSelection==2){

                userIrons.greet();
            }
            //based on user choice, run appropriate method
            if(bytSelection==3){

                userWedges.greet();
            }
            //based on user choice, run appropriate method
            if(bytSelection==4){

                userPutters.greet();
            }
            //based on user choice, run appropriate method
            if(bytSelection==5){

                userAccessories.greet();
            }
            //based on user choice, run appropriate method
            if(bytSelection==6){

                userGolfBalls.greet();
            }
            //if 0, proceed to checkout
            if(bytSelection==0){
                checkout.items(userDriver.shoppingCart);
                checkout.items(userIrons.shoppingCart);
                checkout.items(userWedges.shoppingCart);
                checkout.items(userPutters.shoppingCart);
                checkout.items(userGolfBalls.shoppingCart);
                checkout.items(userAccessories.shoppingCart);
                //for each display shopping list to user
                System.out.println("Your shopping list: ");

                for (String item : checkout.userFinal) {
                    System.out.print(item+"\n");

                }
                System.out.println("\nPlease proceed with your payment\nEnter 1 when finished for your reciept");
                bolErrorTrap=true;
                //input error trapping
                do{
                    try{
                        bytSelection=scanner.nextByte();
                        //when user is done paying, print reciept to file
                        if(bytSelection==1){
                            checkout.reciept(checkout.userFinal);
                            return;
                        }
                        else{System.out.print("Please enter 1 when finished payment");
                            bolErrorTrap=false;
                        }}catch(Exception e){
                        System.out.print("Please enter 1 when finished payment");
                        scanner.nextLine();
                        bolErrorTrap=false;
                    }}while(bolErrorTrap==false);
            }
        }while(bytSelection!=7);

    }
}
