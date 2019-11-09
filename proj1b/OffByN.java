public class OffByN implements CharacterComparator{
    private int n;
    public OffByN(int N) {
        n=N;
    }
    @Override
    public boolean equalChars(char x, char y){
        int diff1=x-y;
        int diff2=y-x;
        if(diff1==n|| diff2==n) {
            return true;
        }
        return false;
    }
}
