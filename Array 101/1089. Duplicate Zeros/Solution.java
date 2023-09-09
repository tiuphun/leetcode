class Solution {
    // two-pointer
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int countZero = 0;
        int i, j;

        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                countZero++;
            }
        }

        // get rid of last zero if not enough space to duplicate
        if (i + countZero < len) {
            arr[len-1] = 0;
            countZero--;
            len--;
        }

        // i point to original location, j point to new location
        for (i = len - 1 - countZero, j = len - 1; i >= 0 && countZero > 0; i--, j--) {
            if (arr[i] == 0) {
                arr[j--] = 0; // duplicate
                countZero--;
            }
            arr[j] = arr[i];
        }

    // shift-counter
    public void duplicateZeros(int[] arr) {
        int i = 0;
        int shift = 0;
        
        // left -> right: count shifts that fit the array
        for (i = 0; shift + i < arr.length; ++i) {
            shift += arr[i] == 0 ? 1 : 0;
        }

        // right -> left: move items, if 0 duplicate and decrease shift
        for (i = i - 1; shift > 0; --i) {
            if (i + shift < arr.length) arr[i + shift] = arr[i];
            if (arr[i] == 0) arr[i + --shift] = arr[i];
        }
    }
}