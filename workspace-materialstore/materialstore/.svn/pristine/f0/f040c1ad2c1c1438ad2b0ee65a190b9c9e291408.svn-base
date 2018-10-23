/**  
 * @Title: PinyinUtil.java
 * @Package com.youzhicai.materialstore.common.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月8日 下午2:22:06
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.util;

import java.util.ArrayList;
import java.util.List;

import com.youzhicai.materialstore.common.constant.CaseType;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @ClassName: PinyinUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月8日 下午2:22:06
 */
public class PinyinUtil {
    private static HanyuPinyinOutputFormat pinyinFormat;

    static {
        synchronized (PinyinUtil.class) {
            if (pinyinFormat == null) {
                pinyinFormat = new HanyuPinyinOutputFormat();
                pinyinFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不展示音调
                pinyinFormat.setVCharType(HanyuPinyinVCharType.WITH_V);// 使用v
                pinyinFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 输出大小写格式
            }
        }
    }

    /*
     * 转换
     */
    private static String[] getPinyin(char ch) throws BadHanyuPinyinOutputFormatCombination {
        return PinyinHelper.toHanyuPinyinStringArray(ch, pinyinFormat);
    }

    /**
     * @Title: getPinyinsFirstAble
     * @Description: 首个可用的拼音集合
     * @param hanyu
     * @return List<String>
     */
    public static List<String> getPinyinsFirstAble(String hanyu) {
        if (hanyu == null || hanyu.length() == 0) {
            return null;
        }

        List<String> pinyins = new ArrayList<String>();
        String pinyin[];
        for (char hy : hanyu.toCharArray()) {
            if (Character.isWhitespace(hy)) {
                continue;
            }
            try {
                pinyin = getPinyin(hy);
                if (pinyin != null && pinyin.length > 0) {
                    pinyins.add(pinyin[0]);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
            }
        }

        return pinyins;
    }

    /**
     * @Title: getPinyinsAlphaFirstAble
     * @Description: 首字母集合
     * @param hanyu
     * @param caseType
     * @return List<String>
     */
    public static List<String> getPinyinsAlphaFirstAble(String hanyu, CaseType caseType) {
        List<String> pinyins = getPinyinsFirstAble(hanyu);
        if (pinyins == null) {
            return null;
        }
        List<String> alphas = new ArrayList<String>();
        String alpha;
        for (String pinyin : pinyins) {
            if (pinyin == null || pinyin.length() == 0) {
                continue;
            }
            alpha = String.valueOf(pinyin.charAt(0));
            if (CaseType.UPPER.equals(caseType)) {
                alpha = alpha.toUpperCase();
            } else if (CaseType.LOWER.equals(caseType)) {
                alpha = alpha.toLowerCase();
            }
            alphas.add(alpha);
        }
        return alphas;
    }
}
