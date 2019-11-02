package com.securityjwtdemo.enums;

public enum MenuName {

    EXAMINATION_MANAGEMENT("考务管理"),

    PLAN_MANAGEMENT("计划管理"),

    ENTRY_MANAGEMENT("报名管理"),

    LAYOUT_MANAGEMENT("编排管理"),

    PAPER_MANAGEMENT("试卷管理"),

    DATA_MANAGEMENT("数据管理"),

    RECORD_MANAGEMENT("成绩管理"),

    NOTICE_MANAGEMENT("通知管理"),

    ORGANIZATION_MANAGEMENT("机构管理");

    private String name;

    private MenuName(String name){
        this.name = name;
    }

    public String getName() {
       return name;
    }
}
