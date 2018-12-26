 public class Node
{ 
    private static int nodeCount = 0;
    private static void increment()
    {
        nodeCount++;
    }
    public static int getCount()
    {
        return nodeCount;
    }
    
    private int value;
    private Node leftNode, rightNode;
    public Node(int v)
    {
        value = v;
        leftNode = rightNode = null;
        increment();
    }
    
    public boolean hasLeft()
    {
        return !(leftNode==null);
    }
    public boolean hasRight()
    {
        return !(rightNode==null);
    }
    
    public Node getLeftNode()
    {
        if(!hasLeft())
        {
            throw new NullPointerException("There is no left node");
        }
        return leftNode;
    }
    public Node getRightNode()
    {
        if(!hasRight())
        {
            throw new NullPointerException("There is no right node");
        }
        return rightNode;
    }
    public int getValue()
    {
        return value;
    }
    
    public void setLeftNode(Node n)
    {
        leftNode = n;
    }
    public void setRightNode(Node n)
    {
        rightNode = n;
    }   
} 