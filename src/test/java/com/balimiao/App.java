package com.balimiao;

import org.junit.Test;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhushaopeng
 * @Date 2020/6/17
 **/
public class App {

    /**
     * 将数据转换成父子的数据结构
     * [{id=1, pId=0}, {id=2, pId=1}, {id=3, pId=0}, {id=4, pId=3}, {id=5, pId=4}] 转换成下面格式
     * [{id=1, pId=0, children=[{id=2, pId=1}]}, {id=3, pId=0, children=[{id=4, pId=3, children=[{id=5, pId=4}]}]}]
     */
    @Test
    public void tree() {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("pId", 0);
        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("id", 2);
        map2.put("pId", 1);
        Map<String, Object> map3 = new LinkedHashMap<>();
        map3.put("id", 3);
        map3.put("pId", 0);
        Map<String, Object> map4 = new LinkedHashMap<>();
        map4.put("id", 4);
        map4.put("pId", 3);
        Map<String, Object> map5 = new LinkedHashMap<>();
        map5.put("id", 5);
        map5.put("pId", 4);
        data.add(map);
        data.add(map2);
        data.add(map3);
        data.add(map4);
        data.add(map5);
        System.out.println(data);
        Map<Object, List<Map<String, Object>>> pId$mapList = data.stream().collect(Collectors.groupingBy(node -> node.get("pId")));
        //全部节点
        List<Map<String, Object>> nodeList = new ArrayList<>();
        //同一级的node
        List<Map<String, Object>> sameLevelNode = new ArrayList<>();
        //循环结束标识
        boolean flg = true;
        //是不是顶级节点
        boolean isTop = true;
        while (flg) {
            if (isTop) {
                List<Map<String, Object>> maps = pId$mapList.get(0);
                nodeList.addAll(maps);
                sameLevelNode.addAll(maps);
                isTop = false;
            } else {
                flg = false;
                List<Map<String, Object>> tempSameLevelNode = new ArrayList<>();
                for (Map<String, Object> node : sameLevelNode) {
                    Object id = node.get("id");
                    List<Map<String, Object>> sonNode = pId$mapList.get(id);
                    if (sonNode != null) {
                        flg = true;
                        tempSameLevelNode.addAll(sonNode);
                        node.put("children", sonNode);
                    }
                }
                sameLevelNode = tempSameLevelNode;
            }
        }
        System.out.println(nodeList);
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
