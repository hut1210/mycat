package cn.wolfcode.mycat.util;

import cn.wolfcode.mycat.domain.PageRequest;
import cn.wolfcode.mycat.domain.PageResult;
import com.github.pagehelper.PageInfo;

/**
 * @author huteng5
 * @version 1.0
 * @date 2022/1/18 11:08
 */
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
