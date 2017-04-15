//bottom up
public class 120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size()==0 || triangle[0].size()==0){
            return 0;
        }
        for(int i=triangle.size()-2; i>=0; i--){//the ith level has i numbers
        	for(int j=0; j<=i; j++){
        		triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
        	}
        }
        return triangle.get(0).get(0);
    }
}

//top down
public class 120_Triangle1 {
	public int minimumTotal1(List<List<Integer>> triangle) {
		int res = Integer.MAX_VALUE;

		for(int i=1; i<triangle.size(); i++){
			triangle.get(i).set(triangle, triangle.get(i).get(0) + triangle.get(i-1)(0));
		}

		for(int i=1; i<triangle.size(); i++){
			int last = triangle.get(i).size()-1;
			triangle.get(i).set(last, triangle.get(i).get(last) + triangle.get(i-1)(last-1));
		}


		for(int i=1; i<triangle.size(); i++){
			for(int j=1; j<=i; j++){
				triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
				if(i == triangle.size()-1){
					if(res > triangle.get(i).get(j)){
						res = triangle.get(i).get(j);
					}
				}
			}
		}
		return res;
	}
}