package com.yiya.mapper;

import com.yiya.bean.TabSentryUser;
import com.yiya.bean.TabSentryUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabSentryUserMapper {
    int countByExample(TabSentryUserExample example);

    int deleteByExample(TabSentryUserExample example);

    int deleteByPrimaryKey(Integer sentry_user_id);

    int insert(TabSentryUser record);

    int insertSelective(TabSentryUser record);

    List<TabSentryUser> selectByExample(TabSentryUserExample example);

    TabSentryUser selectByPrimaryKey(Integer sentry_user_id);

    int updateByExampleSelective(@Param("record") TabSentryUser record, @Param("example") TabSentryUserExample example);

    int updateByExample(@Param("record") TabSentryUser record, @Param("example") TabSentryUserExample example);

    int updateByPrimaryKeySelective(TabSentryUser record);

    int updateByPrimaryKey(TabSentryUser record);
}