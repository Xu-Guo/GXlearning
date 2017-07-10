public class PhoneDirectory {
    LinkedList<Integer> nums;
    Set<Integer> usedNums;
    int cap;
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        nums = new LinkedList<>();
        usedNums = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++){
            nums.add(i);
        }
        cap = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (nums.size() == 0){
            return -1;
        }
        int num = nums.pollFirst();
        usedNums.add(num);
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return number < cap && !usedNums.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (number >= cap){
            return;
        }
        
        if (!usedNums.contains(number)){
            return;
        }
        usedNums.remove(number);
        nums.offerLast(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */