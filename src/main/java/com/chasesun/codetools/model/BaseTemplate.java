/**  
 * Copyright © 2016jkzl. All rights reserved. 
 */
package com.chasesun.codetools.model;

/**
 * @Description: TODO
 * @author peter.Chen
 * @date 2016年2月13日上午11:06:29
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2016年2月13日        peter.Chen           new
 * 
 */

public class BaseTemplate {
    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 模板内map对象名称
     */
    private String templateMapName;
    /**
     * 所在的包名
     */
    private String javaPackage;
    /**
     * 类名
     */
    private String className;

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the templateName
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * @param templateName the templateName to set
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * @return the templateMapName
     */
    public String getTemplateMapName() {
        return templateMapName;
    }

    /**
     * @param templateMapName the templateMapName to set
     */
    public void setTemplateMapName(String templateMapName) {
        this.templateMapName = templateMapName;
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

}
