package cn.itcast.config;


import lombok.Data;

// @ConfigurationProperties(prefix = "jdbc")    //配置属性,通过在application.properties中寻找前缀为指定单词的目标进行注入
@Data
public class JdbcProperties {
    String url;
    String driveClassName;
    String username;
    String password;
}
