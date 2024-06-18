package org.dnine7.idiom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.mapper.IdiomMapper;
import org.dnine7.idiom.service.IIdiomService;
import org.springframework.stereotype.Service;

@Service
public class IdiomServiceImpl extends ServiceImpl<IdiomMapper, Idiom> implements IIdiomService {
}
