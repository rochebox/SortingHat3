
public class BubbleSort extends PapaSort {

    public BubbleSort(int[] l, String name) {
        super(l, name);
        // TODO Auto-generated constructor stub
    }
    
    //This handles one case
    private boolean bubbleIt(int end) {
        boolean didSwap = false;
        for(int i = 0; i < end; i++) {
            if(super.getElement(i)> super.getElement(i+1)) {
                super.swap(i, i+1);
                didSwap = true;
            }  
        }
        return didSwap; 
    }
    
   
    @Override
    public void executeAlgorithm() {
        // TODO Auto-generated method stub
        boolean notDone = true;
        int bubbleEnd = super.getList().length-1;
        do {
            notDone = bubbleIt(bubbleEnd);
            if(notDone) {
                bubbleEnd -= 1;
                //System.out.println("We are not done with BubbleSort");
            } else {
                //System.out.println("We are done with BubbleSort"); 
            }
         
        } while(notDone && bubbleEnd >= 1);
        
        
    }

}
