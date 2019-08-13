package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    FILE_TYPE_UNMATCH(400, "文件类型不匹配"),
    UPLOAD_ERROR(500, "文件上传失败"),
    BRAND_SAVE_ERROR(500, "服务器新增品牌失败"),
    CATEGORY_BRAND_SAVE_ERROR(500, "新增品牌分类中间表失败"),
    BRAND_NOT_FOUND(404, "没有找到指定商品"),
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOUND(404,"商品分类没查到"),
    ;
    private int code;
    private String msg;

}
