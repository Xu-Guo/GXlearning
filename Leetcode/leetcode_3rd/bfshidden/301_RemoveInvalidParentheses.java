public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null ){
            return res;
        }
        
        if (isValid(s)){
            res.add(s);
            return res;
        }
        
        Set<String> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        boolean finished = false;
        while (!q.isEmpty() && !finished){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String current = q.poll();
                for (int j = 0; j < current.length(); j++){
                    if (current.charAt(j) != '(' && current.charAt(j) != ')'){
                        continue;
                    }
                    if (j != 0 && current.charAt(j) == current.charAt(j - 1)){
                        continue;
                    }
                    String ns = current.substring(0, j) + current.substring(j + 1);
                    if (isValid(ns)){
                        result.add(ns);
                        finished = true;
                    } else {
                        if (!visited.contains(ns)){
                            q.offer(ns);
                            visited.add(ns);
                        }
                    }
                }
            }
        }
        res.addAll(result);
        return res;
    }
    
    private boolean isValid(String a){
        if (a == null || a.equals("")){
            return true;
        }
        int count = 0;
        for (char c : a.toCharArray()){
            if (c == '('){
                count++;
            } else if (c == ')'){
                count--;
                if (count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }
}