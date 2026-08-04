# Best Time to Buy and Sell Stock — Notes

## Problem
Given an array `prices` where `prices[i]` is the stock price on day `i`,
find the maximum profit from buying on one day and selling on a later day.
If no profit is possible, return `0`.

## Approach: Single Pass (Track Min So Far)
Keep track of the lowest price seen so far as you scan left to right.
At each day, check what profit you'd make if you sold **today** after
buying at the lowest price seen **before or on today**. Keep the best
profit seen.

This works because the optimal sell day always pairs with the minimum
price occurring *before* it — so you never need to look backward or
compare every pair.

Step by step:
1. `min` starts at `prices[0]` — the earliest possible buy price.
2. On each day `i`:
   - If today's price is lower than `min`, that becomes the new best buy price.
   - Otherwise, check if selling today (`prices[i] - min`) beats the best profit found so far.
3. Return the best profit found. If prices only fall, `profit` stays `0`.

## Complexity
- **Time:** O(n) — single pass through the array.
- **Space:** O(1) — only two extra variables (`profit`, `min`).

## Example Trace
`prices = [7, 1, 5, 3, 6, 4]`

| i | price | min | profit |
|---|-------|-----|--------|
| 0 | 7     | 7   | 0      |
| 1 | 1     | 1   | 0      |
| 2 | 5     | 1   | 4      |
| 3 | 3     | 1   | 4      |
| 4 | 6     | 1   | 5      |
| 5 | 4     | 1   | 5      |

**Result: 5** (buy at 1, sell at 6)

## Edge Cases to Remember
- Empty array → this code would throw (`prices[0]` on empty array). Guard with a length check if input isn't guaranteed non-empty.
- Prices strictly decreasing → profit stays `0`, which is correct (don't do the transaction).
- Single price → loop runs once, profit stays `0`.