package org.dnine7.idiom.controller;

import jakarta.annotation.Resource;
import org.dnine7.idiom.common.Result;
import org.dnine7.idiom.dao.Group;
import org.dnine7.idiom.dao.Type;
import org.dnine7.idiom.service.ITypeService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Resource
    private ITypeService typeService;


    @RequestMapping("/list")
    public Result<List<Type>> list(@RequestBody Type type) {
        return Result.ok(typeService.list());
    }

    @RequestMapping("/getTypeName")
    public Result<String> getTypeName(@RequestParam long typeId) {
        Type byId = typeService.getById(typeId);
        if (byId == null)
            return Result.error("未找到对应的分类记录");
        return Result.ok(byId.getName());
    }

    @PostMapping("/add")
    public Result<String> save(@RequestBody Type type) {
        if (!StringUtils.hasText(type.getName())) {
            return Result.error("类名不能为空");
        }
        typeService.save(type);

        return Result.ok("添加成功！");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Type type) {
        boolean b = typeService.updateById(type);
        if (!b) {
            return Result.error("更新失败，请稍后重试");
        }
        return Result.ok("更新成功！");
    }

    @DeleteMapping("/delete/{id}")
    public Result<String> delete(@PathVariable Long id) {
        boolean b = typeService.removeById(id);
        if (!b) {
            return Result.error("删除失败，请稍后重试");
        }
        return Result.ok("删除成功！");
    }


}
