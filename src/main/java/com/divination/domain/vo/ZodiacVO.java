package com.divination.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 十二宫
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZodiacVO {

    /**
     * id
     */
    private Integer id;

    /**
     * 宫名
     */
    private String name;

    /**
     * 年份
     */
    private String flowYear;

    /**
     * 星
     */
    private List<StarVO> stars = new ArrayList<>();

    /**
     * 宫干
     */
    private String gan;

    /**
     * 长生十二宫
     */
    private String zodiacName;

    /**
     * 特殊的宫位状态
     */
    private String gongStatusName;
}
