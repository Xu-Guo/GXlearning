public class 461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for(int i=0; i<32; i++){
            count += (xor >> i) & 1;
        }
        return count;
    }
}