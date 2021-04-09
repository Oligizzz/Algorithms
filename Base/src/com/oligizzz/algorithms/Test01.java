package com.oligizzz.algorithms;

import java.math.BigDecimal;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/7
 * @Modify By:
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class  buildClass = Class.forName("com.oligizzz.algorithms.Build");
        System.out.println(buildClass.getName());
        System.out.println(buildClass.getSimpleName(  ));
        System.out.println(buildClass.isInterface());
        System.out.println(buildClass.isAnonymousClass());
        System.out.println();
        Build build = (Build) buildClass.newInstance();
        build.doSomething();
        System.out.println(buildClass.isInstance(build));
        System.out.println(build instanceof Build);
    }
}

class Build{

    public void doSomething(){
        System.out.println("DOS");
    }
}
class House extends Build{

}
