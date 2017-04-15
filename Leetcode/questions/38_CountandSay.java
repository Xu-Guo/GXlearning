public class 38_CountandSay {
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder pre;
        int count;//要读的数的个数
        char say;//要读的数
        for(int i=1; i<n; i++){
            pre = cur;//拿到之前n-1次的读法
            cur = new StringBuilder();//新建一个读法
            count = 1;
            
            say = pre.charAt(0);//要读的数从pre第一个开始
            for(int j=1; j<pre.length(); j++){
                if(pre.charAt(j)!=say){//从第二个数开始检查，如果不等于第一个数
                    cur.append(count).append(say);//创建读法
                    count=1;//reset count
                    say = pre.charAt(j);//读下一个不同的数
                }else {
                    count++;//和say相同，count++
                }
            }
            cur.append(count).append(say);
        }
        return cur.toString();
    }
}