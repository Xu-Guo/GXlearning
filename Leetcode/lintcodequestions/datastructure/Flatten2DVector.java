public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> out;
    private Iterator<Integer> in;
    
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        out = vec2d.iterator();
        in = null;
        
    }

    @Override
    public Integer next() {
        // Write your code here
        hasNext();
        return in.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while((in == null || !in.hasNext()) && out.hasNext()){
            in = out.next().iterator();
        }
        return in != null && in.hasNext();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */