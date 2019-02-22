import java.util.Arrays;

public abstract class PapaSort {
    
    private int [] myList;    // We practice data hiding
    private String whichSort;
    
    public PapaSort(int[] l, String sortName) {
        myList = l;
        whichSort = sortName;
    } 
    
    public void swap (int place1, int place2) {
        int temp = myList[place2];
        myList[place2] = myList[place1];
        myList[place1] = temp;    
    }
    
    public String toString() {
        String s = "";
        s += whichSort + ": ";
        s += Arrays.toString(myList);
        return s;
    }  
    
    public int[] getList() {
        return myList;
    }
    
    public int getElement(int which) {
        return myList[which];
    }
    
    public void setElement(int whichE, int value) {
        myList[whichE] = value;
    }
    
    //new thing in papa sort to get length...
    public int getLength() {
        return myList.length;
    }
    
    public abstract void executeAlgorithm();
    
    //new for Monday after Patriot victory (and Squash!)
    public String getSortName() {
        return whichSort;
    }

}
