package lab01;
// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////

public class OrdArray {

    private long[] a; // ref to array a
    private int nElems; // number of data items
    //-----------------------------------------------------------

    public OrdArray(int max) { // constructor
        a = new long[max]; // create array
        nElems = 0;
    }

    //-----------------------------------------------------------
    public int size() {
        return nElems;
    }

    //-----------------------------------------------------------
    public long getValueAt(int index) {
        return a[index];
    }

    //-----------------------------------------------------------
    public void setValueAt(int index, long value) {
        a[index] = value;
    }

    //-----------------------------------------------------------
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn; // found it
            } else if (lowerBound > upperBound) {
                return nElems; // can’t find it
            } else { // divide range
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1; // it’s in upper half
                } else {
                    upperBound = curIn - 1; // it’s in lower half
                }
            } // end else divide range
        } // end while
    } // end find()
//-----------------------------------------------------------

    public void insert(long value) { // put element into array
        int j;
        for (j = 0; j < nElems; j++) { // find where it goes
            if (a[j] > value) { // (linear search)
                break;
            }
        }
        for (int k = nElems; k > j; k--) { // move bigger ones up
            a[k] = a[k - 1];
        }
        a[j] = value; // insert it
        nElems++; // increment size
    } // end insert()
    //-----------------------------------------------------------

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) { // can’t find it
            return false;
        } else { // found it
            for (int k = j; k < nElems; k++) { // move bigger ones down
                a[k] = a[k + 1];
            }
            nElems--; // decrement size
            return true;
        }
    } // end delete()
    //-----------------------------------------------------------

    public static OrdArray merge(OrdArray a, OrdArray b) {

        int length = a.size() + b.size();
        OrdArray c = new OrdArray(length); // Create new array with sum of length of old 2 ones
        int i = 0, j = 0, k = 0;
        while (j < a.size() && k < b.size()) { // While the value are not reach the end of any array yet !
            if (a.getValueAt(j) <= b.getValueAt(k)) { // Choose in which the value is suitablie in this incrementing array
                c.setValueAt(i, a.getValueAt(j)); // Set the value for new array with smaller value
                j++; // Increse j to consider the next value
            } else {
                c.setValueAt(i, b.getValueAt(k)); // If larger, set another one
                k++;
            }
            c.nElems++;
            i++;
        }

        while (j < a.size()) {
            c.setValueAt(i, a.getValueAt(j));
            c.nElems++;
            i++;
            j++;
        }

        while (k < b.size()) {
            c.setValueAt(i, b.getValueAt(k));
            c.nElems++;
            i++;
            k++;
        }
        return c;
    } // end merge()
    //-----------------------------------------------------------

    public void display() { // displays array contents
        for (int j = 0; j < nElems; j++) { // for each element,
            System.out.print(a[j] + " "); // display it
        }
        System.out.println("");
    }
    //-----------------------------------------------------------
} // end class OrdArray

////////////////////////////////////////////////////////////////
class OrderedApp {

    public static void main(String[] args) {
        int maxSize = 100; // array size
        long random = 0;

        OrdArray arr1 = new OrdArray(maxSize); // create the array 1
        OrdArray arr2 = new OrdArray(maxSize); // create the array 2
        for (int i = 0; i < 25; i++) {
            random = (long) (Math.random() * 200);
            arr1.insert(random); // Insert 45 random values
        }
        System.out.print("Array1: ");
        arr1.display(); // display items again in array 1

        for (int i = 0; i < 15; i++) {
            random = (long) (Math.random() * 200);
            arr2.insert(random); // Insert 15 random values
        }

        System.out.print("Array2: ");
        arr2.display(); // display items again in array 2

        OrdArray arr3 = OrdArray.merge(arr1, arr2);
        System.out.print("Array3: ");
        arr3.display(); // display items in array 3 after mergin

    } // end main()
} // end class OrderedApp
//-----------------------------------------------------------
