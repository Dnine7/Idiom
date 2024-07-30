package org.dnine7.idiom.dao.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dnine7.idiom.dao.Idiom;

@EqualsAndHashCode(callSuper = true)
@Data
public class IdiomDto extends Idiom {
    private int page;
    private int pageSize;
}
