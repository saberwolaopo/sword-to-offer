package com.company.ProxyTest;

public class Client {

    public static void main(String[] args){
        //UserManager userManager=new UserManagerImpl();
//        UserManager userManager=new UserManagerImplProxy(new UserManagerImpl());
//        userManager.addUser("1111", "张三");

        LogHandler logHandler = new LogHandler();
        UserManager userManager = (UserManager) logHandler.newProxyInstance(new UserManagerImpl());
        userManager.addUser("saber","wolaopo");

    }
}
