# 3731. Find Missing Elements

**Difficulty:** Easy

## Problem
Given an integer array `nums`, return all the integers in the range `[min(nums), max(nums)]` that are **not** present in `nums`.

## Approach
1. Do a single pass to find `min` and `max` of the array, and simultaneously insert every element into a `HashSet` for O(1) lookup.
2. Walk the range `(min, max)` — i.e. `i = min + 1` up to (but not including) `max` — and for every `i` **not** in the set, add it to the result list.
3. Return the result list.

Using a `HashSet` avoids an O(n) `contains` check on the array for every candidate number, which is what makes this efficient.

## Complexity
- **Time:** O(n) — one pass to build min/max/set, one pass over the `[min, max]` range.
- **Space:** O(n) for the `HashSet`, plus O(k) for the output list (k = number of missing elements).

## Edge Cases
- Array with a single element → `min == max`, loop body never runs, returns empty list.
- Array with no gaps (fully consecutive) → returns empty list.
- Duplicate values in `nums` → handled naturally since `set` dedupes.

## Notes / Gotchas
- Loop condition is `i < max` (exclusive of `max`), so `max` itself is correctly never checked or added — it's already known to be present.
- `min` is also correctly skipped since the range starts at `min + 1`.