package com.sph.practice.test.optional;

import com.sph.practice.test.bean.User;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/5/30 16:34
 * Description: 学会Optional工具类提供的静态方法
 * Optional里面也提供了map和filter方法，用法和作用是和lambda表达式一致的  通过get()方法去获取值
 * @since 1.0.0
 */
public class OptionalMethod {

    @Test
    public void test0() {
        List<String> list = null;
        List<String> stringList = Optional.ofNullable(list).orElse(Collections.emptyList()); //orElse是直接返回原来的类型的了
        Map<String,Object> map = null;
        Optional.ofNullable(map).orElse(Collections.emptyMap());
    }

    //试试Collections里面提供的各种方法 排序
    @Test
    public void tesr3(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-1);
        list.add(0);
        list.add(3);
        list.sort((v1,v2)->v1-v2); //升序排序
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    //试试Collections里面提供的各种方法
    @Test
    public void tesr4(){
        /*List<User> list = new ArrayList<>();
        List<User> list1 = new ArrayList<>();
        //使用List的求交集方法
        User u1 = new User("zhangsan","zhangsan");
        User u2 = new User("lisi","lisi");
        User u3 = new User("zhangsan","zhangsan");
        list.add(u1);
        list.add(u2);
        list1.add(u3);
        list.retainAll(list1);
        for (User user : list) {
            System.out.println(user.getUsername());
        }*/
    }

    //试试Collections里面提供的各种方法
    @Test
    public void tesr5(){
        //比如对增删改审核人，提供单个接口
        //拿到前端userId List<String>类型  list
        //再拿数据库存储的userId List<String>类型 list1
        //然后再求交集，得出结果
        //交集为空，则代表新增的人和数据库的人 全不一样 则批量删除数据库的人 然后批量导入前端传来的人
        //1.外层for循环遍历数据库的
        //交集不为空，那么创建两个list,一个是待添加的userId，一个是待删除的userId（且不可批量删除再批量增加这种操作，性能过低）
        //求交集是对比值类型，地址类型的话就会对比地址
        List<String> reviewers = new ArrayList<>();
        List<String> personSet = new ArrayList<>();
        reviewers.add("tom");
        reviewers.add("jerry");
        reviewers.add("t1");
        reviewers.add("t2");
        personSet.add("tom");
        personSet.add("liuge");
        List<String> delPerson = new ArrayList<>();//数据库待删除人员
        for (String reviewer : reviewers) {
            //循环遍历数据库元素，已包含的在前端传递的审核人中剔除
            if (personSet.contains(reviewer)){
                personSet.remove(reviewer);//已存在的人员不需要再添加
                //不包含的话，是准备在数据库批量剔除的
            }else{
                delPerson.add(reviewer);
            }
        }
        //批量入库
        if (!personSet.isEmpty()){

        }
        //批量删除
        if (!delPerson.isEmpty()){

        }
    }

    @Test
    public void test5(){
        System.out.println(Calendar.getInstance().getTime()); //获得当前时间
        System.out.println(new Date());
    }

    @Test
    public void test1() {
        //public User(Integer id, String username, String password, Integer parentId) {
        User u1 = new User(1, "zhangsan", "zhangsan", -1);
        User u2 = new User(2, "lisi", "lisi", -2);
        User u3 = new User(3, "wangwu", "wangwu", -1);
        List<User> list = new ArrayList<User>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Optional<List<User>> listOptional = Optional.ofNullable(list); //使用ofNullable创建实例
        if (listOptional.isPresent()) {
            //map映射想要的列
            List<String> collect = listOptional.get().stream().map(User::getUsername).collect(Collectors.toCollection(ArrayList::new));
            for (String s : collect) {
                System.out.println(s);
            }
        }

    }

    @Test
    public void test2(){

        Optional<Object> empty = Optional.empty();//使用Optional创建一个空实例，用法同国际化方法创建空实例差不多
        if (empty.isPresent()){
            System.out.println(empty.get());
        }
        System.out.println(1);
    }

    @Test
    public void test3() {
        //public User(Integer id, String username, String password, Integer parentId) {
        User u1 = new User(1, "zhangsan", "zhangsan", -1);
        User u2 = new User(2, "lisi", "lisi", -2);
        User u3 = new User(3, "wangwu", "wangwu", -1);
        List<User> list = new ArrayList<User>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        //先求List<User>   成  mao映射成 List<Integer> 然后过滤  过滤完最后再使用终结方法collect方法 转成List
        List<Integer> collect = list.stream().map(User::getId).filter(value->value>1).collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.println(integer);
        }
    }


}
