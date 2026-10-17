package com.example.applicationPropertiesDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsingValue {

    @Value("${payment-property.type}")
    private String type;

    @Value("${payment-property.retry-count}")
    private int retryCount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
}
