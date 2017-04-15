/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class 277_FindtheCelebrity extends Relation {
    public int findCelebrity(int n) {
        int can = 0;
        for(int i=1; i<n; i++){
            if(knows(can, i)){
                can = i;
            }
        }
        for(int i=0; i<n; i++){
            if(i!=can && (knows(can, i) || !knows(i, can))){
                return -1;
            }
        }
        return can;
    }
}