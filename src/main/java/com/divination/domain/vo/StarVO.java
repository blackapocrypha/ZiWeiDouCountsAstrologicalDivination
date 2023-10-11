package com.divination.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 星耀
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarVO {

    /**
     * 星耀名称
     */
    private String starName;

    /**
     * 星耀编号
     */
    private Long starNo;


    /**
     * 星耀四化状态 1化禄 2化权 3化科 4化忌  0无
     */
    private Integer qiStatus = 0;

    /**
     * 星耀亮度状态 1庙  2旺  3平  4闲  5陷  0无
     */
    private Integer lightStatus = 0;

}
