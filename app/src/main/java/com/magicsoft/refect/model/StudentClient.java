package com.magicsoft.refect.model;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/21
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class StudentClient {
    public static void main(String[] args) {




        //通过反射获取对象
        try {
            //方法一
            Class<?> clz = Class.forName("com.magicsoft.refect.model.Student");//forName(包名.类名)
            Student o = (Student) clz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //方法二
        try {
            Student student = new Student();
            Class<? extends Student> aClass = student.getClass();
            Student student1 = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //方法三
        try {
            Class<Student> studentClass = Student.class;
            Student student = studentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        注意:
//        cls.newInstance()方法返回的是一个泛型T,我们要强转成Person类
//        cls.newInstance()默认返回的是Person类的无参数构造对象
//                被反射机制加载的类必须有无参数构造方法,否者运行会抛出异常

        System.out.println();
    }
}
