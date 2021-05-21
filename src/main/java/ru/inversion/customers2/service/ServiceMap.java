package ru.inversion.customers2.service;

import ru.inversion.bicomp.util.ParamMap;
import ru.inversion.db.expr.SQLExpressionException;
import ru.inversion.fx.form.JInvFXBrowserController;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ServiceMap {

    // 1 - Объект Pojo класса,
    // 2 - Строчное представление функции, которая будет вызываться,
    // 3 - объект Edit-контроллера
    public static void servMap(Object obj, String callFunction, JInvFXBrowserController ctrl) {
        ParamMap map = new ParamMap();
        List<Method> list = new ArrayList<>();
        String s;
        // получаем все методы Pojo-класса
        Method[] meth = obj.getClass().getDeclaredMethods();
        // перебираем методы и отбираем геттеры
        for (Method method : meth) {
            method.setAccessible(true);
            s = method.getName();
            if (s.startsWith("get") && !s.equals("getMarkLongID") && !s.equals("getRES") && !s.equals("getERR")) {
                list.add(method);
            }
        }
        // вызываем методы, наполняем map.
        for (Method method : list) {
            try {
                map.put(method.getName().toLowerCase(Locale.ROOT).substring(3), method.invoke(obj));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        //  передаем map в plsql функцию
        try {
            map.exec(ctrl, ctrl.getClass().getResource("plsql/def.xml"), callFunction);
        } catch (SQLExpressionException e) {
            e.printStackTrace();
        }
    }
}
