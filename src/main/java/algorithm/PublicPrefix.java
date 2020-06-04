package algorithm;

import pojo.Seller;
import pojo.jsonProcess.BeanWithInject;

import java.util.Arrays;

/**
 * @author ll0a
 * @version V1.0
 * @className: PublicPrefix
 * @date 5/30/2020 10:12 AM
 * 数组排序后头尾元素即为最长和最短的，对这两个 String 进行逐字符的对比
 */
public class PublicPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (isInviladStr(strs)) {
            return "";
        } else {
            StringBuilder prefix = new StringBuilder();
            Arrays.sort(strs);
            int strLength = strs.length;
            int lastIndex = strLength - 1;
            int m = strs[0].length();
            int n = strs[lastIndex].length();
            int minLength = Math.min(m, n);
            for (int i = 0; i < minLength; i++) {
                if (strs[0].charAt(i) == strs[lastIndex].charAt(i)) {
                    prefix.append(strs[0].charAt(i));
                } else {
                    break;
                }
            }
            return prefix.toString();
        }
    }

    public boolean isInviladStr(String[] strs) {
        boolean isInvalid = false;

        if (strs == null || strs.length == 0) {
            isInvalid = true;
        }

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null || strs[i].equals("")) {
                isInvalid = true;
                break;
            }
        }

        return isInvalid;
    }

}
