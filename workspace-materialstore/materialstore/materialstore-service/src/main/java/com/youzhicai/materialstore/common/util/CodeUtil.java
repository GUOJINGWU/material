/**  
 * @Title: CodeUtil.java
 * @Package com.youzhicai.materialstore.common.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月9日 下午2:15:04
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.util;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: CodeUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月9日 下午2:15:04
 */
public class CodeUtil {

    /*
     * 数字编码长度
     */
    private static int digitsLength(int digits) {
        int length = 0;
        while (digits > 0) {
            ++length;
            digits = digits / 10;
        }
        return length;
    }

    /*
     * 补全数字编码
     */
    private static String complementCode(int newCode, int limit) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < (digitsLength(limit) - digitsLength(newCode)); i++) {
            buffer.append("0");
        }
        buffer.append(newCode);
        return buffer.toString();
    }

    /**
     * @Title: newCode
     * @Description: 获取新数字编码
     * @param codes
     * @param limit
     * @return String
     */
    public static String newCode(List<Integer> codes, int limit) {
        Integer newCode = null;

        if (codes == null || codes.isEmpty()) {
            newCode = 1;
        } else {
            Integer[] array = codes.toArray(new Integer[] {});
            Arrays.sort(array);
            codes = Arrays.asList(array);

            int size = codes.size();
            for (int i = 0; i < size; i++) {
                Integer code = codes.get(i);
                if ((i + 1) != code) {
                    newCode = i + 1;
                    break;
                }
            }

            if (newCode == null && size < limit) {
                newCode = size + 1;
            }
        }

        return newCode == null ? null : complementCode(newCode, limit);
    }

}
