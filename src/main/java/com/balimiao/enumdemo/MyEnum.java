package com.balimiao.enumdemo;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2019/9/10
 **/
public enum MyEnum {

    CURRENCY(1, "通用券", "sdc"),

    GOODS(2, "商品券", "sdc"),

    NEWPEOPLE(3, "新人券", "sdc");

    private Integer code;

    private String desc;

    private String descddd;

    MyEnum(Integer code, String desc, String descddd) {
        this.code = code;
        this.desc = desc;
        this.descddd = descddd;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescddd() {
        return descddd;
    }

    public void setDescddd(String descddd) {
        this.descddd = descddd;
    }
}
