package org.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.community.domain.LocalFile;
import org.community.domain.LocalFileExample;

@Mapper
public interface LocalFileMapper {
    int countByExample(LocalFileExample example);

    int deleteByExample(LocalFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LocalFile record);

    int insertSelective(LocalFile record);

    List<LocalFile> selectByExampleWithRowbounds(LocalFileExample example, RowBounds rowBounds);

    List<LocalFile> selectByExample(LocalFileExample example);

    LocalFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LocalFile record, @Param("example") LocalFileExample example);

    int updateByExample(@Param("record") LocalFile record, @Param("example") LocalFileExample example);

    int updateByPrimaryKeySelective(LocalFile record);

    int updateByPrimaryKey(LocalFile record);
}