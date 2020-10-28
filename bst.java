/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class BSTops
{
	 private Node root;
    class Node{
        int data,pos;
        Node left,right;
        public Node(int data,int pos){
            this.data=data;
            this.pos=pos;
        }
    }
    public Node insert(Node node,int data,int pos){
        if(node==null){
            System.out.println(pos);
            return new Node(data,pos);
        }
        if(data<node.data){
            node.left=insert(node.left,data,2*pos);
        }
        else if(data>node.data){
            node.right=insert(node.right,data,2*pos+1);
        }
        return node;
    }
    public Node delete(Node node,int data){
        if(node!=null){
            if(data<node.data){
                node.left=delete(node.left,data);
            }
            else if(data>node.data){
                node.right=delete(node.right,data);
            }
            else{
                if(node.left==null){
                    return node.right;
                }
                else if(node.right==null){
                    return node.left;
                }
                else{
                    node.data=findReplacement(node.right);
                    node.right=delete(node.right,node.data);
                }
            }
        }
        return node;
    }
    public static int positionOf(Node node,int data){
        if(data<node.data){
            return positionOf(node.left,data);
        }
        else if(data>node.data){
            return positionOf(node.right,data);
        }
        return node.pos;
    }
    int findReplacement(Node node){
        while(node.left!=null){
            node=node.left;
        }
        return node.data;
    }

    public static void main(String[] args) throws IOException {
        BSTops tree=new BSTops();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(br.readLine());
        while(q-->0){
            String[] command=br.readLine().split("\\s");
            if(command[0].equals("i")){
                tree.root=tree.insert(tree.root,Integer.parseInt(command[1]),1);
            }else{
                System.out.println(positionOf(tree.root,Integer.parseInt(command[1])));
                tree.root=tree.delete(tree.root,Integer.parseInt(command[1]));
            }
        }
    }
}
