import java.util.Map;
import java.util.HashMap;
/**
 * Created by Anatolijus on 2017-03-21.
 */
public class Map2 {

    /*Map-2
    Maps with bulk data and loops. See the Java Map WordCount for help*/

    /*Java Map API
    // Make a new empty map
    Map<String, String> map = new HashMap<String, String>();
    map.get(key) -- retrieves the stored value for a key, or null if that key is not present in the map.
    map.put(key, value) -- stores a new key/value pair in the map. Overwrites any existing value for that key.
    map.containsKey(key) -- returns true if the key is in the map, false otherwise.
    map.remove(key) -- removes the key/value pair for this key if present. Does nothing if the key is not present.*/

    /*Map-2 > word0
    Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, always with the value 0.
    For example the string "hello" makes the pair "hello":0. We'll do more complicated counting later, but for this problem the value is simply 0.
    word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
    word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
    word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}*/
    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> out = new HashMap();
        for (String s:strings) {
            if (!out.containsKey(s)) out.put(s, 0);
        }
        return out;
    }

    /*Map-2 > wordLen
    Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.
    wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
    wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
    wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}*/
    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> out = new HashMap();
        for (String s:strings) {
            if (!out.containsKey(s)) out.put(s, s.length());
        }
        return out;
    }

    /*Map-2 > pairs
    Given an array of non-empty strings, create and return a Map<String, String> as follows:
    for each string add its first character as a key with its last character as the value.
    pairs(["code", "bug"]) → {"b": "g", "c": "e"}
    pairs(["man", "moon", "main"]) → {"m": "n"}
    pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}*/
    public Map<String, String> pairs(String[] strings) {
        Map<String, String> out = new HashMap();
        for (String s:strings) {
            out.put(s.substring(0, 1), s.substring(s.length()-1));
        }
        return out;
    }

    /*Map-2 > wordCount
    The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string,
    with the value the number of times that string appears in the array.
    wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
    wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
    wordCount(["c", "c", "c", "c"]) → {"c": 4}*/
    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> out = new HashMap();
        for (String s:strings) {
            if (out.containsKey(s)) {
                out.put(s, out.get(s)+1);
            } else {
                out.put(s, 1);
            }
        }
        return out;
    }

    /*Map-2 > firstChar
    Given an array of non-empty strings, return a Map<String, String> with a key for every different first character seen,
    with the value of all the strings starting with that character appended together in the order they appear in the array.
    firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
    firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}*/
    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> out = new HashMap();
        for (String s:strings) {
            if (out.containsKey(s.substring(0, 1))) {
                out.put(s.substring(0, 1), out.get(s.substring(0, 1)) + s);
            } else {
                out.put(s.substring(0, 1), s);
            }
        }
        return out;
    }

    /*Map-2 > wordAppend
    Loop over the given array of strings to build a result string like this: when a string appears the 2nd, 4th, 6th, etc. time in the array,
    append the string to the result. Return the empty string if no string appears a 2nd time.
    wordAppend(["a", "b", "a"]) → "a"
    wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
    wordAppend(["a", "", "a"]) → "a"*/
    public String wordAppend(String[] strings) {
        String out = "";
        Map<String, Integer> map = new HashMap();
        for (String s:strings) {
            if (map.containsKey(s)) {
                int val = map.get(s) + 1;
                if (val % 2 == 0) out = out + s;
                map.put(s, val);
            } else {
                map.put(s, 1);
            }
        }
        return out;
    }

    /*Map-2 > wordMultiple
    Given an array of strings, return a Map<String, Boolean> where each different string is a key
    and its value is true if that string appears 2 or more times in the array.
    Hint: One way to solve with a Map<String, Boolean>:
    -no value: string not seen yet
    -value false: string seen once
    -value true: string seen 2 or more times
    wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
    wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
    wordMultiple(["c", "c", "c", "c"]) → {"c": true}*/
    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> out = new HashMap<String, Boolean>();
        for (String s:strings) {
            if (out.containsKey(s) && !out.get(s)) out.put(s, true);
            if (!out.containsKey(s)) out.put(s, false);
        }
        return out;
    }

    /*Map-2 > allSwap
    We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
    Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array.
    When a position in the array has been swapped, it no longer matches anything. Using a map, this can be solved making just one pass over the array.
    More difficult than it looks.
    Hint: Make a Map<String, Integer> with the first char as the key and the index in the array as the value.
    After doing a swap, remove that key so it won't match anything in the future.
    allSwap(["ab", "ac"]) → ["ac", "ab"]
    allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
    allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]*/
    public String[] allSwap(String[] strings) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i].substring(0, 1);
            if (map.containsKey(key)) {
                int pos = map.get(key);
                String tmp = strings[pos];
                strings[pos] = strings[i];
                strings[i] = tmp;
                map.remove(key);
            } else {
                map.put(key, i);
            }
        }
        return strings;
    }

    /*Map-2 > firstSwap
    We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
    Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array.
    A particular first char can only cause 1 swap, so once a char has caused a swap, its later swaps are disabled.
    Using a map, this can be solved making just one pass over the array. More difficult than it looks.
    firstSwap(["ab", "ac"]) → ["ac", "ab"]
    firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
    firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]*/
    public String[] firstSwap(String[] strings) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i].substring(0, 1);
            if (map.containsKey(key)) {
                if (map.get(key) == -1) continue;
                int pos = map.get(key);
                String tmp = strings[pos];
                strings[pos] = strings[i];
                strings[i] = tmp;
                map.put(key, -1);
            } else {
                map.put(key, i);
            }
        }
        return strings;
    }

}