/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.model;

import java.util.List;

/**
 * @Description: 方法内模板
 * @author peter.Chen
 * @date 2015年9月10日下午5:11:05
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2015年9月10日        peter.Chen           new
 * 
 */

public class ServiceMethodTemplate extends BaseTemplate {

    /**
     * 介绍
     */
    private String todo;
    /**
    * 方法名
    */
    private String methodName;
    /**
     * 请求类的名称
     */
    private String methodReqName;
    /**
     * 返回类型
     */
    private ResType resType;
    /**
     * 返回类 类的名称（未加工）
     */
    private String simpleResName;
    /**
     * 模板中  返回类的名称（已加工）
     */
    private String returnResName;

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
     * @return the methodName
     */
    public String getMethodName() {
        return methodName;
    }

   /**
    * 
    * @Description: TODO
    * @date:  2016年2月14日 下午3:02:53 
    * @author peter.Chen
    * @param methodName
    * @param resName 返回类名称（假如类型是normal可不传)
    * @param resType 
    * @return void
    * @throws Exception
    */
    public void setMethodNameAndResName(String methodName,String resName,ResType resType) {
        this.methodName = methodName;
        this.setResType(resType);
        if(resName==null || "".equals(resName)){
            this.simpleResName=methodName;
        }else{
            this.simpleResName=resName;
        }
        String firstChar = simpleResName.substring(0, 1);
        String endStr = simpleResName.substring(1);
        this.simpleResName=firstChar.toUpperCase() + endStr;
        // 顺便赋值
        this.methodReqName = getMethodReqName();
        this.returnResName = getReturnResName();
    }

    public String getMethodReqName() {

        String firstChar = methodName.substring(0, 1);
        String endStr = methodName.substring(1);
        String reqName = firstChar.toUpperCase() + endStr + "Req";
        return reqName;
    }
    public String getReturnResName(){
        String methodResName="";
        ResType resType=this.resType;
        if(ResType.normal.equals(resType)){
            String firstChar = methodName.substring(0, 1);
            String endStr = methodName.substring(1);
            methodResName=firstChar.toUpperCase() + endStr+"Res";
            
        }else {
            String firstChar = simpleResName.substring(0, 1);
            String endStr = simpleResName.substring(1);
            String newResName=firstChar.toUpperCase() + endStr;
            if(ResType.list.equals(resType)){
                methodResName="List<"+newResName+">";
            }else if(ResType.page.equals(resType)){
                methodResName="PagePoJo<"+newResName+">";
            }
        }
        return methodResName;
    }
    

    /**
     * @return the resType
     */
    public ResType getResType() {
        return resType;
    }

    /**
     * @param resType the resType to set
     */
    public void setResType(ResType resType) {
        this.resType = resType;
    }

    /**
     * @return the simpleResName
     */
    public String getSimpleResName() {
        return simpleResName;
    }

    /**
     * @param simpleResName the simpleResName to set
     */
    public void setSimpleResName(String simpleResName) {
        this.simpleResName = simpleResName;
    }



    public ServiceMethodTemplate() {
        super();
        setTemplateName("serviceMethod.ftl");
        setTemplateMapName("method");
    }
}
