public class MergeSort
{
    public static void sort(int[] array)
    {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end)
    {
        if(end - start == 1) //If its 2 elements, we can just check and swap them if necessary
        {
            if(array[start] > array[end])
            {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            return;
        }
        else if(start >= end) //Otherwise we can just return if theres 1 or less elements.
            return;
        
        int mid = (start+end) / 2, //where we divid and conquer the array
        firstIndex = start, //where the first divided segment starts
        secondIndex = mid + 1; //where the second divided segment starts
        int[] mergeArray = new int[(end - start) + 1]; //An array which can hold all the values of both segments.
 
        //sort both halves
        sort(array, start, mid); //sorting from the start to the mid
        sort(array, mid + 1, end); //sorting from the mid to the end
        
        //merge the now sorted halves of the array into a seperate array
        for(int i = 0; i < mergeArray.length; i++)
        {
            mergeArray[i] = (secondIndex > end) || ((firstIndex <= mid) && (array[firstIndex] < array[secondIndex])) ? 
                            array[firstIndex++] : 
                            array[secondIndex++];
        }

        //throw the seperate sorted portion back into the array
        int j = 0;
        for(int i = start; i <= end; i++)
        {
            array[i] = mergeArray[j++];
        }
    }
}
