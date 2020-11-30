package com.sph.practice.test.markdown.designPattern.proxy;

/**
 * Created by Shen Peihong on 2020/11/29 14:39
 * Description:代理类
 *
 * @since 1.0.0
 */
public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao teacherDao;

    public TeacherDaoProxy(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void teach() {
        System.out.println("代理模式开启");
        teacherDao.teach();
        System.out.println("代理模式关闭");
    }
}
