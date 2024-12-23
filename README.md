# 项目名称：AzureCollection

## 项目简介
AzureCollection 是一个基于 Spring Boot 的数字收藏品管理系统，支持用户创建、管理和展示数字收藏品。


## TODO
 ### 大厅展示页面(选购)
  按分类展示游戏装备,虚拟货币,电子票据
 ### 交易功能
  交易,转让之类


## 初始化环境

### 安装jdk-21
1. 安装 Java 21


### 安装gradle
Windows手动安装Gradle
#### 先安装 Scoop（如果还没有安装）
Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
irm get.scoop.sh | iex

#### 然后安装 Gradle
scoop install gradle

检查版本
```
gradle -v
```

清理并构建项目
```
gradle clean build
```

2. 安装 MySQL 并创建数据库 `AC_db`
3. 创建 `src/main/resources/application.properties` 文件中的数据库连接信息
例：
```properties
spring.application.name=AzureCollection
server.port=1234

spring.datasource.url=jdbc:mysql://localhost:3306/AC_db?severTimezone=UTC
spring.datasource.username=root
spring.datasource.password=2890
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Show SQL in console
spring.jpa.show-sql=true

# Format SQL in console
spring.jpa.properties.hibernate.format_sql=true

# Auto generate table
spring.jpa.hibernate.ddl-auto=update

```

## 项目结构

- `src/main/java/edu/swjtu/azurecollection`：Java 源代码目录
  - `controller`：控制器层，处理 HTTP 请求
  - `pojo`：实体类，映射数据库表
  - `repository`：数据访问层，定义数据库操作
  - `service`：服务层，包含业务逻辑
- `src/main/resources`：资源文件目录
  - `application.properties`：应用程序配置文件
- `build.gradle.kts`：Gradle 构建脚本

## API 端点

- 创建用户：`POST /api/users`
- 更新用户：`PUT /api/users/{id}`
- 删除用户：`DELETE /api/users/{id}`
- 获取用户：`GET /api/users/{id}`
- 获取所有用户：`GET /api/users`

## 示例请求

### 创建用户

使用 Postman 或其他工具发送 `POST` 请求到 `http://localhost:8080/api/users`，请求体示例如下：

```json
{
    "username": "newuser",
    "passwordHash": "hashedpassword",
    "email": "newuser@example.com",
    "phone": "1234567890"
}
```




