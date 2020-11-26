/**
 * Title: Student Client class 
 * Author: Faiz Syed 
 * Student ID: 33243485
 * Date: 22/10/2018
 * File name: StudentClient.java
 * Purpose: Supplies hard coded student arrays to Student class constructor, displays a menu and performs operations involving students details and marks.
 * Assumptions: Assuming that valid values are stored in the array, and in proper order.
 *              
 **/

package Student;

//import static Student.Student.StudentInfo;
import java.util.Scanner;

public class StudentClient { //START OF CLIENT CLASS
    
static Scanner keyboard = new Scanner(System.in);//creating an object of Scanner class
    
public static void main(String[] args) {    //START OF MAIN

StudentClient obj = new StudentClient ();   //creating an object of Student class

int menu_choice;    //variable that stores the menu choice of user
boolean flag = false; //boolean variables to exit from the menu

Student[] stu = new Student [25]; //array declaration with default size of 25

/*******Populating array of Student objects with data to perform operations************/
stu[0] = new Student("Miss", "Mary", "James", 3322441, 12, 3, 2001, 40, 50, 60, 8, 75);
stu[1] = new Student("Mr", "jeremy", "Nick", 3322442, 3, 7, 1997, 66, 56.5, 78, 8.5, 82);
stu[2] = new Student("Mr", "Morris", "Kay", 3322443, 17, 5, 1995, 43, 63.67, 51.8, 8, 79);
stu[3] = new Student("Mrs", "Jen", "Parker", 3322444, 28, 11, 1990, 86, 75, 56, 8.75, 86);
stu[4] = new Student("Mr", "Tom", "Sawyer", 3322445, 19, 2, 1985, 76, 80.67, 82.8, 9, 70.73);
stu[5] = new Student("Mrs", "Emma", "Thomson", 3322446, 22, 8, 1992, 55, 39, 62, 7.2, 70);
stu[6] = new Student("Miss", "Aisha", "Rom", 3322449, 26, 6, 2004, 100, 100, 90, 9, 97.99);
stu[7] = new Student("Mr", "Kevin", "Roger", 3322450, 10, 9, 1992, 71, 67, 60, 8, 68);
stu[8] = new Student("Mr", "Kevin", "Roger", 3322450, 10, 9, 1992, 100, 100, 100, 8, 100);
stu[9] = new Student("Miss", "Tony", "Garcia", 3322449, 26, 6, 2004, 65, 69, 74, 8, 77);

int arraycounter=10; //counter for number of students in the array must be set according to hard coded data entries

//Calling method StudentInfo() that displays my details
Student.StudentInfo();

//while loop that terminates the program when flag is true
while(!flag)
{
    displayMenu();//Method to display a menu
 
    System.out.println("\nEnter your choice (1-11): "); //asking menu choice
    menu_choice = keyboard.nextInt();  //storing menu choice 
 
    /*START OF MENU*/
    switch(menu_choice)    //using switch statements to perform operation as per user input
    {
        case 1: flag=true;  //sets flag to true to exit program
                break;
         
        case 2: arraycounter = AddStudent(stu, arraycounter);    //Adding new student and getting back the incremented arraycounter
                break;
                
        case 3: DisplayStudents(stu, arraycounter);   //Calling method that displays details of all students
                break;
                
        case 4: DispAvg(stu, arraycounter);   //Calling a method that calculates and displaying average of overall marks of all students
                break;
                
        case 5: CatOverallMark(stu, arraycounter);    //Calling a method that categories students based the average calculated in option 4
                break;
        
        case 6: DistributeGrades(stu, arraycounter);  //Calling a method that displays the distribution of student grades
                break;
         
        case 7: FindByStudentID(stu, arraycounter);   //Calling a method that searches the array to find student with the given Student number
                break;
                
        case 8: FindByStudentName(stu, arraycounter);     //Calling a method that searches the array to find student with the given name
                break;
        
        case 9: Student.HighestOverallMark(stu, arraycounter);//To find and display the students with highest and the second highest overall mark in the array
                HighestOverallMark(stu, arraycounter);    //Calling a method that shows students with the highest and 2nd highest overall mark
                break;
                
        case 10:Student.SortArrayBySelection(stu, arraycounter);  // Sorting array by Student numbers in ascending order:
                SortStudentsBySelection(stu, arraycounter);  //Sorting and displaying students in ascending order of student ID
                break;
                 
        case 11: Student.SortArrayByBubbleSort(stu, arraycounter);   // Sorting array by Student names ascending alphebetical order: 
                SortStudentsByBubbleSort(stu, arraycounter); //Sorting and displaying students in ascending alphabetical order of Surnames
                break;
                
        default: System.out.println("Invalid input");   //Default message 
                break;
                
    }//END OF SWITCH
    
} //END OF WHILE

} //END OF MAIN

//To display menu to the user
public static void displayMenu()
{
    System.out.println("\n\nMENU:\n");
    
    System.out.println("1. Quit (exit the program)\n\n" +
"2. Add (to the array) all information about a student (except the overall mark and the grade) by\n" +
"reading it from the keyboard and determine the student’s grade\n\n" +
"3. Output from the array the details (all information including the overall mark and the grade) of\n" +
"all students currently held in the array\n\n" +
"4. Compute and output the average overall mark for students currently held in the array\n\n" +
"5. Determine and display how many students obtained an overall mark equal to or above the\n" +
"average overall mark and how many obtained an overall mark below the average overall mark\n\n" +
"6. Display the distribution of grades (i.e., the number of HDs, Ds etc) awarded\n\n" +
"7. Given a student number (ID), view all details of the student with that number. If the student is\n" +
"not found in the array, an appropriate error message is to be displayed\n\n" +
"8. Given a student’s name (both surname and given name – ignoring case), view all details of that\n" +
"student. If the student is not found in the array, an appropriate error message is to be displayed\n\n" +
"9. Display the names of the students with the highest overall mark and the second highest overall\n" +
"mark in the array with the help of the method in the student class.\n\n" +
"10. Display the sorted array into ascending order of students’ numbers (IDs) using the sorting\n" +
"algorithm in (vi) from the student class\n\n" +
"11. Display the sorted array of student objects into ascending (alphabetical/dictionary) order of\n" +
"students’ surnames using a different sorting algorithm in (vii) from the student class.");
}

/*****************SWICTH CASE 2**********************/

//Method to get new students details from the user and add them to array suing constructor
public static int AddStudent(Student []stu, int arraycounter)
{
    String fname, lname, title;     //variables to store store details
    long StudentID;
    int day, month, year;
    double mark1, mark2, mark3, pracmark, finalmark;
    
    System.out.println("Enter student title (Mr/Miss/Mrs): ");
    title = keyboard.next();
    if(title.matches("Mr|Miss|Mrs"))        //validating title input
    {
        title=title;
    }
    else
    {
        title = "Not set";  //if valid title is not given
        System.err.format("Title is invalid, expecting Mr,Mrs or Miss\n");
    }
   
    
    System.out.println("Enter student first name:");
    fname= keyboard.next();
    
    System.out.println("Enter student last name:");
    lname= keyboard.next();
    
    
    System.out.println("Enter student number: ");
    StudentID= keyboard.nextLong();
    
    do{
        System.out.println("Enter student DOB day: ");
        day= keyboard.nextInt();
    }while(!((day>=1)&&(day<=31))); //validtaing DOB day
    
    do{
        System.out.println("Enter student DOB month: ");
        month= keyboard.nextInt();  
    }while(!((month>=1)&&(month<=12))); //validating DOB month
    
    do{
        System.out.println("Enter student DOB year: ");
        year= keyboard.nextInt();   
    }while(!(year<=2018));  //validating DOB year
    
    do{
    System.out.println("Enter student assignment 1 mark (0-100): ");
    mark1= keyboard.nextDouble();
    }while(!((mark1>=0)&&(mark1<=100)));    //validating marks range 0-100
    
    do{
    System.out.println("Enter student assignment 2 mark (0-100): ");
    mark2= keyboard.nextDouble();
    }while(!((mark2>=0)&&(mark2<=100)));    //validating marks range 0-100
    
    do{
    System.out.println("Enter student assignment 3 mark (0-100): ");
    mark3= keyboard.nextDouble();
    }while(!((mark3>=0)&&(mark3<=100)));    //validating marks range 0-100
    
    do{
    System.out.println("Enter student weekly practical mark (0-10): ");
    pracmark= keyboard.nextDouble();
    }while(!((pracmark>=0)&&(pracmark<=10)));   //validating marks range 0-10
    
    do{
    System.out.println("Enter student final exam mark (0-100): ");
    finalmark= keyboard.nextDouble();
     }while(!((finalmark>=0)&&(finalmark<=100)));   //validating marks range 0-100
     
    stu[arraycounter]=new Student(title, fname, lname, StudentID, day, month, year, 
            mark1, mark2, mark3, pracmark, finalmark);    //Passing these values to constructor in Student class
  
    //Presenting Output
    System.out.println("NEW STUDENT ADDED");
    System.out.println("New student name: "+ stu[arraycounter].getFname() + " " + stu[arraycounter].getLname());
    System.out.println("Student number: "+ stu[arraycounter].getStudentID());
    
    
    arraycounter++; //incrementing arraycounter each time after adding a student to array
    return arraycounter;
}

/*****************SWITCH CASE 3**********************/

//Method to display details of all students present in the array
public static void DisplayStudents(Student []stu, int arraycounter)
{
    //Presenting output
    
    System.out.println("**************************************************************************************************************************************************************");
    System.out.println("\nSTUDENT DETAILS:\n");
    System.out.println("\t\t\tTitle\tFname\tLname\t  Student no.\t  DOB\t\tMark 1\tMark2\t"
                + "Mark 3\t  Weekly mark\tExam mark\tOverall mark\tGrade");
    
    for(int i=0; i<arraycounter; i++)
    {
        //Calling method to display output
        OutputStudentDetails(stu, i); 
    }
    
    System.out.println("**************************************************************************************************************************************************************");

}

/*****************SWICTH CASE 4**********************/

//Method to calculate and display average of student overall marks 
public static void DispAvg(Student []stu, int arraycounter)
{
    double Avg; //declaring variable
    Avg=CalcAverage(stu, arraycounter); //Calling method that will calculate Average overall
    System.out.println("Average overall mark of all students: "+ Avg);
}

/********Method that calculates Average overall to be used in Switch case 4 and 5*****/
public static double CalcAverage(Student []stu, int arraycounter)
{
    double sum=0, Avg=0, maxoverall=0;
    
    for(int i=0; i< arraycounter; i++)
    {
       sum += stu[i].getoverallMark();  
    }
    
    maxoverall= arraycounter*100;
    Avg= (sum/maxoverall)*100;
    Avg = (double) Math.round(Avg * 100) / 100; //rounding up Avg to 2 decimal places
    
    return Avg;  //Avg returned to methods DispAvg() and CatOverallMark()
}

/*****************SWICTH CASE 5**********************/

//To categorize and display students based on their overall mark
public static void CatOverallMark(Student []stu, int arraycounter)
{
    int aboveAvg=0, belowAvg=0;
    double Avg;
    Avg=CalcAverage(stu, arraycounter); //Calling method that will calculate Average overall
    
    for(int i=0; i< arraycounter; i++)
    {
        if(stu[i].getoverallMark()>=Avg)
            aboveAvg++;
        else
            belowAvg++;    
    }
    //Calling method that displays the output
    DisplayStuOverall(arraycounter, Avg, aboveAvg, belowAvg);
    
}

public static void DisplayStuOverall(int arraycounter, double Avg, int belowAvg, int aboveAvg)
{
    System.out.println("\nTotal number of students: " + arraycounter);
    System.out.println("Average overall mark of all students: " + Avg);
    System.out.println("Number of students with overall mark equal to or greater than average: " + aboveAvg);
    System.out.println("Number of students with overall mark equal below the average: " + belowAvg);
}



/*****************SWICTH CASE 6**********************/

//Method to show distribution of grades
public static void DistributeGrades(Student []stu, int arraycounter)
{
    int HD=0, D=0, C=0, P=0, N=0;     //declaring variables

   
     for(int i=0; i< arraycounter; i++)
    {
        if(stu[i].getGrade()=="HD")
            HD++;
        else
            if(stu[i].getGrade()=="D")
                D++;
            else
                if(stu[i].getGrade()=="C")
                    P++;
                else
                    if(stu[i].getGrade()=="P")
                        C++;
                    else
                        N++;
                
    }
     //Calling method that displays the output
     DisplayGrades(HD, D, C, P, N);
    
}


public static void DisplayGrades (int HD, int D, int C, int P, int N)
{
    System.out.println("\nNo. of students with HD grade: " + HD);
    System.out.println("\nNo. of students with D grade: " + D);
    System.out.println("\nNo. of students with C grade: " + C);
    System.out.println("\nNo. of students with P grade: " + P);
    System.out.println("\nNo. of students with N grade: " + N);
}

/*****************SWICTH CASE 7**********************/

//Method to search students by Student ID
public static void FindByStudentID(Student []stu, int arraycounter)
{
   long stunum; //variable to store the Student ID to be searched
   boolean found=false;   //boolean that is initialised as not found
   
    System.out.println("Displaying student details using Student Id:\n");
    System.out.println("Enter Student Id: ");
    stunum= keyboard.nextLong();    //taking user input
   
    
     for( int i=0; i< arraycounter; i++)
    {
        if((stunum==stu[i].getStudentID())==true)  //if found
        {
            System.out.println("\t\t\tTitle\tFname\tLname\t  Student no.\t  DOB\t\tMark 1\tMark2\t"
                + "Mark 3\t  Weekly mark\tExam mark\tOverall mark\tGrade");
            
            //Calling method display student deatils
            OutputStudentDetails(stu, i); 
            
            found=true;   //changing found to true          //keep i=-1
        }
         
    }
     
     if(found==false)   //message to be displayed if not found
     {
        System.out.println("Student Not Found!");    
     }
              
}


/*****************SWICTH CASE 8**********************/

//Method to search student with the given first name and last name
public static void FindByStudentName(Student []stu, int arraycounter)
{
    String fnameinput, lnameinput;
    boolean found=false;    //initialised as not found
    
    System.out.println("Enter first name: ");       //Getting user input
    fnameinput= keyboard.next();
    fnameinput= fnameinput.toLowerCase();
    
     System.out.println("Enter last name: ");
    lnameinput= keyboard.next();
    lnameinput= lnameinput.toLowerCase();
    
    
    
     for(int i=0; i< arraycounter; i++)
    {                                   
        if(((fnameinput.equals((stu[i].getFname()).toLowerCase())==true))                  
                && 
          ((fnameinput.equals((stu[i].getFname()).toLowerCase())==true)))
                            //if both firsrt name and last name match
        {
            System.out.println("\t\t\tTitle\tFname\tLname\t  Student no.\t  DOB\t\tMark 1\tMark2\t"
                + "Mark 3\t  Weekly mark\tExam mark\tOverall mark\tGrade");
            
            //calling method to display student details
           OutputStudentDetails(stu, i);   
            found=true;     //student found
        }
         
    }
     
     if(found==false)       //if not found display the folloeing message
     {
         System.out.println("Student Not Found!");      
     }
}

/*****************SWICTH CASE 9**********************/

//Method that displays names of students with highest and second highest overall mark
public static void HighestOverallMark(Student [] stu, int arraycounter)
{
    int i=Student.HighestOverallMark(stu, arraycounter);  //calling method that returns the position of student with highest overall mark in array
    
    //Calling method that displays output
    DispHighestOverall(stu, i);
}

public static void DispHighestOverall(Student []stu, int i)
{
    System.out.println("\n******************************************************");
    System.out.println("Highest Overall Mark:");                                                                //rounding up to 2 decimal places
    System.out.println("\n" + stu[i].getFname() + " " + stu[i].getLname() + " has highest overall mark: " + (double) Math.round(stu[i].getoverallMark() * 100) / 100);  
    System.out.println(stu[i-1].getFname() + " " + stu[i-1].getLname() + " has second highest overall mark: " + (double) Math.round(stu[i-1].getoverallMark() * 100) / 100);
    System.out.println("********************************************************");
}


/*****************SWICTH CASE 10**********************/

//Method to sort students in ascending order of their Student number
public static void SortStudentsBySelection( Student []stu, int arraycounter)
{
    Student.SortArrayBySelection(stu, arraycounter);  //Calling the Student class method that sorts the array accordingly
    
       System.out.println("\t\t\tTitle\tFname\tLname\t  Student no.\t  DOB\t\tMark 1\tMark2\t"
                + "Mark 3\t  Weekly mark\tExam mark\tOverall mark\tGrade");
    //Displaying the whole array
    for (int i=0; i< arraycounter; ++i) 
    {   
        //calling method that displays student details
        OutputStudentDetails(stu, i); 
    }
    System.out.println("\n**************************************************************************************");
    System.out.println("Students sorted based on Student numbers ~Selection Sort Complete !\n");   
}
        

/*****************SWICTH CASE 10**********************/
//Method to sort students in ascending order of their Surnames
public static void SortStudentsByBubbleSort( Student [] stu, int arraycounter)
{
    Student.SortArrayByBubbleSort(stu, arraycounter); //calling a Student class method that sorts the array accordingly
   
    System.out.println("\t\t\tTitle\tFname\tLname\t  Student no.\t  DOB\t\tMark 1\tMark2\t"
                + "Mark 3\t  Weekly mark\tExam mark\tOverall mark\tGrade");
    //Displaying the whole array
    for (int i=0; i< arraycounter; ++i) 
    {  
        //calling method that displays student details
       OutputStudentDetails(stu, i);      
    }
    System.out.println("\n**************************************************************************************");
    System.out.println("Students sorted based on Surnames ~Bubble Sort Complete ! \n"); 
      
}

public static void OutputStudentDetails(Student []stu, int i)
{
    
    
    System.out.println("Student Details" + ": \t" + stu[i].getTitle() + "\t" + stu[i].getFname()+ 
            "\t"+ stu[i].getLname() + "\t  " + stu[i].getStudentID()+"\t" + stu[i].getDay() + "-" + 
            stu[i].getMonth() + "-" + stu[i].getYear()+ "\t" + stu[i].getMark1()+"\t" + stu[i].getMark2() +
            "\t"+ stu[i].getMark3() + "\t   "+ stu[i].getPracmark() + "\t\t  " + stu[i].getTestmark() + 
            "\t\t  " + stu[i].getoverallMarkRoundup() +  "\t\t   "+ stu[i].getGrade());
            
}

}//END CLIENT CLASS

