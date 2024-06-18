package org.dnine7.idiom.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.dao.Type;

import java.util.Map;

public interface ITypeService extends IService<Type> {

    Map<Long, String> getTypeMap();
}
