/**
 * Binary Seach Tree Word Cross-Reference
 *
 * Written by @author Srilokh Karuturi(Sai) for CS2336.005,Assignment 5,started Oct 25,2021
 * NetID: sxk180163
 *
 * Class/Program (TreeNode.java) Purpose:
 * Define the actual TreeNode which contains Strings
 *
 */

// over all package
package CS2336Asg5_sxk180163;

// import
import java.util.*;
import java.util.stream.Collectors;

// TreeNode class
public class TreeNode<String>{
    // define the actual string
    protected String element;
    // define the number of occurrences
    protected int occurence = 0;
    // define the number of line numbers
    ArrayList<Integer> lineNumbers = new ArrayList<>();
    // define the left tree node
    protected TreeNode<String> left;
    // define the right tree node
    protected TreeNode<String> right;

    // node tree constructor which takes in the element and line number
    public TreeNode(String element,int line) {
        this.element = element;
        occurence++;
        lineNumbers.add(line);
    }

    public void removeDuplicates(){
        // remove duplicates
        lineNumbers = (ArrayList<Integer>)lineNumbers.stream().distinct().collect(Collectors.toList());
    }
}
