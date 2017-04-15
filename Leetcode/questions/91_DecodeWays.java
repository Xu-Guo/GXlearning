public class 91_DecodeWays {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0'){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        if(s.charAt(n-1) == '0'){
            dp[n-1] = 0;
        }else{
            dp[n-1] = 1;
        }
        
        for(int i=n-2; i>=0; i--){
            if(s.charAt(i) == '0'){
                continue;
            }else if(Integer.parseInt(s.substring(i,i+2))<=26){// can combine
                dp[i] = dp[i+1] + dp[i+2];//exten from i+1 and also can do combine then exten from i+2
            }else{
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }


//old solution
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0'){
            return 0;
        }
        int[] dp = new int[s.length()];
        for(int i= 0; i<s.length(); i++){
            dp[i] = 0;
        }
        char[] c = s.toCharArray();
        dp[0] = 1;
        for(int i=1; i<c.length; i++){
            int temp = Character.getNumericValue(c[i-1]) * 10 + Character.getNumericValue(c[i]);
            System.out.println(temp);
            if(c[i]!='0'){//can append
                if(c[i-1]!= '0' && temp < 27){//can combine
                    if(i>=2){
                        dp[i]=dp[i-1]+dp[i-2];
                    }else{
                        dp[i] = dp[i-1]+1;
                    }
                }else{//can't combine
                    dp[i] = dp[i-1];
                }
            }else if( temp!=0 && temp < 27 ){//can't append, can combine
                if(i>=2){//can be appended to pre  
                    dp[i] = dp[i-2];
                }else{
                    dp[i] = 1;
                }
            }else{
                dp[i] = 0;
            }
        }
        return dp[c.length-1];
    }
}
