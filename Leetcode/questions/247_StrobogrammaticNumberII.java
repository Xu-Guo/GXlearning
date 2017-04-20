public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m){
        if(n == 0){
            return new ArrayList<>(Arrays.asList(""));
        }
        if(n == 1){
            return new ArrayList<>(Arrays.asList("0","1","8"));
        }
        
        List<String> list = helper(n-2, m);//当前结果是有n-2的结果转化来
        
        List<String> res = new ArrayList<>();
        
        
        for(String s : list){
            if(n != m){
                res.add("0" + s + "0");//num can not start with 0
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}