public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0){
            return list;
        }
        for (int i = 0; i <= rowIndex; i++){
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++){
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}