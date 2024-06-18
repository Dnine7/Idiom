package org.dnine7.idiom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dnine7.idiom.dao.Group;
import org.dnine7.idiom.dao.Type;

@Mapper
public interface GroupMapper extends BaseMapper<Group> {
}
