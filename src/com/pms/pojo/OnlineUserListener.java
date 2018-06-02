package com.pms.pojo;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener{
    public void sessionCreated(HttpSessionEvent event){
        NumOfOwner.numOfOwner++; //添加用户
    }
    
    public void sessionDestroyed(HttpSessionEvent event){
        synchronized(this){
            NumOfOwner.numOfOwner--; //用户数减-
        }
    }
}
