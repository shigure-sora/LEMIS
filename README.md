# LEMIS
用Java Swing 写的实验设备管理信息系统(Laboratory Equipment Management Information System)以下简称LEMIS<br>
![image](https://user-images.githubusercontent.com/60839179/127880463-ebd4050b-ed41-4017-977b-7e99beda90fb.png)
## 标识与权限总览
![image](https://user-images.githubusercontent.com/60839179/127882028-10d8dc94-cce9-4745-bdcb-8356026a809e.png)

## 功能
#### 管理员
实验室管理：系统管理员可以新增或查看或修改实验室信息<br>
实验技术员管理：系统管理员可以新增或查看或修改实验技术员信息<br>
设备管理：系统管理员可以新增或查看或修改设备信息<br>
设备报修申请：系统管理员可以新增或查看或修改设备报修申请信息<br>
维修管理：系统管理员可以查看或修改设备维修状态信息<br>
设备报修申请审核：系统管理员可以批准或驳回设备报修申请<br>
#### 实验技术员
设备管理：实验技术员可以新增或查看或修改设备信息<br>
设备报修申请：实验技术员可以新增或查看或修改设备报修申请信息<br>
维修管理：实验技术员可以查看或修改设备维修状态信息<br>
#### 维修技术员
维修管理：维修员可以查看或修改设备维修状态信息<br>
#### 教师与学生等其他用户
设备报修申请：教师与学生可以新增或查看或修改设备报修申请信息<br>

**TODO**：
  - [ ] bugfix
  - [ ] 数据备份
  - [ ] AI自动录入
  - [ ] 冷重启
  - [ ] 软件国际化
  - [ ] 代码简化
  - [ ] 有好的数据库配置修改界面

## 使用方法
编辑gradle.properties，启用网络资源，注释或删除本地资源描述<br>
导入IDE 建议使用IDEA，IDEA会自动识别gradle脚本，等待项目构建完成<br>

## 项目预览

#### 登录窗口
![image](https://user-images.githubusercontent.com/60839179/127880249-f528cec4-c0a4-433c-832b-bc4680210aab.png)
#### 注册窗口
![image](https://user-images.githubusercontent.com/60839179/127880343-801a9fdd-eb72-4e7b-9ff9-30068baa5b69.png)
#### 找回密码窗口
![image](https://user-images.githubusercontent.com/60839179/127880404-36d51f18-f5ed-4a64-9311-df6626c13f5d.png)
#### 管理员默认界面（以下以其标识介绍，其他用户标识待构建完成后，自行测试）
![image](https://user-images.githubusercontent.com/60839179/127880463-ebd4050b-ed41-4017-977b-7e99beda90fb.png)
##### 实验室管理
![image](https://user-images.githubusercontent.com/60839179/127880656-460ee83f-8507-499d-8912-61027ccfd439.png)
##### 设备管理
![image](https://user-images.githubusercontent.com/60839179/127880726-d228a4f0-1893-49af-bcfe-a57011962d14.png)
##### 设备报修申请
![image](https://user-images.githubusercontent.com/60839179/127880780-34d5d83a-37e9-4865-9346-19436456a44a.png)
##### 实验技术员管理
![image](https://user-images.githubusercontent.com/60839179/127880821-8fa37df4-98ac-43ae-8b93-14292ee8b434.png)
##### 维修管理
![image](https://user-images.githubusercontent.com/60839179/127880885-9751726f-9c45-4be9-93d2-f3e710393cde.png)
##### 报修申请审核
![image](https://user-images.githubusercontent.com/60839179/127880993-ea8287db-db47-4d62-94ff-7305434915a9.png)
##### 关于LEMIS
![image](https://user-images.githubusercontent.com/60839179/127881043-f6827cb1-7604-4166-baa4-7cfa272a730f.png)

## 声明
本项目所使用的图标包括about页面的图标均来自互联网，如有侵权，我将立刻删除<br>

互动图标来源iconfont-阿里巴巴矢量图标库<br>

Airilib是目前我开发Minecraft mod 所用的外部库，恕不公开<br>

特别感谢JetBrains为本项目提供 Intellij IDEA等IDE授权<br>
![image](https://user-images.githubusercontent.com/60839179/127881222-51f94199-abe3-478f-82cb-bec8119ba1c7.png)

## 相关链接
个人GitHub主页：https://github.com/shigure-sora <br>
iconfont-阿里巴巴矢量图标库 https://www.iconfont.cn/ <br>
个人官网 https://soracraft.com/ <br>
MVNrepository https://mvnrepository.com/ <br>
JetBrains官网 https://www.jetbrains.com/zh-cn/ <br>

## 测试用户
Administrator（authcode 122448）<br>
Id: 316381099<br>
Password:123456<br>

Technician（authcode 140422）<br>
Id: 316381100<br>
Password:123456<br>

Maintenance Worker（authcode 211135）<br>
Id: 316381099<br>
Password:123456<br>

Teacher（authcode 564465）<br>
Id: 316381114<br>
Password:123456<br>

Student（authcode 165165）<br>
Id: 316381115<br>
Password:123456<br>
