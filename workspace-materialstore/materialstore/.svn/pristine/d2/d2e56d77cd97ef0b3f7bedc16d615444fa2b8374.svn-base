/**  
 * @Title: Strings.java
 * @Package com.youzhicai.materialstore.common.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月11日 上午9:46:19
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.util;

/**
 * @ClassName: Strings
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月11日 上午9:46:19
 */
public class Strings {

    private static final char whitespace = ' ';

    /**
     * @Title: trim
     * @Description: 清除字符串中的空格,非空格字符间允许至多一位空格
     * @param str
     * @return String
     */
    public static String trim(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuffer buffer = new StringBuffer();
        char[] chs = str.toCharArray();
        char current = chs[0];
        buffer.append(current);

        char ch;
        for (int i = 1; i < chs.length; i++) {
            if ((ch = chs[i]) != whitespace || (ch == whitespace && current != whitespace)) {
                current = ch;
                buffer.append(ch);
            }
        }
        return buffer.toString().trim();
    }

    /**
     * @Title: trimStrict
     * @Description: 精确清除字符串中的空格
     * @param str
     * @return String
     */
    public static String trimStrict(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuffer buffer = new StringBuffer();
        for (char ch : str.toCharArray()) {
            if (ch != whitespace) {
                buffer.append(ch);
            }
        }
        return buffer.toString().trim();
    }

    /**
     * @Title: isBlank
     * @Description: 空白字符串判断
     * @param str
     * @return boolean
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Title: isNotBlank
     * @Description: 非空白字符串判断
     * @param str
     * @return boolean
     */
    public static boolean isNotBlank(String str) {
        return !Strings.isBlank(str);
    }

    /**
     * @Title: str2Long
     * @Description: 字符串转长整型
     * @param str
     * @return Long
     */
    public static Long str2Long(String str) {
        Long l = null;
        try {
            l = Long.parseLong(str);
        } catch (Exception e) {
        }
        return l;
    }

}
