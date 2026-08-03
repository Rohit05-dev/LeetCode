# 54. Spiral Matrix

🔗 LeetCode Problem **Difficulty:** Medium **Topics:** Array, Matrix, Simulation

## Problem (summary)

Given an `m x n` matrix, return all elements of the matrix in spiral order — starting from the top-left, moving right, then down, then left, then up, and spiraling inward until every element has been visited.

## Approach

Track four boundaries: `sr` (starting row), `er` (ending row), `sc` (starting column), `ec` (ending column). Traverse the matrix one layer at a time in four passes per loop iteration:

1. Left → right along `sr`, then increment `sr`
2. Top → bottom along `ec`, then decrement `ec`
3. Right → left along `er`, then decrement `er`
4. Bottom → top along `sc`, then increment `sc`

A `count` variable tracks how many elements remain to be added (`m * n` total). After each of the four passes, check if `count == 0` and break immediately — this prevents re-visiting cells or going out of bounds when the remaining elements run out mid-layer (important for non-square matrices, e.g. a single row or column).

Repeat until all elements are collected.

## Complexity

- Time: O(m·n)
- Space: O(m·n) (for the output list; O(1) extra space otherwise)

## Edge Cases Considered

- Single row matrix (`1 x n`)
- Single column matrix (`m x 1`)
- Single element matrix (`1 x 1`)
- Non-square matrix (rows ≠ columns)
- The `count == 0` breaks after each of the four inner loops — without these, a partially-filled final layer would cause duplicate or out-of-bounds reads

## Alternative Approaches

- **Layer-by-layer with visited matrix:** use a boolean grid to mark visited cells and check bounds/visited status while moving in a direction, turning when blocked — more general but higher space (O(m·n) extra) and more overhead than boundary tracking.
- **Recursive peeling:** print the outer layer, then recurse on the inner submatrix — conceptually similar to the boundary approach but less efficient due to function call overhead.