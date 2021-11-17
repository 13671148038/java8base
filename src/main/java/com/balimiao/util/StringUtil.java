package com.balimiao.util;

public class StringUtil {

    /**
     * 根据分隔符计算可以分割多少句子,多个相同的分隔符算一个
     *
     * @param str
     * @param separator
     * @return
     */
    public static int getNumBySeparator(String str, char[] separator) {
        char[] chars = str.toCharArray();
        int num = 1;
        int separatorFlag = 0;
        boolean b = false;
        for (int i = 0; i < chars.length; i++) {
            char valueChar = chars[i];
            for (int j = 0; j < separator.length; j++) {
                if (valueChar == separator[j]) {
                    separatorFlag++;
                    b = true;
                    break;
                }
            }
            if (b) {
                b = false;
                continue;
            }
            if (valueChar == '\n') {
                continue;
            }
            if (separatorFlag > 0) {
                separatorFlag = 0;
                num++;
            }
        }
        return num;
    }
}
