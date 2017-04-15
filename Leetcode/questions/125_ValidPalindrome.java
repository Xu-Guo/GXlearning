public class 125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length()==0){
            return true;
        }
        
        int b = 0;
        int e = s.length()-1;
        char cs;
        char ce;
        while(b <= e){
            cs = s.charAt(b);
            ce = s.charAt(e);
            if(!Character.isLetterOrDigit(cs)){
                b++;
            }else if(!Character.isLetterOrDigit(ce)){
                e--;
            }else{
                if(Character.toLowerCase(cs) != Character.toLowerCase(ce)){
                    return false;
                }
                b++;
                e--;
            }
        }
        return true;
    }
}