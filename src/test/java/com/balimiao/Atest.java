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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Slf4j
public class Atest {
    private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    @Test
    public void bbbbccc() throws IOException {

        String aa = "demo_topic,activity_record_like_topic,distribute_user_class_leader_boards_msg_topic,upload_read_process_topic,save_ch_book_card_read_record,distribute_user_bilingual_activity_leader_boards_msg_topic,update_user_bilingual_activity_area_leader_boards_topic,distribute_user_bilingual_activity_like_leader_boards_msg_topic,update_user_bilingual_activity_area_like_leader_boards_topic,activity_clock_book,add_user_news_topic,join_default_class_topic,island_friend_boost_topic,common_topic,wechat_exchange_code_topic,user_book_read_completed_topic,student_join_class_group_succeeded_topic,teacher_up_class_activity_cache_topic,activity_publish_and_generate_template_task_topic,record_make_up_complete_status_task_topic,refresh_activity_cache_task_topic,merge_role_play_voice_topic,save_user_share_log_topic,teacher_novice_task_topic,update_activity_status_topic,user_read_task_submit_topic,ch_book_card_read_record_like_topic,ch_book_card_read_record_play_topic,english_pk_activity_sumit_topic,question_activity_submit_topic,syncronized_student_area_school_info,read_top_user_topic,province_city_code_from_mobile_ip_topic,synchronization_student_school_grade_class_topic,pay_order_success_topic,pay_order_create_topic,delay_order_create_topic,add_user_daily_task,update_user_class_leader_boards_topic,update_user_coin~add,update_user_coin~reduce,distribute_user_bd_activity_leader_boards_msg_topic,distribute_user_activity_leader_boards_msg_topic,push_student_topic,push_teacher_topic,push_parent_topic,wechat_msg_push_task_topic,user_visit_topic";
        List<String> list = Arrays.asList(aa.split(","));
        System.out.println(list.size());


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
