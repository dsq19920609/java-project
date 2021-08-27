package com.iwhalecloud.offer.ZClass;

import com.iwhalecloud.offer.ZClass.annotation.Column;
import com.iwhalecloud.offer.ZClass.annotation.Table;
import com.iwhalecloud.offer.ZClass.dto.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Genneic {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("dong");
        person.setUserName("shaoqiang");
        System.out.println(query(person));
    }

    private static String query(Person person) {
        StringBuilder sqlStr = new StringBuilder();
        // 通过反射获取类的Class对象
        Class p = person.getClass();

        // 判断Person类是不是注解类
        boolean isTable = p.isAnnotationPresent(Table.class);

        if (!isTable) {
            return null;
        }

        // 类型强制转换
        Table table = (Table) p.getAnnotation(Table.class);
        String tableName = table.value();
        sqlStr.append("select * from ").append(tableName).append(" where 1 = 1");

        // 构建查询字段
        Field[] fields = p.getDeclaredFields();
        for (Field field : fields) {
            boolean fieldExist = field.isAnnotationPresent(Column.class);
            if (!fieldExist) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            // 注解值
            String columnName = column.value();
            // 属性名称
            String fieldName = field.getName();

            Object fieldValue = null;

            // 通过调用对象的get方法获取对象的值 如 getName 需要将field首字母大写
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

            try {
                Method method = p.getMethod(getMethodName);

                // 通过反射调用对象上的方法
                fieldValue = method.invoke(person);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            sqlStr.append(" and ").append(columnName).append(" = ").append(fieldValue);
        }
        return sqlStr.toString();
    }
}
