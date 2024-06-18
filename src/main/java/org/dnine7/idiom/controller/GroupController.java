package org.dnine7.idiom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.dnine7.idiom.common.Result;
import org.dnine7.idiom.dao.Group;
import org.dnine7.idiom.service.IGroupService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Resource
    private IGroupService groupService;


    @RequestMapping("/list")
    public Result<List<Group>> list(@RequestBody Group group) {
        return Result.ok(groupService.list());
    }

    @PostMapping("/add")
    public Result<String> save(@RequestBody Group group) {
        if (!StringUtils.hasText(group.getName())) {
            return Result.error("组名不能为空");
        }
        groupService.save(group);

        return Result.ok("添加成功！");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Group group) {
        boolean b = groupService.updateById(group);
        if (!b) {
            return Result.error("更新失败，请稍后重试");
        }
        return Result.ok("更新成功！");
    }

    @DeleteMapping("/delete/{id}")
    public Result<String> delete(@PathVariable Long id) {
        boolean b = groupService.removeById(id);
        if (!b) {
            return Result.error("删除失败，请稍后重试");
        }
        return Result.ok("删除成功！");
    }


}
