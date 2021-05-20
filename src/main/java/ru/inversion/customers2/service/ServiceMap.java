package ru.inversion.customers2.service;

import ru.inversion.bicomp.util.ParamMap;
import ru.inversion.customers2.controller.EditCustomersController;
import ru.inversion.db.expr.SQLExpressionException;
import ru.inversion.fx.form.JInvFXBrowserController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ServiceMap {

    public static void servMap(Object obj, String callFunction, JInvFXBrowserController ctrl) {
        ParamMap map = new ParamMap();
        List<Method> list = new ArrayList<>();
        String s;
        Method[] meth = obj.getClass().getDeclaredMethods();
        for (Method method : meth) {
            method.setAccessible(true);
            s = method.getName();
            if (s.startsWith("get") && s != "getMarkLongID" && s != "getRES" && s != "getERR") {
                list.add(method);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                map.put(list.get(i).getName().toLowerCase(Locale.ROOT).substring(3), list.get(i).invoke(obj));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        try {
            map.exec(ctrl, ctrl.getClass().getResource("plsql/def.xml"), callFunction);
        } catch (SQLExpressionException e) {
            e.printStackTrace();
        }
    }
}
