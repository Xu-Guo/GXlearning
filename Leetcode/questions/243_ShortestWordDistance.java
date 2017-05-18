public class Solution {
    /*
    遍历数组，两个单词一定会前后出现，每次出现其中一个的时候更新其位置，如果之前另一个单词出现过则计算与之前出现过
    的另一个单词之间的距离，并更新最小距离

    */
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                p1 = i;
            }
            
            if(words[i].equals(word2)){
                p2 = i;
            }
            
            if(p1 != -1 && p2 != -1){
                min = Math.min(Math.abs(p1 - p2), min);
            }
        }
        return min;
    }
}