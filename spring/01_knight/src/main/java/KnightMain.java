package com.alex.spring.knight;

import org.springframework.context.support.*;
import org.springframework.context.*;

public class KnightMain {
    public static void main(String[] args) throws Exception {
        // 1. 基于xml装配
        /*
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/knight.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
        */
        
        // 2. 使用Java来描述配置
        /*
        KnightConfig config = new KnightConfig();
        config.knight().embarkOnQuest();
        */


    	// 3. AOP测试
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/minstrel.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}