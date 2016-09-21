/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.service.impl;

import com.chasesun.codetools.model.*;
import com.chasesun.codetools.service.TemplateService;

/**
 * @Description: 模板接口
 * @author peter.Chen
 * @date 2015年9月9日下午5:28:32
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2015年9月9日        peter.Chen           new
 * 
 */

public class TemplateServiceImpl extends BaseTemplateImpl implements TemplateService{

    private TemplateProperties templateProperties;

    public TemplateServiceImpl() {
    }

    public TemplateServiceImpl(String templatePath) throws Exception {
        templateProperties = new TemplateProperties().loadProperties(templatePath);
    }


    public TemplateServiceImpl(TemplateProperties templateProperties)
            throws Exception {
        this.templateProperties = templateProperties;
    }

    @Override
    public String createEntityTemplate(EntityTemplate entity) throws Exception {

        return createTemplate(entity, templateProperties);
    }

    @Override
    public String createDaoTemplate(DaoTemplate dao) throws Exception {
        return createTemplate(dao, templateProperties);
    }

    @Override
    public String createResTemplate(ResTemplate res) throws Exception {

        return createTemplate(res, templateProperties);
    }

    @Override
    public String createReqTemplate(ReqTemplate req) throws Exception {
        return createTemplate(req, templateProperties);

    }
    @Override
    public String createControllMethodTemplate(ControllerMethodTemplate temp) throws Exception {
        return createTemplate(temp, templateProperties);
        
    }


    @Override
    public String createServiceMethodTemplate(ServiceMethodTemplate method) throws Exception {
        
        return createTemplate(method, templateProperties);
    }

    @Override
    public String createServiceImplMethodTemplate(ServiceImplMethodTemplate method) throws Exception {
        return createTemplate(method, templateProperties);
    }

    /**
     * @return the templateProperties
     */
    public TemplateProperties getTemplateProperties() {
        return templateProperties;
    }

    /**
     * @param templateProperties the templateProperties to set
     */
    public void setTemplateProperties(TemplateProperties templateProperties) {
        this.templateProperties = templateProperties;
    }
}
