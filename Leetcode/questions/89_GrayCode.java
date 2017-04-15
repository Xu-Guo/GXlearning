//gray code : The idea is simple. G(i) = i^ (i/2).
public class 89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++){
            result.add(i ^ i>>1);
        }
        return result;
    }
}