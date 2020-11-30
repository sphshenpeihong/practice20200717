package com.sph.practice.test.markdown.designPattern.proxy;

/**
 * Created by Shen Peihong on 2020/11/29 14:38
 * Description:目标对象实现类
 *
 * @since 1.0.0
 */
public class TeacherDaoImpl implements ITeacherDao,ITeacherDao1 {
    @Override
    public void teach() {
        System.out.println("老师正在上课了");
    }
}