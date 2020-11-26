package com.balimiao.classload;

import org.junit.Test;
import sun.misc.Launcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

/**
 * @Author zhushaopeng
 * @Date 2020/11/24
 **/
public class ClassLoadDemo {

    @Test
    public void aa() throws MalformedURLException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        Launcher.getBootstrapClassPath().addURL(new URL("file:/D:/install/jdk8/jre/demo"));
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toString());
        }
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        Set<Object> objects = System.getProperties().keySet();
        for (Object url : objects) {
            System.out.println(url);
        }

    }
}
