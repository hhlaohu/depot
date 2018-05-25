package com.yiya.mapper;

import com.yiya.bean.TabPassagewayRecord;
import com.yiya.bean.TabPassagewayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabPassagewayRecordMapper {
    int countByExample(TabPassagewayRecordExample example);

    int deleteByExample(TabPassagewayRecordExample example);

    int deleteByPrimaryKey(Long passageway_record_id);

    int insert(TabPassagewayRecord record);

    int insertSelective(TabPassagewayRecord record);

    List<TabPassagewayRecord> selectByExample(TabPassagewayRecordExample example);

    TabPassagewayRecord selectByPrimaryKey(Long passageway_record_id);

    int updateByExampleSelective(@Param("record") TabPassagewayRecord record, @Param("example") TabPassagewayRecordExample example);

    int updateByExample(@Param("record") TabPassagewayRecord record, @Param("example") TabPassagewayRecordExample example);

    int updateByPrimaryKeySelective(TabPassagewayRecord record);

    int updateByPrimaryKey(TabPassagewayRecord record);
}