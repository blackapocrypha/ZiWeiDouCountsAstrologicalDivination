// 登录接口返回的数据类型
export interface jsonResult {
    /**
     * 状态
     */
    status:string,

    /**
     * 消息
     */
    message:string,

    /**
     * 数据
     */
    data:any,

    /**
     * 数量
     */
    totalsize:number,

    /**
     * 标识
     */
    success:boolean
}
