package org.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.community.domain.AdminMenuItem;
import org.community.domain.AdminMenuItemExample;

@Mapper
public interface AdminMenuItemMapper {
    int countByExample(AdminMenuItemExample example);

    int deleteByExample(AdminMenuItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminMenuItem record);

    int insertSelective(AdminMenuItem record);

    List<AdminMenuItem> selectByExampleWithRowbounds(AdminMenuItemExample example, RowBounds rowBounds);

    List<AdminMenuItem> selectByExample(AdminMenuItemExample example);

    AdminMenuItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminMenuItem record, @Param("example") AdminMenuItemExample example);

    int updateByExample(@Param("record") AdminMenuItem record, @Param("example") AdminMenuItemExample example);

    int updateByPrimaryKeySelective(AdminMenuItem record);

    int updateByPrimaryKey(AdminMenuItem record);
}