package ru.alcereo.system;

import org.gradle.api.file.FileCollection;

import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by alcereo on 30.05.17.
 */
public class Generator {

    public static void generateSome(FileCollection fileCollection) {

        URL[] urls = fileCollection.getFiles().stream().map(file -> {
            try {
                return file.toURI().toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }).toArray(URL[]::new);

        ClassLoader loader = new URLClassLoader(urls, Object.class.getClassLoader());

        try {
            Class annotationClass = loader.loadClass("org.springframework.boot.autoconfigure.domain.EntityScan");
            Class beanAnnotationClass = loader.loadClass("org.springframework.context.annotation.Bean");
            Class aClass = loader.loadClass("ru.alceo.entity.PersonEntity");
            Annotation annotation = aClass.getAnnotation(annotationClass);
            Annotation beanAnnotation = aClass.getAnnotation(beanAnnotationClass);
            System.out.println(annotation);
            System.out.println(beanAnnotation);
            System.out.println("<----------------------");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("asd");


    }

}
