package org.dnine7.idiom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.dnine7.idiom.common.Result;
import org.dnine7.idiom.dao.Idiom;
import org.dnine7.idiom.service.IGroupService;
import org.dnine7.idiom.service.IIdiomService;
import org.dnine7.idiom.service.ITypeService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/idiom")
public class IdiomController {

    @Resource
    private IIdiomService idiomService;
    @Resource
    private ITypeService typeService;
    @Resource
    private IGroupService groupService;


    @RequestMapping("/list")
    public Result<List<Idiom>> list(@RequestBody(required = false) Idiom idiom) {
        QueryWrapper<Idiom> qw = new QueryWrapper<Idiom>();
        if (idiom != null) {
            if (StringUtils.hasText(idiom.getName())) qw.like("name",idiom.getName());
            if (idiom.getTypeId() != null && idiom.getTypeId() != 0) qw.eq("type_id",idiom.getTypeId());
            if (idiom.getGroupId() != null && idiom.getGroupId() != 0) qw.eq("group_id",idiom.getGroupId());
        }
        List<Idiom> list = idiomService.list(qw);
        Map<Long, String> typeMap = typeService.getTypeMap();
        Map<Long, String> groupMap = groupService.getGroupMap();
        list.forEach( i -> {
            if (i.getTypeId() != 0) {
                i.setType(typeMap.get(i.getTypeId()));
            }
            if (i.getGroupId() != 0) {
                i.setGroup(groupMap.get(i.getGroupId()));
            }
        });
        return Result.ok(list);
    }

    @RequestMapping("/bindType")
    public Result<String> bindType(@RequestParam long idiomId, @RequestParam long typeId) {
        try {
            Idiom idiom = idiomService.getById(idiomId);
            if (idiom == null) {
                return Result.error("未找到对应的成语记录");
            }
            idiom.setTypeId(typeId);
            boolean updateResult = idiomService.updateById(idiom);
            if (!updateResult) {
                return Result.error("分类失败，请稍后重试");
            }
            return Result.ok("分类成功！");
        } catch (Exception e) {
            // 记录异常日志
            return Result.error("分类失败：" + e.getMessage());
        }
    }

    @RequestMapping("/bindGroup")
    public Result<String> bindGroup(@RequestParam long idiomId, @RequestParam long groupId) {
        try {
            Idiom idiom = idiomService.getById(idiomId);
            if (idiom == null) {
                return Result.error("未找到对应的成语记录");
            }
            idiom.setGroupId(groupId);
            boolean updateResult = idiomService.updateById(idiom);
            if (!updateResult) {
                return Result.error("编组失败，请稍后重试");
            }
            return Result.ok("编组成功！");
        } catch (Exception e) {
            // 记录异常日志
            return Result.error("编组失败：" + e.getMessage());
        }
    }

    @PostMapping("/add")
    public Result<String> save(@RequestBody Idiom idiom) {
        if (!StringUtils.hasText(idiom.getName())) {
            return Result.error("成语名称不能为空");
        }
        if (!StringUtils.hasText(idiom.getMean())) {
            return Result.error("成语释义不能为空");
        }
        idiomService.save(idiom);

        return Result.ok("添加成功！");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Idiom idiom) {
        boolean b = idiomService.updateById(idiom);
        if (!b) {
            return Result.error("更新失败，请稍后重试");
        }
        return Result.ok("更新成功！");
    }

    @DeleteMapping("/delete/{id}")
    public Result<String> delete(@PathVariable Long id) {
        boolean b = idiomService.removeById(id);
        if (!b) {
            return Result.error("删除失败，请稍后重试");
        }
        return Result.ok("删除成功！");
    }


}
