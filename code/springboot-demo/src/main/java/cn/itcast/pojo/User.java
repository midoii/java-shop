package cn.itcast.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name = "tb_user")    //告诉通用mapper要寻找的表名
public class User {

    @Id //告诉主键是Id
    @KeySql(useGeneratedKeys = true)    //主键自增
    private Long id;

    private String username;

    private String password;

    @Transient  //不需要持久化，不会作为sql语句
    private String phone;

    private Date created;
}
