package com.example;
// Janet Weber  DUE 10/12/2015
// Week 8 Lab: functions
// Assignment: Design code that will calculate and display when the moon will be full
// based on the day you entered. 

import java.util.Scanner;

public class MyClass {

    public static void main(String[] args) {
        // *****************************************************************
        // Variables & Constants
        // *****************************************************************
        // (parallel arrays that together contain the complete date information regarding
        // when full moons will occur from today (10/12/15) thru the end of 2016).
        // To modify this, just add too each of the date arrays.

        final int[] FYEAR = {2015, 2015, 2015,
                2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016,
                2017};
        final int[] FMONTH = {10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1};
        final int[] FDAY = {27, 25, 25, 24, 22, 23, 22, 21, 20, 19, 18, 16, 16, 14, 14, 12};

        int fullMoon;           // holds index into date of next full moon
        int month, day, year;   // user input - find next full moon from this date
        Scanner scan = new Scanner(System.in);


        // display program purpose and prompt user for input initializing
        // variables month, day, and year.
        System.out.println("Enter a date between 10/1/2015 and 12/31/2016 " +
                        "and find the date of the next full moon!");
        System.out.print("\nEnter month (integer format) => ");
        month = scan.nextInt();
        System.out.print("\nEnter day (integer format) => ");
        day = scan.nextInt();
        System.out.print("\nEnter year (integer format) => ");
        year = scan.nextInt();

        // call function validDate to make sure the date entered is within range
        if (validDate(month, day, year)) {
            // call function nextFullMoon to get index into date of next full moon
            fullMoon = nextFullMoon(month, day, year, FMONTH, FDAY, FYEAR);
            if (fullMoon >= 0)                                  // display result
                System.out.println("Next full moon will be " +
                        FMONTH[fullMoon] + "-" + FDAY[fullMoon] +
                        "-" + FYEAR[fullMoon]);
            else
                System.out.println("Error! Try again!");        //  error, index -1
        }
        else
            System.out.println("invalid date");                 // date out of range
    } // end of main()

    // ****************************************************************************
    // This function takes as input a month(m), day(d), and year(y) and makes sure
    // it is within the range available to find the full moon.  Currently, this is
    // between 10/12/2015 and 12/31/2016.  Returns a boolean.
    // ****************************************************************************
    public static boolean validDate(int m, int d, int y) {
        boolean valid = false;      // initialize return value to false
        final int FIRSTYEAR = 2015, // constants that holds first and last
                LASTYEAR = 2016;    //  year of valid date range for user input

        if ((y >= FIRSTYEAR) || (y <= LASTYEAR)) {  // check year
            if ((m >= 1) && (m < 13)) {             // check month
                if ((d >= 0) && (d<31)) {           // check day
                    valid = true;                   // update return value
                }
            }
        }
        return valid;                               // return "valid"
    } // end of function validDate()

    // *************************************************************************
    // This function takes as input a month(m), day(d), and year(y) plus a
    // constant date arrays fm(FMONTH), fd(FDAY), fy(FYEAR) that containt the
    // full moon dates and returns the index into the date arrays of the next
    // full moon.
    // **********************************************************************
    public static int nextFullMoon(int m, int d, int y,
                                   int[] fm, int[] fd, int[]fy) {
        int i;              // loop variable
        int resultIndex;    // will hold index into fd (or FDAY), fm (or FMONTH),
                            //      fy (or FYEAR) of next full moon
        resultIndex = -1;   // Initialize to -1 (signals error)
        for (i = 0; i < fd.length; i++) {   // go through full moon dates comparing to input
            if (fy[i] == y && fm[i] == m) { //    if year and month match -
                if (d < fd[i])             //    then if day is <= save the index
                    resultIndex = i;
                else                        //    otherwise save the index+1
                    resultIndex = i + 1;
            }
        }
        return resultIndex;                 // return the index for date of next full moon.
    } // end of function next FullMoon()

} // end of class