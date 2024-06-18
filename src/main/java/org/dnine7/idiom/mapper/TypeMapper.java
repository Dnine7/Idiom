package org.dnine7.idiom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.dao.Type;

@Mapper
public interface TypeMapper extends BaseMapper<Type> {
}
