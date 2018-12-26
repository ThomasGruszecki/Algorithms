//Only took seven and a half years to actually figure out what the heck makes this sort tick

import java.util.Arrays;

public class TreeSort
{
    private static int i = 0;
    public static void sort(int[] array)
    {
        Node rootNode = buildBinarySearchTree(array);
        
        traverseInOrder(rootNode, array);
    }
    
    public static void traverseInOrder(Node node, int[] array) 
    {
        if (node.hasLeft()) 
        {
            traverseInOrder(node.getLeftNode(), array);
        }
        array[i++] = node.getValue();
        if(node.hasRight())
        {
            traverseInOrder(node.getRightNode(), array);
        }
    }
    
    public static Node buildBinarySearchTree(int[] array)
    {
        Node rootNode = new Node(array[0]);
        
        for(int i = 1; i < array.length; i++)
        {
            addNode(array[i], rootNode);
        }
        return rootNode;
    }
    
    public static void addNode(int num, Node rootNode)
    {
        if(num > rootNode.getValue())
        {// if array[i] is greater, itś node goes to the right of the checked node
            if(rootNode.hasRight())
                addNode(num, rootNode.getRightNode());
            else 
                rootNode.setRightNode(new Node(num));
        }
        else // if array[i] isn't greater, itś node goes to the left of the checked node
        {
            if(rootNode.hasLeft())
                addNode(num, rootNode.getLeftNode());
            else
                rootNode.setLeftNode(new Node(num));
        }
    }
}

