# 基于SSM框架的分布式权限管理系统

### 基于最流行的RBAC拓展模型的, 分布式, 有界面, 高灵活性, 高拓展性的权限管理系统,可以运用于企业开发中与权限管理及后台系统相关的需求.

### 功能列表
Java权限管理系统功能列表
1. 部门模块/新增部门/更新部门/删除部门/部门树形结构展示

2. 用户模块/新增用户/更新用户/根据部门分页获取用户列表并展示

3. 权限模块/新增权限模块/更新权限模块/删除权限模块/权限模块树形结构展示

4. 权限点模块/新增权限点/更新权限点/根据权限模块分页获取权限点列表并展示

5. 角色模块/新增角色/更新角色/删除角色/获取角色列表并展示

6. 权限关系维护/角色-权限树形结构列表/更新角色-权限关系

7. 用户关系维护/获取指定角色已分配用户列表/获取指定角色未分配用户列表/更新角色-用户关系

8. 日志模块/带查询条件分页展示权限日志/根据权限日志撤销之前的操作

9. Redis缓存模块/Redis缓存用户权限/Redis缓存系统权限/已缓存权限清理

10. 其他: 在切面判断是否允许当前用户访问某个URL/查询指定用户已分配的权限(树形结构)/查询指定权限被哪些人拥有

### 所用技术
> - 权限框架：Spring Security / Apache Shiro
> - 项目框架：Spring Boot/Spring MVC/Mybatis/Redis
> - 基础工具：Maven/Tomcat/MySQL/JDK1.8
> - 前端技术：jQuery/Bootstrap/Mustache/zTree/Duallistbox
> - 其他技术：Java高级技术/Guava/Druid/Jackson

### 项目启动注意事项

1. 数据库配置：/resources/settings.properties

2. redis配置：/resources/redis.properties

3. 项目登录页：/signin.jsp

4. 登录使用用户名和密码：
    username: admin@foxmail.com  
    password: 12345678

### 其他
1. 如果暂时不想使用redis，如何移除

- applicationContext.xml里移除 <import resource="redis.xml" />

- 修改RedisPool.java 类取消被spring管理

- 修改SysCacheService.java 类移除RedisPool.java的使用

2. 如果想在正式环境使用，需要注意哪些

- 如果是集群部署，需要配置session共享，保证登录一次就可以

- 确认一下项目里超级管理员的权限的规则
代码位置：SysCoreService.java类里的isSuperAdmin()

- 新增管理员的密码处理
SysUserService.java里的save() 方法里需要移除 password = "12345678";
同时，MailUtil里的发信参数要补全，并在SysUserService.java里的save()里 sysUserMapper.insertSelective(user) 之前调用
这是默认给的逻辑，可以根据项目实际情况调整