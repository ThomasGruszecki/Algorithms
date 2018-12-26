public class QuickSort
{
    public static void quickSort(int[] array, int start, int end)
    {
        if(end<=start)
        {
            return;
        }
        
        int pivot = array[start]; 
        int i = start+1; int tmp; 
    
        for(int j = start+1; j<= end; j++)
        {
            if(pivot > array[j])
            {
                tmp = array[j]; 
                array[j] = array[i]; 
                array[i] = tmp; 
    
                i++; 
            }
        }
    
        array[start] = array[i-1]; 
        array[i-1] = pivot; 
   
        quickSort(array, start, i-2); 
        quickSort(array, i, end); 
    }
}
