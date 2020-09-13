package com.sph.practice.test.abstractAndImplements;

import org.springframework.stereotype.Service;

/**
 * Created by Shen Peihong on 2020/9/13 17:45
 * Description:
 *
 * @since 1.0.0
 */
@Service("cowService")
public class CowServiceImpl extends AbstractCowServiceImpl implements ICowService{

    @Override
    public void cowTest() {

    }
}
