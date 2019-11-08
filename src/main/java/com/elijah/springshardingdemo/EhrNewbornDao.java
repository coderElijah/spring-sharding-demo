package com.elijah.springshardingdemo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 *
 * @author elijahliu
 * @Note Talk is cheap,just show me ur code.- -!
 * ProjectName:spring-sharding-demo
 * PackageName: com.elijah.springshardingdemo
 * Date: 2019-11-06 16:44
 */
@Mapper
public interface EhrNewbornDao {
    @Select("select sampleid from ehr_newborn where centerid=#{centerid} order by createtime limit 10;")
    List<String> selectSampleidByCenterid(String centerid);

    @Select("select personid from ehr_person_newborn limit 1;")
    String selectOnePersonid();

    @Select("select sampleid from ehr_newborn where sampleid='00030170-207a-44a0-a0c3-6d5df6dd5bd4'")
    String selectOneSample();

    @Select("select b.labresult from ehr_newborn a left join ehr_newborn_result b on a.sampleid=b.sampleid where a.sampleid='00030170-207a-44a0-a0c3-6d5df6dd5bd4' and a.centerid='bb717701-10de-47ee-b49e-693261c6df22';")
    List<String> selectJoinSampleResult();

    @Select("select mothername from ehr_newborn a left join (select sampleid, max(screening_type) screening_type from ehr_newborn_result where centerid='bb717701-10de-47ee-b49e-693261c6df22' group by sampleid) b on a.sampleid = b.sampleid and a.screening_type=b.screening_type where a.centerid='bb717701-10de-47ee-b49e-693261c6df22';")
    List<String> selectSubQuerySample();
}
