package cn.wolfcode.mycat.mapper;

import cn.wolfcode.mycat.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wolfcode-lanxw
 */
@Mapper
public interface UserMapper {
    //@Insert("insert into user(id,name) value (#{id},#{name})")
    int insert(@Param("user") User user);
    //@Select("select * from user order by id limit 200")
    List<User> selectAll();

    User selectById(@Param("id") Long id);
}
