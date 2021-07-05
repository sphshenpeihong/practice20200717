package com.sph.practice.test.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sph.practice.test.serialization.dto.json.Bean;
import com.sph.practice.test.serialization.dto.json.Friend;
import com.sph.practice.test.serialization.dto.json.People;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

/**
 * 序列化成JSON对象
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Slf4j
public class JsonSerialization {

    /**
     * json序列化：写
     *
     * @throws Exception
     */
    @Test
    public void jsonWrite() throws Exception {
        //
        Bean bean = new Bean("Album");
        ObjectMapper mapper = new ObjectMapper();

        bean.setStature(new int[]{88, 60, 89});

        ArrayList<String> song = new ArrayList<String>();
        song.add("奇异恩典");
        song.add("东京的都");
        bean.setSong(song);

        Friend friend = new Friend();
        friend.name = "小明";
        friend.age = 24;
        bean.setFriend(friend);

        bean.addScore("Math", 100);
        bean.addScore("PE", 88);

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);    //格式化输出
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);    //键按自然顺序输出
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);    //忽略POJO中属性为空的字段
        mapper.writeValue(System.out, bean);
        /*
            {
              "name" : "Album",
              "stature" : [ 88, 60, 89 ],
              "friend" : {
                "name" : "小明",
                "age" : 24
              },
              "song" : [ "奇异恩典", "东京的都" ],
              "score" : {
                "Math" : 100,
                "PE" : 88
              }
            }
         */
    }

    /**
     * json序列化：读
     *
     * @throws Exception
     */
    @Test
    public void jsonRead() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //忽略未知的属性
        People people = mapper.readValue(new File("D:\\temp\\IO流练习demo\\serialization\\json\\test.json"), People.class);

        System.out.println(people.getName());
        System.out.println(people.getAge());
        System.out.println(people.getFriend());
        int[] stature = people.getStature();
        for (int num : stature) {
            System.out.println(num);
        }
        /*
            weixia
            24
            com.sph.practice.test.serialization.dto.json.Friend@413d1baf
            89
            66
            89
         */
    }
}
