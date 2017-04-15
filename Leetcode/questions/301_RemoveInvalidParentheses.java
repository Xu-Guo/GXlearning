public class 301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        if(s == null){
            return list;
        }
        
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        q.offer(s);
        while(!q.isEmpty()){
            String str = q.poll();
            if(isValid(str)){
                list.add(str);
                set.add(str);
                continue;
            }
            if(list.size() == 0){//did not find a valid, otherwise we do not need to search deeper by remove more
                for(int i=0; i<str.length(); i++){
                    if(str.charAt(i) != '(' && str.charAt(i) != ')'){
                        continue;
                    }
                    //remove
                    String string = str.substring(0, i) + str.substring(i+1);
                    if(!set.contains(string)){
                        q.offer(string);
                        set.add(string);
                    }
                }
            }
        }
        return list;
    }
    
    private boolean isValid(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}