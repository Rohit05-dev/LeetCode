# LeetCode 3345 — Smallest Divisible Digit Product I

## Problem
Given two integers `n` and `t`, return the smallest number **≥ n** such that
the product of its digits is divisible by `t`.

**Example:**
- `n = 10, t = 2` → `10` (digit product of 10 is `1*0 = 0`, and 0 is divisible by anything)
- `n = 15, t = 3` → `16` (digit product of 16 is `1*6 = 6`, divisible by 3)

**Constraints:** `n ≤ 100`, `t ≤ 10` (small — brute force is intended).

---

## First attempt (buggy)

```java
public int smallestNumber(int n, int t) {
    int i = n;
    int a, b;
    while (true) {
        a = n % 10;
        n /= 10;
        b = n % 10;
        if ((a * b) % t == 0) {
            return i;
        }
        i++;
        n = i;
    }
}
```

### Bug
This code always extracts **exactly two digits** (`a` and `b`), no matter
how many digits the number actually has.

- **1-digit numbers (e.g. `n=1`):** `a = 1`, `n/=10 → 0`, `b = 0`. The code
  fabricates a phantom second digit `b = 0`, making `a*b = 0`, which is
  falsely divisible by any `t`. Wrong answer for `n=1, t=2` (returns `1`
  instead of `2`).
- **3+ digit numbers (e.g. `920`):** only the last two digits get used —
  the hundreds digit is silently dropped, giving a wrong digit product.

### Root cause
Hardcoding a fixed number of digit variables (`a`, `b`) instead of looping
until all digits are consumed.

---

## Fixed solution

```java
public int smallestNumber(int n, int t) {
    while (true) {
        int product = 1;
        for (int i = n; i > 0; i /= 10) {
            product *= i % 10;
        }
        if (product % t == 0) {
            return n;
        }
        n++;
    }
}
```

### Why it works
- **Inner loop** extracts digits one at a time via `i % 10`, multiplies
  into `product`, and stops naturally when `i` becomes `0` — works for
  any number of digits.
- **Outer loop** tries `n, n+1, n+2, ...` until the digit-product condition
  is satisfied.

### Verified against the buggy cases
- `n=1, t=2`: product(1) = 1 → not divisible → try 2: product(2) = 2 →
  divisible → returns `2`. ✅
- `n=920`: product = `9*2*0 = 0` → divisible by any `t` → returns `920`
  immediately. ✅

---

## Complexity
- **Nested loops**, not sequential: total work = (numbers checked) ×
  (digits per number), i.e. `k × d`.
- With `n ≤ 100`, both `k` (search distance) and `d` (digit count, max 3)
  are small — effectively **O(1)** for the given constraints.
- Space: O(1).

## Takeaway
Don't hardcode a fixed number of digit-extraction steps — always loop
until the number is fully consumed (`i > 0`), so the logic generalizes
to any digit count.