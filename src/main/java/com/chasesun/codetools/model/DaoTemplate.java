package com.chasesun.codetools.model;

public class DaoTemplate extends BaseTemplate {
    /**
     * 介绍
     */
    private String todo;

    /**
     * @return the todo
     */
    public String getTodo() {
        return todo;
    }

    /**
     * @param todo the todo to set
     */
    public void setTodo(String todo) {
        this.todo = todo;
    }


    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        String firstChar=className.substring(0,1);
        String endStr=className.substring(1);
        className=firstChar.toUpperCase()+endStr+"Dao";
        super.setClassName(className);
    }

    public DaoTemplate() {
        super();
        setTemplateName("dao.ftl");
        setTemplateMapName("dao");
    }
}
