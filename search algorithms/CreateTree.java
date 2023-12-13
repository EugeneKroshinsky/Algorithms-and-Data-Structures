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

            Tree tree = new Tree();
            while (in.hasNext()) {
                tree.insert(in.nextInt());
            }

            if (tree.getRoot() != null) {
                printTree(tree.getRoot(), out);
            }
            out.flush();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
