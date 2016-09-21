/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.service;

import com.chasesun.codetools.model.*;

/**
 * @Description: 模版生成
 * @author peter.Chen
 * @date 2015年9月9日下午5:25:57
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2015年9月9日        peter.Chen           new
 * 
 */

public interface TemplateService {
    /**
     * 
     * @Description: 创建实体
     * @date:  2015年9月9日 下午4:32:11 
     * @author peter.Chen
     * @param entity 
     * @return 
     * @throws Exception
     */
    public String createEntityTemplate(EntityTemplate entity) throws Exception;

    /**
     * 
     * @Description: 创建dao
     * @date:  2015年9月9日 下午4:32:11 
     * @author peter.Chen
     * @param dao
     * @return 
     * @throws Exception
     */
    public String createDaoTemplate(DaoTemplate dao) throws Exception;

    /**
     * 
     * @Description: 创建res
     * @date:  2015年9月9日 下午4:32:11 
     * @author peter.Chen
     * @param res
     * @return 
     * @throws Exception
     */
    public String createResTemplate(ResTemplate res) throws Exception;

    public String createReqTemplate(ReqTemplate req) throws Exception;

    public String createControllMethodTemplate(ControllerMethodTemplate method) throws Exception;

    public String createServiceMethodTemplate(ServiceMethodTemplate method) throws Exception;

    public String createServiceImplMethodTemplate(ServiceImplMethodTemplate method) throws Exception;
}
