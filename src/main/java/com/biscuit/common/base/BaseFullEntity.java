package com.biscuit.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 通用实体类公共字段
 * @author biscuit
 */
@Getter
@Setter
public abstract class BaseFullEntity implements Serializable {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 是否删除，0未删除，1已删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField(value = "modified_by", fill = FieldFill.INSERT_UPDATE)
    private Long modifiedBy;

    /**
     * 修改时间
     */
    @TableField(value = "modified_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;

    /**
     * 删除时间
     */
    @TableField(value = "deleted_time")
    private LocalDateTime deletedTime;

}
