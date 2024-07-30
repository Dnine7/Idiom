package org.dnine7.idiom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.dao.dto.IdiomDto;
import org.dnine7.idiom.dao.vo.IdiomVo;
import org.dnine7.idiom.mapper.IdiomMapper;
import org.dnine7.idiom.service.IIdiomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomServiceImpl extends ServiceImpl<IdiomMapper, Idiom> implements IIdiomService {
    @Resource
    private IdiomMapper idiomMapper;
    @Override
    public PageInfo<IdiomVo> dtoList(IdiomDto idiom) {
        PageHelper.startPage(idiom.getPage(), idiom.getPageSize());
        List<IdiomVo> idioms = idiomMapper.dtoList(idiom);
        return new PageInfo<>(idioms);
    }
}
