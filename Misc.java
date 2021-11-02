/**
 * Binary Seach Tree Word Cross-Reference
 *
 * Written by @author Srilokh Karuturi(Sai) for CS2336.005,Assignment 5,started Oct 25,2021
 * NetID: sxk180163
 *
 * Class/Program (Misc.java) Purpose:
 * Class of things that are more technical to the program
 *
 */



// over all package
package CS2336Asg5_sxk180163;

// imports
import java.io.*;
import java.util.*;

/**
 * Class MISC which contains techincal functions which is required for code to work
 */
public class Misc {
    // define static binary search tree
    static BST wordTree = new BST();

    // define static line number
    static int line = 1;

    /**
     * Digest File will actaully go through line by line collecting each word properly and populating binary search tree
     * @param file
     * @throws FileNotFoundException
     */
    public static void digestFile(File file) throws FileNotFoundException {
        // define scanner object for going through file
        Scanner scanFile = new Scanner(file);

        // array of strings to temporarily store words
        String[] tempArr;

        // temporary string to store the line for printing
        String temp;

        // go through each word in file and insert accordingly into binary search tree
        while(scanFile.hasNextLine() ) {
            // set string temp to the line of words
            temp = scanFile.nextLine();
            /**
             * temp will split the line after being clean where there are spaces
             */
            tempArr = (Misc.cleanLine(temp)).split("\\s+");

            // go through element in the list and add to the linked list
            for(String element:tempArr) {
                // send the string and line number into the insert function of BST
                if(!(element.equals(""))) {
                    wordTree.insert(element, line);
                }

                }
            // increase line number
            line++;
            // increase the line number for the binary search tree
            wordTree.increaseLine();
            } // end of while loop

    } // end of function digest file

    /**
     * print file as is
     * @param file
     * @throws FileNotFoundException
     */
    public static void printFile(File file) throws FileNotFoundException {
        // print new line
        System.out.println();

        // define scanner object for going through file
        Scanner scanFile = new Scanner(file);

        // define line number
        int line = 1;

        // go through each line in file and print out accordingly
        while(scanFile.hasNextLine()) {
            System.out.print(line + " ");
            System.out.println(scanFile.nextLine());
            line++;
        } // end of while loop

        // print new line
        System.out.println();

    } // end of function print file

    /**
     * Properly output at the ending
     */
    public static void output(){
        // function of in order will traverse the binary search tree in order and print out accordingly
        wordTree.inorder();
        // print new line
        System.out.println();
        // print the total number of nodes in the BST
        System.out.println("Total words: " + wordTree.size);
        // print the total number of unique words .. this is found during the in order traversal
        System.out.println("Total unique: " + wordTree.numUnique);
        // print the number of lines contained in the file
        System.out.println("Total num lines: " + wordTree.numLines);
        // print new line
        System.out.println();
    }

    /**
     * Line will be cleaned of all unnecessary things
     * @param line
     * @return
     */
    public static String cleanLine(String line) {
        line = line.replace("An ","");
        line = line.replace(" an "," ");
        line = line.replace(" a ",  " ");
        line = line.replace("A ",  "");
        line = line.replaceAll(" The "," ");
        line = line.replaceAll("The ","");
        line = line.replaceAll(" An "," ");
        line = line.replaceAll(" the "," ");
        line = line.replace(" an "," ");
        line = line.replace(" a ",  " ");
        line = line.replace("?","");
        line = line.replace(".", "");
        line = line.replace(",","");
        line = line.replace("!","");
        line = line.replace(";","");
        line = line.replace(":","");
        line = line.replace(",","");
        line = line.replaceAll(",","");
        line = line.replace("-"," ");
        line = line.replaceAll("[()]","");
        line = line.replace("\"", "");

        return line;
    }

}
