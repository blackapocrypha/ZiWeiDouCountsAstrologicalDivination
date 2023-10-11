package com.divination.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 命四化工具类  【禄 权 科 忌】
 */
public class FourDestinyStarshineUtil {


    /**
     * 获取命四化词条
     * @param yearGan  年份天干
     * @return String（如 "廉贞 破军 武曲 太阳"）
     */
    public static String getFourStarTag(String yearGan){

        if(Objects.equals(yearGan,"甲")){
            return "廉贞 破军 武曲 太阳";
        }else if(Objects.equals(yearGan,"乙")){
            return "天机 天梁 紫薇 太阴";
        }
        else if(Objects.equals(yearGan,"丙")){
            return "天同 天机 文昌 廉贞";
        }
        else if(Objects.equals(yearGan,"丁")){
            return "太阳 天同 天机 巨门";
        }
        else if(Objects.equals(yearGan,"戊")){
            return "贪狼 太阴 右弼 天机";
        }
        else if(Objects.equals(yearGan,"己")){
            return "武曲 贪狼 天梁 文曲";
        }
        else if(Objects.equals(yearGan,"庚")){
            return "太阳 武曲 太阴 天同";
        }
        else if(Objects.equals(yearGan,"辛")){
            return "巨门 太阳 文曲 文昌";
        }
        else if(Objects.equals(yearGan,"壬")){
            return "天梁 紫薇 左辅 武曲";
        }
        else {
            return "破军 巨门 太阴 贪狼";
        }
    }

    /**
     * 获取命四化数组
     * @param yearGan  年份天干
     * @return String（如 "廉贞 破军 武曲 太阳"）
     */
    public static List<String> getFourStarList(String yearGan){

        if(Objects.equals(yearGan,"甲")){
            return Arrays.asList("廉贞", "破军", "武曲", "太阳");
        }else if(Objects.equals(yearGan,"乙")){
            return Arrays.asList("天机", "天梁", "紫薇", "太阴");
        }
        else if(Objects.equals(yearGan,"丙")){
            return Arrays.asList("天同", "天机", "文昌", "廉贞");
        }
        else if(Objects.equals(yearGan,"丁")){
            return Arrays.asList("太阳", "天同", "天机", "巨门");
        }
        else if(Objects.equals(yearGan,"戊")){
            return Arrays.asList("贪狼", "太阴", "右弼", "天机");
        }
        else if(Objects.equals(yearGan,"己")){
            return Arrays.asList("武曲", "贪狼", "天梁", "文曲");
        }
        else if(Objects.equals(yearGan,"庚")){
            return Arrays.asList("太阳", "武曲", "太阴", "天同");
        }
        else if(Objects.equals(yearGan,"辛")){
            return Arrays.asList("巨门", "太阳", "文曲", "文昌");
        }
        else if(Objects.equals(yearGan,"壬")){
            return Arrays.asList("天梁", "紫薇", "左辅", "武曲");
        }
        else {
            return Arrays.asList("破军", "巨门" ,"太阴","贪狼");
        }
    }

}
