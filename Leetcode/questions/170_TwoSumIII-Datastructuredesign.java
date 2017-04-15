//add O(n), find O(1)
public class TwoSum {
    Set<Integer> sum;
    Set<Integer> num;
    
    /** Initialize your data structure here. */
    public TwoSum() {
       sum = new HashSet<>();//store sums
       num = new HashSet<>();//stroe nums
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!num.contains(number)){
            for(Integer n : num){
                sum.add(n + number);
            }
            num.add(number);
        }else{
            sum.add(number * 2);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sum.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */



public class TwoSum {
    Map<Integer, Integer> map; //nums, number of num
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, 2);
        }else{
            map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer num : map.keySet()){
            int remain = value - num;
            if(map.containsKey(remain)){
                if(num != remain || map.get(remain) == 2){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */