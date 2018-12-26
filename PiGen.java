public class PiGen
{
  public void main()
  {
  int N = 1000000;

  int len = (int)(Math.floor(10 * N/3) + 1);
  int[] A = new int[len];

  for(int i = 0; i < len; ++i) 
  {
    A[i] = 2;
  }

  int nines    = 0;
  int predigit = 0;

  for(int j = 1; j < N + 1; ++j) 
  {        
    int q = 0;

    for(int i = len; i > 0; --i) 
    {
      int x  = 10 * A[i-1] + q*i;
      A[i-1] = x % (2*i - 1);
      q = x / (2*i - 1);
    }

    A[0] = q%10;
    q = q/10;

    if (9 == q) 
    {
      nines++;
    }
    else if (10 == q) 
    {
      System.out.print(predigit+1);
      

      for (int k = 0; k < nines; ++k) 
      {
        System.out.print(0);
        
      }
      predigit = 0;
      nines = 0;
    }
    else 
    {
      System.out.print(predigit);
      predigit = q;

      if (0 != nines) 
      {    
        for (int k = 0; k < nines; ++k) 
        {
          System.out.print(9);
        }

        nines = 0;
      }
    }
  }
  System.out.print(predigit);
}

}