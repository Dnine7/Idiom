package org.dnine7.idiom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.dao.dto.IdiomDto;
import org.dnine7.idiom.dao.vo.IdiomVo;

import java.util.List;

@Mapper
public interface IdiomMapper extends BaseMapper<Idiom> {

    List<IdiomVo> dtoList(IdiomDto idiom);
}
