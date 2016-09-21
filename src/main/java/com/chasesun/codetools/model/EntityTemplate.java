/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.model;

import java.util.List;

/**
 * @Description: TODO
 * @author peter.Chen
 * @date 2015年9月9日下午2:12:26
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2015年9月9日        peter.Chen           new
 * 
 */

public class EntityTemplate extends BaseTemplate {
    /**
     * 实体对应的数据库表名
     */
    private String tableName;
    /**
     *  父类名
     */
    private String superclass;
    /**
     * 介绍
     */
    private String todo;

    /**
     * 属性集合
     */
    private List<Property> properties;
    /**
    * 是否有构造函数
    */
    private boolean constructors;


    public String getSuperclass() {
        return superclass;
    }

    public void setSuperclass(String superclass) {
        this.superclass = superclass;
    }

    public boolean isConstructors() {
        return constructors;
    }

    public void setConstructors(boolean constructors) {
        this.constructors = constructors;
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
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        String firstChar=className.substring(0,1);
        String endStr=className.substring(1);
        className=firstChar.toUpperCase()+endStr;
        super.setClassName(className);
    }

    public EntityTemplate() {
        super();
        setTemplateName("entity.ftl");
        setTemplateMapName("entity");
    }
}
