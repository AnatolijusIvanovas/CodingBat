import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
 * Created by Anatolijus on 2017-03-25.
 */
public class Functional1 {

    /*Functional-1
    Functional mapping operations on lists with lambdas. See the Java Functional Mapping page for an introduction.
    The main computation for each of these problems can be done with 1 line of lambda code.*/

    /*Java Functional API
    list.replaceAll(lambda) -- calls the lambda once for each item in the list, storing the result back into the list (or other type of collection).
    e.g. nums.replaceAll(n -> n * 2);
    list.removeIf(lambda) -- calls the lambda once for each item in the collection, removing each item where the lambda returns true.
    e.g. nums.removeIf(n -> n < 0);
    Simple Lambda Examples -- the data types are inferred from the context and from the type of the expression following the "->":
    n -> n * 2 -- takes Integer, returns Integer
    n -> n < 0 && n >= -10 -- takes Integer, returns boolean
    s -> s.length()  -- takes String, returns Integer
    s -> s.startsWith("hi") -- takes String, returns boolean
    The Java stream system provides more complicated lambda features.
    The stream calls do not modify the original list, returning a new data structure of the results.
    Note that the boolean logic of filter() is the opposite of removeIf().
    List<Integer> nums = -something-;
    nums = nums.stream()
            .map(n -> n * 2)
            .filter(n -> n >= 0)
            .collect(Collectors.toList());
    The above are just the most common calls, for more information see the official Java Stream Docs*/

    /*Functional-1 > doubling
    Given a list of integers, return a list where each integer is multiplied by 2.
    doubling([1, 2, 3]) → [2, 4, 6]
    doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
    doubling([]) → []*/
    public List<Integer> doubling(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        return nums;
    }

    /*Functional-1 > square
    Given a list of integers, return a list where each integer is multiplied with itself.
    square([1, 2, 3]) → [1, 4, 9]
    square([6, 8, -6, -8, 1]) → [36, 64, 36, 64, 1]
    square([]) → []*/
    public List<Integer> square(List<Integer> nums) {
        nums.replaceAll(n -> n * n);
        return nums;
    }

    /*Functional-1 > addStar
    Given a list of strings, return a list where each string has "*" added at its end.
    addStar(["a", "bb", "ccc"]) → ["a*", "bb*", "ccc*"]
    addStar(["hello", "there"]) → ["hello*", "there*"]
    addStar(["*"]) → ["**"]*/
    public List<String> addStar(List<String> strings) {
        strings.replaceAll(s -> s + "*");
        return strings;
    }

    /*Functional-1 > copies3
    Given a list of strings, return a list where each string is replaced by 3 copies of the string concatenated together.
    copies3(["a", "bb", "ccc"]) → ["aaa", "bbbbbb", "ccccccccc"]
    copies3(["24", "a", ""]) → ["242424", "aaa", ""]
    copies3(["hello", "there"]) → ["hellohellohello", "theretherethere"]*/
    public List<String> copies3(List<String> strings) {
        strings.replaceAll(s -> s + s + s);
        return strings;
    }

    /*Functional-1 > moreY
    Given a list of strings, return a list where each string has "y" added at its start and end.
    moreY(["a", "b", "c"]) → ["yay", "yby", "ycy"]
    moreY(["hello", "there"]) → ["yhelloy", "ytherey"]
    moreY(["yay"]) → ["yyayy"]*/
    public List<String> moreY(List<String> strings) {
        strings.replaceAll(s -> "y" + s + "y");
        return strings;
    }

    /*Functional-1 > math1
    Given a list of integers, return a list where each integer is added to 1 and the result is multiplied by 10.
    math1([1, 2, 3]) → [20, 30, 40]
    math1([6, 8, 6, 8, 1]) → [70, 90, 70, 90, 20]
    math1([10]) → [110]*/
    public List<Integer> math1(List<Integer> nums) {
        nums.replaceAll(n -> (n + 1) * 10);
        return nums;
    }

    /*Functional-1 > rightDigit
    Given a list of non-negative integers, return an integer list of the rightmost digits. (Note: use %)
    rightDigit([1, 22, 93]) → [1, 2, 3]
    rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
    rightDigit([10, 0]) → [0, 0]*/
    public List<Integer> rightDigit(List<Integer> nums) {
        nums.replaceAll(n -> n % 10);
        return nums;
    }

    /*Functional-1 > lower
    Given a list of strings, return a list where each string is converted to lower case (Note: String toLowerCase() method).
    lower(["Hello", "Hi"]) → ["hello", "hi"]
    lower(["AAA", "BBB", "ccc"]) → ["aaa", "bbb", "ccc"]
    lower(["KitteN", "ChocolaTE"]) → ["kitten", "chocolate"]*/
    public List<String> lower(List<String> strings) {
        strings.replaceAll(s -> s.toLowerCase());
        return strings;
    }

    /*Functional-1 > noX
    Given a list of strings, return a list where each string has all its "x" removed.
    noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
    noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
    noX(["x"]) → [""]*/
    public List<String> noX(List<String> strings) {
        strings.replaceAll(s -> func.apply(s));
        return strings;
    }

    final Function<String, String> func = s -> {
        if (s.equals("")) return s;
        if (s.charAt(0) == 'x') return this.func.apply(s.substring(1));
        else return s.charAt(0) + this.func.apply(s.substring(1));
    };

}