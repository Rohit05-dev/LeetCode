# 215. Kth Largest Element in an Array

🔗 LeetCode Problem **Difficulty:** Medium **Topics:** Array, Heap (Priority Queue), Divide and Conquer

## Problem (summary)

Given an integer array `nums` and an integer `k`, find the kth largest element in the array — the kth largest in sorted order, not the kth distinct element. Duplicates count individually.

## Approach

Use a min-heap (`PriorityQueue`) of size `k`. Iterate through `nums`, adding each element to the heap. Whenever the heap grows past size `k`, remove the smallest element with `poll()`. After processing all elements, the heap holds the `k` largest elements seen so far, with the smallest of those — the kth largest overall — sitting at the top. Return `minHeap.peek()`.

This avoids sorting the whole array when `k` is small relative to `n`.

## Complexity

- Time: O(n log k)
- Space: O(k)

## Edge Cases Considered

- `k` equals `nums.length` (kth largest is the minimum of the array)
- `k` equals `1` (kth largest is the maximum of the array)
- Duplicate values in the array (e.g. `[3,3,3]`, k=2 → still counts individually)
- Array with negative numbers

## Alternative Approaches

- **Sorting:** sort descending and return `nums[k-1]` — O(n log n) time, O(1) extra space (or O(log n)/O(n) depending on sort implementation), simpler but slower for large `n` with small `k`.
- **Quickselect:** partition-based selection — O(n) average time, O(n) worst case, O(1) space. More complex to implement correctly but optimal on average.