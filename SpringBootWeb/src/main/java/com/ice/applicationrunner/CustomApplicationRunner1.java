package com.ice.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 21.ApplicationRunner 实现系统启动任务
 */
@Component
@Order(2)
public class CustomApplicationRunner1 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 获取启动的所有参数
        System.out.println("CustomApplicationRunner1 Start.");
        String[] sourceArgs = args.getSourceArgs();
        System.out.println("SourceArgs: " + Arrays.toString(sourceArgs));

        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("nonOptionArgs: " + nonOptionArgs);

        Set<String> optionNames = args.getOptionNames();
        for (String optionName : optionNames) {
            System.out.println(optionName + ": " + args.getOptionValues(optionName));
        }
        System.out.println("CustomApplicationRunner1 End.");
    }
}
