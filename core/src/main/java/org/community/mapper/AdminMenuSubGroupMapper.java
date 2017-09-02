package org.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.community.domain.AdminMenuSubGroup;
import org.community.domain.AdminMenuSubGroupExample;

@Mapper
public interface AdminMenuSubGroupMapper {
    int countByExample(AdminMenuSubGroupExample example);

    int deleteByExample(AdminMenuSubGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminMenuSubGroup record);

    int insertSelective(AdminMenuSubGroup record);

    List<AdminMenuSubGroup> selectByExampleWithRowbounds(AdminMenuSubGroupExample example, RowBounds rowBounds);

    List<AdminMenuSubGroup> selectByExample(AdminMenuSubGroupExample example);

    AdminMenuSubGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminMenuSubGroup record, @Param("example") AdminMenuSubGroupExample example);

    int updateByExample(@Param("record") AdminMenuSubGroup record, @Param("example") AdminMenuSubGroupExample example);

    int updateByPrimaryKeySelective(AdminMenuSubGroup record);

    int updateByPrimaryKey(AdminMenuSubGroup record);
}