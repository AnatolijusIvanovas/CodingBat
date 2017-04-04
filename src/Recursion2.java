/**
 * Created by Anatolijus on 2017-03-30.
 */
public class Recursion2 {

    /*Recursion-2
    Harder recursion problems. Currently, these are all recursive backtracking problems with arrays.*/

    /*Recursion-2 > groupSum
    Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target?
    This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem,
    you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array,
    our convention is to consider the part of the array starting at index start and continuing to the end of the array.
    The caller can specify the whole array simply by passing start as 0. No loops are needed -- the recursive calls progress down the array.
    Hint:
    The base case is when start>=nums.length. In that case, return true if target==0. Otherwise, consider the element at nums[start].
    The key idea is that there are only 2 possibilities -- nums[start] is chosen or it is not.
    Make one recursive call to see if a solution is possible if nums[start] is chosen (subtract nums[start] from target in that call).
    Make another recursive call to see if a solution is possible if nums[start] is not chosen.
    Return true if either of the two recursive calls returns true.
    groupSum(0, [2, 4, 8], 10) → true
    groupSum(0, [2, 4, 8], 14) → true
    groupSum(0, [2, 4, 8], 9) → false*/
    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length && target == 0) return true;
        if (start < nums.length && groupSum(start + 1, nums, target - nums[start])) return true;
        if (start < nums.length && groupSum(start + 1, nums, target)) return true;
        return false;
    }

    /*Recursion-2 > groupSum6
    Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index,
    such that the group sums to the given target? However, with the additional constraint that all 6's must be chosen.
    (No loops needed.)
    groupSum6(0, [5, 6, 2], 8) → true
    groupSum6(0, [5, 6, 2], 9) → false
    groupSum6(0, [5, 6, 2], 7) → false*/
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length && target == 0) return true;
        if (start < nums.length && groupSum6(start + 1, nums, target - nums[start])) return true;
        if (start < nums.length && nums[start] != 6 && groupSum6(start + 1, nums, target)) return true;
        return false;
    }

    /*Recursion-2 > groupNoAdj
    Given an array of ints, is it possible to choose a group of some of the ints,
    such that the group sums to the given target with this additional constraint:
    If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen.
    (No loops needed.)
    groupNoAdj(0, [2, 5, 10, 4], 12) → true
    groupNoAdj(0, [2, 5, 10, 4], 14) → false
    groupNoAdj(0, [2, 5, 10, 4], 7) → false*/
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length && target == 0) return true;
        if (start < nums.length && groupNoAdj(start + 2, nums, target - nums[start])) return true;
        if (start < nums.length && groupNoAdj(start + 1, nums, target)) return true;
        return false;
    }

    /*Recursion-2 > groupSum5
    Given an array of ints, is it possible to choose a group of some of the ints,
    such that the group sums to the given target with these additional constraints:
    all multiples of 5 in the array must be included in the group.
    If the value immediately following a multiple of 5 is 1, it must not be chosen.
    (No loops needed.)
    groupSum5(0, [2, 5, 10, 4], 19) → true
    groupSum5(0, [2, 5, 10, 4], 17) → true
    groupSum5(0, [2, 5, 10, 4], 12) → false*/
    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length && target == 0) return true;
        if (start < nums.length - 1 && nums[start] % 5 == 0 && nums[start + 1] == 1 && groupSum5(start + 2, nums, target - nums[start])) return true;
        if (start < nums.length - 1 && nums[start] % 5 == 0 && nums[start + 1] != 1 && groupSum5(start + 1, nums, target - nums[start])) return true;
        if (start == nums.length - 1 && nums[start] % 5 == 0 && groupSum5(start + 1, nums, target - nums[start])) return true;
        if (start < nums.length && nums[start] % 5 != 0 && groupSum5(start + 1, nums, target - nums[start])) return true;
        if (start < nums.length && nums[start] % 5 != 0 && groupSum5(start + 1, nums, target)) return true;
        return false;
    }

    /*Recursion-2 > groupSumClump
    Given an array of ints, is it possible to choose a group of some of the ints,
    such that the group sums to the given target, with this additional constraint:
    if there are numbers in the array that are adjacent and the identical value, they must either all be chosen, or none of them chosen.
    For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group.
    (one loop can be used to find the extent of the identical values).
    groupSumClump(0, [2, 4, 8], 10) → true
    groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
    groupSumClump(0, [2, 4, 4, 8], 14) → false*/
    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        int sum = nums[start];
        int count = 1;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] == nums[start]) {
                sum += nums[i];
                count++;
            }
        }
        return (start < nums.length && groupSumClump(start + count, nums, target - sum)) ||
                (start < nums.length && groupSumClump(start + count, nums, target));
    }

    /*Recursion-2 > splitArray
    Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same.
    Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like,
    and make the initial call to your recursive helper from splitArray(). (No loops needed.)
    splitArray([2, 2]) → true
    splitArray([2, 3]) → false
    splitArray([5, 2, 3]) → true*/
    public boolean splitArray(int[] nums) {
        return helper1(0, nums, 0, 0);
    }

    public boolean helper1(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) return sum1 == sum2;
        return helper1(start + 1, nums, sum1 + nums[start], sum2) || helper1(start + 1, nums, sum1, sum2 + nums[start]);
    }

    /*Recursion-2 > splitOdd10
    Given an array of ints, is it possible to divide the ints into two groups, so that the sum of one group is a multiple of 10,
    and the sum of the other group is odd. Every int must be in one group or the other.
    Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitOdd10().
    (No loops needed.)
    splitOdd10([5, 5, 5]) → true
    splitOdd10([5, 5, 6]) → false
    splitOdd10([5, 5, 6, 1]) → true*/
    public boolean splitOdd10(int[] nums) {
        return helper2(0, nums, 0, 0);
    }

    public boolean helper2(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) return sum1 % 10 == 0 && sum2 % 2 != 0 || sum1 % 2 != 0 && sum2 % 10 == 0;
        return helper2(start + 1, nums, sum1 + nums[start], sum2) || helper2(start + 1, nums, sum1, sum2 + nums[start]);
    }

    /*Recursion-2 > split53
    Given an array of ints, is it possible to divide the ints into two groups,
    so that the sum of the two groups is the same, with these constraints:
    all the values that are multiple of 5 must be in one group, and all the values that
    are a multiple of 3 (and not a multiple of 5) must be in the other.
    (No loops needed.)
    split53([1, 1]) → true
    split53([1, 1, 1]) → false
    split53([2, 4, 2]) → true*/
    public boolean split53(int[] nums) {
        return helper3(0, nums, 0, 0);
    }

    public boolean helper3(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) return sum1 == sum2;
        if (nums[start] % 5 == 0) return helper3(start + 1, nums, sum1 + nums[start], sum2);
        if (nums[start] % 3 == 0) return helper3(start + 1, nums, sum1, sum2 + nums[start]);
        return helper3(start + 1, nums, sum1 + nums[start], sum2) || helper3(start + 1, nums, sum1, sum2 + nums[start]);
    }

}