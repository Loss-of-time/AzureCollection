# 项目名称：AzureCollection

## 项目简介

AzureCollection 是一个基于 Spring Boot 的数字收藏品管理系统，支持用户创建、管理和展示数字收藏品。

## 技术栈

- Java 21
- Spring Boot 3.4.0
- Gradle
- MySQL
- JPA (Java Persistence API)

## 项目结构

- `src/main/java/edu/swjtu/azurecollection`：Java 源代码目录
  - `controller`：控制器层，处理 HTTP 请求
  - `pojo`：实体类，映射数据库表
  - `repository`：数据访问层，定义数据库操作
  - `service`：服务层，包含业务逻辑
- `src/main/resources`：资源文件目录
  - `application.properties`：应用程序配置文件
- `build.gradle.kts`：Gradle 构建脚本

## 环境配置

1. 安装 Java 21
2. 安装 MySQL 并创建数据库 `AC_db`
3. 配置 `src/main/resources/application.properties` 文件中的数据库连接信息

```ini
spring.datasource.url=jdbc:mysql://localhost:3306/AC_db?severTimezone=UTC
spring.datasource.username=root
spring.datasource.password=2890
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## 构建和运行

1. 使用以下命令构建项目：

```sh
./gradlew build
```

2. 使用以下命令运行项目：

```sh
./gradlew bootRun
```

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

## 贡献指南

### 理论上
1. Fork 本仓库
2. 创建新分支 (`git checkout -b feature-branch`)
3. 提交更改 (`git commit -m 'Add some feature'`)
4. 推送到分支 (`git push origin feature-branch`)
5. 创建 Pull Request

### 实际
如果你能直接联系到我，请告知我将你添加为合作者，这样你就可以直接提交代码了。
