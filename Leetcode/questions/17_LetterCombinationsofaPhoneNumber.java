//BFS
public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new LinkedList<>();
        }
        LinkedList<String> list = new LinkedList<>();//实际上是建立了新的队列
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};//map nums to characters
        list.add("");//add a empty string
        for(int i=0; i<digits.length(); i++){//go through all the digits
            int n = Character.getNumericValue(digits.charAt(i));//get curr digit
            while(list.peek().length() == i){//i stands for current level, if length > i, cur level is finished
                String s = list.poll();//get a string
                for(char c : map[n].toCharArray()){//bfs add new character at each result's end
                    list.add(s+c);
                }
            }
        }
        return list;
    }
}

//DFS
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0){
            return res;
        }
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        StringBuilder sb = new StringBuilder();
        dfs(res, digits, map, 0, sb);
        return res;
    }
    
    private void dfs(List<String> res, String digits, String[] map, int start, StringBuilder sb){
        if(start == digits.length()){//已经加入了最后一个digit对应的字母， 返回
            res.add(sb.toString());
            return;
        }
        String str = map[digits.charAt(start) - '0'];//拿到map的String
        for(int i=0; i<str.length(); i++){//mapping String中的每一个字母都是一个分支
            sb.append(str.charAt(i));//选择一条分支
            dfs(res, digits, map, start+1, sb);
            sb.deleteCharAt(sb.length()-1);//上面的递归函数返回，要进入下个分支之前，去掉之前分支加入的字符
        }
    }
}