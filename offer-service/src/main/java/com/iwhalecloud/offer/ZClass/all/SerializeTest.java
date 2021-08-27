package com.iwhalecloud.offer.ZClass.all;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeTest {

    public static void main(String[] args) throws Exception {
        serializeAOper();
        System.out.println(deSerializeOper());
    }

    private static void serializeAOper() throws IOException {
        Student student  = new Student();

        student.setName("dong");
        student.setColor("red");
        student.setCar("oooo");
        student.setClassNumber("1");
        student.setGrade("98");


        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("D:/test.txt")));

        out.writeObject(student);
        out.flush();
        System.out.println("序列化成功");
        out.close();

    }

    private static Person deSerializeOper() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("D:/test.txt")));

        Student student = new Student();
        student = (Student) in.readObject();
        System.out.println("反序列化成功");
        return student;
    }
}
