package com.balimiao;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhushaopeng
 * @Date 2020/6/17
 **/
public class App {

    @Test
    public void tree() {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("pId", 0);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 2);
        map2.put("pId", 1);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", 3);
        map3.put("pId", 0);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", 4);
        map4.put("pId", 3);
        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", 5);
        map5.put("pId", 4);
        data.add(map);
        data.add(map2);
        data.add(map3);
        data.add(map4);
        data.add(map5);
        Map<Object, List<Map<String, Object>>> pId$mapList = data.stream().collect(Collectors.groupingBy(node -> node.get("pId")));
        //全部节点
        List<Map<String, Object>> nodeList = new ArrayList<>();
        //同一级的node
        List<Map<String, Object>> sameNodeLevel = new ArrayList<>();
        boolean flg = true;
        int a = 0;
        while (flg) {
            if (a == 0) {
                List<Map<String, Object>> maps = pId$mapList.get(0);
                for (Map<String, Object> c : maps) {
                    nodeList.add(c);
                    sameNodeLevel.add(c);
                }
            } else {
                flg = false;
                List<Map<String, Object>> tempSameNodeLevel = new ArrayList<>();
                for (Map<String, Object> map1 : sameNodeLevel) {
                    Object id = map1.get("id");
                    List<Map<String, Object>> maps = pId$mapList.get(id);
                    if (maps != null) {
                        flg = true;
                        tempSameNodeLevel.addAll(maps);
                        map1.put("childrun", maps);
                    }
                }
                sameNodeLevel = tempSameNodeLevel;
            }
            a = 1;
        }
        System.out.println(JSON.toJSONString(nodeList));
    }

    @Test
    public void aa() {

        Year now = Year.now();
        Year of = Year.of(2010);
        Integer b = 6;
        System.out.println(now.compareTo(of));

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(null, 2);
        linkedHashMap.put(2, null);
        Object o = linkedHashMap.values();
        String key = "sdc";
        int h;
        final int i = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(i);

    }

    @Test
    public void bb() {
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.forEach(c -> {
            System.out.println(c);
        });
    }

}
