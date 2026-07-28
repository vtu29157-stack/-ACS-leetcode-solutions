class Solution {
    public int[] runningSum(int[] a) {
            int i;
            for(i=1;i<a.length;i++)
            {
                a[i]=a[i]+a[i-1];
            }
            return a;
    }
}
