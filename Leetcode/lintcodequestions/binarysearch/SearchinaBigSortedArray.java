/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int k = 1;
        while(reader.get(k) < target){
            k *= 2;
        }
        int l=0;
        int r=k;
        while(l+1 < r){
            int mid = l + (r - l) /2;
            int v = reader.get(mid);
            //find first
            if(v >= target){
                r = mid;
            }else{
                l = mid;
            }
        }
        if(reader.get(l) == target){
            return l;
        }
        if(reader.get(r) == target){
            return r;
        }
        return -1;
    }
}