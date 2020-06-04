package algorithm;

import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;

import javax.security.auth.callback.TextInputCallback;

/**
 * @author ll0a
 * @version V1.0
 * @className: ConvertStringToInt
 * @date 5/30/2020 11:19 AM
 * @description:
 */
public class ConvertStringToInt {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] charArr = str.toCharArray();
        int flag = 0;
        if (charArr[0] == '+') {
            flag = 1;
        } else if (charArr[0] == '-') {
            flag = 2;
        }

        int startIndex = flag > 0 ? 1 : 0;
        int result = 0;
        for (int i = startIndex; i < str.length(); i++) {
            if (Character.isDigit(charArr[i])) {
                int temp = charArr[i];
                result = result * 10 + temp;
            } else {
                return 0;
            }
        }

        try {
            int a = 1/0;
        }
        catch (Exception ex){

        }
        return flag == 2 ? -result : result;
    }
}
