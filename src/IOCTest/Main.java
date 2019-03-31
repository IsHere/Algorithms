package IOCTest;

import IOCUtil.BeanFactory;
import algorithms.annotation.Autowire;
import algorithms.annotation.Bean;

import java.util.*;

@Bean
public class Main {
    private String className = "MAIN";
    @Autowire
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Main{" +
                "className='" + className + '\'' +
                ", user=" + user +
                '}';
    }

    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();
        System.out.println(factory.getClassByName("User"));

    }




}
