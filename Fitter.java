/**
 * Store
 *Fitter home, greets user with fitter categories
 *when a category is selected, run fitting
 * Yaorui Xu
 * version: 2024-1-18
 */
//import java util package
import java.util.*;
public class Fitter
{

    //private fields
    private boolean bolErrorTrap;
    private byte bytUserChoice;

    //default constructor
    public Fitter()
    {

    }
    //hompage method: displays fitting options to user and runs the fitting
    //until user chooses to exit
    //gives club recommendations based on user input
    public void homepage()
    {
        //do while until user exits
        do{
            System.out.println("\nWelcome to the fitting station! What would you like to be fit for today?");
            System.out.println("\n1. Driver\n2. Iron\n3. Wedges\n4. Putter\n5. Golf Ball\n6. Exit\nEnter your choice corresponding to the number beside");
            Scanner scanner = new Scanner(System.in);

            //user input error trapping
            do{
                bolErrorTrap=true;
                //try catch for invalid input
                try{
                    System.out.println("\nEnter the number which corresponds to your answer");
                    bytUserChoice = scanner.nextByte();
                    if(bytUserChoice<1||bytUserChoice>7){
                        System.out.println("\nPlease enter a valid number");
                        bolErrorTrap=false;
                    }
                }catch(Exception e){
                    System.out.println("\nPlease enter a valid number");
                    scanner.nextLine();
                    bolErrorTrap=false;
                }

            }while(bolErrorTrap==false);

            //based on user choice, run create the correct gitter object
            if(bytUserChoice==1){
                DriverFitter driverFitter = new DriverFitter();

            }
            //based on user choice, run create the correct gitter object
            if(bytUserChoice==2){
                IronFitter ironFitter = new IronFitter(); 

            }
            //based on user choice, run create the correct gitter object
            if(bytUserChoice==3){
                WedgeFitter wedgeFitter = new WedgeFitter(); 

            }
            //based on user choice, run create the correct gitter object
            if(bytUserChoice==4){
                PutterFitter putterFitter = new PutterFitter(); 

            }
            //based on user choice, run create the correct gitter object
            if(bytUserChoice==5){

                BallFitter ballFitter = new BallFitter(); 

            }
        }while(bytUserChoice!=6);
    }
}