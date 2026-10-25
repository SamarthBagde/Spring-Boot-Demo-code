package com.example.ProfileDemo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "default"})
public class DummyNotificationServiceImpl implements NotificationService{

    @Override
    public String send(){
        return "Dummy Notification send";
    }
}
