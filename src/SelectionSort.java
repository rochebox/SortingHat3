import java.util.Arrays;

public class SelectionSort extends PapaSort {
    
   
    public SelectionSort(int[] l, String name) {
        super(l, name);
        //System.out.println("Selection Sort with Hierarchy");
       
    }
  /*  
    public void swap(int place1, int place2) {
        
        //int temp = myList[place2];
        int temp = super.getElement(place2);
        //myList[place2] = myList[place1];
        super.setElement(place2, super.getElement(place1));
        //myList[place1] = temp;   
        super.setElement(place1, temp);
    }
    */
      

    
    
    public void executeAlgorithm() {
        
        for(int j = 0; j < super.getList().length-1; j++) {
        
                //loop through numbers, find biggest
                //int biggest = myList[0];
                int biggest = super.getElement(0);
                int bigLoc  = 0;
                
                for(int i = 0; i < super.getList().length -j; i++) {
                    //if( biggest < myList[i]) {
                    if( biggest < super.getElement(i)) {
                        biggest = super.getElement(i);
                        bigLoc = i;
                    }
                }
              
                //swap
                super.swap(bigLoc, super.getList().length -1 -j);
        }
                
    }
}
