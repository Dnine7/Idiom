package org.dnine7.idiom.dao;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
@TableName("Idiom")
public class Idiom {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String mean;
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String sentence;
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String sentimentType;
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String collocation;
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String fontColor;
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String remark;
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private Long typeId;
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private Long groupId;


}
