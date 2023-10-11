package com.divination.util;

import com.divination.domain.dto.FiveElementsBureauDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 获取五行局
 */
public class FiveElementsBureauUtil {


    /**
     * 获取五行局
     *
     * @param yearGan 年份的天干
     * @param destinyPalace 命宫位置
     * @return FiveElementsBureauDTO
     * <p>
     * 六十甲子纳音表：
     * 甲子、乙丑，海中金； 丙寅、丁卯，炉中火； 戊辰、己巳，大林木；
     * 　　庚午、辛未，路旁土； 壬申、癸酉，剑锋金； 甲戌、乙亥，山头火；
     * 　　丙子、丁丑，涧下水； 戊寅、己卯，城墙土； 庚辰、辛巳，白腊金；
     * 　　壬午、癸未，杨柳木； 甲申、乙酉，泉中水； 丙戌、丁亥，屋上土；
     * 　　戊子、己丑，霹雳火； 庚寅、辛卯，松柏木； 壬辰、癸巳，长流水；
     * 　　甲午、乙未，沙中金； 丙申、丁酉，山下火； 戊戌、己亥，平地木；
     * 　　庚子、辛丑，壁上土； 壬寅、癸卯，金箔金； 甲辰、乙巳，佛灯火；
     * 　　丙午、丁未，天河水； 戊申、己酉，大驿土； 庚戌、辛亥，钗钏金；
     * 　　壬子、癸丑，桑柘木； 甲寅、乙卯，大溪水； 丙辰、丁巳，沙中土；
     * 　　戊午、己未，天上火； 庚申、辛酉，石榴木； 壬戌、癸亥，大海水。
     */
    public static FiveElementsBureauDTO getBureau(String yearGan, Integer destinyPalace) {
        FiveElementsBureauDTO bureauDTO = new FiveElementsBureauDTO();
        if (Objects.isNull(yearGan) || Objects.isNull(destinyPalace)) {
            return null;
        }
        List<String> zhiList = Arrays.asList("","寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥","子", "丑");
        // 取命宫的天干地支
        String target = getDestinyGanList(yearGan).get(destinyPalace-1) +zhiList.get(destinyPalace);
        if (Arrays.asList("甲子", "乙丑", "壬申", "癸酉", "庚辰", "辛巳", "甲午", "乙未", "壬寅", "癸卯", "庚戌", "辛亥").contains(target)) {
            bureauDTO.setIntSet(4);
            bureauDTO.setNameSet("金四局");
        } else if (Arrays.asList("丙寅", "丁卯", "乙亥", "甲戌", "戊子", "己丑", "丙申", "丁酉", "甲辰", "乙巳", "戊午", "己未").contains(target)) {
            bureauDTO.setIntSet(6);
            bureauDTO.setNameSet("火六局");
        } else if (Arrays.asList("戊辰", "己巳", "壬午", "癸未", "庚寅", "辛卯", "戊戌", "己亥", "壬子", "癸丑", "庚申", "辛酉").contains(target)) {
            bureauDTO.setIntSet(3);
            bureauDTO.setNameSet("木三局");
        } else if (Arrays.asList("丙子", "丁丑", "甲申", "乙酉", "壬辰", "癸巳", "丙午", "丁未", "甲寅", "乙卯", "壬戌", "癸亥").contains(target)) {
            bureauDTO.setIntSet(2);
            bureauDTO.setNameSet("水二局");
        } else {
            bureauDTO.setIntSet(5);
            bureauDTO.setNameSet("土五局");
        }
        return bureauDTO;
    }

    /**
     * 盘内天干
     * @param yearGan 生年干
     * @return List<String>
     */
    public static List<String>  getDestinyGanList(String yearGan){
        List<String> ganList = new ArrayList<>();
        // "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛",  "壬", "癸"
        if ("甲".equals(yearGan) || "己".equals(yearGan)) {
            ganList = Arrays.asList("丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁");
        } else if ("乙".equals(yearGan) || "庚".equals(yearGan)) {
            ganList = Arrays.asList("戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己");
        } else if ("丙".equals(yearGan) || "辛".equals(yearGan)) {
            ganList = Arrays.asList("庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛");
        } else if ("丁".equals(yearGan) || "壬".equals(yearGan)) {
            ganList = Arrays.asList("壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸");
        } else {
            ganList = Arrays.asList("甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙");
        }
        return ganList;
    }

}
