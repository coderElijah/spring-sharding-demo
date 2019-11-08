package com.elijah.springshardingdemo;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Description:
 *
 * @author elijahliu
 * @Note Talk is cheap,just show me ur code.- -!
 * ProjectName:spring-sharding-demo
 * PackageName: com.elijah.springshardingdemo
 * Date: 2019-11-07 14:56
 */
@Component
public class AcmePreciseAlgorithm implements PreciseShardingAlgorithm {
    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        if ("ehr_newborn".equals(preciseShardingValue.getLogicTableName())) {
            if ("bb717701-10de-47ee-b49e-693261c6df22".equals(preciseShardingValue.getValue())) {
                return "ehr_newborn_001";
            }
            return "ehr_newborn_002";
        } else if("ehr_newborn_result".equals(preciseShardingValue.getLogicTableName())){
            if ("bb717701-10de-47ee-b49e-693261c6df22".equals(preciseShardingValue.getValue())) {
                return "ehr_newborn_result_001";
            }
            return "ehr_newborn_result_002";
        }else{
            throw new RuntimeException();
        }
    }
}
