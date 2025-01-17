/**
 * Wedge fitter gives user a iron fitting
 * then returns to fitting homepage
 *
 * Yaorui Xu
 * version: 2024-1-18
 */

//import java util package
import java.util.*;
public class IronFitter extends Fitter
{

    //private fields of questions and answer selection
    private String [] strQuestions = {"What is your handicap?",
            "What trajectory do you prefer?",
            "Describe your spin on approach shots:",
            "What is your prefered look in an iron",
            "How far do you hit your 7-iron?",
            "Longest iron you are confident in playing?",
            "What type of divot do you normally take?",
            "What is most important to you in an iron?",
        };

    private String strAnswers[][] = {
            {"1. 20+","2. 15-5","3. >5"},
            {"1. high","2. medium","3. low"},
            {"1. low","2. medium","3. high"},
            {"1. Confidence Inspiring Build","2. Compact Shap","3. Tour blade"},
            {"1. >140","2.145<and<165","3. 165+"},
            {"1. 6iron","2. 5-4 iron","3iron"},
            {"1. Shallow/none","Compact","Deep"},
            {"1. Foregivness","2. Blend","3. Workability"},
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
    public IronFitter()
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
            strText="Your Perfect Fit: Flight School B-747\n A players improvment iron offering maximum" 
            +"forgiveness, the highest ballflight, and confidence on every strike\n"; 
        }
        if(r==2){ strText="Your Perfect Fit: Flight School G-200\n The best of both worlds, an iron with"
            +"workability and foregivness\n";

        }
        if(r==3){
            strText = "Your Perfect Fit: Flight School F-22\n Maximum workability, preferred by top touring professionals"
            +"for maximum ball flight control\n";

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