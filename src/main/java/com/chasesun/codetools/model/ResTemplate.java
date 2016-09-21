/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.model;

import java.util.List;

/**
 * @Description:    请求响应
 * @author peter.Chen
 * @date 2015年9月18日上午9:14:26
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2015年9月18日        peter.Chen           new
 * 
 */

public class ResTemplate extends BaseTemplate{
    /**
     * 实体所在的包名
     */
    private String javaPackage;
    /**
     * 介绍
     */
    private String todo;

    /**
     * 属性集合
     */
    private List<Property> properties;

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
     * @return the javaPackage
     */
    public String getJavaPackage() {
        return javaPackage;
    }

    /**
     * @param javaPackage the javaPackage to set
     */
    public void setJavaPackage(String javaPackage) {
        this.javaPackage = javaPackage;
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
    * 
    * @Description:
    * @date:  2016年2月14日 下午2:22:45 
    * @author peter.Chen
    * @param className 
    * @param isNormal  是否是普通的res
    * @return void
    * @throws Exception
    */
    public void setResClassName(String className,boolean isNormal) {
        String firstChar=className.substring(0,1);
        String endStr=className.substring(1);
        className=firstChar.toUpperCase()+endStr;
        if(isNormal){
            className+="Res";
        }
        super.setClassName(className);
    }

    public ResTemplate() {
        super();
        setTemplateName("res.ftl");
        setTemplateMapName("res");
    }

}
