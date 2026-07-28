class Solution {
    public int[] sortedSquares(int[] a) {

        int l = 0;
        int r = a.length - 1;
        int[] res = new int[a.length];
        int i = res.length - 1;

        while (l <= r) {
            if (Math.abs(a[l]) >= Math.abs(a[r])) {
                res[i] = a[l] * a[l];
                l++;
            } else {
                res[i] = a[r] * a[r];
                r--;
            }
            i--;
        }

        return res;
    }
}
