package algorithm;

/**
 * @author ll0a
 * @version V1.0
 * @className: BracketDepth
 * @date 5/30/2020 1:19 PM
 * 从左往右，遇到 （ 当前深度加 1 ，否则减 1， max 保存最大深度
 */
public class BracketDepth {
    public int getBracketDepth(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxCount = 0;
        int currentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                currentCount++;
            } else {
                currentCount--;
            }
            maxCount = Math.max(maxCount, currentCount);
        }
        return maxCount;
    }
}
