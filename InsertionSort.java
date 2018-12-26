//wow
//it's basically fancy bubble sort
public class InsertionSort
{
    public static void sort(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            int j = i;
            while(j > 0 && array[j-1] > array[j])
            {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
    }
}
