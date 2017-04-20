public class Solution {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(""+ i);
        }
        
        return helper(list);
    }
    
    private String helper(List<String> list){
        if(list.size() == 1){
            return list.get(0);
        }
        List<String> newList = new ArrayList<>();
        int l = 0;
        int r = list.size()-1;
        while(l < r){
            String t1 = list.get(l);
            String t2 = list.get(r);
            newList.add("(" + t1 + "," + t2 + ")");
            l++;
            r--;
        }
        return helper(newList);
    }
}