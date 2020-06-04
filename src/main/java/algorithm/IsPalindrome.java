package algorithm;

import javax.security.auth.callback.TextInputCallback;

/**
 * @author ll0a
 * @version V1.0
 * @className: IsPalindrome
 * @date 5/30/2020 11:01 AM
 * @description:
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            if (!Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
            } else if (!Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
            } else {
                if (Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex))) {
                    return false;
                }
                leftIndex++;
                rightIndex--;
            }
        }
        return true;
    }
}
