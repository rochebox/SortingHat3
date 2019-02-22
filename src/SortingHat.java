import java.util.ArrayList;

public class SortingHat {

    public static void main(String[] args) {
        
        int howMany = 8000000;
        
        int numList[] = getRandom(howMany);

        //Create a merge sort object
        //MergeSortNR ms = new MergeSortNR(numList, "MS Non-Recursive");
        //Write and test a merge routine (using just one array)
        MergeSortRecursive rms = new MergeSortRecursive( numList, "Recursive MS");
        doTiming(rms);
        if(listCheck2(numList)) {
            System.out.println("I checked new list and its good!");
        } else {
            System.out.println("Thumbs Down on your sort");
        }
        
        
        
    }    
     
        /*
         * 
         * System.out.println("Length of numList2 is " + numList.length);
        int firstHalf[] = getAscendingOrder(10);
        int secondHalf[] = getAscendingOrder(5);
        
        int numList2[] = new int[firstHalf.length + secondHalf.length];
        for(int i = 0; i < firstHalf.length; i++) numList2[i]=firstHalf[i];
        for(int i = 0; i < secondHalf.length; i++) numList2[i+firstHalf.length]=secondHalf[i];
        */
        
        
        
        
        
        // TODO Auto-generated method stub  
        //int howMany = 15;
        //int[ ] nums = getRandom(howMany);
//        int[ ] nums0 = getDescendingOrder(howMany); //good
//        int[ ] nums0A = nums0.clone();
        
        //int[ ] nums1 = getDescendingOrder(howMany); //Worst
        //int[ ] nums2 = getDescendingOrder(howMany); //Worst
        
        //System.out.println(Arrays.toString(nums0));
        //int[ ] nums2 = getRandom(howMany);
       // System.out.println(Arrays.toString(nums2));
        
        
        //int[ ] nums2 = getRandom(howMany);
       
        /* 
        SelectionSort sSort = new SelectionSort(nums0, "Selection Sort");  
        doTiming(sSort);
        System.out.println();
        BubbleSort bSort = new BubbleSort(nums1, "BubbleSort");
        doTiming(bSort);
        */
        /*
        InsertionSort inS = new InsertionSort(nums0, "Insertion Sort Worst");
        //System.out.println(inS);
        doTiming(inS);
        System.out.println();
        BubbleSort bs = new BubbleSort(nums0A, "Bubble Worst");
        //System.out.println(inSW);
        doTiming(bs);
        
        */
    
    
    
    public static void doTiming(PapaSort s) {
        
        if(s.getLength() <=100) {
            System.out.println("Before: " + s);
        }
       
        long start = System.currentTimeMillis();
        long start2 = System.nanoTime();
        
        s.executeAlgorithm();
        
        long end = System.currentTimeMillis();
        long end2 = System.nanoTime();
        long theTime = end-start;
        long theTime2 = end2-start2;
          
        if(s.getLength() < 100) {
            System.out.println("Time for " + s.getSortName() + " on " +
                s.getLength() + " numbers is: " +  theTime2 +
                " (nano) seconds"
                );
            System.out.println("After: " + s);
        } else {
            System.out.println("Time for "  + s.getSortName() + " on " +
                s.getLength() + " numbers is: " +  theTime +
                " (milli) seconds"
                ); 
        }
        
    }
    
    public static int[ ] getRandom(int n) {
        
        int [ ] nList = new int[n];
        
        for(int  i = 0 ; i < nList.length; i++) {
            nList[i] = (int)(Math.random() * 1000);
        }
       
        return nList;
        
    }
    
    public static int [ ] getAscendingOrder(int n) {
        
        int [ ] nList = new int[n];
        
        for(int  i = 0 ; i < nList.length; i++) {
            nList[i] = i+1;
        }
       
        return nList;
        
    }
    
    public static int [ ] getDescendingOrder(int n) {
        
        int [ ] nList = new int[n];
     /*   
        for(int  i = 0 ; i < nList.length; i++) {
            nList[i] = nList.length -i;
        }
        */
        
        //or
        for(int i = nList.length; i > 0; i--) {
            nList[nList.length-i ] = i;
        }
       
        return nList;
        
    }
    
    public static boolean listCheck2(int[] l) {
        
        for(int i = 0; i < l.length-1; i++) {
            if(l[i] > l[i+1]) {
                return false;
            }
        }
        
        return true;
        
    }
    
    
    
    
    
    
    public static void lListCheckAsc(int[] l) {
        if( l!= null) {
            int lastVal = l[0];
            ArrayList<Integer> errorLocs = new ArrayList<Integer>();
            boolean listOK = true;
            
            for(int i = 1; i < l.length; i++) {
                if(lastVal > l[i]) {
                    listOK = false;
                    errorLocs.add(new Integer(i));
                } else {
                    lastVal = l[i];
                }
            }
            
            if(listOK) {
                System.out.println("List is Good for " + l.length + " numbers");
            } else {
                System.out.println("Found Errors at " + errorLocs);
            }
        } else {
            System.out.println("You didn't give me a list.");
        }
        
        
    }

}