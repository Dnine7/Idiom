package org.dnine7.idiom.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.dao.dto.IdiomDto;
import org.dnine7.idiom.dao.vo.IdiomVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IIdiomService extends IService<Idiom> {
    public PageInfo<IdiomVo> dtoList(IdiomDto idiom);
}
