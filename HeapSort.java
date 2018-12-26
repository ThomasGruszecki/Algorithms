//Makes vague sense to me
//Atleast more so than tree sort does.
//Editors Note: After writing the algorithm for an hour, make's alot more sense.

//Here's how it works -- We take an array, and sort it so that array[i] is >= array[2i] and array[2i + 1]. In order for this to work, we pretend our indexing starts at 1. This takes O(log(n))

//Then, we can take the first value, swap it with the end, and remove the last index of our array from what we look at.
//We can do this, because by generating a heap, we know that what ever value is at the top is the greatest value in the array.

//Then, we take the slightly smaller array, and reheapify it. This only takes one pass, because the heap will recursively 'bubble' the integer that was taken to the top to wherever it needs to be.
//This coalesces into a O(n*log(n)) total Big O.

public class HeapSort
{
    public static void sort(int[] array)
    {
        for(int i = (array.length/2) - 1; i>= 0; i--)
        {
            maxHeapify(array, array.length, i);
        }
        
        for(int end = array.length - 1; end >= 0; end--)
        {
            int temp = array[0]; 
            array[0] = array[end]; 
            array[end] = temp; 
            maxHeapify(array, end, 0);
        }
    }
    
    public static void maxHeapify(int[] array, int end, int rootIndex)
    {
        int leftIndex = (2 * rootIndex) + 1, 
            rightIndex = (2 * rootIndex) + 2,
            largestIndex = rootIndex; 
        
        //check if left is larger
        if(leftIndex < end && array[leftIndex] > array[largestIndex])
        {
            largestIndex = leftIndex;
        }
        //then right
        if(rightIndex < end && array[rightIndex] > array[largestIndex])
        {
            largestIndex = rightIndex;
        }
        //then we swap the largest with root, if right or left were larger
        if(largestIndex != rootIndex)
        {
            int temp = array[rootIndex];
            array[rootIndex] = array[largestIndex];
            array[largestIndex] = temp;
            
            maxHeapify(array, end, largestIndex); //Then, we call the heapify function on the place where the previous rootIndex was swapped to, and so on until we've recursively satisfied our heap.
        }
    }
}