
# Mt4Server.exe
基于mt4官方提供的ManagerAPI.dll进行二次封装并对外提供thrift接口(支持多语言客户端访问), 为CRM系统提供操作接口, 通过长时间实践总结进行了诸多优化, 比如心跳, 断开重连, 查询接口通过sqlite3进行数据缓存以提高mt4并发查询能力
* 心跳 & 自动重连
* 开户
* 出入金
* 用户信息查询
* 用户持仓订单查询
* 用户历史订单查询
* 下单
* 用户保证金查询
* 重置密码
* 行情数据
* 设置杠杆
* 获取mt4时区

---

# Mt4Plugin.dll
由于mt4的ServerApi的要求实现dll供mt4服务端加载并对外提供thrift接口(支持多语言客户端访问)
* 新建组
* 新建管理员

---

# Mt4Client
Mt4Server.exe和Mt4Plugin.dll的java客户端实现, 请参考, PHP, C#请自行使用thrift描述文件生成接口客户端代码 ..
