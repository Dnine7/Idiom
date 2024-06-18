package org.dnine7.idiom.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dnine7.idiom.dao.Group;
import org.dnine7.idiom.dao.Type;

import java.util.Map;

public interface IGroupService extends IService<Group> {

    Map<Long, String> getGroupMap();
}
