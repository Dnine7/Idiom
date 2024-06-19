package org.dnine7.idiom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.dao.Type;
import org.dnine7.idiom.mapper.IdiomMapper;
import org.dnine7.idiom.mapper.TypeMapper;
import org.dnine7.idiom.service.IIdiomService;
import org.dnine7.idiom.service.ITypeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {
    @Override
    public Map<Long, Type> getTypeMap() {
        List<Type> list = list();
        Map<Long, Type> typeMap = new HashMap<>();
        list.forEach(type -> {
            typeMap.put(type.getId(), type);
        });
        return typeMap;
    }
}
