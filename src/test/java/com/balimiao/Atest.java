package com.balimiao;

import com.alibaba.fastjson.JSON;
import com.balimiao.pojo.UserVisitMsg;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Slf4j
public class Atest {
    private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    @Test
    public void bbbbccc() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = binarySearch(arr, 5);
        System.out.println(i);

    }

    //二分法查找
    public int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int startIndex = 0, endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void bbbb() {
//        System.out.println(177534474465902592L / 10000 % 256);
//        System.out.println(360207024878780416L % 512);

        List<List<UserVisitMsg>> lists = new ArrayList<>();
        List<UserVisitMsg> list = new ArrayList<>();
        lists.add(list);
        UserVisitMsg userVisitMsg = new UserVisitMsg();
        userVisitMsg.setUserId(33L);
        list.add(userVisitMsg);
        lists.stream().flatMap(Collection::stream).forEach(c -> {
            c.setChannel("343434");
            c.setUserId(5555l);
        });
        System.out.println(JSON.toJSONString(lists));

    }


    @Test
    public void aas() throws Exception {

        StringBuffer stringBuffer = new StringBuffer("https://sf-book-audio.oss-cn-beijing.aliyuncs.com/1632908405691_E1027.mp3");
        stringBuffer.delete(0, stringBuffer.indexOf("//") + 2);
        String bucketName = stringBuffer.substring(0, stringBuffer.indexOf("."));
        String key = stringBuffer.substring(stringBuffer.indexOf("/") + 1);

        System.out.println(bucketName);
        System.out.println(key);
//        URI uri = new URI("https://sf-book-audio.oss-cn-beijing.aliyuncs.com/1632908405691_E1027.mp3");
//        URI uri1 = URI.create("https://sf-book-audio.oss-cn-beijing.aliyuncs.com/1632908405691_E1027.mp3");
//        InputStream inputStream = new URL("https://sf-book-audio.oss-cn-beijing.aliyuncs.com/1632908405691_E1027.mp3").openStream();
//        URL urlfile = new URL("https://sf-book-audio.oss-cn-beijing.aliyuncs.com/1632908405691_E1027.mp3");
//        URI uri = urlfile.toURI();
//        File file = new File("C:/Users/admin/Desktop/数据/歌曲动画/seehear/079/15569/0.mp3");
//        MP3File mp3File = new MP3File("C:/Users/admin/Desktop/数据/歌曲动画/seehear/079/15569/0.mp3");
//        MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();
//
//        String strLen = audioHeader.getTrackLengthAsString();
//        System.out.println(strLen);
//
//        System.out.println(JSON.toJSONString(audioHeader));
//
//        int intLen = audioHeader.getTrackLength();
//        System.out.println(intLen);

    }

    @Test
    public void aa() throws Exception {
        URL urlfile = new URL("https://sf-book-audio.oss-cn-beijing.aliyuncs.com/1632908405691_E1027.mp3");
        URLConnection con = null;
        try {
            con = urlfile.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int b = con.getContentLength();
        BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
        Bitstream bt = new Bitstream(bis);
        Header h = bt.readFrame();
        int time = (int) h.total_ms(b);
        System.out.println(time);

    }

    @Test
    public void aa3() {
        int a = 8;
        switch (a) {
            case 8: {
                return;
            }
            case 1: {
            }
            case 6: {
            }
            default:
                break;
        }
        System.out.println(222);
    }


}
