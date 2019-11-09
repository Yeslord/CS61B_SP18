public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y){
        int diff1=x-y;
        int diff2=y-x;
        if(diff1==1 || diff2==1) {
            return true;
        }
        return false;
    }
}
