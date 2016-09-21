/**  
 * Copyright  2016jkzl. All rights reserved. 
 */
package ${res.javaPackage};
 
/**
 * @Description: ${res.todo}
 * @author ${user}
 * @date ${createdTime}
 * @version 1.0
 *
 * operation
 * date                                      operator             content
 * ${createdTime}                       ${user}           new
 * 
 */
public class ${res.className} { 
    
    <#list res.properties as property>
    /**
     * ${property.cnName}
     */
    private ${property.propertyType} ${property.propertyName};
    </#list>
    
    <#list res.properties as property>
     /**
     * @return the ${property.propertyName}
     */
    public ${property.propertyType} get${property.firstCapitalName}() {
        return ${property.propertyName};
    }

    /**
     * @param ${property.propertyName} the ${property.propertyName} to set
     */
    public void set${property.firstCapitalName}(${property.propertyType} ${property.propertyName}) {
        this.${property.propertyName} = ${property.propertyName};
    }
    </#list>
    
    
}