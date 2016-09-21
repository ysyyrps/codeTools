/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.model;

import java.util.List;

/**
 * @Description: 请求模板
 * @author peter.Chen
 * @date 2015年9月10日下午5:11:05
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2015年9月10日        peter.Chen           new
 * 
 */

public class ReqTemplate extends BaseTemplate {

    /**
     *  父类名
     */
    private String superClass = "CommonReqPoJo";
    /**
     * 介绍
     */
    private String todo;

    /**
     * 属性集合
     */
    private List<Property> properties;

    /**
     * @return the superClass
     */
    public String getSuperClass() {
        return superClass;
    }

    /**
     * @param superClass the superClass to set
     */
    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

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
     * @return the properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    /**
     * @param className the className to set
     */
    
    public void setClassName(String className) {
        String firstChar=className.substring(0,1);
        String endStr=className.substring(1);
        className=firstChar.toUpperCase()+endStr+"Req";
        super.setClassName(className);
    }

    public ReqTemplate() {
        super();
        setTemplateName("req.ftl");
        setTemplateMapName("req");
    }
}
