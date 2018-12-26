//Thomas Gruszecki
//Program Magic. Doesn't even do any comparisons. On the flip side, negative numbers will make it scream.
//Funnily enough, this can run faster than QuickSort in most cases; but me using ArrayList makes it not do that anymore.

import java.util.List;
import java.util.ArrayList;
public class RadixSort
{
    public static void sort(int[] array)
    {
        for(int num : array)
        {
            if(num < 0)
                throw new RuntimeException("Negatives not supported on radix yet");
        }
        
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(); //the buckets
        
        //initializing buckets
        for(int i = 0; i < 10; i++)
        {
            buckets.add(new ArrayList<Integer>());
        }
        
        //gets the max value in the array
        int max = array[0];
        for(int i = 1; i < array.length; i++)
        {
            if(array[i] > max)
                max = array[i];
        }
        
        //gets the number of digit of the max number in the array
        int digits = 0;
        while(max > 0)
        {
            max /= 10;
            digits++;
        }
        
        //where the magic happens.
        int divisor = 1, modulator = 10;//takes a divisor starting at 1 and a modulator starting at 10
        for(int i = 0; i < digits; i++)
        {
            //starting with the least significant digit and heading to the most significant digit
            //sorts the numbers based on their digits into different buckets
            for(int s : array)
            {
                int digit = (s % modulator) / divisor;
                buckets.get(digit).add(s);
            }
            
            //then it sorts the array based on the order they appear in the buckets.
            int m = 0;
            for(ArrayList<Integer> bucket : buckets)
            {
                for(int num : bucket)
                {
                    array[m] = num;
                    m++;
                }
                bucket.clear();
            }
            
            //then we move on to the next digit until we've gotten to the last digit
            divisor *= 10;
            modulator *= 10;
        }
    }
}
