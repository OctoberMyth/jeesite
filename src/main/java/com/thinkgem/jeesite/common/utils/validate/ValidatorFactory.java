package com.thinkgem.jeesite.common.utils.validate;

/**
 * Created by 86443
 * on 2017/4/7.
 */
public class ValidatorFactory {
    private ValidatorFactory() {
    }

    private static final String PACKAGE_URL = "com.thinkgem.jeesite.common.utils.validate.impl.";

    /**
     * 执行具体的校验方法
     *
     * @param ValidatorName 具体校验的类名称
     */
    public static void execute(String ValidatorName) {
        String classPath = PACKAGE_URL + toUpperCaseFirstOne(ValidatorName);
        try {
            Class cls = Class.forName(classPath);
            IValidator validator = (IValidator) cls.newInstance();
            validator.test();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //首字母转大写
    private static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}
