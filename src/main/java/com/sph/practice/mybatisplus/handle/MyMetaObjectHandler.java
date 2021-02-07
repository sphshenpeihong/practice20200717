package com.sph.practice.mybatisplus.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Shen Peihong on 2021/2/3
 * Description: MP定义了这个接口，以及在这个接口里面定义了许多的方法，需要你把一些填充策略写在定义的方法里边
 * MP提供的增、改方法里边，会去识别你提供的实体类类型，拿到对应的反射对象，然后看你的属性是否用到了@TableField注解，
 * 进而再继续确认你是否用到了fill数据，进而再确认你是否用了INSERT或UPDATE或INSERT_UPDATE，如果是的话，那么就去Spring的IOC容器中
 * 扫描出实现了MetaObjectHandler这个接口的实现类，然后执行对应的生成策略方法，
 * 这样就能成功地set指定的值到某个变量中了(一定是有注解声明的变量哈) 因为如果你加了注解，并且也打开了策略，但是你在书写生成策略
 * 的方法中没有去写生成策略(给某个属性set值)，那么也是无法给属性set值成功的哈
 * 还有一点：
 * 定义的接口有个参数是MetaObject类型的，也就是说到时候底层调用你这个方法的时候，会传这么一个实例化对象给你
 * 你具体就要看看这个对象是干什么用的，里面有什么方法，什么属性，因为一般都是一个引用类型的类类型
 * 需要你set一下里面的属性，或提供给你get方法拿到里面的某些属性或是处理逻辑处理后的值啥的。
 * 总之就是这个实例化对象里面都会提供许多方法，去set值或get值，或是提供一些有的没的的方法
 *
 * @since 1.0.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 当注解@TableFiled的属性fill的值为INSERT时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    // 当注解@TableFiled的属性fill的值为UPDATE或INSERT_UPDATE时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

}
