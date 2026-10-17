package com.example.applicationPropertiesDemo;

import org.springframework.stereotype.Component;

@Component
public class UsingConfigurationProperties {

    private propeties prop;

    public UsingConfigurationProperties(propeties prop){
        this.prop = prop;
    }

    public void printInfo(){
        System.out.println(prop.getType());
        System.out.println(prop.getRetryCount());
        System.out.println(prop.isEnabled());
        System.out.println(prop.getTimeout());
    }

}
