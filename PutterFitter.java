/**
 * Wedge fitter gives user a putter fitting
 * then returns to fitting homepage
 *
 * Yaorui Xu
 * version: 2024-1-18
 */

//import java util package
import java.util.*;
public class PutterFitter extends Fitter
{
    //private fields of questions and answer selection
    String [] strQuestions = {"What is your preferred putter?",
            "How heavy do you prefer your putter?",
            "How consistent is your impact location?",
        };

    String strAnswers[][] = {
            {"1. Mallet","2. Hybrid","3. Blade"},
            {"1. heavy","2. medium","3. light"},
            {"1. low","2. medium","3. high"},
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
    public PutterFitter()
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
            strText="Your Perfect Fit: Flight School A380\n Large Mallet putter designed to give you the most consistent roll "; 
        }
        if(r==2){ strText="Your Perfect Fit: Flight School Slick Back\n Sleek design, giving you confidence with every roll";

        }
        if(r==3){
            strText = "Your Perfect Fit: Flight School Softest Touch\n Sleek blade design, maximum insert feedback";

        }
    }

    //display questions and get user answers
    private byte fittingQuestions(String[] q, String[][]a)
    {
        //nested for loop to iterate through questions then answers
        for(int i=0; i<strQuestions.length;i++){
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
