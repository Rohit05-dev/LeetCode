# 704. Binary Search

🔗 LeetCode Problem **Difficulty:** Easy **Topics:** Array, Binary Search

## Problem (summary)

Given a sorted array `nums` of distinct integers and a `target`, return the index of `target` if it exists, otherwise return `-1`.

## Approach

Standard binary search over the full array:

1. Set `low = 0`, `high = nums.length - 1`
2. While `low <= high`:
   - `mid = (low + high) / 2`
   - If `nums[mid] == target` → return `mid`
   - If `nums[mid] < target` → search right half, `low = mid + 1`
   - If `nums[mid] > target` → search left half, `high = mid - 1`
3. Loop ends with no match → return `-1`

## Complexity

- Time: O(log n)
- Space: O(1)

## Edge Cases Considered

- Empty array — `high = -1`, loop never runs, returns `-1`
- Single element array — `low == high`, one comparison decides the result
- Target smaller than every element — `high` shrinks to `-1`
- Target larger than every element — `low` grows past `high`
- `(low + high) / 2` — safe here since array sizes stay well under `Integer.MAX_VALUE / 2`, but `low + (high - low) / 2` is the overflow-safe form for very large inputs

## Alternative Approaches

- **Linear scan:** check each element in order. O(n) time, O(1) space — simpler but doesn't exploit the sorted property.
- **Recursive binary search:** same logic, expressed as a recursive call on the narrowed range instead of a `while` loop. Same time complexity, but O(log n) space from the call stack.