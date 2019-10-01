/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static Node root;
    
    static class Node {
        int data, position;
        Node left, right;
        public Node(int data, int position){
            this.data = data;
            this.position = position;
        }
    }//end Node
    
    static Node insertNode(Node root, int data, int position){
        if(root == null){
            root = new Node(data, position);
            System.out.println(position);
            return root;
        }
        if(data < root.data){
            root.left = insertNode(root.left, data, 2 * position);
        }
        else if(data > root.data){
            root.right = insertNode(root.right, data, 2*position+1);
        }
        return root;
    }//end insertNode
    
    static Node deleteNode(Node root, int data){
        if(root == null){
            return root;
        }
        if(data < root.data){
            root.left = deleteNode(root.left, data);
        }
        else if(data > root.data){
            root.right = deleteNode(root.right, data);
        }
        else{
            System.out.println(root.position);
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                root.data = smallestValue(root.right);
                root.right = deleteNode(root.right, root.data);
            }
        }
        return root;
    }//deleteNode
    
    static int smallestValue(Node root){
        int low = root.data;
        while(root.left != null){
            low = root.left.data;
            root = root.left;
        }
        return low;
    }//end smallestValue
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		String[] input;
		int totalInput = 0;
		
		totalInput = Integer.parseInt(in.nextLine());
		
		while(totalInput > 0){
		    input = in.nextLine().split("[ ]");
		    String operation = input[0];
		    int data = Integer.parseInt(input[1]);
		    
		    if(operation.compareTo("i") == 0 ){
		        root = insertNode(root, data, 1);
		    }
		    if(operation.compareTo("d") == 0){
		        root = deleteNode(root, data);
		    }
		    totalInput -= 1;
		}
		    
			in.close();
	}//end main
}
