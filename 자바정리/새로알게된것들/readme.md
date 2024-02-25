
자바에서는 따로 조합을 제공하는 함수가 없다. 따라서 직접 구현하는데 자바에 최적화된 조합 코드는 다음과 같이 백트랙킹을 이용하여 구현한다 num배열에서 k개뽑은 조합들을 리스트에 저장한다.

```
public static List<List<Integer>> combinations(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(nums, k, 0, new ArrayList<>(), result);
        return result;
    }


    private static void combine(int[] nums, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            combine(nums, k, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }

```
