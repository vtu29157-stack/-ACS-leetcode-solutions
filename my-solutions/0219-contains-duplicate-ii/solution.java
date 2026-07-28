class Solution {
    public boolean containsNearbyDuplicate(int[] a, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {

            if (map.containsKey(a[i])) {
                int prev = map.get(a[i]);

                if (i - prev <= k) {
                    return true;
                }
            }

            map.put(a[i], i);
        }

        return false;
    }
}
