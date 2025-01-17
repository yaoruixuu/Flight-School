/**
 * testClass
 * creates objects of many classes that will be used throught the program
 *Runs the program
 * Yaorui Xu
 * version: 2024-1-18
 */
//import java util package
import java.util.*;
public class TestClass{
    //main method
    public static void main(String[]args){
        //initialize variables
        int response=0;
        boolean errorTrap=false;
        //create objects that will be used
        Store user = new Store();
        Fitter fitter = new Fitter();
        Checkout checkout = new Checkout();
        storeDriver storeD= new storeDriver();
        storeIrons storeI = new storeIrons();
        storeWedges storeW= new storeWedges();
        storePutters storeP = new storePutters();
        storeGolfBalls storeG= new storeGolfBalls();
        storeAccessories storeA= new storeAccessories();
        //new scanner
        Scanner scanner = new Scanner(System.in);
        //do while until user exits
        do{
            
            System.out.println("\nFlight School-Take Flight\nAre you ready to level up your game?");
            System.out.println("\nWe offer the widest selection of the highest preforming golf equipment personalized for you");
            System.out.println("\nTry our fitting tool to find the optimal club for you");
            System.out.println("\nEnter 1 for your ultimate fitting expierience");
            System.out.println("\nEnter 2 for the Flight School shop and checkout");
            System.out.println("\nEnter 3 to exit");
            //do while input error trapping
            do{
                //try catch for invalid input
                try{
                    response=scanner.nextInt();
                    //if 1, run fitter
                    if(response==1){

                        fitter.homepage();
                        errorTrap=true;
                    }
                    //if 2, run store
                    if(response==2){

                        user.greet(checkout, storeD, storeI, storeW, storeP, storeG, storeA);
                        errorTrap=true;
                    }
                    if(response<1||response>3){
                        System.out.println("Please enter a valid number");
                    }}
                catch(Exception e){
                    System.out.println("Please enter a valid number");
                    scanner.nextLine();
                }
            }while(errorTrap==false);
        }while(response!=3);
    }
}