package org.dnine7.idiom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.service.IIdiomService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/idiom")
public class IdiomController {

    @Resource
    private IIdiomService idiomService;


    @RequestMapping("/list")
    public List<Idiom> list(@RequestBody Idiom idiom) {
        QueryWrapper<Idiom> qw = new QueryWrapper<Idiom>();
        if (StringUtils.hasText(idiom.getName())) qw.like("name",idiom.getName());
        if (idiom.getTypeId() != null && idiom.getTypeId() != 0) qw.eq("type_id",idiom.getTypeId());
        if (idiom.getGroupId() != null && idiom.getGroupId() != 0) qw.eq("group_id",idiom.getGroupId());
        List<Idiom> list = idiomService.list(qw);
        return list;
    }

    @PostMapping("/add")
    public void save(@RequestBody Idiom idiom) {
        idiomService.save(idiom);
    }

    @PutMapping("/update")
    public void update(@RequestBody Idiom idiom) {
        idiomService.updateById(idiom);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        idiomService.removeById(id);
    }


}
