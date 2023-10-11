package com.divination.util;

import java.util.HashMap;

/**
 * 斗数排盘
 *
 *  —— —— —— —— —— —— —— ——
 * |  4  |  5  |  6  |  7  |
 *  —— —— —— —— —— —— —— ——
 * |  3  |           |  8  |
 *  —— ——             —— ——
 * |  2  |           |  9  |
 *  —— —— —— —— —— —— —— ——
 * |  1  | 12  | 11  |  10 |
 *  —— —— —— —— —— —— —— ——
 *
 * 按数字顺序：寅、卯、辰、巳、午、未、申、酉、戌、亥、子、丑
 *
 */
public class StarBureaUtil {


    /**
     * 找命宫的位置
     * @param month       月份
     * @param bornTime    时间地支
     * @return Integer
     */
    public static Integer getDestinyPalace(Integer month,String bornTime){
        HashMap<String, Integer> zhiMap = getDiZhiMap();
        Integer integer = zhiMap.get(bornTime) - 1;
        Integer firstCircle = month - integer;
        if(firstCircle <= 0){
            return  12 + firstCircle;
        }else{
            return firstCircle;
        }
    }

    /**
     * 取身宫
     * @param month     月份
     * @param bornTime  时间地支
     * @return Integer
     */
    public static Integer getLifePalace(Integer month,String bornTime){
        HashMap<String, Integer> zhiMap = getDiZhiMap();
        Integer integer = zhiMap.get(bornTime) - 1;
        Integer firstCircle = (month + integer) % 12;
        if(firstCircle == 0){
            return  12;
        }else{
            return firstCircle;
        }
    }


    /**
     * 获取紫微星的位置 【推算法】
     * @param numJu  月份
     * @param day  日期
     * @return Integer
     */
    public static Integer getZiweiStarByCalculate(Integer numJu, Integer day){
        //
        Integer yu = day % numJu;
        Integer chu = (day / numJu) % 12;
        if(chu==0){chu=12;}
        if(yu == 0){
            return chu;
        }


        else if(yu % 2 != 0){
            yu = chu - yu ;
            if(yu == 0){
                return 12;
            }
            if(yu < 0){
                yu = 13 + yu;
            }
        }
        else {
            yu = (chu + yu) % 12;
            if(yu ==0){yu = 12;}
        }

        return yu;
    }

