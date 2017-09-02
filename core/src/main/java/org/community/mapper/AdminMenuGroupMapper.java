package org.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.community.domain.AdminMenuGroup;
import org.community.domain.AdminMenuGroupExample;

@Mapper
public interface AdminMenuGroupMapper {
    int countByExample(AdminMenuGroupExample example);

    int deleteByExample(AdminMenuGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminMenuGroup record);

    int insertSelective(AdminMenuGroup record);

    List<AdminMenuGroup> selectByExampleWithRowbounds(AdminMenuGroupExample example, RowBounds rowBounds);

    List<AdminMenuGroup> selectByExample(AdminMenuGroupExample example);

    AdminMenuGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminMenuGroup record, @Param("example") AdminMenuGroupExample example);

    int updateByExample(@Param("record") AdminMenuGroup record, @Param("example") AdminMenuGroupExample example);

    int updateByPrimaryKeySelective(AdminMenuGroup record);

    int updateByPrimaryKey(AdminMenuGroup record);
}