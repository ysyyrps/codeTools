/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.model;

/**
 * @Description: 属性
 * @author peter.Chen
 * @date 2015年9月9日下午2:10:18
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2015年9月9日        peter.Chen           new
 * 
 */

public class Property {
    /**
     * 属性名称
     */
    private String propertyName;
    /**
     * 属性首字母变大写
     */
    private String firstCapitalName;
    /**
     * 列名
     */
    private String columnName;
    /**
     * 中文名
     */
    private String cnName;
    /**
     * 是否能为空
     */
    private boolean nullable=true;
    /**
     * 类型
     */
    private PropertyType propertyType;


    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
        String first = this.propertyName.substring(0, 1);
        String result = first.toUpperCase()+this.propertyName.substring(1);
        this.firstCapitalName=result;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * @return the columnName
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * @param columnName the columnName to set
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * @return the cnName
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * @param cnName the cnName to set
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * @return the firstCapitalName
     */
    public String getFirstCapitalName() {
        return firstCapitalName;
    }

    /**
     * @param firstCapitalName the firstCapitalName to set
     */
    public void setFirstCapitalName(String firstCapitalName) {
        this.firstCapitalName = firstCapitalName;
    }

    /**
     * @return the nullable
     */
    public boolean isNullable() {
        return nullable;
    }

    /**
     * @param nullable the nullable to set
     */
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

   

}
