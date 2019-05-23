package com.aaron.enums;

/**
 * @author: lfl
 * @description:
 * @date: Create in 2019/5/2 下午 01:02
 */
public enum LogEnum {

    /**
     * bussiness
     */
    BUSSINESS("bussiness"),

    /**
     * platform
     */
    PLATFORM("platform"),

    /**
     * db
     */
    DB("db"),

    /**
     * exception
     */
    EXCEPTION("exception"),;

    private String category;

    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
