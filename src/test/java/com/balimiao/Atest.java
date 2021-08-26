package com.balimiao;

import com.alibaba.fastjson.JSONObject;
import com.balimiao.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Slf4j
public class Atest {
    private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    @Test
    public void bbbbccc() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> pageByOffset = PageUtil.getPageByOffset(list, 12, 10);
        System.out.println(pageByOffset);
    }

    @Test
    public void bbbb() {
        System.out.println(177534474465902592L / 10000 % 256);
    }


    @Test
    public void aa() throws UnsupportedEncodingException {

        Map map = JSONObject.parseObject("{\"APP绑定手机号\":\"18501965169\"}", Map.class);
        System.out.println(map.get("APP绑定手机号"));

        String decode = URLDecoder.decode("http%3A%2F%2Fmp.weixin.qq.com%2Fs%3F__biz%3DMzg3NTA4NjIyNQ%3D%3D%26mid%3D100006093%26idx%3D1%26sn%3Db1f36c5bae75b661f215591af5ba7de0%26chksm%3D4ec7b03379b0392576adbf674b495dc9e962784e12e2d410d7616b94ac6795624753a319ea52%23rd", "utf-8");
        System.out.println(decode);

    }

    @Test
    public void aa3() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("二年级9班", "6");
        map.put("五年级3班", "6");
        map.put("六年级3班", "6");
        map.put("三年级3班", "6");
        map.put("二年级2班", "2");
        map.put("二年级5班", "2");
        map.put("二年级1班", "2");
        map.put("一年级7班", "2");
        map.put("一年级4班", "2");
        map.put("二年级4班", "4");
        System.out.println(map);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println(entries);
    }

}
