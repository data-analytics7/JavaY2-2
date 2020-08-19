/**
 * Title: Student class that stores values in array and performs sorting operations.
 * Author: Faiz Syed 
 * Student ID: 33243485
 * Date: 22/10/2018
 * File name: Student.java
 * Purpose: To set values in array stu[], and perform other sorting operations.
 * Assumptions: Assuming that valid values are supplied to the constructor from the StudentClient class.
 *              
 **/

package Student;

public class Student {
  
private String title, fname, lname;
private long StudentID;
private int day, month, year;
private double mark1, mark2, mark3, pracmark, finalmark;
private double overallMark;
private String grade;



public Student(){ //Default constructor
    
    title="Null";       //
    fname="No fname";
    lname="No lname";
    StudentID=-1;
    day=-1;
    month=-1;
    year=-1;
    mark1=-1;
    mark2=-1;
    mark3=-1;
    pracmark=-1;
    finalmark=-1;
    
}//end default constructor


//Constructor to populate the array with the hard coded values
public Student(String title , String fname, String lname, long StudentID, int day, int month, int year,
                    double mark1, double mark2, double mark3, double pracmark, double finalmark)
{
    //set method to store title
    setTitle(title);

    //set method to store fname
    setFname(fname);

    //set method to store lname
    setLname(lname);

    //set method to store StudentID
    setStudentID(StudentID);

    //set method to store DOB day
    setDay(day);

    //set method to store DOB month
    setMonth(month);

    //set method to store DOB year
    setYear(year);

    //set method to store assignment 1 mark
    setMark1(mark1);

    //set method to store assignment 2 mark
    setMark2(mark2);

    //set method to store assignment 3 mark
    setMark3(mark3);

    //set method to store weekly practical mark
    setPracmark(pracmark);

    //set method to store final exam mark
    setFinalmark(finalmark);

    //Calling method that calculates overall mark for each stdent
    OverallMark(this.mark1, this.mark2, this.mark3, this. pracmark, this.finalmark);
    
} //end of constructor

// method StudentInfo() that displays my details
public static void StudentInfo( )
{
    System.out.println("Name: Faiz Syed"); 
    System.out.println("Student ID: 33243485");
    System.out.println("Mode of enrolment: On-campus");
    System.out.println("Tutor name: Mark");
    System.out.println("Tutorial: 1:30pm Thursday\n");
}

/*****************Set Methods*****************/

//set method to store title
public void setTitle(String title)
{
    this.title=title;
}

//set method to store first name
public void setFname(String fname)
{
    this.fname=fname;
}

//set method to store last name
public void setLname(String lname)
{
    this.lname=lname;
}

//set method to store Student number
public void setStudentID(long StudentID)
{
    this.StudentID=StudentID;
}

//set method to store DOB day
public void setDay(int day)
{
    this.day=day;
}

//set method to store DOB month
public void setMonth(int month)
{
    this.month=month;
}

//set method to store DOB year
public void setYear(int year)
{
    this.year=year;
}

//set method to store assignment 1 mark
public void setMark1(double mark1)
{
    this.mark1=mark1;
}

//set method to store assignment 2 mark
public void setMark2(double mark2)
{
    this.mark2=mark2;
}

//set method to store assignment 3 mark
public void setMark3(double mark3)
{
    this.mark3=mark3;
}

//set method to store weekly practical mark
public void setPracmark(double pracmark)
{
    this.pracmark=pracmark;
}

//set method to store final exam mark
public void setFinalmark(double finalmark)
{
    this.finalmark=finalmark;
}

/*********************Get Methods************************/

//get method to return assignment 1 mark to Client class
public double getMark1()
{
    return this.mark1;
}

//get method to return assignment 2 mark to Client class
public double getMark2()
{
    return this.mark2;
}

//get method to return assignment 3 mark to Client class
public double getMark3()
{
    return this.mark3;
}

//get method to return weekly practical mark to Client class
public double getPracmark()
{
    return this.pracmark;
}

//get method to return final exam mark to Client class
public double getTestmark()
{
    return finalmark;
}

//get method to return assignment 1 mark to Client class
public String getTitle()
{
    return this.title;
}

//get method that returns student First name to Client class
public String getFname ()
{
    return this.fname;
}

//get method that returns student Last name to Client class
public String getLname ()
{
    return this.lname;
}

//get method that returns Student number to Client class
public long getStudentID ()
{
    return this.StudentID;
}

//get method that returns student DOB day to Client class
public int getDay ()
{
    return this.day;
}

//get method that returns student DOB month to Client class
public int getMonth ()
{
    return this.month;
}

//get method that returns student DOB year to Client class
public int getYear ()
{
    return this.year;
}

// get method that returns student Grade to Client class
public String getGrade ()
{
    return this.grade;
}

//get method that returns student overall mark to Client class
public double getoverallMark()
{
    return this.overallMark;
}

//get method that returns student overall mark rounded up to 2 decimal places to the Client class 
public double getoverallMarkRoundup() //returning overall mark in float format
{     
    this.overallMark = (double) Math.round(this.overallMark * 100) / 100;
    return this.overallMark;
}


/******Method to calculate Overall mark************/

public void OverallMark(double mark1, double mark2, double mark3, double pracmark, double finalmark)
{
    double totalmark;

    {
        totalmark = mark1+ mark2 + mark3 + pracmark + finalmark;
        overallMark= (totalmark/410)*100;   //Max marks that can be obtained is 410
       
        if(overallMark>80)
        {
            grade="HD";
        }
        else 
            if(overallMark>70)
            {
                grade="D";
            }
            else
                if(overallMark>60)
                {
                    grade="C";
                }
                else
                    if(overallMark>50)
                    {
                        grade="P";
                    }
                    else
                    {
                        grade="N";
                    }
            
    }
}//end method


/*******Method to compare student information and list any duplicates********/
public boolean equalStudent(Student inputStu)  
{
    boolean theFlag = false;
    if(this.getStudentID()==inputStu.getStudentID() && this.getFname().equals(inputStu.getFname()) 
            && this.getLname().equals(inputStu.getLname()) && this.getDay()==inputStu.getDay() 
            &&  this.getMonth()==inputStu.getMonth() && this.getYear()==inputStu.getYear())
    {
        theFlag = true;   
    }

    return theFlag;
}


/****Finding and displaying the student information which is repetitive ~ Equals method ********/ 
public static void equalOutput(Student [] stu, int arraycounter)
{
    int counterduplicate=0;
    for( int j = 0; j < arraycounter-1; j++)
    {
        for(int k = j+1; k < arraycounter; k++)
        {
            if(stu[j].equalStudent(stu[k]))
            {
                counterduplicate++;// keeping count of duplicate students not sure if to be used
                
                System.out.println("Duplicate student information found: " );
                System.out.println("****************************************");
                System.out.println("Student name: "  + stu[j].getFname() + " " + stu[j].getLname()
                        + "\nStudent ID: " + stu[j].getStudentID() +
                "\nDOB: " + stu[j].getDay()+"-"+stu[j].getMonth()+"-"+stu[j].getYear());
                System.out.println("****************************************\n");
                
            }

        }
    }
}


/******************SELECTION SORT*************************/
public static void SortArrayBySelection( Student []arrayToSort, int arraycounter) {
    
    Student temp;
    int indexOfSmallest;
    
        // One by one moving through unsorted array
        for ( int i = 0; i < arraycounter-1; i++) 
        { 
            // Finding the minimum element in unsorted array 
            indexOfSmallest = i; 
            for (int j = i+1; j < arraycounter; j++) 
                if (arrayToSort[j].StudentID < arrayToSort[indexOfSmallest].StudentID) 
                    indexOfSmallest = j; 
  
            // Swap the found minimum element with the first element
            Swap(arrayToSort, indexOfSmallest, i);
        } 
}


/**********Sorting Student Names in Ascending Order Using Bubble Sort**********/
public static void SortArrayByBubbleSort( Student [] arrayToSort, int arraycounter) 
{
    // number of passes
    for(int i = 1;i < arraycounter;i++) 
    {
        // perform one pass
        for(int j=0;j< arraycounter-1;j++)
        // perform one comparison
            if ((arrayToSort[j].lname).compareToIgnoreCase(arrayToSort[j + 1].lname)>0)
                Swap (arrayToSort, j, j+1);

    } // end for loop of i

} // end method SortArrayByBubbleSort

// A separate method that performs swap  for Bubble sort
public static void Swap (Student []arr, int first, int second)
{
    Student temp;
    temp = arr[first];
    arr[first] = arr[second];
    arr[second]= temp;

} // end method swap

//Method that sorts students based on their overall Mark using Seletion sort
public static int HighestOverallMark(Student [] stu, int arraycounter)
{
    Student temp;
    int indexOfSmallest, i;
   
    // One by one moving through unsorted subarray 
    for ( i = 0; i < arraycounter-1; i++) 
    { 
        // Find the minimum element in unsorted array 
        indexOfSmallest = i; 
        for (int j = i+1; j < arraycounter; j++) 
            if (stu[j].overallMark < stu[indexOfSmallest].overallMark) 
                indexOfSmallest = j; 

        // Swap the found minimum element with the first element
        temp = stu[indexOfSmallest]; 
        stu[indexOfSmallest] = stu[i]; 
        stu[i] = temp;    
    } 
  
        return i;
        
}

}//End of class Student