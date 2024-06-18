package org.dnine7.idiom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dnine7.idiom.dao.Group;
import org.dnine7.idiom.dao.Type;
import org.dnine7.idiom.mapper.GroupMapper;
import org.dnine7.idiom.mapper.TypeMapper;
import org.dnine7.idiom.service.IGroupService;
import org.dnine7.idiom.service.ITypeService;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {
}
