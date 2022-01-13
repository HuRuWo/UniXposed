## UniXposed

xposed通用脚手架

内嵌

- 1.XP代码修改免重启
  
- 2.Sekiro 长连接框架 支撑RPC服务

- 3.工具类


## TODO LIST DescriptionFindClass 

加入一个实验性的功能 DescriptionFindClass 通过描述寻找class

[分支 dev_DescriptionFindClass](https://github.com/HuRuWo/UniXposed/tree/dev_DescriptionFindClass)


易用的Xposed脚手架，旨在解决软件版本之间的由于混淆导致的各种类名无法find问题。解决即使软件更新或者用户有各种各样的版本的情况下依然可以hook生效。

混淆导致的hook失效
多版本混淆导致的类名 find class error。快速迭代的版本导致 a.b.c.xx 路径在下次就会编程 a.c.d.xx。这会导致我们写死的类名无法正确抵达路径。

一般的商业软件都会快速的发版本，每个版本混淆类名。带着这些类名寻找失败，所以需要一个通用的方案去解决。

例如微信的版本，从豌豆荚上来看2021就发布了11个版本。其中8就有十个版本。

这种小版本号更改其实对核心的hook影响不大。但是却每次都要打开来看这次的更新导致的失效路径在哪里。

热修复影响的hook
还有一个就是热修复，在一次软件hook中。发现无法正常hook，检查软件版本号并未更新。最后排查发现是热更新导致的。例如tinker在导入下载新的dex文件之后。替换原来的dex文件。

同样的新的dex也是用了新的混淆方式，这就导致了新的dex合上去没法被find class找到。

通用的hook方式
源于WechatSpellbook的思想，针对我们的apk源文件进行扫描find特征值过滤出目标类。

1.包含的类名

2.包含的常量

3.继承关系

4.包含的变量(类)

5.包含的方法名(包括参数)

如果一个类里面的东西没有被混淆，那么下次混淆也不会被混淆。

依靠这些没有被混淆的信息去找到目标的混淆类。
