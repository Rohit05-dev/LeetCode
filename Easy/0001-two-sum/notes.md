# 1. Two Sum

🔗 [LeetCode Problem](https://leetcode.com/problems/two-sum/)
**Difficulty:** Easy
**Topics:** Array, Hash Map

## Problem (summary)
Given an array of integers and a target value, find the indices of the two
numbers that add up to the target. Exactly one valid pair exists, and you
can't reuse the same element twice.

## Approach
Use a hash map to store each number's index as you iterate. For each
element, check if `target - current` has already been seen — if so, return
both indices. This avoids the O(n²) brute-force pair check.

## Complexity
- Time: O(n)
- Space: O(n)

## Edge Cases Considered
- Duplicate values in the array (e.g. `[3,3]`, target `6`)
- Answer order doesn't matter, but indices must be distinct