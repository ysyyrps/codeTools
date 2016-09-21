/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.model;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Description: 模板
 * @author peter.Chen
 * @date 2015年9月10日下午7:14:21
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2015年9月10日        peter.Chen           new
 * 
 */

public class TemplateProperties {

    private String createdTime;
    private String authorName;
    private SourceType sourceType;
    private String templatePath;
    private String projectPath;
    private boolean needJavaFile;

    /**
     * @return the projectPath
     */
    public String getProjectPath() {
        return projectPath;
    }

    /**
     * @param projectPath the projectPath to set
     */
    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the sourceType
     */
    public SourceType getSourceType() {
        return sourceType;
    }

    /**
     * @param sourceType the sourceType to set
     */
    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * @return the templatePath
     */
    public String getTemplatePath() {
        return templatePath;
    }

    /**
     * @param templatePath the templatePath to set
     */
    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    /**
     * @return the createdTime
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime the createdTime to set
     */
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return the needJavaFile
     */
    public boolean isNeedJavaFile() {
        return needJavaFile;
    }

    /**
     * @param needJavaFile the needJavaFile to set
     */
    public void setNeedJavaFile(boolean needJavaFile) {
        this.needJavaFile = needJavaFile;
    }

    public TemplateProperties loadProperties(String templatePath) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(templatePath + "\\template.properties"));
        TemplateProperties templateProperties = new TemplateProperties();
        templateProperties.setAuthorName(prop.getProperty("authorName"));
        templateProperties.setTemplatePath(templatePath);
        return templateProperties;
    }

    public TemplateProperties() {
        super();
    }

    public TemplateProperties(String templatePath, String projectPath, String authorName, SourceType sourceType,
            boolean needJavaFile) throws Exception {
        super();
        this.authorName = authorName;
        this.sourceType = sourceType;
        this.templatePath = templatePath;
        this.needJavaFile = needJavaFile;
        this.projectPath = projectPath;
    }
}
