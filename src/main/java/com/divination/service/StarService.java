package com.divination.service;

import com.divination.domain.vo.ZodiacVO;
import com.nlf.calendar.Lunar;

import java.util.List;

public interface StarService {

    /**
     * 获取星盘
     * @param destnayNum    命宫
     * @param ziweiNum      紫微星落
     * @param fourStarList  命四化
     * @param Lunnar        生辰相关
     * @param lifePalace    身宫
     * @param setIndex      局数
     * @param gender        性别
     * @return List<ZodiacVO>
     */
    List<ZodiacVO> getZodiacWithStar(Integer destnayNum, Integer ziweiNum, List<String> fourStarList, Lunar lunar,Integer lifePalace,Integer setIndex,Integer gender );

}
