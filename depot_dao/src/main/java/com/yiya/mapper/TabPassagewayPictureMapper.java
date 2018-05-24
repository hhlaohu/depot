package com.yiya.mapper;

import com.yiya.bean.TabPassagewayPicture;
import com.yiya.bean.TabPassagewayPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabPassagewayPictureMapper {
    int countByExample(TabPassagewayPictureExample example);

    int deleteByExample(TabPassagewayPictureExample example);

    int deleteByPrimaryKey(Long passageway_pic_id);

    int insert(TabPassagewayPicture record);

    int insertSelective(TabPassagewayPicture record);

    List<TabPassagewayPicture> selectByExample(TabPassagewayPictureExample example);

    TabPassagewayPicture selectByPrimaryKey(Long passageway_pic_id);

    int updateByExampleSelective(@Param("record") TabPassagewayPicture record, @Param("example") TabPassagewayPictureExample example);

    int updateByExample(@Param("record") TabPassagewayPicture record, @Param("example") TabPassagewayPictureExample example);

    int updateByPrimaryKeySelective(TabPassagewayPicture record);

    int updateByPrimaryKey(TabPassagewayPicture record);
}