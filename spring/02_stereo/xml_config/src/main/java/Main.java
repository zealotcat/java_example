package com.alex.spring.stereo;

import org.springframework.context.support.*;
import org.springframework.context.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // <constructor-arg>元素配置
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/ConstructorArgReferenceTest-context.xml");

        // c-命名空间
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/CNamespaceReferenceTest-context.xml");

        // <constructor-arg>元素配置构造函数参数
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/ConstructorArgValueTest-context.xml");

        // c-命名空间配置构造函数参数
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/CNamespaceValueTest-context.xml");

        // 带入list参数
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/ConstructorArgCollectionTest-context.xml");
        
        // 配置属性
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/PNamespaceRefTest-context.xml");

        // 配置属性，包含list属性
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/PropertyValueTest-context.xml");

        // 使用p-命名空间配置属性，包含list属性
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/PNamespaceValueTest-context.xml");

        // 使用p-命名空间配置属性，使用util:list属性
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/PNamespaceWithUtilNamespaceTest-context.xml");

        MediaPlayer player = context.getBean(MediaPlayer.class);
        player.play();
    }
}