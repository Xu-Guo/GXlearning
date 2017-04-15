public class 282_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0){
            return res;
        }
        helper(res, "", num, target, 0,0,0);
        return res;
    }
    
    private void helper(List<String> res, String path, String num, int target, int pos, long eval, long toBeMutiplied){
        if(pos == num.length()){//reach the end of the num
            if(target == eval){//found a match
                res.add(path);
            }
            return;
        }
        for(int i=pos; i<num.length(); i++){
            if(i!=pos && num.charAt(pos) == '0'){//a number with mutlple digit can not start with '0'
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i+1));//get the num start at num.charAt(pos) and end with num.charAt(i)
            if(pos == 0){
                helper(res, path + cur, num, target, i+1, cur, cur);//first number
            }else{
                helper(res, path + "+" + cur, num, target, i+1, eval + cur, cur);
                helper(res, path + "-" + cur, num, target, i+1, eval - cur, -cur);
                helper(res, path + "*" + cur, num, target, i+1, eval - toBeMutiplied + toBeMutiplied * cur, toBeMutiplied * cur);
            }
        }
    }
}