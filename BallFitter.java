/**
 * Wedge fitter gives user a ball fitting
 * then returns to fitting homepage
 *
 * Yaorui Xu
 * version: 2024-1-18
 */

//import java util package
import java.util.*;
public class BallFitter extends Fitter
{
    //private fields of questions and answer selection
    private String [] strQuestions = {"What is your handicap?",
            "What trajectory do you prefer?",
            "Describe your spin on approach shots:",
            "What type of feel do you prefer?"};

    private String strAnswers[][] = {
            {"1. 20+","2. 15-5","3. >5"},
            {"1. High","2. Medium","3. Low"},
            {"1. Low","2. Medium","3. High"},
            {"1. Soft","2. Medium","3. Hard"},
        };
    //private fields
    private byte bytBeginnerCounter;
    private byte bytIntermediateCounter;
    private byte bytAdvancedCounter;
    private byte bytChoice;
    private boolean bolErrorTrap;
    private String strText;
    private byte bytResult;

    //constructor to run once object is created
    public BallFitter()
    {

        //get the result of the fitter
        bytResult=fittingQuestions(strQuestions, strAnswers);
        //recommend to user
        recommendation(bytResult);
        //print out to user
        System.out.print(strText);

    }
    //recommendation method: recommends club
    private void recommendation(byte r){
        if(r==1){
            strText="Your Perfect Fit: Long and Soft\n Our softest and longest ball\n"; 
        }
        if(r==2){ strText="Your Perfect Fit: Flight School G-5\n Quality ball providing distance off the tee, and greenside control\n";

        }
        if(r==3){
            strText = "Your Perfect Fit: Flight School-Flight School\n Our premium golf ball, providing maximum approach and greenside control\n";

        }
    }

    //display questions and get user answers
    private byte fittingQuestions(String[] q, String[][]a)
    {
        //nested for loop to iterate through questions then answers
        for(int i=0; i<q.length;i++){
            System.out.println(q[i]);
            for(int j=0; j<a[0].length;j++){
                System.out.println(a[i][j]);
            }
            //new scanner
            Scanner scanner = new Scanner(System.in);
            //do while error trapping
            do{
                bolErrorTrap=true;
                //try catch for invalid input
                try{
                    System.out.println("Enter the number which corresponds to your answer\n");
                    bytChoice = scanner.nextByte();
                    if(bytChoice<1||bytChoice>3){
                        System.out.println("Please enter a valid number\n");
                        bolErrorTrap=false;
                    }
                }catch(Exception e){
                    System.out.println("Please enter a valid number\n");
                    scanner.nextLine();
                    bolErrorTrap=false;
                }

            }while(bolErrorTrap==false);

            //based on user answer, increment counter to calculate optimal selection
            if(bytChoice==1){
                bytBeginnerCounter++;

            }
            if(bytChoice==2){
                bytIntermediateCounter++;

            }
            if(bytChoice==3){
                bytAdvancedCounter++;

            }
        }
        //based on fitting results, recommend
        if(bytAdvancedCounter>bytIntermediateCounter||bytAdvancedCounter>bytBeginnerCounter){
            return 3;
        }
        //based on fitting results, recommend
        if(bytBeginnerCounter>bytIntermediateCounter||bytBeginnerCounter>bytAdvancedCounter){

            return 1;
        }
        //based on fitting results, recommend
        if(bytIntermediateCounter>bytAdvancedCounter||bytIntermediateCounter>bytBeginnerCounter){
            return 2;
        }
        //based on fitting results, recommend
        if(bytAdvancedCounter>bytIntermediateCounter||bytAdvancedCounter==bytBeginnerCounter){
            return 3;
        }
        //based on fitting results, recommend
        if(bytAdvancedCounter==bytIntermediateCounter||bytAdvancedCounter>bytBeginnerCounter){
            return 3;
        }
        //based on fitting results, recommend
        if(bytIntermediateCounter>bytAdvancedCounter||bytIntermediateCounter==bytBeginnerCounter){
            return 2;
        }

        return -1;
    }

}