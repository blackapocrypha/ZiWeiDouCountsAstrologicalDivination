package com.divination.service.impl;

import com.divination.domain.vo.StarVO;
import com.divination.domain.vo.ZodiacVO;
import com.divination.service.StarService;
import com.nlf.calendar.Lunar;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StarServiceImpl implements StarService {


    /**
     * 获取星盘
     *
     * @param ziweiNum     紫微星所在的星盘位置
     * @param destnayNum   命宫的星盘位置
     * @param fourStarList 命四化
     * @param lunar        生辰相关
     * @param lifePalace   身宫
     * @param setIndex     局数
     * @param gender       性别
     * @return List<ZodiacVO>
     */
    @Override
    public List<ZodiacVO> getZodiacWithStar(Integer destnayNum, Integer ziweiNum, List<String> fourStarList, Lunar lunar,Integer lifePalace,Integer setIndex,Integer gender) {
        List<ZodiacVO> stars = new ArrayList<>();

        // 在亥 巳时七杀与紫薇同宫，其他宫则紫薇与七杀根据亥巳对称
        Integer qishaNum = 0;
        if (ziweiNum == 4 || ziweiNum == 10) {
            qishaNum = ziweiNum;
        } else {
            if (ziweiNum < 8) {
                qishaNum = 8 - ziweiNum;
            } else {
                qishaNum = 20 - ziweiNum;
            }
        }

        // 七杀对宫求天府
        Integer tianfuNum = getAgainst(qishaNum);

        // 顺时针宫位
        List<String> gongList = Arrays.asList("命  宫", "父母宫", "福德宫", "田宅宫", "官禄宫", "奴仆宫", "迁移宫", "疾厄宫", "财帛宫", "子女宫", "夫妻宫", "兄弟宫");
        // 填充星宫
        for (int i = 0; i < gongList.size(); i++) {
            ZodiacVO zodiacVO = new ZodiacVO();
            if ((destnayNum + i) % 12 == 0) {
                zodiacVO.setId(12);
            } else {
                zodiacVO.setId((destnayNum + i) % 12);
            }
            zodiacVO.setName(gongList.get(i));
            // 身宫设置
            if(zodiacVO.getId().equals(lifePalace)){
                zodiacVO.setGongStatusName("身");
            }

            // 放置紫微
            putStarInZodiac(ziweiNum, "紫薇", zodiacVO, fourStarList);

            // 放置七杀
            putStarInZodiac(qishaNum, "七杀", zodiacVO, fourStarList);

            // 放置天府
            putStarInZodiac(tianfuNum, "天府", zodiacVO, fourStarList);

            // 放置天机星
            Integer tainji = ziweiNum - 1;
            putStarInZodiac(tainji, "天机", zodiacVO, fourStarList);

            // 放置太阳
            Integer sun = ziweiNum - 3;
            putStarInZodiac(sun, "太阳", zodiacVO, fourStarList);

            // 放置武曲
            Integer wuqu = ziweiNum - 4;
            putStarInZodiac(wuqu, "武曲", zodiacVO, fourStarList);

            // 放置天同
            Integer tiantong = ziweiNum - 5;
            putStarInZodiac(tiantong, "天同", zodiacVO, fourStarList);

            // 放置廉贞
            Integer lianzhen = ziweiNum - 8;
            putStarInZodiac(lianzhen, "廉贞", zodiacVO, fourStarList);

            // 放置天梁
            Integer tianliang = qishaNum - 1;
            putStarInZodiac(tianliang, "天梁", zodiacVO, fourStarList);

            // 放置巨门
            Integer jumen = qishaNum - 3;
            putStarInZodiac(jumen, "巨门", zodiacVO, fourStarList);

            // 放置贪狼
            Integer tanlang = qishaNum - 4;
            putStarInZodiac(tanlang, "贪狼", zodiacVO, fourStarList);

            // 放置太阴
            Integer moon = qishaNum - 5;
            putStarInZodiac(moon, "太阴", zodiacVO, fourStarList);

            // 放置破军
            Integer pojun = qishaNum - 8;
            putStarInZodiac(pojun, "破军", zodiacVO, fourStarList);

            // 天相在破军对宫
            Integer tianxiangNum = getAgainst(pojun);
            putStarInZodiac(tianxiangNum, "天相", zodiacVO, fourStarList);

            // 安置左辅，左辅从辰宫开始 + 月份
            Integer zuofu = (3 + lunar.getMonth() - 1) % 12;
            zuofu = zuofu == 0 ? 12 : zuofu;
            putStarInZodiac(zuofu, "左辅", zodiacVO, fourStarList);

            // 放置右弼，从戌宫开始  - 月份
            Integer youbi = 9 - lunar.getMonth() + 1;
            putStarInZodiac(youbi, "右弼", zodiacVO, fourStarList);

            // 放置文曲星，从辰宫开始 + 出生时辰地支
            Integer wenqu = (3 + lunar.getTimeZhiIndex()) % 12;
            wenqu = wenqu == 0 ? 12 : wenqu;
            putStarInZodiac(wenqu, "文曲", zodiacVO, fourStarList);

            // 放置文昌，从戌宫开始 - 出生时辰地支
            Integer wenchang = 9 - lunar.getTimeZhiIndex();
            putStarInZodiac(wenchang, "文昌", zodiacVO, fourStarList);

            // 放置禄存
            Integer lucun = getLucunStarIndex(lunar.getYearGan());
            putStarInZodiac(lucun, "禄存", zodiacVO, fourStarList);

            // 放置擎羊 为禄存 + 1 且羊不入四马之地，即不入寅申巳亥
            Integer qingyang = (lucun + 1) % 12;
            qingyang = qingyang == 0 ? 12 : qingyang;
            putStarInZodiac(qingyang, "擎羊", zodiacVO, fourStarList);

            // 放置陀螺 为禄存 -1 且羊不入四败之地，即不入子午卯酉
            Integer tuoluo = lucun - 1;
            putStarInZodiac(tuoluo, "陀螺", zodiacVO, fourStarList);

            // 放置火星
            Integer mars = (getMarsIndex(lunar.getYearZhi()) + lunar.getTimeZhiIndex()) % 12;
            mars = mars == 0 ? 12 : mars;
            putStarInZodiac(mars, "火星", zodiacVO, fourStarList);

            // 放置铃星
            Integer ling = (getLingStarIndex(lunar.getYearZhi()) + lunar.getTimeZhiIndex()) % 12;
            ling = ling == 0 ? 12 : ling;
            putStarInZodiac(ling, "铃星", zodiacVO, fourStarList);

            // 放置地空
            Integer dikong = 10 - lunar.getTimeZhiIndex();
            putStarInZodiac(dikong, "地空", zodiacVO, fourStarList);

            // 放置地劫
            Integer dijie = (10 + lunar.getTimeZhiIndex())%12;
            dijie = dijie == 0? 12 : dijie;
            putStarInZodiac(dijie, "地劫", zodiacVO, fourStarList);

            // 放置天马
            Integer house = getHeavenlyHorseStarIndex(lunar.getYearZhi());
            putStarInZodiac(house, "天马", zodiacVO, fourStarList);

            // 放置天魁
            Integer kui = getTianKuiIndex(lunar.getYearGan());
            putStarInZodiac(kui, "天魁", zodiacVO, fourStarList);

            // 放置天钺
            Integer yue = getTianYueIndex(lunar.getYearGan());
            putStarInZodiac(yue, "天钺", zodiacVO, fourStarList);

            // 放置红鸾
            Integer aphrodite = 2 - lunar.getYearZhiIndex();
            putStarInZodiac(aphrodite, "红鸾", zodiacVO, fourStarList);

            // 放置天喜
            Integer hera = 8 - lunar.getYearZhiIndex();
            putStarInZodiac(hera, "天喜", zodiacVO, fourStarList);

            // 放置天姚
            Integer tianyao = (11 + lunar.getMonth())%12;
            tianyao = tianyao==0?12:tianyao;
            putStarInZodiac(tianyao, "天姚", zodiacVO, fourStarList);

            // 放置咸池
            Integer xianchi = getXianChiIndex(lunar.getYearZhi());
            putStarInZodiac(xianchi, "咸池", zodiacVO, fourStarList);

            // 放置天刑
            Integer tianxing = (7 + lunar.getMonth()) % 12;
            tianxing = tianxing==0?12:tianxing;
            putStarInZodiac(tianxing, "天刑", zodiacVO, fourStarList);

            // 向下为相对不重要的丙丁级星耀
            // 放置龙池
            Integer dragonPool = (3 + lunar.getYearZhiIndex()) % 12;
            dragonPool = dragonPool==0?12:dragonPool;
            putStarInZodiac(dragonPool, "龙池", zodiacVO, fourStarList);

            // 放置凤阁
            Integer phoenixAttic = 9 - lunar.getYearZhiIndex();
            putStarInZodiac(phoenixAttic, "凤阁", zodiacVO, fourStarList);

            // 放置三台
            Integer threeSets = (zuofu + lunar.getDay() -1)%12;
            threeSets = threeSets==0?12:threeSets;
            putStarInZodiac(threeSets, "三台", zodiacVO, fourStarList);

            // 放置八座
            if(youbi <=0){
                youbi = 12 + youbi;
            }
            Integer eightSets = youbi - lunar.getDay() +1;
            putStarInZodiac(eightSets, "八座", zodiacVO, fourStarList);


            stars.add(zodiacVO);
        }
        // 填充宫干
        setGan(stars,lunar.getYearGan());
        // 填充大限流年
        fleetingTime(stars, lunar.getYearGan(),gender,setIndex,destnayNum);
        return stars;
    }


    /**
     * 根据当前宫的位置取对宫所在
     *
     * @param current 当前宫位置
     * @return Integer
     */
    private Integer getAgainst(Integer current) {
        // 除了巳 和 亥，其他对宫的位置分别以巳亥轴对称
        if (current <= 6) {
            return current + 6;
        } else {
            return current - 6;
        }
    }


    /**
     * 星落
     *
     * @param starNum      所在星盘编号
     * @param starName     星耀名称
     * @param zodiacVO     盘
     * @param fourStarList 四化
     */
    private void putStarInZodiac(Integer starNum, String starName, ZodiacVO zodiacVO, List<String> fourStarList) {
        if (starNum <= 0) {
            starNum = 12 + starNum;
            // 当宫ud如果跟星属id对应则落
            if (zodiacVO.getId().equals(starNum)) {
                StarVO starVO = new StarVO();
                starVO.setStarName(starName);
                // 设置生年四化
                if (fourStarList.contains(starVO.getStarName())) {
                    starVO.setQiStatus(fourStarList.indexOf(starVO.getStarName()) + 1);
                }
                zodiacVO.getStars().add(starVO);
            }
        } else {
            if (zodiacVO.getId().equals(starNum)) {
                StarVO starVO = new StarVO();
                starVO.setStarName(starName);
                // 设置生年四化
                if (fourStarList.contains(starVO.getStarName())) {
                    starVO.setQiStatus(fourStarList.indexOf(starVO.getStarName()) + 1);
                }
                zodiacVO.getStars().add(starVO);
            }
        }
    }


    /**
     * 根据天干放置禄存
     * —— ——   —— ——  —— —— —— ——
     * |  丙   |  丁  |     |  庚  |
     * —— ——  —— ——  —— —— —— ——
     * |      |            |  辛  |
     * —— ——               —— ——
     * |  乙  |            |     |
     * —— ——  —— —— —— —— —— ——
     * |  甲  |     | 癸  |  壬  |
     * —— —— —— —— —— —— —— ——
     * 东方甲乙木  西方庚辛金  南方丙丁火  北方壬癸水   戊己同丙丁火位置
     * 禄存不入四库地，即不入辰 丑 未 戌
     *
     * @param gan 生年天干
     * @return Integer
     */
    private Integer getLucunStarIndex(String gan) {
        if (Objects.equals(gan, "甲")) {
            return 1;
        } else if (Objects.equals(gan, "乙")) {
            return 2;
        } else if (Objects.equals(gan, "丙") || Objects.equals(gan, "戊")) {
            return 4;
        } else if (Objects.equals(gan, "丁") || Objects.equals(gan, "己")) {
            return 5;
        } else if (Objects.equals(gan, "庚")) {
            return 7;
        } else if (Objects.equals(gan, "辛")) {
            return 8;
        } else if (Objects.equals(gan, "壬")) {
            return 10;
        } else {
            return 11;
        }

    }


    /**
     * 根据生年地支获取火星起点
     *
     * @param yearZhi 生年地支
     * @return Integer
     */
    private Integer getMarsIndex(String yearZhi) {
        if ("申".equals(yearZhi) || "子".equals(yearZhi) || "辰".equals(yearZhi)) {
            return 1;
        } else if ("巳".equals(yearZhi) || "酉".equals(yearZhi) || "丑".equals(yearZhi)) {
            return 2;
        } else if ("寅".equals(yearZhi) || "午".equals(yearZhi) || "戌".equals(yearZhi)) {
            return 12;
        } else {
            return 8;
        }
    }


    /**
     * 获取铃星的起点
     *
     * @param yearZhi 生年地支
     * @return Integer
     */
    private Integer getLingStarIndex(String yearZhi) {
        if ("寅".equals(yearZhi) || "午".equals(yearZhi) || "戌".equals(yearZhi)) {
            return 2;
        } else {
            return 9;
        }
    }


    /**
     * 获取天马星位置
     *
     * @param yearZhi 生年地支
     * @return Integer
     */
    private Integer getHeavenlyHorseStarIndex(String yearZhi) {
        if ("申".equals(yearZhi) || "子".equals(yearZhi) || "辰".equals(yearZhi)) {
            return 1;
        } else if ("巳".equals(yearZhi) || "酉".equals(yearZhi) || "丑".equals(yearZhi)) {
            return 10;
        } else if ("寅".equals(yearZhi) || "午".equals(yearZhi) || "戌".equals(yearZhi)) {
            return 7;
        } else {
            return 4;
        }
    }

    /**
     * 设置寅首天干位置
     *
     * @param stars    星盘
     * @param yearGan  生年天干
     */
    private void setGan(List<ZodiacVO> stars, String yearGan) {
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

        // 设置天干
        for (ZodiacVO star : stars) {
            star.setGan(ganList.get(star.getId() - 1));
        }


    }


    /**
     * 获取天魁位置
     *
     * 甲戊庚牛羊
     * 乙己鼠猴乡
     * 丙丁猪鸡位
     * 六辛逢虎马
     * 壬癸兔蛇藏
     * @param yearGan  生年天干
     * @return
     */
    private Integer getTianKuiIndex(String yearGan){
        if ("甲".equals(yearGan)|| "戊".equals(yearGan) || "庚".equals(yearGan)) {
            return 12;
        } else if ("乙".equals(yearGan) || "己".equals(yearGan)) {
            return 11;
        } else if ("丙".equals(yearGan) || "丁".equals(yearGan)) {
            return 10;
        }
        else if ("辛".equals(yearGan) ) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * 获取天钺位置
     *
     * 甲戊庚牛羊
     * 乙己鼠猴乡
     * 丙丁猪鸡位
     * 六辛逢虎马
     * 壬癸兔蛇藏
     * @param yearGan  生年天干
     * @return
     */
    private Integer getTianYueIndex(String yearGan){
        if ("甲".equals(yearGan)|| "戊".equals(yearGan) || "庚".equals(yearGan)) {
            return 6;
        } else if ("乙".equals(yearGan) || "己".equals(yearGan)) {
            return 7;
        } else if ("丙".equals(yearGan) || "丁".equals(yearGan)) {
            return 8;
        }
        else if ("辛".equals(yearGan) ) {
            return 5;
        } else {
            return 4;
        }
    }


    /**
     * 获取咸池
     * @param yearZhi 生年地支
     * @return Integer
     */
    private Integer getXianChiIndex(String yearZhi){
        if ("寅".equals(yearZhi)|| "戌".equals(yearZhi) || "午".equals(yearZhi)) {
            return 2;
        }else if ("申".equals(yearZhi)|| "子".equals(yearZhi) || "辰".equals(yearZhi)) {
            return 8;
        }else if ("巳".equals(yearZhi)|| "酉".equals(yearZhi) || "丑".equals(yearZhi)) {
            return 5;
        }else{
            return 11;
        }
    }

    /**
     * 设置大限
     * @param stars        星宫
     * @param yearGan      生年天干
     * @param gender       性别
     * @param setIndex     局数
     * @param destnayNum   命宫位置
     */
    private void fleetingTime(List<ZodiacVO> stars, String yearGan,Integer gender,Integer setIndex,Integer destnayNum){
        // 找阳男阳女阴男阴女
        Integer yinyang = 0;
        if(Arrays.asList("甲","丙","戊","庚","壬").contains(yearGan)){
            yinyang = 1;
        }else{
            yinyang = -1;
        }
        if(gender.equals(1)){
            yinyang = yinyang * gender;
        }else{
            if(yinyang < 0 ){
                yinyang = 1;
            }else{
                yinyang = -1;
            }
        }

        // 填充流年
        Integer lastMax = setIndex - 1;
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            Integer from = lastMax + 1;
            Integer to = from + 9;
            hashMap.put(destnayNum.toString(),from +"-" + to);
            lastMax = to;

            destnayNum += yinyang;
            if(destnayNum > 12){
                destnayNum  %= 12;
                destnayNum = destnayNum==0?12:destnayNum;
            }
            if(destnayNum <= 0){
                destnayNum += 12;
            }
        }

        for (ZodiacVO star : stars) {
            star.setFlowYear(hashMap.get(star.getId().toString()));
        }


    }

}
