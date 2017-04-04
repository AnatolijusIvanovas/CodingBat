/**
 * Created by Anatolijus on 2017-03-06.
 */
public class String2 {

    /*String-2
    Medium String problems -- 1 loop.*/

    /*String-2 > doubleChar
    Given a string, return a string where for every char in the original, there are two chars.
    doubleChar("The") → "TThhee"
    doubleChar("AAbb") → "AAAAbbbb"
    doubleChar("Hi-There") → "HHii--TThheerree"*/
    public String doubleChar(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            out = out + str.substring(i, i + 1) + str.substring(i, i + 1);
        }
        return out;
    }

    /*String-2 > countHi
    Return the number of times that the string "hi" appears anywhere in the given string.
    countHi("abc hi ho") → 1
    countHi("ABChi hi") → 2
    countHi("hihi") → 2*/
    public int countHi(String str) {
        int out = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i+2).equals("hi")) out++;
        }
        return out;
    }

    /*String-2 > catDog
    Return true if the string "cat" and "dog" appear the same number of times in the given string.
    catDog("catdog") → true
    catDog("catcat") → false
    catDog("1cat1cadodog") → true*/
    public boolean catDog(String str) {
        int a = 0, b = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("cat")) a++;
            if (str.substring(i, i + 3).equals("dog")) b++;
        }
        return a == b ? true : false;
    }

    /*String-2 > countCode
    Return the number of times that the string "code" appears anywhere in the given string,
    except we'll accept any letter for the 'd', so "cope" and "cooe" count.
    countCode("aaacodebbb") → 1
    countCode("codexxcode") → 2
    countCode("cozexxcope") → 2*/
    public int countCode(String str) {
        int out = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i + 2).equals("co") && str.substring(i + 3, i + 4).equals("e")) out++;
        }
        return out;
    }

    /*String-2 > endOther
    Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences
    (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.
    endOther("Hiabc", "abc") → true
    endOther("AbC", "HiaBc") → true
    endOther("abc", "abXabc") → true*/
    public boolean endOther(String a, String b) {
        String[] str = a.length() < b.length() ? new String[]{a, b} : new String[]{b, a};
        if (str[1].substring(str[1].length() - str[0].length()).equalsIgnoreCase(str[0])) return true;
        return false;
    }

    /*String-2 > xyzThere
    Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.).
    So "xxyz" counts but "x.xyz" does not.
    xyzThere("abcxyz") → true
    xyzThere("abc.xyz") → false
    xyzThere("xyz.abc") → true*/
    public boolean xyzThere(String str) {
        if (str.length() == 3 && str.substring(0, 3).equals("xyz")) return true;
        for (int i = 0; i < str.length() - 3; i++) {
            if (i == 0 && str.substring(i, i+3).equals("xyz")) return true;
            if (!str.substring(i, i+1).equals(".") && str.substring(i+1, i+4).equals("xyz")) return true;
        }
        return false;
    }

    /*String-2 > bobThere
    Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
    bobThere("abcbob") → true
    bobThere("b9b") → true
    bobThere("bac") → false*/
    public boolean bobThere(String str) {
        if (str.length() == 3 && str.substring(0, 1).equals("b") && str.substring(2, 3).equals("b")) return true;
        if (str.length() > 3) {
            for (int i = 1; i < str.length() - 2; i++) {
                if (str.substring(i, i+1).equals("b") && str.substring(i+2, i+3).equals("b")) return true;
            }
        }
        return false;
    }

    /*String-2 > xyBalance
    We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string.
    So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
    xyBalance("aaxbby") → true
    xyBalance("aaxbb") → false
    xyBalance("yaaxbb") → false*/
    public boolean xyBalance(String str) {
        int index = str.lastIndexOf("x");
        if (index < 0) return true;
        for (int i = index; i < str.length(); i++) {
            if (str.substring(i, i+1).equals("y")) return true;
        }
        return false;
    }

    /*String-2 > mixString
    Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, the second char of b, and so on.
    Any leftover chars go at the end of the result.
    mixString("abc", "xyz") → "axbycz"
    mixString("Hi", "There") → "HTihere"
    mixString("xxxx", "There") → "xTxhxexre"*/
    public String mixString(String a, String b) {
        String out = "";
        int len = a.length() < b.length() ? a.length() : b.length();
        for (int i = 0; i < len; i++) {
            out = out + a.substring(i, i+1) + b.substring(i, i+1);
        }
        if (a.length() > len) out = out + a.substring(len);
        if (b.length() > len) out = out + b.substring(len);
        return out;
    }

    /*String-2 > repeatEnd
    Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
    You may assume that n is between 0 and the length of the string, inclusive.
    repeatEnd("Hello", 3) → "llollollo"
    repeatEnd("Hello", 2) → "lolo"
    repeatEnd("Hello", 1) → "o"*/
    public String repeatEnd(String str, int n) {
        String out = "";
        for (int i = 0; i < n; i++) {
            out = out + str.substring(str.length() - n);
        }
        return out;
    }

    /*String-2 > repeatFront
    Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1 characters of the string, and so on.
    You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
    repeatFront("Chocolate", 4) → "ChocChoChC"
    repeatFront("Chocolate", 3) → "ChoChC"
    repeatFront("Ice Cream", 2) → "IcI"*/
    public String repeatFront(String str, int n) {
        String out = "";
        for (int i = n; i > 0; i--) {
            out = out + str.substring(0, i);
        }
        return out;
    }

    /*String-2 > repeatSeparator
    Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string.
    repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    repeatSeparator("This", "And", 2) → "ThisAndThis"
    repeatSeparator("This", "And", 1) → "This"*/
    public String repeatSeparator(String word, String sep, int count) {
        String out = "";
        for (int i = 0; i < count; i++) {
            out = out + word;
            if (count - i != 1) out = out + sep;
        }
        return out;
    }

    /*String-2 > prefixAgain
    Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string?
    Assume that the string is not empty and that N is in the range 1..str.length().
    prefixAgain("abXYabc", 1) → true
    prefixAgain("abXYabc", 2) → true
    prefixAgain("abXYabc", 3) → false*/
    public boolean prefixAgain(String str, int n) {
        String prefix = str.substring(0, n);
        for (int i = 1; i < str.length() + 1 - n; i++) {
            if (str.substring(i, i + n).equals(prefix)) return true;
        }
        return false;
    }

    /*String-2 > xyzMiddle
    Given a string, does "xyz" appear in the middle of the string?
    To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
    xyzMiddle("AAxyzBB") → true
    xyzMiddle("AxyzBB") → true
    xyzMiddle("AxyzBBB") → false*/
    public boolean xyzMiddle(String str) {
        int len = str.length();
        int mid = str.length() / 2;
        if (len == 3 && str.equals("xyz")) return true;
        if (len > 3 && len % 2 == 0) {
            if (str.substring(mid - 2, mid + 1).equals("xyz")) return true;
            if (str.substring(mid - 1, mid + 2).equals("xyz")) return true;
        }
        if (len > 3 && len % 2 != 0) {
            if (str.substring(mid - 1, mid + 2).equals("xyz")) return true;
        }
        return false;
    }

    /*String-2 > getSandwich
    A sandwich is two pieces of bread with something in between.
    Return the string that is between the first and last appearance of "bread" in the given string,
    or return the empty string "" if there are not two pieces of bread.
    getSandwich("breadjambread") → "jam"
    getSandwich("xxbreadjambreadyy") → "jam"
    getSandwich("xxbreadyy") → ""*/
    public String getSandwich(String str) {
        String out = "";
        if (str.length() > 10 && str.indexOf("bread") != str.lastIndexOf("bread")) {
            int start = str.indexOf("bread");
            int finish = str.lastIndexOf("bread");
            out = out + str.substring(start + 5, finish);
        }
        return out;
    }

    /*String-2 > sameStarChar
    Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same.
    sameStarChar("xy*yzz") → true
    sameStarChar("xy*zzz") → false
    sameStarChar("*xa*az") → true*/
    public boolean sameStarChar(String str) {
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.substring(i, i + 1).equals("*") && !str.substring(i - 1, i).equals(str.substring(i + 1, i + 2))) return false;
        }
        return true;
    }

    /*String-2 > oneTwo
    Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca".
    Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
    oneTwo("abc") → "bca"
    oneTwo("tca") → "cat"
    oneTwo("tcagdo") → "catdog"*/
    public String oneTwo(String str) {
        String out = "";
        int step = str.length() / 3;
        int end = step * 3;
        for (int i = 0; i < end; i += 3) {
            out = out + str.substring(i + 1, i + 3) + str.substring(i, i + 1);
        }
        return out;
    }

    /*String-2 > zipZap
    Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'.
    Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
    zipZap("zipXzap") → "zpXzp"
    zipZap("zopzop") → "zpzp"
    zipZap("zzzopzop") → "zzzpzp"*/
    public String zipZap(String str) {
        String out = "";
        if (str.length() < 3) return str;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("z") && str.substring(i + 2, i + 3).equals("p")) {
                out = out + "zp";
                i = i + 2;
            } else {
                out = out + str.substring(i, i + 1);
            }
        }
        return out;
    }

    /*String-2 > starOut
    Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone.
    So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
    starOut("ab*cd") → "ad"
    starOut("ab**cd") → "ad"
    starOut("sm*eilly") → "silly"*/
    public String starOut(String str) {
        String out = "";
        int len = str.length();
        if (len == 0) return str;
        if (len == 1 && !str.equals("*")) return str;
        if (len == 2 && !str.substring(0, 1).equals("*") && !str.substring(1, 2).equals("*")) return str;
        for (int i = 0; i < len; i++) {
            if (str.substring(i, i+1).equals("*")) {
                i += 1;
                continue;
            }
            if (i < len-1 && str.substring(i+1, i+2).equals("*")) {
                i += 2;
                continue;
            }
            if (i == 0 && !str.substring(i, i+1).equals("*") && !str.substring(i+1, i+2).equals("*")) out = out + str.substring(i, i+1);
            if (i > 0 && i < len-1 && !str.substring(i-1, i).equals("*") && !str.substring(i, i+1).equals("*") && !str.substring(i+1, i+2).equals("*")) out = out + str.substring(i, i+1);
            if (i == len-1 && !str.substring(i, i+1).equals("*")) out = out + str.substring(i, i+1);
        }
        return out;
    }

    /*String-2 > plusOut
    Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"),
    except for appearances of the word string which are preserved unchanged.
    plusOut("12xy34", "xy") → "++xy++"
    plusOut("12xy34", "1") → "1+++++"
    plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"*/
    public String plusOut(String str, String word) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if (i + word.length() <= str.length() && str.substring(i, i + word.length()).equals(word)) {
                out += word;
                i += word.length() - 1;
            } else {
                out += "+";
            }
        }
        return out;
    }

    /*String-2 > wordEnds
    Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string.
    Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words.
    wordEnds("abcXY123XYijk", "XY") → "c13i"
    wordEnds("XY123XY", "XY") → "13"
    wordEnds("XY1XY", "XY") → "11"*/
    public String wordEnds(String str, String word) {
        String out = "";
        for (int i = 0; i <= str.length(); i++) {
            if (i + word.length() < str.length() && str.substring(i + 1, i + word.length()+1).equals(word)) {
                out += str.substring(i, i+1);
            }
            if (i + word.length() <= str.length() - 1 && str.substring(i, i + word.length()).equals(word)) {
                out += str.substring(i + word.length(), i + word.length() + 1);
            }
        }
        return out;
    }

}