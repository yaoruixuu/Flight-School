/**
 * Wedge fitter gives user a driver fitting
 * then returns to fitting homepage
 *
 * Yaorui Xu
 * version: 2024-1-18
 */
//import java util package
import java.util.*;
public class DriverFitter extends Fitter
{
    //private fields of questions and answer selection
    private String [] strQuestions = {"What is your handicap?",
            "Current trajectory?",
            "Typical driving distance?",
            "How consistent is your impact location?"};

    private String strAnswers[][] = {
            {"1. 20+","2. 15-5","3. >5"},
            {"1. Low","2. Medium","3. High"},
            {"1. >200","2. 210<and<250","3. 265+"},
            {"1. Low","2. Medium","3. High"},
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
    public DriverFitter()
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
            strText="Your Perfect Fit: Flight School Launcher\nOur highest launching, highest spinning driver"
            +" designed for lower swing speeds"; 
        }
        if(r==2){ strText="Your Perfect Fit: Flight School Hammer\n Long and Forgiving";

        }
        if(r==3){
            strText = "Your Perfect Fit: Flight School F5\nSmaller head for maximum workability\npreferred by top touring professionals"
            +"for maximum ball flight control";

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
                    System.out.println("Enter the number which corresponds to your answer");
                    bytChoice = scanner.nextByte();
                    if(bytChoice<1||bytChoice>3){
                        System.out.println("Please enter a valid number");
                        bolErrorTrap=false;
                    }
                }catch(Exception e){
                    System.out.println("Please enter a valid number");
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