/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package ${entity.javaPackage};
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @Description: ${entity.todo}
 * @author ${user}
 * @date ${createdTime}
 * @version 1.0
 *
 * operation
 * date                                      operator             content
 * ${createdTime}                       ${user}           new
 * 
 */
@Entity(name = "${entity.tableName}")
public class ${entity.className}{ 
    
    <#list entity.properties as property>
    /**
     * ${property.cnName}
     */
    <#if property.propertyName=="id">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    </#if>
    @Column(name = "${property.columnName}" <#if !property.nullable>, nullable = true</#if>)
    private ${property.propertyType} ${property.propertyName};
    </#list>
    
    <#list entity.properties as property>
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