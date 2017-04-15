public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row : wall){
            int sum = 0;
            for(int i=0; i<row.size()-1; i++){
                sum += row.get(i);
                if(!map.containsKey(sum)){
                    map.put(sum, 1);
                }else{
                    map.put(sum, map.get(sum) + 1);
                }
            }
        }
        int max = 0;
        for(Integer i:map.values()){
            if(i > max){
                max = i;
            }
        }
        return wall.size() - max;
    }
}