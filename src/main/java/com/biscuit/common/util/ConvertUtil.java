package com.biscuit.common.util;

import com.biscuit.common.factory.GsonFactory;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 数据转换工具类
 *
 * @author biscuit
 */
@Slf4j
public abstract class ConvertUtil {

    /**
     * 0 = false，1 = true
     *
     * @param flat Boolean 变量
     * @return 对应 Integer 值
     */
    public static int convertBoolean2Integer(Boolean flat) {
        return flat ? 1 : 0;
    }

    /**
     * 0 = false，1 = true
     *
     * @param number Integer 变量
     * @return 对应 Boolean 值
     */
    public static boolean convertInteger2Boolean(Integer number) {
        return number == 1;
    }

    public static String convertPinyin(String content) {
        StringBuilder pinyin = new StringBuilder();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        try {

            char[] charArray = content.toCharArray();
            for (char c : charArray) {
                if (Character.toString(c).matches("[\\u4E00-\\u9FFF]")) {
                    String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    if (pinyinArray != null) {
                        pinyin.append(pinyinArray[0]);
                    } else {
                        pinyin.append(c);
                    }
                } else {
                    pinyin.append(c);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            log.error("ConvertUtil convertPinyin error => {}", GsonFactory.get().toJson(e));
            throw new RuntimeException(e);
        }
        return pinyin.toString();
    }

    /**
     * 转换简体中文为繁体中文
     *
     * @param simplified 简体中文
     * @return 繁体中文
     */
    public static String convertTraditional(String simplified) {
        return ZhConverterUtil.toTraditional(simplified);
    }

    /**
     * 转换繁体中文为简体中文
     *
     * @param traditional 繁体中文
     * @return 简体中文
     */
    public static String convertSimplified(String traditional) {
        return ZhConverterUtil.toSimple(traditional);
    }

}
