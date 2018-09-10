
namespace java site.caoh.dll

service Mt4Service
{
	/**
	 * @brief 心跳 & 断开重连
	 * @param
	 * @return
	 */
	void ping();

	/**
	 * @brief 新建组
	 * @param
	 *		group		组名称
	 * @return
     *		success:%d	成功
	 *		failure:%d	失败
	 */
	string mt4NewGroup(1:string group);

	/**
	 * @brief 新建管理员
	 * @param
	 *		login		Account Number
	 *		groups		组名称逗号拼接
	 * @return
	 *		success:%d	成功
	 *		failure:%d	失败
	 */
	string mt4NewAdmin(1:i32 login, 2:string groups);

}