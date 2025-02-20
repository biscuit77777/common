package com.biscuit.common.util;

import java.util.*;

/**
 * 生成内容工具类
 *
 * @author biscuit
 */
public abstract class GenerateUtil {

    private static final Random random = new Random();

    private static final List<String> LETTER_LOWER_LIST = Arrays.asList(
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    private static final List<String> LETTER_UPPER_LIST = Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    private static final List<String> LETTER_LIST;

    private static final List<String> ADJECTIVE_LIST = Arrays.asList(
            "聪明的", "笨拙的", "拙略的", "勇敢的", "可爱的", "机智的", "敏锐的", "果敢的", "沉稳的", "谨慎的",
            "狡黠的", "憨厚的", "圆滑的", "固执的", "呆呆的", "刻薄的", "谦逊的", "傲慢的", "偏执的", "狂傲的",
            "鲁莽的", "隐忍的", "浮躁的", "迂腐的", "顽强的", "热情的", "冷漠的", "温柔的", "暴躁的", "忧郁的",
            "欢快的", "孤僻的", "豁达的", "悲观的", "乐观的", "敏感的", "麻木的", "多疑的", "坦率的", "虚伪的",
            "虔诚的", "叛逆的", "顺从的", "倔强的", "包容的", "俊美的", "邋遢的", "精致的", "粗犷的", "妩媚的",
            "朴素的", "端庄的", "妖娆的", "清秀的", "沧桑的", "稚嫩的", "魁梧的", "纤弱的", "挺拔的", "臃肿的",
            "灵动的", "木讷的", "飘逸的", "凌乱的", "优雅的", "敏捷的", "迟缓的", "笨重的", "轻盈的", "矫健的",
            "蹒跚的", "踉跄的", "利落的", "拖沓的", "娴熟的", "生疏的", "娴静的", "喧闹的", "沉默的", "聒噪的",
            "从容的", "慌张的", "笨手笨脚的", "手忙脚乱的", "镇定自若的", "睿智的", "愚钝的", "机敏的", "呆板的",
            "灵光的", "混沌的", "缜密的", "马虎的", "精明的", "天真的", "世故的", "单纯的", "复杂的", "深刻的",
            "肤浅的", "创新的", "守旧的", "理性的", "感性的", "迂回的", "正直的", "奸诈的", "仁慈的", "残忍的",
            "慷慨的", "吝啬的", "无私的", "自私的", "宽容的", "狭隘的", "诚实的", "虚伪的", "忠诚的", "背叛的",
            "高尚的", "卑劣的", "磊落的", "阴险的", "仗义的", "忘恩的", "璀璨的", "黯淡的", "清新的", "浑浊的",
            "炽热的", "冰冷的", "柔和的", "刺眼的", "静谧的", "喧嚣的", "荒芜的", "繁华的", "辽阔的", "狭窄的",
            "朦胧的", "清晰的", "虚无的", "真实的", "虚幻的", "永恒的", "狼狈的", "潇洒的", "颓废的", "蓬勃的",
            "枯萎的", "鲜活的", "腐朽的", "崭新的", "破旧的", "华丽的", "简陋的", "奢华的", "朴实的", "浮夸的",
            "怪异的", "平凡的", "非凡的", "扭曲的", "笔直的", "崎岖的", "诙谐的", "严肃的", "俏皮的", "呆萌的",
            "凶悍的", "温顺的", "执拗的", "随和的", "懒散的", "勤快的", "挑剔的", "随意的", "细腻的", "粗糙的",
            "脆弱的", "坚韧的", "空洞的", "充实的", "晦涩的", "直白的", "晦暗的", "明媚的", "阴郁的", "晴朗的",
            "浑浊的", "通透的", "斑驳的", "光洁的", "残缺的", "完整的", "松散的", "紧凑的", "臃肿的", "精炼的",
            "冗长的", "简洁的", "繁琐的", "协调的", "突兀的", "和谐的", "简单的", "无语的", "焦虑的", "灵巧的"
    );

    private static final List<String> OBJECT_LIST = Arrays.asList(
            "饼干", "西瓜", "牛牛", "白兔", "自行车", "冲锋枪", "火车", "高铁", "草莓", "蛋糕", "曲奇"
    );

    static {
        LETTER_LIST = new ArrayList<>();
        LETTER_LIST.addAll(LETTER_LOWER_LIST);
        LETTER_LIST.addAll(LETTER_UPPER_LIST);
    }

    /**
     * 生成随机小写字母串
     *
     * @param length 长度
     * @return 随机字母串
     */
    public static String letterLower(int length) {
        return letter(length, 1);
    }

    /**
     * 生成随机大写字母串
     *
     * @param length 长度
     * @return 随机字母串
     */
    public static String letterUpper(int length) {
        return letter(length, 2);
    }

    /**
     * 生成随机大小写混合字母串
     *
     * @param length 长度
     * @return 随机字母串
     */
    public static String letterMixed(int length) {
        return letter(length, 3);
    }

    private static String letter(int length, int type) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            switch (type) {
                case 1:
                    sb.append(LETTER_LOWER_LIST.get(random.nextInt(LETTER_LOWER_LIST.size())));
                    break;
                case 2:
                    sb.append(LETTER_UPPER_LIST.get(random.nextInt(LETTER_UPPER_LIST.size())));
                    break;
                case 3:
                    sb.append(LETTER_LIST.get(random.nextInt(LETTER_LIST.size())));
                    break;
            }
        }
        return sb.toString();
    }

    /**
     * 生成随机昵称
     *
     * @return 昵称
     */
    public static String nickname() {
        return ADJECTIVE_LIST.get(random.nextInt(ADJECTIVE_LIST.size())) +
                OBJECT_LIST.get(random.nextInt(OBJECT_LIST.size()));
    }

    /**
     * 生成随机数字符串
     *
     * @param length 长度
     * @return 随机数字符串
     */
    public static String number(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 生成 uuid
     *
     * @return uuid
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}