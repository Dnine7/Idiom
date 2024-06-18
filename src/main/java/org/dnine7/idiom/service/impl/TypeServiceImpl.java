package org.dnine7.idiom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.dao.Type;
import org.dnine7.idiom.mapper.IdiomMapper;
import org.dnine7.idiom.mapper.TypeMapper;
import org.dnine7.idiom.service.IIdiomService;
import org.dnine7.idiom.service.ITypeService;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {
}
