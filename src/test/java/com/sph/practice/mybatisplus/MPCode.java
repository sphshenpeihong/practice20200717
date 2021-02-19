package com.sph.practice.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * Created by Shen Peihong on 2021/2/19
 * Description: 代码自动生成器
 *
 * @since 1.0.0
 */
public class MPCode {

    // 代码自动生成器 根据数据库的字段，自动生成相关pojo、controller、service、dao
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("Shen Peihong");
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setSwagger2(true); //设置丝袜哥
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://localhost:3306/db_mybatis?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.nochange);// 表名生成策略
        strategy.setInclude("qy_plus_auto"); // 需要生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.sph.practice.mybatisplus");
        pc.setModuleName("auto");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();

    }


}
