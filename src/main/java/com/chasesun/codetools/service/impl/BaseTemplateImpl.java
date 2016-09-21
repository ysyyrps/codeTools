/**  
 * Copyright © 2016jkzl. All rights reserved. 
 */
package com.chasesun.codetools.service.impl;

import com.chasesun.codetools.model.BaseTemplate;
import com.chasesun.codetools.model.SourceType;
import com.chasesun.codetools.model.TemplateProperties;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @author peter.Chen
 * @date 2016年2月13日上午11:03:17
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2016年2月13日        peter.Chen           new
 * 
 */

public class BaseTemplateImpl {
    public String createTemplate(BaseTemplate baseTemplate, TemplateProperties templateProperties) throws Exception {
        Configuration cfg = new Configuration();
        String filePath = "";
        try {
            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
            cfg.setDirectoryForTemplateLoading(new File(templateProperties.getTemplatePath()));
            cfg.setObjectWrapper(new DefaultObjectWrapper());

            // 步骤二：获取 模板文件
            Template template = cfg.getTemplate(baseTemplate.getTemplateName());

            // 步骤三：创建 数据模型
            Map<String, Object> map = createMap(templateProperties, baseTemplate);

            // 步骤四：合并 模板 和 数据模型
            // 创建.java类文件
            boolean needJavaFile = templateProperties.isNeedJavaFile();
            if (needJavaFile) {
                String javaPackage = baseTemplate.getJavaPackage();
                String javaClassName = baseTemplate.getClassName();
                File javaFile = createJavaFile(templateProperties, javaPackage, javaClassName);
                if (javaFile != null) {
                    // 合并模型
                    FileOutputStream outputStream = new FileOutputStream(javaFile);
                    OutputStreamWriter javaWriter = new OutputStreamWriter(outputStream, Charset.forName("utf-8"));
                    template.process(map, javaWriter);
                    javaWriter.flush();
                    filePath = javaFile.getCanonicalPath();
                    System.out.println("文件生成路径：" + filePath);
                    javaWriter.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    private Map<String, Object> createMap(TemplateProperties templateProperties, BaseTemplate baseTemplate) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", templateProperties.getAuthorName());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("createdTime", sf.format(new Date()));
        map.put(baseTemplate.getTemplateMapName(), baseTemplate);
        return map;
    }

    /**
     * 创建.java文件所在路径 和 返回.java文件File对象
     * @param templateProperties 配置信息
     * @param javaPackage java包名
     * @param javaClassName java类名
     * @return
     */
    private File createJavaFile(TemplateProperties templateProperties, String javaPackage, String javaClassName) {

        // 创建.java类文件

        String projectPath = templateProperties.getProjectPath();
        if (projectPath != null && !projectPath.equals("")) {

        } else {
            projectPath = "./";
        }
        SourceType sourceType = templateProperties.getSourceType();
        String sourceName = "";
        if (sourceType == null) {
            sourceName = "";
        } else {
            sourceName = SourceType.getSourceTypeStr(sourceType) + ".";
        }
        javaPackage = sourceName + javaPackage;
        projectPath += javaPackage.replace('.', '/');
        File packageDirectory = new File(projectPath);
        if (!packageDirectory.exists()) {
            packageDirectory.mkdirs();
        }
        File file = new File(packageDirectory, javaClassName + ".java");
        return file;
    }

}
