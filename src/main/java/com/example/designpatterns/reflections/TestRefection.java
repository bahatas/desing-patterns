package com.example.designpatterns.reflections;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestRefection {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Product product = new Product();
        System.out.println(product.getClass()); // product class'ının full path'ini verir.

        Class cls = Class.forName("com.metin.reflection.Product"); // full path kullanarak bir nesne oluşturulmasıdır. Metodlarını kullanmak için invoke kullanılır.
        Object obj = cls.newInstance(); // newInstance metodu ile Object tipi olarak geri döndürür.

        Product product3 = (Product) obj; // newInstance ile oluşturulmuş olan nesne Object olarak oluşturulmuştur. Product nesnesine cast ediyoruz.
        product3.getCategory();
        product3.getParts();
        product3.getPrice();
        product3.getProductName();
        product3.getId();

        product3.setCategory("category1");
        product3.setParts(new ArrayList<String>());
        product3.setPrice(100D);
        product3.setProductName("computer");
        product3.setId(10L);

        System.out.println("\n*** Invoke Methods (setCategory, getCategory) ***");
        Class[] cArgs = new Class[1]; // setCategory metodunun parametre/leri
        cArgs[0] = String.class;
        Method method1 = cls.getMethod("setCategory", cArgs);
        method1.invoke(obj, "Electronic");

        Method method2 = cls.getMethod("getCategory", null);
        System.out.println(method2.invoke(obj, null));

        System.out.println("\n*** All Methods ***");
        Method[] methods = cls.getDeclaredMethods();

        for (Method method: methods) {
            System.out.println(method.toString());
        }

        System.out.println("\n*** All Fields ***");
        Field[] fields = cls.getDeclaredFields();

        for (Field field: fields) {
            System.out.println(field.toString());
        }

        System.out.println("\n*** The superclass of product2 ***");
        System.out.println(cls.getSuperclass());



    }
}
