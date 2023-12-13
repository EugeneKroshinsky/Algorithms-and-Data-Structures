import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Node {
    public int key;
    public Node left;
    public Node right;

    public Node(int key) {
        this.key = key;
    }
}
class Tree {
    private Node root;
    public Node getRoot(){
        return root;
    }
    public void insert(int x) {
        root = doInsert(root, x);
    }
    public void delete(int x) {
        root = doDelete(root, x);
    }
    private static Node doInsert(Node node, int x) {
        if (node == null) {
            return new Node(x);
        }
        if (x < node.key) {
            node.left = doInsert(node.left, x);
        } else if (x > node.key) {
            node.right = doInsert(node.right, x);
        }
        return node;
    }
    private static Node doDelete(Node node, int deleteNumber) {
        if (node == null){
            return null;
        }

        if (node.key > deleteNumber) {
            node.left = doDelete(node.left, deleteNumber);
            return node;
        } else if (node.key < deleteNumber){
            node.right = doDelete(node.right, deleteNumber);
            return node;
        } else {
            if (node.left == null && node.right == null){
                node = null;
                return node;
            } else if(node.left == null) {
                node = node.right;
                return node;
            } else if(node.right == null) {
                node = node.left;
                return node;
            } else {
                Node temp = node;
                node = node.right;
                while(node.left != null){
                    node = node.left;
                }
                temp.key = node.key;
                temp.right =  doDelete(temp.right, node.key);
                return temp;
            }
        }
    }

}

public class Main implements Runnable{
    public static void printTree(Node node, PrintWriter out) {
        out.println(node.key);
        if (node.left != null) printTree(node.left, out);
        if (node.right != null) printTree(node.right, out);
    }
    public static void main(String[] args) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }
    @Override
    public void run() {
        try {
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter((new FileWriter("output.txt")));

            int deleteNumber = in.nextInt();

            Tree tree = new Tree();
            while (in.hasNext()) {
                tree.insert(in.nextInt());
            }

            tree.delete(deleteNumber);

            if (tree.getRoot() != null) {
                printTree(tree.getRoot(), out);
            }
            out.flush();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
