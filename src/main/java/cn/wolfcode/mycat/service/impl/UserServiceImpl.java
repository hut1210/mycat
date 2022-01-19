package cn.wolfcode.mycat.service.impl;

import cn.wolfcode.mycat.domain.PageRequest;
import cn.wolfcode.mycat.domain.User;
import cn.wolfcode.mycat.mapper.UserMapper;
import cn.wolfcode.mycat.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huteng5
 * @version 1.0
 * @date 2022/1/19 16:29
 */
@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public PageInfo<User> selectAll(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> collect = userMapper.selectAll();
        System.out.println(collect);
        PageInfo<User> pageInfo = new PageInfo<>(collect);
        return pageInfo;
    }
}
