package com.elijah.springshardingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author elijahliu
 * @Note Talk is cheap,just show me ur code.- -!
 * ProjectName:spring-sharding-demo
 * PackageName: com.elijah.springshardingdemo
 * Date: 2019-11-07 10:54
 */
@RestController
public class OrderController {

    @Autowired
    EhrNewbornDao ehrNewbornDao;

    @GetMapping("testSample")
    public List<String> testSample(){
        return ehrNewbornDao.selectSampleidByCenterid("bb717701-10de-47ee-b49e-693261c6df22");
    }

    @GetMapping("testPerson")
    public String testPerson(){
        return ehrNewbornDao.selectOnePersonid();
    }

    @GetMapping("testSampleById")
    public String testSampleById(){
        return ehrNewbornDao.selectOneSample();
    }

    @GetMapping("testSampleLabresult")
    public List<String> testSampleLabresult(){
        return ehrNewbornDao.selectJoinSampleResult();
    }

    @GetMapping("testSubQuerySample")
    public List<String> testSubQuerySample(){
        return ehrNewbornDao.selectSubQuerySample();
    }
}
