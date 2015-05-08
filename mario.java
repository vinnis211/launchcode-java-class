/**
 * Write a description of class mario here.
 * 
 * @author Vinnis L. Bryant
 * @version v.02
 */

import java.util.Scanner;
public class mario
{
   public static void main(String[] args) {
       
       int pHeight = getHeight();
       makePyramid(pHeight);
       
    }
   
   /*****************************************
   * Request and store a height for Mario's *
   * pyramid                                *
   *****************************************/
   public static int getHeight () {
      
      int inputHeight = 0;
      Scanner in = new Scanner(System.in);
    
      do
      {
        System.out.print("Height: ");
        inputHeight = in.nextInt();
      }  while (inputHeight < 0 || inputHeight > 23);
    
      return inputHeight;

    }
   
   /*****************************************
   * Build pyramid using two loops to pad  *
   * each row with spaces then #s. The top *
   * starts with # then susbsequent rows   *
   * stair step by additional # per row.   *
   *****************************************/
 
   public static void makePyramid(int height) {
   
       int maxcol = height + 1;
       int i;
       int s = maxcol;
       int spaceLooper;
       int sharpLooper;
       String row = "";
       System.out.print(row);
       
       for(i = 2; i <= maxcol; i++) 
        
        {
          
            spaceLooper = s - 2;
            
                while (spaceLooper > 0)
                     { 
                        System.out.print(" ");
                        spaceLooper--;
                     }
                 s--;    
            
              
              sharpLooper = i;   
              while (sharpLooper > 0)
              {
              System.out.print("#");
              sharpLooper--;
              }
              
              System.out.print("\n");
                
        }

       

       
   }
      
}


