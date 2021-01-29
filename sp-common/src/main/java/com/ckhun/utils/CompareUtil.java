package com.ckhun.utils;


import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:48 2021/1/29
 * @description :
 * @since : 1.0.0
 */
public class CompareUtil {
    /**
     * 比较两个实体属性值，返回一个boolean,true则表时两个对象中的属性值无差异
     * @param oldObject 进行属性比较的对象1
     * @param newObject 进行属性比较的对象2
     * @return 属性差异比较结果boolean
     */
    public static boolean compareObject(Object oldObject, Object newObject) {
        Map<String, List<Object>> resultMap=compareFields(oldObject,newObject,null);

        if(resultMap.size()>0) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * 比较两个实体属性值，返回有差异的属性名为key的map，value为一个Map分别为 oldObject,newObject 属性名的值
     * @param obj1 属性比较的对象1 - oldObject
     * @param obj2 属性比较的对象2 - newObject
     * @param ignoreArr 忽略比较的字段
     * @return 属性差异结果的map
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, List<Object>> compareFields(Object obj1, Object obj2, String[] ignoreArr) {
        try{
            Map<String, List<Object>> map = new HashMap<String, List<Object>>();
            List<String> ignoreList = null;
            if(ignoreArr != null && ignoreArr.length > 0){
                ignoreList = Arrays.asList(ignoreArr);
            }
            if (obj1.getClass() == obj2.getClass()) {
                Class clazz = obj1.getClass();
                PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz,
                        Object.class).getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {
                    String name = pd.getName();
                    if(ignoreList != null && ignoreList.contains(name)){
                        continue;
                    }
                    Method readMethod = pd.getReadMethod();
                    Object o1 = readMethod.invoke(obj1);
                    Object o2 = readMethod.invoke(obj2);
                    if(o1 instanceof Timestamp){
                        o1 = new Date(((Timestamp) o1).getTime());
                    }
                    if(o2 instanceof Timestamp){
                        o2 = new Date(((Timestamp) o2).getTime());
                    }
                    if(o1 == null && o2 == null){
                        continue;
                    }else if(o1 == null && o2 != null){
                        List<Object> list = new ArrayList<Object>();
                        list.add(o1);
                        list.add(o2);
                        map.put(name, list);
                        continue;
                    }
                    if (o2 != null && !o1.equals(o2)) {
                        List<Object> list = new ArrayList<Object>();
                        list.add(o1);
                        list.add(o2);
                        map.put(name, list);
                    }
                }
            }
            return map;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
