package cn.wolfcode.mycat.controller;

import cn.wolfcode.mycat.domain.PageRequest;
import cn.wolfcode.mycat.domain.PageResult;
import cn.wolfcode.mycat.domain.User;
import cn.wolfcode.mycat.mapper.UserMapper;
import cn.wolfcode.mycat.service.UserService;
import cn.wolfcode.mycat.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wolfcode-lanxw
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/save")
    @Transactional
    public String save() {
        for (int i = 1; i < 101; i++) {
            String id = restTemplate.getForObject("http://localhost:9999/tinyid/id/nextIdSimple?bizType=user&token=0f673adf80504e2eaa552f5d791b644c",String.class);
            if(!StringUtils.isEmpty(id)){
                User user = new User();
                user.setId(Long.valueOf(id));
                user.setName("ceshi" + id);
                userMapper.insert(user);
            }
        }
        return "保存成功";
    }

    @PostMapping("/findById/{id}")
    public User findPage(@PathVariable Long id) {
        return userMapper.selectById(id);
    }

    @RequestMapping("/list")
    public List<User> list() {
        return userMapper.selectAll().stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
    }

    @PostMapping("/listPage")
    public Object listPage(@RequestBody PageRequest pageQuery) {
        int pageNum = pageQuery.getPageNum();
        int pageSize = pageQuery.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> collect = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(collect);
        return pageInfo;
    }

    @PostMapping("/listPage2")
    public Object listPage2(@RequestBody PageRequest pageQuery) {
        PageInfo<User> pageInfo = userService.selectAll(pageQuery);
        return pageInfo;
    }

    @PostMapping("/findPage")
    public Object findPage(@RequestBody PageRequest pageQuery) {
        int pageNum = pageQuery.getPageNum();
        int pageSize = pageQuery.getPageSize();
        PageInfo<Object> objectPageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> userMapper.selectAll().stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList()));
        return objectPageInfo;
    }
}
