public class RandomizedCollection {
    ArrayList<Integer> list;
    Map<Integer, Set<Integer>> map;
    java.util.Random random = new java.util.Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if(!contain){
            map.put(val, new LinkedHashSet<>());// create a set to store the index
        }
        list.add(val);
        map.get(val).add(list.size()-1);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if(!contain){
            return false;
        }
        int index = map.get(val).iterator().next();//get the first index from the set
        //remove index from the map
        map.get(val).remove(index);//remove the first index from set
        //deal with the list
        if(index != list.size()-1){//not the last number
            int last = list.get(list.size()-1);
            list.set(index, last);//put the last on to the position where the element was removed
            map.get(last).remove(list.size()-1);//remove the old position of the last 
            map.get(last).add(index);//add the new position
        }
        
        list.remove(list.size()-1);//remove the last one from the end of the list
        
        if(map.get(val).isEmpty()){//if the element was remove was the last one in the set, remove it from map
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(new java.util.Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */