package com.sph.practice.test.sebase;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sph.practice.mybatis.vo.Param1VO;
import com.sph.practice.test.bean.User1;
import com.sph.practice.test.controller.bean.DefaultBean;
import com.sph.practice.test.controller.bean.ParamBean;
import com.sph.practice.test.jedis.utils.JedisUtils;
import com.sph.practice.test.param.BankVO;
import com.sph.practice.test.sebase.util.ObjectUtil1;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/6/4 17:58
 * Description:
 *
 * @since 1.0.0
 */
@Slf4j
public class Test0604 {

    public void invokeTest(){
        System.out.println("该方法对外提供调用");
    }

    /**
     *
     */
    @Test
    public void test1(){
        BankVO bankVO = new BankVO();
    }

    /**
     * StringBuffer  append 拼接
     */
    @Test
    public void test2(){
        String test = "123123";
        String preId = "123123121";
        System.out.println(test + "preId=" + preId);
    }

    /**
     * 使用Map提供的几个新的方法
     */
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<>();
        map.put("username",null);
        Integer username11 = map.getOrDefault("username11", 212);
        System.out.println("打印出：+" + username11);
        map.keySet().forEach(k -> System.out.println(k));
        //System.out.println(map.compute);
    }

    /**
     * 试试TreeMap
     */
    @Test
    public void test4(){
        Map<Integer,Object> map = new TreeMap<>();
        map.put(2,2);
        map.put(4,2);
        map.put(5,2);
        map.put(3,2);
        map.put(1,2);
        map.put(9,2);
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((v1, v2) -> v1-v2);
        list.stream().forEach(System.out::println);


    }

    /**
     * 类型强转
     */
    @Test
    public void test5(){
        Map<String,Object> map = new TreeMap<>();
        map.put("ab","1");
        map.put("zg","1");
        map.put("zd","1");
        map.put("ba","3");
        map.put("d","3");
        map.put("za","3");
        map.put("zb","3");
        map.put("c","3");
        map.put("e","3");
        map.put("x","3");
        map.put("f","3");
        map.put("g","2");
        map.keySet().forEach(k -> System.out.println(k));
    }

    /**
     *
     */
    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            JedisUtils.test();
        }
        //静态代码块只会在类加载的时候才会去执行，只执行一次
        System.out.println("1111");
    }

    /**
     * 定义一个泛型方法，参数带泛型的话，那么该方法是泛型方法，则需要记得声明方法是泛型方法
     */
    @Test
    public void test11(){
        List<String> list = Lists.newArrayList("123", "456");
        String[] ss = new String[]{"111","44444"};
        this.serial(ss);
    }

    private <E> void serial(E objects){
        if (objects instanceof List){
            for (String object : (List<String>)objects) {
                System.out.println(object);
            }
        } else if (objects instanceof String[]){
            for (String object : (String[])objects) {
                System.out.println(object);
            }
        }
    }

    @Test
    public void test12(){
        User1 u = new User1(1, "1", "2");
        System.out.println(this.returnObject(u).getUsername());
    }

    //返回指定泛型对象
    private <T> T returnObject(T t){
        return t;
    }

    /**
     * 测试一下TimeUnit枚举类
     */
    @Test
    public void test0(){
        System.out.println(TimeUnit.DAYS.toHours(1));
        System.out.println(TimeUnit.MINUTES);
    }

    @Test
    public void test123(){
        Set<String> set = new HashSet<>();
    }

    private static int num = 0;

    public static void main(String[] args) {
        System.out.println(num);
        num++;
        main(args);
    }

    /**
     *
     */
    @Test
    public void test6(){
        List<String> list = getList();
        list.add("123");
    }

    private List<String> getList(){

        return Collections.emptyList();
    }

    //试试封装查询参数 map
    /**
     *
     */
    @Test
    public void test13(){
        test13a("111","222");
    }

    private void test13a(Object... Object){
        List<String> strings = Lists.newArrayList("111", "222");
        Map<String, Object> map = Maps.newHashMap();
        map.put("username", "123");
        System.out.println(map.get("username"));
        map.put("username", "456");
        System.out.println(map.get("username"));
    }

    //用一下Hutool 任意一个为空则有问题
    /**
     *
     */
    @Test
    public void test7(){
        boolean flag1 = ObjectUtil.isAllNotEmpty(null, null);
        boolean flag2 = ObjectUtil.isAllEmpty("123", null);
        System.out.println("flag1 = " + flag1);
        System.out.println("flag2 = " + flag2);
    }

    /**
     *
     */
    @Test
    public void test8(){
    }

    /**
     *
     */
    @Test
    public void test9(){
        DefaultBean defaultBean = new DefaultBean();
        System.out.println(defaultBean);
    }

    /**
     *
     */
    @Test
    public void test10(){
        ObjectUtil1 util1 = new ObjectUtil1();
        ObjectUtil1 util11 = util1.ObjectTest();
        System.out.println("123");
    }

    /**
     *
     */
    @Test
    public void test22(){
        List<String> list = new ArrayList<String>(){
            {
                add("中交集团");
                add("中交集团->one");
                add("中交集团->two");
                add("中交集团->two->three");
            }
        };
        List<String> collect = list.stream().filter(str -> str.startsWith("中交集团->")).collect(Collectors.toList());
        System.out.println(collect);
    }

    //String类型拼接的话，貌似只有 +

    /**
     *
     */
    @Test
    public void test23(){
        String str = "123";
        String concat = str.concat("456");
        System.out.println(concat);
    }

    // List里面放入对象，然后add，后面remove的时候
    /**
     *
     */
    @Test
    public void test24(){
        List<Param1VO> list = new ArrayList<Param1VO>() {
            {
                add(new Param1VO(1,"1"));
                add(new Param1VO(2,"2"));
            }
        };
        Param1VO param1VO = new Param1VO(1, "1");
        //记录id，然后删除的时候根据id去删即可

    }

    /**
     * 遍历一个list，能否遍历过程中改变当前这个List呢？
     */
    @Test
    public void test25(){
        //循环的次数有变？
        List<String> list = new Vector<String>() {
            {
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
                add("6");
            }
        };
        List<Object> respList = Lists.newArrayList();
        for (int i = 0; i < list.size(); i++) {
            respList.add(list.get(i));
            list.remove("3");
            list.remove("4");
        }
        System.out.println(list);
        System.out.println(respList);

    }

    //直接remove一整个collection
    /**
     *
     */
    @Test
    public void test26(){
        List<Param1VO> list = new ArrayList<Param1VO>() {
            {
                add(new Param1VO(1,"1"));
                add(new Param1VO(2,"2"));
                add(new Param1VO(3,"3"));
            }
        };
        List<Param1VO> list1 = new ArrayList<Param1VO>() {
            {
                add(new Param1VO(1,"1"));
                add(new Param1VO(2,"2"));
            }
        };
        list.removeAll(list1);
        System.out.println(list);
    }

    /**
     *
     */
    @Test
    public void test27(){
        String str = "http://localhost:8085/wxqyh/learnonline.html?corp_id=10086&agentCode=learnonline#learnonline/?id=2312323";
        //目标：将appId追加在参数列上 最好是追加在?后面，不能直接追加在最后面呢。
        //实现：转成sb，sb里面有个insert方法可以指定位置索引插入，
        //我们先获得?出现的索引，
        int index = str.indexOf("?");
        StringBuffer sb = new StringBuffer(str);
        StringBuffer insert = sb.insert(++index, String.format("appId=%s&", 6000));
        System.out.println(insert);
    }

    /**
     *
     */
    @Test
    public void test28(){
        // indexOf
        String str = "http";
        int h = str.indexOf("1");
        System.out.println(h);
    }

    /**
     *
     */
    @Test
    public void test29(){
        String str = "555";
        str = handleUrl(str);
        System.out.println(str);
    }

    private String handleUrl(String str){
        return str + "666";
    }

    /**
     * 切割祖先单位
     */
    @Test
    public void test30(){
        String unitFullName = "中交集团->通产部门->研发三部->研发二组->打杂祖";
        //用lastIndexOf判断是否包含 "->"字眼，如果存在的话，那么进行切割，切割的方法从0到 lastIndex -1

        List<String> ancestorDeptList = new ArrayList<>();
        getAncestorDepts(unitFullName, ancestorDeptList);
        System.out.println(ancestorDeptList);
    }

    // 提供一个递归切割方法，入参String和List 获取祖先部门

    private void getAncestorDepts(String unitFullName, List<String> ancestorDeptList) {
        int lastIndex = unitFullName.lastIndexOf("->");
        if (lastIndex > -1) {
            //如果有的话，先subString进行切割，然后添加到List后，再进行递归
            String preDeptName = unitFullName.substring(0, lastIndex);
            ancestorDeptList.add(preDeptName);
            getAncestorDepts(preDeptName, ancestorDeptList);
        }
    }

    /**
     *
     */
    @Test
    public void test31(){
        List<ParamBean> list = new ArrayList<ParamBean>(){
            {
                add(new ParamBean("111","111","111"));
                add(new ParamBean("222","222","222"));
            }
        };
        Map<String, ParamBean> map = new HashMap<String, ParamBean>() {
            {
                put("1", new ParamBean("111","111","111"));
                put("2", new ParamBean("222","222","222"));
            }
        };
        log.info(JSON.toJSONString(map));
    }

    /**
     * 获取当前项目所在的目录路径
     */
    @Test
    public void test20() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
    }

    /**
     * null
     */
    @Test
    public void test40(){
        int FIELD = 1;
        Integer i = 1;

        //System.out.println(FIELD == i);
        System.out.println(!Integer.valueOf(FIELD).equals(i));
    }

    /**
     * 试试一个List的对象，然后遍历时候的地址
     */
    @Test
    public void test41(){
        List<ParamBean> list = new ArrayList<ParamBean>(){
            {
                add(new ParamBean("111","111","111"));
                add(new ParamBean("222","222","222"));
                add(new ParamBean("333","333","333"));
            }
        };
        HashSet<ParamBean> set = new HashSet<>(list);
        Set<ParamBean> small = set.stream().filter(VO -> "111".equals(VO.getId())).collect(Collectors.toSet());
        System.out.println(small);

        Sets.SetView<ParamBean> difference = Sets.difference(set, small); //求补集 求arg1的补集，也即是arg1中-arg2中相同的 剩余的就是arg1的补集
        System.out.println(difference);
    }

    /**
     *  Long contains
     */
    @Test
    public void test42(){
        String str = "123";
        HashSet<Long> set = Sets.newHashSet();
        set.add(1L);
        set.add(10000123456L);
        set.add(11111L);
        Long i = 10000123456L;
        System.out.println(set.contains(i));
    }

    /**
     *
     */
    @Test
    public void test43(){
        List<ParamBean> list = new ArrayList<ParamBean>(){
            {
                add(new ParamBean("111","111","111"));
                add(new ParamBean("222","222","222"));
                add(new ParamBean("333","333","333"));
            }
        };

        ParamBean paramBean = new ParamBean("111", "111", "111");
        boolean equals = paramBean.equals(paramBean);
        boolean contains = list.contains(paramBean);
        System.out.println("=====");

    }

    /**
     *
     */
    @Test
    public void test44(){
        Long l1 = 123456L;
        Long l2 = 123456L;
        boolean equals = l1.equals(l2);
        System.out.println("======");
    }

    /**
     *
     */
    @Test
    public void test45(){
        Integer i1 = 123;
        Integer i2 = 123;
        boolean equals = i1.equals(null);
        System.out.println(equals);
    }

    /**
     *
     */
    @Test
    public void test46(){
        ParamBean paramBean = new ParamBean("222", "222", "222");
        ParamBean paramBean1 = new ParamBean("222", "222", "222");
        paramBean.equals(paramBean1);
        //Long Integer这些都重写了Object的equals方法了，所以没用Object的equals方法
        // Object的equals方法直接是用== 比较地址值了

    }

    // 看了equlas方法，大概也可以直接contains也是大概这个套路

    /**
     *
     */
    @Test
    public void test47(){
        List<ParamBean> list = new ArrayList<ParamBean>(){
            {
                add(new ParamBean("111","111","111"));
                add(new ParamBean("222","222","222"));
                add(new ParamBean("333","333","333"));
            }
        };
        ParamBean paramBean = new ParamBean("111", "111", "111");
        boolean contains = list.contains(paramBean);
        System.out.println(contains);
    }

    /**
     *
     */
    @Test
    public void test48(){
        List<Long> list = Lists.newArrayList();
        list.add(1L);
        list.add(10000123L);
        list.add(11111L);
        Object i = 10000123L;
        boolean contains = list.contains(i);
        System.out.println(contains);
    }

    /**
     *
     */
    @Test
    public void test49(){
        ExtendObject extendObject = new ExtendObject();
        boolean equals = extendObject.equals("1");
        System.out.println(equals);
    }

    /**
     *
     */
    @Test
    public void test50(){
        String str =  "123";
        String str1 = "123";
        boolean equals = str.equals(str1);
        System.out.println(equals);
    }

    /**
     * Set的contains
     */
    @Test
    public void test51(){
        String str = "123";
        HashSet<Long> set = Sets.newHashSet();
        set.add(1L);
        set.add(10000123456L);
        set.add(11111L);
        Long i = 10000123456L;
        boolean contains = set.contains(i);
        System.out.println(contains);

    }

    /**
     * Map 用Long
     * Key  Long 拆箱
     */
    @Test
    public void test52(){
        Map<Long, Object> map = new HashMap<>();
        map.put(1L, new Object());
        map.put(1L, new Object());
        map.put(2L, new Object());
        map.containsKey(1L);
        System.out.println("=====");
    }

    /**
     *
     */
    @Test
    public void test53(){

    }










}
