package com.divination.util;



import java.util.List;

/**
 * 标准返回结果集
 */
public class JsonResult {


    public static String STATUS_SUCCESS="20000";

    public static String STATUS_ERROR="20001";

    // 状态
    private String status;

    // 消息
    private String message;


    // 返回数据
    private Object data;

    // 总数
    private Long totalsize;

    public JsonResult() {

    }

    public JsonResult(String status, String message, Object data) {
        this.status=status;
        this.message=message;
        this.data=data;
    }

    public JsonResult(String status, String message, Object data,Long totalsize) {
        this.status=status;
        this.message=message;
        this.data=data;
        this.totalsize = totalsize;
    }


    public JsonResult(String status, String message) {
        this.status=status;
        this.message=message;
        this.data=null;
    }

    public String getStatus() {
        return status;
    }

    public boolean isSuccess(){
        return this.status.equals(JsonResult.STATUS_SUCCESS);
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(Long totalsize) {
        this.totalsize = totalsize;
    }

    /**
     * 构造一个成功返回
     * @return
     */
    public JsonResult buildTrue(){
        this.status = JsonResult.STATUS_SUCCESS;
        this.message = null;
        this.data = null;
        return this;
    }
    public JsonResult buildTrue(String message){
        this.status = JsonResult.STATUS_SUCCESS;
        this.message = message;
        this.data = null;
        return this;
    }

    public void buildTrue(long totalSize, List root) {
        this.data = root;
        this.status = JsonResult.STATUS_SUCCESS;
        this.totalsize = totalSize;
    }

    /**
     * 构造一个失败返回
     * @return
     */
    public JsonResult buildFalse(String errorMessage){
        this.status = JsonResult.STATUS_ERROR;
        this.message = errorMessage;
        this.data = null;
        return this;
    }



    /**
     * 检查结果是否成功
     * @return
     */
    public boolean check(){
        return JsonResult.STATUS_SUCCESS.equals(status);
    }
}
