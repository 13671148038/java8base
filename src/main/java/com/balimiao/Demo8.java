package com.balimiao;

import java.util.*;

/*
    [{id=1, pId=0}, {id=2, pId=1}, {id=3, pId=0}, {id=4, pId=3}, {id=5, pId=4}]

    [{"id":1,"pId":0,"children":[{"id":2,"pId":1}]},
    {"id":3,"pId":0,"children":[{"id":4,"pId":3,"children":[{"id":5,"pId":4}]}]}]

 */
public class Demo8 {

    static List<Map<String,Integer>> list = new ArrayList<>();
    static List<Map<String,Object>> result = new ArrayList<>();
    static {
        Map<String,Integer> m1 = new HashMap<>();
        m1.put("id",1);
        m1.put("pId",0);
        Map<String,Integer> m2 = new HashMap<>();
        m2.put("id",2);
        m2.put("pId",1);
        Map<String,Integer> m3 = new HashMap<>();
        m3.put("id",3);
        m3.put("pId",0);
        Map<String,Integer> m4 = new HashMap<>();
        m4.put("id",4);
        m4.put("pId",3);
        Map<String,Integer> m5 = new HashMap<>();
        m5.put("id",5);
        m5.put("pId",4);
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
    }

    public static void main(String[] args) {
        List resList = new ArrayList();
        Iterator<Map<String, Integer>> iterator = list.stream().filter(c->c.get("pId").equals(0)).iterator();
        while (iterator.hasNext()){
            Map<String, Integer> map = iterator.next();
            Integer id = map.get("id");
            Integer pId = map.get("pId");
            List child = getChild(id, list);
            if (child.size() > 0){
                HashMap<String, Object> stringObjectHashMap = new LinkedHashMap<>();
                stringObjectHashMap.put("id",id);
                stringObjectHashMap.put("pId",pId);
                stringObjectHashMap.put("children",child);
                resList.add(stringObjectHashMap);
            }
        }

        System.out.println("resultSize: "+ resList.size());
        System.out.println("result: "+ resList);

    }

    private static List getChild(Integer parId, List<Map<String,Integer>> list){
       List resList = new ArrayList();
        Iterator<Map<String, Integer>> iterator = list.iterator();
        while (iterator.hasNext()){
            Map<String, Integer> map = iterator.next();
            Integer id = map.get("id");
            Integer pId = map.get("pId");
            if (parId.equals(pId)){
                Map map2 = new LinkedHashMap();
                map2.put("id",id);
                map2.put("pId",pId);
                List child = getChild(id, list);
                if (child.size() > 0){
                    map2.put("children",child);
                }
                resList.add(map2);
            }
        }
        return resList;
    }


}
