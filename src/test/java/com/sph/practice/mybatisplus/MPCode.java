package com.sph.practice.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Arrays;

/**
 * Created by Shen Peihong on 2021/2/19
 * Description: 代码自动生成器
 *
 * @since 1.0.0
 */
public class MPCode {

    /**
     * 代码自动生成器 根据数据库的字段，自动生成相关pojo、controller、service、dao
     * 只需你提前建好表，即可自动生成相关代码
     *
     * @param args
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 1.全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("Shen Peihong"); //设置类上面的作者
        String projectPath = System.getProperty("user.dir"); //获取当前项目的路径
        gc.setOutputDir(projectPath + "/src/main/java"); //设置代码输出目录
        gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setSwagger2(true); //开启Swagger相关注解
        gc.setOpen(false); //代码运行完毕后，是否打开Windows资源管理器
        gc.setIdType(IdType.ID_WORKER); //主键生成策略使用雪花ID

        mpg.setGlobalConfig(gc);

        // 2.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL); //连接数据库的类型
        dsc.setDriverName("com.mysql.cj.jdbc.Driver"); //数据库驱动
        dsc.setUsername("root"); //数据库账号
        dsc.setPassword("root"); //数据库密码
        dsc.setUrl("jdbc:mysql://localhost:3306/db_mybatis?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8"); //数据库链接

        mpg.setDataSource(dsc);

        // 3.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("qy_plus_auto"); // 需要进行映射的表
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 列名生成策略
        strategy.setLogicDeleteFieldName("deleted"); //逻辑删除字段名
        strategy.setVersionFieldName("version"); //乐观锁字段名
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        strategy.setTableFillList(Arrays.asList(createTime, updateTime)); //自动填充值

        mpg.setStrategy(strategy);

        // 4.包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.sph.practice.mybatisplus");
        pc.setModuleName("auto");
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setEntity("pojo");
        mpg.setPackageInfo(pc);

        // 5.执行生成
        mpg.execute();

    }


}
