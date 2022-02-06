public class Bitset {
    char[] arr;
    int[] flipArr;
    int one;
    int flip = 0;
    public Bitset(int size) {
        arr = new char[size];
        flipArr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = '0';
        }
        one = 0;
    }

    public void fix(int idx) {
        boolean flip = needToFlip(idx);
        if(flip){
            arr[idx] = arr[idx] == '0' ? '1' : '0';
        }
        if(arr[idx] == '0') one++;
        arr[idx] = '1';

    }

    public void unfix(int idx) {
        boolean flip = needToFlip(idx);
        if(flip){
            arr[idx] = arr[idx] == '0' ? '1' : '0';
        }
        if(arr[idx] == '1') one--;
        arr[idx] = '0';
    }

    public void flip() {
//       for(int i=0;i<arr.length;i++){
//           arr[i] = arr[i] == '0' ? '1' : '0';
//       }
        flip++;
        one = arr.length - one;

    }

    public boolean all() {
        return one == arr.length;
    }

    public boolean one() {
        return one >=1;
    }

    public int count() {
        return one;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            boolean flip =  needToFlip(i);
            if(flip){
                arr[i] = arr[i] == '0' ? '1' : '0';
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    private boolean needToFlip(int index){
        int diffFlip = flip - flipArr[index];
        diffFlip%=2;
        flipArr[index] = flip;
        return diffFlip == 1;
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */