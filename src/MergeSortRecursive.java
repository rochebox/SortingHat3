
public class MergeSortRecursive extends PapaSort
{
    public MergeSortRecursive(int[] l, String sortName) {
        super(l, sortName);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void executeAlgorithm() {    
        mergeSort(0, this.getLength()-1);
    }
    

    //This is our recursive method that will be called again and again
    private void mergeSort(int lStart, int lEnd) {
        
        int listLen = lEnd - lStart + 1;
        //System.out.println("in MergeSort list len is " + listLen);
        //System.out.println("in MergeSort list start and end are " + lStart + ", " + lEnd);
        
        /* 
         *   1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
             
             2. Call mergeSort for first half:   
                     Call mergeSort(arr, l, m)
             3. Call mergeSort for second half:
                     Call mergeSort(arr, m+1, r)
             4. Merge the two halves sorted in step 2 and 3:
                     Call merge(arr, l, m, r)
         */
        if(listLen > 1) {  //The stopping condition--- stop when list is 1
            //mergeSort(lStart, lStart + (listLen/2) -1 );
            //mergeSort(lStart + (listLen/2) , lEnd );
            // merge(lStart, lStart + (listLen/2) -1, lStart + (listLen/2) , lEnd);
            
            int lMiddle = (lStart + lEnd)/2;
            mergeSort( lStart, lMiddle);
            mergeSort( lMiddle+1, lEnd);
            
            merge(lStart, lMiddle, lMiddle+1, lEnd);
            
        }  else {
            //System.out.println("Stop Recursion");
        }
        
    }
    
    
    private void merge(int start1, int end1, int start2, int end2) {
        //set up...
        int l1 = start1;
        int l2 = start2;
        int [] temp = new int[(end1-start1+1) + (end2-start2+1)];
        int tPointer = 0;
        
        //MAIN LOOP TO DO THE MERGING...
        while(l1 <= end1 && l2 <= end2) {
            if( this.getElement(l1) <= this.getElement(l2)) {
                temp[tPointer] = this.getElement(l1);  
                l1++;
            } else {
                temp[tPointer] = this.getElement(l2); 
                l2++;
            }
            tPointer++;
        }
        //cleanup  put extras on temp...
        for(int tp = tPointer; tp < temp.length; tp++) {
           if(l1 <= end1) {
               temp[tp] = this.getElement(l1);  
               l1++;
               
           } else {
               temp[tp] = this.getElement(l2); 
               l2++;
              
           }
            
        }
        //more clean up  -- finally copy every thing back to numlist
        //copy the result back to the array
        for(int i = start1,  t= 0; i <= end2; i++, t++) {
            this.setElement(i, temp[t]);
        }  
   }  
}
