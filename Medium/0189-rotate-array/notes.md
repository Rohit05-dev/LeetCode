# 189. Rotate Array

🔗 LeetCode Problem **Difficulty:** Medium **Topics:** Array, Math, Two Pointers

## Problem (summary)

Given an array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative. Must be done in-place (O(1) extra space).

## Approach

Use the **reversal algorithm**:

1. Normalize `k` with `k = k % n` (in case `k > n`).
2. Reverse the entire array.
3. Reverse the first `k` elements.
4. Reverse the remaining `n - k` elements.

This effectively rotates the array to the right by `k` without needing extra space. The `reverse(nums, left, right)` helper swaps elements from the outside in using two pointers (`left`, `right`) until they meet.

## Complexity

- Time: O(n) (three linear passes)
- Space: O(1)

## Edge Cases Considered

- `k` greater than `n` (handled by `k = k % n`)
- `k == 0` or `k == n` (no effective rotation)
- Single element array
- Array with duplicate values

## Alternative Approaches

- **Extra array:** create a new array of the same length, place each element at `(i + k) % n`, then copy back into `nums` — O(n) time, O(n) space. Simpler to reason about but doesn't meet the O(1) space constraint. (Left commented out in the code above as a reference for how this was first solved.)
- **Cyclic replacements:** rotate elements in-place by following cycles — O(n) time, O(1) space, but trickier to implement correctly (needs care with `gcd(n, k)` cycles).