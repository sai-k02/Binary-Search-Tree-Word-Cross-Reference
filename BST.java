/**
 * Binary Seach Tree Word Cross-Reference
 *
 * Written by @author Srilokh Karuturi(Sai) for CS2336.005,Assignment 5,started Oct 25,2021
 * NetID: sxk180163
 *
 * Class/Program (BST.java) Purpose:
 * Defines the binary search tree for Word Cross-Reference
 *
 */

// overall package
package CS2336Asg5_sxk180163;

import com.sun.source.tree.Tree;

import java.util.ArrayList;

/*
Binary Search Tree Class
 */
public class BST{
    // define tree node rood
    protected TreeNode<String> root = null;
    // define integer size
    protected int size = 0;
    // define numUnique
    protected int numUnique = 0;
    // define numLines
    protected int numLines = 0;

    // elementary constructor
    public BST() {

    }

    // insert node
    public void insert(String element, int line) {
        // check if there are any nodes
        if (root == null) {
            root = new TreeNode(element, line);
            size++;
        }
        else {
            // locate the parent node
            TreeNode<String> current = root;
            TreeNode<String> parent = null;

            // find the parent node
            while (current != null) {
                // if string argument is less than current node
                if (element.compareToIgnoreCase(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                // if string argument is greater than current node
                else if (element.compareToIgnoreCase(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } // if string argument is the same then do this
                else if (element.compareToIgnoreCase(current.element) == 0){
                    current.occurence += 1;
                    current.lineNumbers.add(line);
                    return;
                }


            } // end of while loop

            // Create the new node and attach it to the parent node
            if (element.compareToIgnoreCase(parent.element) < 0) {
                parent.left = new TreeNode(element, line);
                size++;

            }
            else if (element.compareToIgnoreCase(parent.element) > 0) {
                parent.right = new TreeNode(element, line);
                size++;
            }

        }


    }

    // inorder recursive call
    public void inorder() {
        inorder(this.root);
    }

    public void inorder(TreeNode<String> root){
        // if the BST is not empty
        if(root != null){
            // recursion call
            inorder(root.left);

            /**
             * This is where we are actually checking every node and seeing if it is a unique element
              */
            if(root.occurence == 1) {
                numUnique++;
            }

            // print accordingly
            System.out.print(root.element + " " + root.occurence + " ");

            // remove duplicates from the line number array list
            root.removeDuplicates();

            // accordingly print array list of line numbers
            if(root.lineNumbers.size() == 1) {
                System.out.print(root.lineNumbers.get(0));
            }
            else {
                for(int element : root.lineNumbers) {
                    if(root.lineNumbers.get(root.lineNumbers.size()-1) == element) {
                        System.out.print(element);
                    }
                    else System.out.print(element + ", ");

                }
            }
            // new line
            System.out.println();
            // recursion call
            inorder(root.right);
        } // end of if statement

    } // end of function inORDER

    // increase line function
    public void increaseLine(){
        numLines++;
    } // end of increase line

}
