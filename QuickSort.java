public class QuickSort
{
    public static void sort(int array[])
    {
        sort(array, 0, array.length - 1);
    }
    
    public static void sort(int array[], int start, int end)
    {
        if(start >= end)
            return;
        int pivot = (int)(Math.random() * (end - start)) + start,
            pivotNumber = array[pivot],
            index = start + 1;
        array[pivot] = array[start];
        array[start] = pivotNumber;
        
        
        for(int i = start + 1; i <= end; i++)
        {
            if(array[i] < pivotNumber)
            {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
                
                index++;
            }
        }
        array[start] = array[index - 1];
        array[index - 1] = pivotNumber;
        
        sort(array, start, index-2);
        sort(array, index, end);
    }
}
