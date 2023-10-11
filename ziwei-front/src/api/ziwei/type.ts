// 查询请求参数
export interface requestModel {
  /**
   * 生日
   */
  birth?: string;

  /**
   * 性别
   */
  gender?: number;
}

// 星耀
export interface star {
  /**
   * 星耀名称
   */
  starName?: string;

  /**
   * 星耀编号
   */
  starNo?: number;

  /**
   * 星耀四化状态 1化禄 2化权 3化科 4化忌  0无
   */
  qiStatus?: number;

  /**
   * 星耀亮度状态 1庙  2旺  3平  4闲  5陷  0无
   */
  lightStatus?: number;
}

// 星盘
export interface zodiac {
  /**
   * 编号
   */
  id?: number;

  /**
   * 宫名
   */
  name?: string;

  /**
   * 星耀列表
   */
  stars?: Array<star>;

  /**
   * 大运
   */
  flowYear?: string;

  /**
   * 天干
   */
  gan?: string;

  /**
   * 特殊的宫位置状态
   */
  gongStatusName?: string;
}
