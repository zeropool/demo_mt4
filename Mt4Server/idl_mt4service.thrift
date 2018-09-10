/**
 * @author	
 * @date	2017/12/17
 * @comment	
 *	已知问题:
 */
namespace java site.caoh.exe

enum TradeCMD
{
	OP_BUY_LIMIT = 2,
	OP_SELL_LIMIT,
	OP_BUY_STOP,
	OP_SELL_STOP
}

service Mt4Service
{
	/**
	 * @brief 心跳 & 断开重连
	 * @param
	 * @return
	 */
	void ping();

	/**
	 * @brief 开户
	 * @param
	 *		login		Account Number
	 *		name		用户名
	 *		group		组
	 *		email		邮箱
	 *		password	密码, 对格式有要求, 具体请测试或者咨询刘总
	 * @return
     *		success:%d	成功
	 *		failure:%d	失败
	 */
	string mt4AccOpen(1:i32 login, 2:string name, 3:string group, 4:string email, 5:string password);

	/**
	 * @brief 出入金
	 * @param
	 *		login		Account Number
	 *		amount		金额, 正负
	 * @return
	 *		success:%d	成功
	 *		failed:%d	失败
	 */
	string mt4AccDeposits(1:i32 login, 2:double amount);

	/**
	 * @brief 用户信息
	 * @param
	 *		login		Account Number
	 * @return
	 *		name		用户名
	 *		group		组
	 *		balance		余额
	 *		taxes		税率
	 *		credit		信用
	 */
	map<string, string> mt4AccInfo(1:i32 login);

	/**
	 * @brief 查询系统所有用户的持仓订单
	 * @param
	 *		login		Account Number
	 * @return
	 *		order		订单号
	 *		commission	佣金
	 *		storage		利息
	 */
	//list<map<string, string>> mt4AllOrders();

	/**
	 * @brief 历史订单信息
	 * @param
	 *		login		Account Number
	 *		tmfrom		开始时间戳
	 *		tmto		结束时间戳
	 * @return
	 *		order		订单号
	 */
	list<map<string, string>> mt4AccOrderHis(1:i32 login, 2:i32 tmfrom, 3:i32 tmto);

	/**
	 * @brief 下单
	 * @param
	 *		login		Account Number
	 * @return
	 *		success:%d	成功
	 *		failure:%d	失败:失败原因
	 */
	string mt4AccOrderNew(1:i32 login, 2:TradeCMD cmd, 3:string symbol, 4:i32 volume, 5:double price, 6:double stoploss,
		7:double takeprofit, 8:string comment);

	/**
	 * @brief 查询某个用户的保证金
	 * @param
	 *		login		Account Number
	 * @return
	 *		balance		余额
	 *		equity		净值
	 *		margin		保证金
	 *		margin_free	可用
	 *		margin_level	比例
	 */
	map<string, string> mt4AccMargin(1:i32 login);

	/**
	 * @brief 查询某个用户的持仓订单
	 */
	list<map<string, string>> mt4AccOrders(1:i32 login);
	
	/**
	 * @brief 重置密码
	 */
	string mt4ResetPwd(1:i32 login, 2:string password);
	
	/**
	 * @brief 行情数据
	 */
	list<map<string, string>> mt4Market();
	
	/**
	 * @brief 设置杠杆
	 */
	string mt4SetLeverage(1:i32 login, 2:i32 leverage);
	
	/**
	 *
	 */
	string mt4GetTimezone();
}