    /**
     * 获取紫微星的位置 【查表发】
     * @param numJu  月份
     * @param day  日期
     * @return Integer
     */
    public static Integer getZiweiStarByTable(Integer numJu, Integer day){
        if(day.equals(1)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("丑");
                case 3:
                    return getDiZhiPanMap().get("辰");
                case 4:
                    return getDiZhiPanMap().get("亥");
                case 5:
                    return getDiZhiPanMap().get("午");
                default:
                    return getDiZhiPanMap().get("酉");
            }
        }
        else if(day.equals(2)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("寅");
                case 3:
                    return getDiZhiPanMap().get("丑");
                case 4:
                    return getDiZhiPanMap().get("辰");
                case 5:
                    return getDiZhiPanMap().get("亥");
                default:
                    return getDiZhiPanMap().get("午");
            }
        }
        else if(day.equals(3)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("寅");
                case 3:
                    return getDiZhiPanMap().get("寅");
                case 4:
                    return getDiZhiPanMap().get("丑");
                case 5:
                    return getDiZhiPanMap().get("辰");
                default:
                    return getDiZhiPanMap().get("亥");
            }
        }
        else if(day.equals(4)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("卯");
                case 3:
                    return getDiZhiPanMap().get("巳");
                case 4:
                    return getDiZhiPanMap().get("寅");
                case 5:
                    return getDiZhiPanMap().get("丑");
                default:
                    return getDiZhiPanMap().get("辰");
            }
        }
        else if(day.equals(5)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("卯");
                case 3:
                    return getDiZhiPanMap().get("寅");
                case 4:
                    return getDiZhiPanMap().get("子");
                case 5:
                    return getDiZhiPanMap().get("寅");
                default:
                    return getDiZhiPanMap().get("丑");
            }
        }
        else if(day.equals(6)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("辰");
                case 3:
                    return getDiZhiPanMap().get("卯");
                case 4:
                    return getDiZhiPanMap().get("巳");
                case 5:
                    return getDiZhiPanMap().get("未");
                default:
                    return getDiZhiPanMap().get("寅");
            }
        }
        else if(day.equals(7)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("辰");
                case 3:
                    return getDiZhiPanMap().get("午");
                case 4:
                    return getDiZhiPanMap().get("寅");
                case 5:
                    return getDiZhiPanMap().get("子");
                default:
                    return getDiZhiPanMap().get("戌");
            }
        }
        else if(day.equals(8)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("巳");
                case 3:
                    return getDiZhiPanMap().get("卯");
                case 4:
                    return getDiZhiPanMap().get("卯");
                case 5:
                    return getDiZhiPanMap().get("巳");
                default:
                    return getDiZhiPanMap().get("未");
            }
        }
        else if(day.equals(9)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("巳");
                case 3:
                    return getDiZhiPanMap().get("辰");
                case 4:
                    return getDiZhiPanMap().get("丑");
                case 5:
                    return getDiZhiPanMap().get("寅");
                default:
                    return getDiZhiPanMap().get("子");
            }
        }
        else if(day.equals(10)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("午");
                case 3:
                    return getDiZhiPanMap().get("未");
                case 4:
                    return getDiZhiPanMap().get("午");
                case 5:
                    return getDiZhiPanMap().get("卯");
                default:
                    return getDiZhiPanMap().get("巳");
            }
        }
        else if(day.equals(11)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("午");
                case 3:
                    return getDiZhiPanMap().get("辰");
                case 4:
                    return getDiZhiPanMap().get("卯");
                case 5:
                    return getDiZhiPanMap().get("申");
                default:
                    return getDiZhiPanMap().get("寅");
            }
        }
        else if(day.equals(12)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("未");
                case 3:
                    return getDiZhiPanMap().get("巳");
                case 4:
                    return getDiZhiPanMap().get("辰");
                case 5:
                    return getDiZhiPanMap().get("丑");
                default:
                    return getDiZhiPanMap().get("卯");
            }
        }
        else if(day.equals(13)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("未");
                case 3:
                    return getDiZhiPanMap().get("申");
                case 4:
                    return getDiZhiPanMap().get("寅");
                case 5:
                    return getDiZhiPanMap().get("午");
                default:
                    return getDiZhiPanMap().get("亥");
            }
        }
        else if(day.equals(14)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("申");
                case 3:
                    return getDiZhiPanMap().get("巳");
                case 4:
                    return getDiZhiPanMap().get("未");
                case 5:
                    return getDiZhiPanMap().get("卯");
                default:
                    return getDiZhiPanMap().get("申");
            }
        }
        else if(day.equals(15)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("申");
                case 3:
                    return getDiZhiPanMap().get("午");
                case 4:
                    return getDiZhiPanMap().get("辰");
                case 5:
                    return getDiZhiPanMap().get("辰");
                default:
                    return getDiZhiPanMap().get("丑");
            }
        }
        else if(day.equals(16)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("酉");
                case 3:
                    return getDiZhiPanMap().get("酉");
                case 4:
                    return getDiZhiPanMap().get("巳");
                case 5:
                    return getDiZhiPanMap().get("酉");
                default:
                    return getDiZhiPanMap().get("午");
            }
        }
        else if(day.equals(17)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("酉");
                case 3:
                    return getDiZhiPanMap().get("午");
                case 4:
                    return getDiZhiPanMap().get("卯");
                case 5:
                    return getDiZhiPanMap().get("寅");
                default:
                    return getDiZhiPanMap().get("卯");
            }
        }
        else if(day.equals(18)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("戌");
                case 3:
                    return getDiZhiPanMap().get("未");
                case 4:
                    return getDiZhiPanMap().get("申");
                case 5:
                    return getDiZhiPanMap().get("未");
                default:
                    return getDiZhiPanMap().get("辰");
            }
        }
        else if(day.equals(19)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("戌");
                case 3:
                    return getDiZhiPanMap().get("戌");
                case 4:
                    return getDiZhiPanMap().get("巳");
                case 5:
                    return getDiZhiPanMap().get("辰");
                default:
                    return getDiZhiPanMap().get("子");
            }
        }
        else if(day.equals(20)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("亥");
                case 3:
                    return getDiZhiPanMap().get("未");
                case 4:
                    return getDiZhiPanMap().get("午");
                case 5:
                    return getDiZhiPanMap().get("巳");
                default:
                    return getDiZhiPanMap().get("酉");
            }
        }
        else if(day.equals(21)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("亥");
                case 3:
                    return getDiZhiPanMap().get("申");
                case 4:
                    return getDiZhiPanMap().get("辰");
                case 5:
                    return getDiZhiPanMap().get("戌");
                default:
                    return getDiZhiPanMap().get("寅");
            }
        }     else if(day.equals(22)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("子");
                case 3:
                    return getDiZhiPanMap().get("亥");
                case 4:
                    return getDiZhiPanMap().get("酉");
                case 5:
                    return getDiZhiPanMap().get("卯");
                default:
                    return getDiZhiPanMap().get("未");
            }
        }
        else if(day.equals(23)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("子");
                case 3:
                    return getDiZhiPanMap().get("申");
                case 4:
                    return getDiZhiPanMap().get("午");
                case 5:
                    return getDiZhiPanMap().get("申");
                default:
                    return getDiZhiPanMap().get("辰");
            }
        }
        else if(day.equals(24)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("丑");
                case 3:
                    return getDiZhiPanMap().get("酉");
                case 4:
                    return getDiZhiPanMap().get("未");
                case 5:
                    return getDiZhiPanMap().get("巳");
                default:
                    return getDiZhiPanMap().get("巳");
            }
        }
        else if(day.equals(25)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("丑");
                case 3:
                    return getDiZhiPanMap().get("子");
                case 4:
                    return getDiZhiPanMap().get("巳");
                case 5:
                    return getDiZhiPanMap().get("午");
                default:
                    return getDiZhiPanMap().get("丑");
            }
        }
        else if(day.equals(26)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("寅");
                case 3:
                    return getDiZhiPanMap().get("酉");
                case 4:
                    return getDiZhiPanMap().get("戌");
                case 5:
                    return getDiZhiPanMap().get("亥");
                default:
                    return getDiZhiPanMap().get("戌");
            }
        }
        else if(day.equals(27)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("寅");
                case 3:
                    return getDiZhiPanMap().get("戌");
                case 4:
                    return getDiZhiPanMap().get("未");
                case 5:
                    return getDiZhiPanMap().get("辰");
                default:
                    return getDiZhiPanMap().get("卯");
            }
        }
        else if(day.equals(28)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("卯");
                case 3:
                    return getDiZhiPanMap().get("丑");
                case 4:
                    return getDiZhiPanMap().get("申");
                case 5:
                    return getDiZhiPanMap().get("酉");
                default:
                    return getDiZhiPanMap().get("申");
            }
        }
        else if(day.equals(29)){
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("卯");
                case 3:
                    return getDiZhiPanMap().get("戌");
                case 4:
                    return getDiZhiPanMap().get("午");
                case 5:
                    return getDiZhiPanMap().get("午");
                default:
                    return getDiZhiPanMap().get("巳");
            }
        }
        else {
            switch (numJu) {
                case 2:
                    return getDiZhiPanMap().get("辰");
                case 3:
                    return getDiZhiPanMap().get("亥");
                case 4:
                    return getDiZhiPanMap().get("亥");
                case 5:
                    return getDiZhiPanMap().get("未");
                default:
                    return getDiZhiPanMap().get("午");
            }
        }
    }


    /**
     * 得到地支顺序Map
     * @return HashMap<String,Integer>
     */
    public static HashMap<String,Integer> getDiZhiMap(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("子",1);
        hashMap.put("丑",2);
        hashMap.put("寅",3);
        hashMap.put("卯",4);
        hashMap.put("辰",5);
        hashMap.put("巳",6);
        hashMap.put("午",7);
        hashMap.put("未",8);
        hashMap.put("申",9);
        hashMap.put("酉",10);
        hashMap.put("戌",11);
        hashMap.put("亥",12);
        return hashMap;
    }


    /**
     * 得到盘子中的地支顺序Map
     * @return HashMap<String,Integer>
     */
    public static HashMap<String,Integer> getDiZhiPanMap(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("子",11);
        hashMap.put("丑",12);
        hashMap.put("寅",1);
        hashMap.put("卯",2);
        hashMap.put("辰",3);
        hashMap.put("巳",4);
        hashMap.put("午",5);
        hashMap.put("未",6);
        hashMap.put("申",7);
        hashMap.put("酉",8);
        hashMap.put("戌",9);
        hashMap.put("亥",10);
        return hashMap;
    }

}
