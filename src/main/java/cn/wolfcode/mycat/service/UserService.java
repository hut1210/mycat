package cn.wolfcode.mycat.service;

import cn.wolfcode.mycat.domain.PageRequest;
import cn.wolfcode.mycat.domain.User;
import com.github.pagehelper.PageInfo;

/**
 * @author huteng5
 * @version 1.0
 * @date 2022/1/18 12:01
 */
public interface UserService {

    PageInfo<User> selectAll(PageRequest pageRequest);
}
