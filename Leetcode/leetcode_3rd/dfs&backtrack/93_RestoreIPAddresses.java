/*
ip 由4个8位数字组成，每个数字0-255，
还原的时候从string第0个字符开始，使用for loop遍历所有1-3个字符的情况
-如果数组多于1位，首字符不能为0
-数字不能大于255
遍历完一个数字后继续dfs遍历下一个数字

递归时track已经recover的数字数量，和path，大于4个字符并且字符串没有遍历完则返回
当数字个数为4，且字符串遍历完时加入result。

*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0){
            return res;
        }
        helper(res, s, 0, "", 0);
        return res;
    }
    
    private void helper(List<String> res, String s, int index, String path, int count){
        if (count > 4){
            return;
        }
        
        if (count == 4 && index == s.length()){//向下递归时会传入index + i 和count + 1
            res.add(path);
            return;
        }
        
        for (int i = 1; i < 4; i++){//for 循环数字结束为止
            if (index + i > s.length()){//out of bound
                break;
            }
            
            String ip = s.substring(index, index + i);
            if (ip.startsWith("0") && ip.length() > 1){
                continue;
            }
            
            if (Integer.parseInt(ip) > 255){
                continue;
            }
            helper(res, s, index + i, path + ip + (count == 3 ? "" : "."), count + 1);
        }
    }
}