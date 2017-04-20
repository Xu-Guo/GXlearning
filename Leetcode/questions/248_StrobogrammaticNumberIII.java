public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> res = new ArrayList<>();
        for(int i=low.length(); i<=high.length(); i++){
            res.addAll(helper(i,i));
        }
        for(String num : res){
	        if((num.length() == low.length()&&num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0)){
	            continue;
	        }
		    count++;
		}
		return count;
    }
    
    private List<String> helper(int cur, int max){
		if(cur == 0) return new ArrayList<String>(Arrays.asList(""));
		if(cur == 1) return new ArrayList<String>(Arrays.asList("1", "8", "0"));

		List<String> rst = new ArrayList<String>();
		List<String> list = helper(cur - 2, max);

		for(int i = 0; i < list.size(); i++){
			String tmp = list.get(i);
			if(cur != max) rst.add("0" + tmp + "0");
			rst.add("1" + tmp + "1");
			rst.add("6" + tmp + "9");
			rst.add("8" + tmp + "8");
			rst.add("9" + tmp + "6");
		}
		return rst;
	}
}