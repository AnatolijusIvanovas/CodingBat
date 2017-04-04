import java.util.Map;
import java.util.HashMap;
/**
 * Created by Anatolijus on 2017-03-03.
 */
public class Map1 {

    /*Map-1
    Basic Map get()/put(), no loops. See the Java Map Introduction for help.*/

    /*Java Map API
    // Make a new empty map
    Map<String, String> map = new HashMap<String, String>();
    map.get(key) -- retrieves the stored value for a key, or null if that key is not present in the map.
    map.put(key, value) -- stores a new key/value pair in the map. Overwrites any existing value for that key.
    map.containsKey(key) -- returns true if the key is in the map, false otherwise.
    map.remove(key) -- removes the key/value pair for this key if present. Does nothing if the key is not present.*/

    /*Map-1 > mapBully
    Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that value, and set the key "a" to have the value "".
    Basically "b" is a bully, taking the value and replacing it with the empty string.
    mapBully({"a": "candy", "b": "dirt"}) → {"a": "", "b": "candy"}
    mapBully({"a": "candy"}) → {"a": "", "b": "candy"}
    mapBully({"a": "candy", "b": "carrot", "c": "meh"}) → {"a": "", "b": "candy", "c": "meh"}*/
    public Map<String, String> mapBully(Map<String, String> map) {
        if (map.get("a") != null) {
            map.put("b", map.get("a"));
            map.put("a", "");
        }
        return map;
    }

    /*Map-1 > mapShare
    Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that same value.
    In all cases remove the key "c", leaving the rest of the map unchanged.
    mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
    mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
    mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}*/
    public Map<String, String> mapShare(Map<String, String> map) {
        if (map.get("a") != null) {
            map.put("b", map.get("a"));
        }
        map.remove("c");
        return map;
    }

    /*Map-1 > mapAB
    Modify and return the given map as follows: for this problem the map may or may not contain the "a" and "b" keys.
    If both keys are present, append their 2 string values together and store the result under the key "ab".
    mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
    mapAB({"a": "Hi"}) → {"a": "Hi"}
    mapAB({"b": "There"}) → {"b": "There"}*/
    public Map<String, String> mapAB(Map<String, String> map) {
        if (map.get("a") != null && map.get("b") != null) {
            map.put("ab", map.get("a") + map.get("b"));
        }
        return map;
    }

    /*Map-1 > topping1
    Given a map of food keys and topping values, modify and return the map as follows:
    If the key "ice cream" is present, set its value to "cherry".
    In all cases, set the key "bread" to have the value "butter".
    topping1({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
    topping1({}) → {"bread": "butter"}
    topping1({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}*/
    public Map<String, String> topping1(Map<String, String> map) {
        if (map.get("ice cream") != null) map.put("ice cream", "cherry");
        map.put("bread", "butter");
        return map;
    }

    /*Map-1 > topping2
    Given a map of food keys and their topping values, modify and return the map as follows:
    If the key "ice cream" has a value, set that as the value for the key "yogurt" also.
    If the key "spinach" has a value, change that value to "nuts".
    topping2({"ice cream": "cherry"}) → {"yogurt": "cherry", "ice cream": "cherry"}
    topping2({"spinach": "dirt", "ice cream": "cherry"}) → {"yogurt": "cherry", "spinach": "nuts", "ice cream": "cherry"}
    topping2({"yogurt": "salt"}) → {"yogurt": "salt"}*/
    public Map<String, String> topping2(Map<String, String> map) {
        if (map.get("ice cream") != null) map.put("yogurt", map.get("ice cream"));
        if (map.get("spinach") != null) map.put("spinach", "nuts");
        return map;
    }

    /*Map-1 > topping3
    Given a map of food keys and topping values, modify and return the map as follows:
    If the key "potato" has a value, set that as the value for the key "fries".
    If the key "salad" has a value, set that as the value for the key "spinach".
    topping3({"potato": "ketchup"}) → {"potato": "ketchup", "fries": "ketchup"}
    topping3({"potato": "butter"}) → {"potato": "butter", "fries": "butter"}
    topping3({"salad": "oil", "potato": "ketchup"}) → {"spinach": "oil", "salad": "oil", "potato": "ketchup", "fries": "ketchup"}*/
    public Map<String, String> topping3(Map<String, String> map) {
        if (map.get("potato") != null) map.put("fries", map.get("potato"));
        if (map.get("salad") != null) map.put("spinach", map.get("salad"));
        return map;
    }

}