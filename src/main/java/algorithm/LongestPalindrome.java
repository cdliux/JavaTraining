package algorithm;

import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import pojo.Seller;

import java.util.HashSet;

/**
 * @author ll0a
 * @version V1.0
 * @className: LongestPalindrome
 * @date 5/30/2020 10:36 AM
 * @description:
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        //将字符串转为字符数组
        char[] charArr = s.toCharArray();
        HashSet<Character> charSet = new HashSet<>();
        int count = 0;
        //遍历元素，Set 不存在就加入，存在则移除并将计数器加 1
        for (int i = 0; i < charArr.length; i++) {
            if (!charSet.contains(charArr[i])) {
                charSet.add(charArr[i]);
            } else {
                charSet.remove(charArr[i]);
                count++;
            }
        }
        //Set 不为空说明有单个存在的数，单个存在的数只能在回文串中存在一个，所以长度加 1
        return charSet.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
