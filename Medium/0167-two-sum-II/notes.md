# 167. Two Sum II - Input Array Is Sorted

🔗 LeetCode Problem **Difficulty:** Medium **Topics:** Array, Two Pointers, Binary Search

## Problem (summary)

Given a 1-indexed array `numbers` sorted in non-decreasing order, return the 1-indexed positions of the two numbers that add up to `target`. Exactly one solution is guaranteed.

## Approach

For each index `i`, compute the value still needed: `diff = target - numbers[i]`. Since the array is sorted, binary search for `diff` within the remaining sub-array `[i+1, n-1]`:

1. Set `low = i + 1`, `high = n - 1`
2. `mid = (low + high) / 2`
3. If `numbers[mid] == diff` → return `{i+1, mid+1}` (1-indexed)
4. If `numbers[mid] < diff` → search right half, `low = mid + 1`
5. If `numbers[mid] > diff` → search left half, `high = mid - 1`

Starting the search at `i + 1` rather than `0` avoids reusing the same element twice and avoids re-finding pairs already covered by earlier values of `i`.

## Complexity

- Time: O(n log n) — n outer iterations × O(log n) binary search per iteration
- Space: O(1) extra (besides the output array)

## Edge Cases Considered

- No valid pair — not expected per problem constraints, but as written the function falls through and returns `{0, 0}`, which isn't a valid 1-indexed answer
- Duplicate values — binary search still finds a correct match since the range only ever looks right of `i`, so `i < mid` always holds
- Smallest input (`n == 2`) — single outer iteration, single binary search over one element

## Alternative Approaches

- **Two pointers:** `low = 0`, `high = n - 1`; move `low` up if the sum is too small, `high` down if too large. O(n) time, O(1) space — asymptotically better than the binary search version, and the standard solution for this problem.
- **Hash map:** store `value → index` while scanning once; check for `target - numbers[i]` in the map. O(n) time, O(n) space — doesn't exploit the sorted property.