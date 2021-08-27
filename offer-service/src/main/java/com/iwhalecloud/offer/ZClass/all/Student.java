package com.iwhalecloud.offer.ZClass.all;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 *  student 继承person  继承后 序列化和反序列化
 *
 *  Externalizable 接口自定义序列化：1、必须有默认的构造函数 2、关键字transient不起作用
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {

    private  String classNumber;

    private String grade;

    /** 序列化的时候 首先通过反射调用类的  writeExternal 方法*/
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.classNumber);
        out.writeObject(this.grade);
    }

    /** 反序列化时 首先通过反射调用类的  readExternal 方法*/
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.classNumber = in.readObject().toString();

        this.grade = in.readObject().toString();
    }

    @Override
    public String toString() {
        return "Student{" +
                "classNumber='" + classNumber + '\'' +
                ", grade='" + grade + '\'' +
                '}' + "------" + super.toString();
    }
}
