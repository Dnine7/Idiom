package org.dnine7.idiom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dnine7.idiom.dao.Group;
import org.dnine7.idiom.dao.Type;
import org.dnine7.idiom.mapper.GroupMapper;
import org.dnine7.idiom.mapper.TypeMapper;
import org.dnine7.idiom.service.IGroupService;
import org.dnine7.idiom.service.ITypeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {
    @Override
    public Map<Long, String> getGroupMap() {
        List<Group> list = list();
        Map<Long, String> typeMap = new HashMap<>();
        list.forEach(type -> {
            typeMap.put(type.getId(), type.getName());
        });
        return typeMap;
    }
}
