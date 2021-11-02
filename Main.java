/**
 * Binary Search Tree Word Cross-Reference
 *
 * Written by @author Srilokh Karuturi(Sai) for CS2336.005,Assignment 4,started Oct 25, 2021
 * NetID: sxk180163
 *
 * Program Description:
 * The goal of this program is for the student to understand the creation of a tree and to do a inorder traversal of said tree.
 * This program is designed to keep track of all words in a document. In the end, it will print out all the words down in alphabetical order
 * using the data structure binary search trees.
 *
 * Class/Program (main.java) Purpose:
 * - receive file name
 * - call according function for organizing word document into binary search tree
 * - properly sort binary search tree
 * - handle any sort of exceptions
 *
 *
 * Important:
 * - program will keep track of each word in the file
 *   - the num times the word occurs
 *   - line number that contains the word
 * - when the word occurs more than once, count it more than once but do not duplicate the line number
 * - words separated via question mark, period, comma, exclamation point, semicolon, colon, hyphen.
 * - ignore parenthesis & quotation marks
 * - blank lines do count for the line numbers
 * - plurals and variations of a word are considered different.
 * - Ignore case
 * - program will exit after printing the output
 * - the list should be maintained in alphabetical order, as in when words come in they accordingly get put in the right part
 * - write small "helper" functions for various tasks'
 * - ignore the following words "the","a","an"
 * - print the text as you read it which has a line number before it
 *
 *
 * - output should look like:
 *   = file preceded by a line number
 *   = words in alphabetical order, num occurence of word, line number of occurence
 *   = at end print the total number of words, total number of unique words, total number of lines
 *
 *   sample output:
 *
 *      alphabetical 	 1  1
 *      and		 1 1
 *      word 		 1 1
 *      words 		 2 1,3
 *      your		 1 1
 *
 *
 *
 * Inputs:
 * - file name
 *
 * Outputs:
 * - console
 *
 * Imports:
 * - java.io.*
 * - java.util.*
 *
 * Classes:
 * Main
 * Misc
 *
 * Grading important comments:
 * Everything in main: -20
 * Using a sort function instead of keeping order using a BST: -10
 * Using a BST class rather than building your own: -50
 * Printing the same line number for a word more than once. -5
 * Missing a word that should be in the list. -10
 * Submitting anything other than a zip file. -10
 * Submitting entire IDE project rather than just the zip file. -10
 */
package CS2336Asg5_sxk180163;


import java.io.*;
import java.util.*;


/**
 *  program will take in a file and properly alphabetize the line numbers using BST
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // define scanner for user input
        Scanner userInput = new Scanner(System.in);

        // define file name
        String fileName = "";

        // ask user for file name
        System.out.print("Enter file name: ");

        // receive file name from user
        fileName = userInput.next();

        // define file object
        File file = new File(fileName);

        if (file.exists()) {
            // print file
            Misc.printFile(file);

            // properly populate binary search tree
            Misc.digestFile(file);

            // properly output binary search tree using inorder traversal
            Misc.output();

            // exit
            System.exit(0);

        } else {
                // print file not found
                System.out.println("[File not found]");

            }


        // end of main loop

    }// end of main

}// end of main loop
