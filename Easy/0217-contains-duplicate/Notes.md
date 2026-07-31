# 217. Contains Duplicate

🔗 [LeetCode Problem](https://leetcode.com/problems/contains-duplicate/)
**Difficulty:** Easy
**Topics:** Array, Hash Set

## Problem (summary)
Given an integer array, return `true` if any value appears at least twice,
and `false` if every element is distinct.

## Approach
Iterate through the array while adding each element to a hash set. If an
element is already in the set before adding, a duplicate exists — return
`true` immediately. If the loop finishes with no match, all elements are
distinct — return `false`. This avoids the O(n²) cost of comparing every
pair, and avoids the O(n log n) cost of sorting first.

## Complexity
- Time: O(n)
- Space: O(n)

## Edge Cases Considered
- Empty array or single-element array (no duplicates possible)
- Duplicate at the very start vs. very end of the array
- Array where all elements are identical