package cn.wolfcode.mycat.domain;

import lombok.Data;

/**
 * @author huteng5
 * @version 1.0
 * @date 2022/1/18 10:59
 */
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
}
