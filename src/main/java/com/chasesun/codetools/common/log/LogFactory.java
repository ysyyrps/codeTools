/**  
 * Copyright © 2015jkzl. All rights reserved.
 */
package com.chasesun.codetools.common.log;



import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * @Description: TODO
 * @author JKZL
 * @date 2015年9月29日下午1:51:47
 * @version 1.0
 *
 * operation
 * date         operator            content
 * 2015年9月29日      ZX                新建
 * 
 */
public class LogFactory {
    
    public static Logger getLogger(Class<?> clazz) {
        
        Logger log = Logger.getLogger(clazz);
//        String folderPath =
//                LogFactory.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        String path=LogFactory.class.getResource("/log4j.xml").getPath();
//        String path =  "I:/log/log4j.xml";
        DOMConfigurator.configure(path);
        return log;
    }
}
