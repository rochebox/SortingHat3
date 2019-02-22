
public class MergeSortNR extends PapaSort
{
    

    public MergeSortNR(int[] l, String sortName) {
        super(l, sortName);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void executeAlgorithm() {
        // TODO Auto-generated method stub
        
        //This is how wapple did it
        // for(int i =0, j= 1; j<= this.getLength(); i++, i++, j++, j++) {
        //    merge(i,i, j, j);
        //}
        
        //for(int j = 1;  Math.log(j)/Math.log(2) <= this.getLength() ;   j*=2  ) {  //this goes 2, 4, 8, 16, 32 n*log(n)
        for(int j = 1, e=0;  Math.pow( 2.0, (double)(e)) <= this.getLength() ;   j*=2 , e++ ) {    
            for(int i = 0; i < this.getLength()-1; i+= j*2) {
                if( i+(j*2)-1  < this.getLength() ) {
                    merge(i,  i+j-1,  i+j, i+(j*2)-1);  //our best thinking
                } else  {
                    merge(i,  i+j-1,  i+j, this.getLength()-1);  //our best thinking^2
                }
            }
            
            System.out.println(j);
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
