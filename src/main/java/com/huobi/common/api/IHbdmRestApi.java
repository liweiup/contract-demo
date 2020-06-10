package com.huobi.common.api;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpException;

import com.huobi.common.request.Order;

public interface IHbdmRestApi {

	/**
	 * 期货行情
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param contractType
	 *            合约类型: this_week:当周 next_week:下周 quarter:季度
	 * @param contract_code
	 *            合约code
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractInfo(String symbol, String contractType, String contractCode)
			throws HttpException, IOException;

	/**
	 * 获取合约指数
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractIndex(String symbol) throws HttpException, IOException;

	/**
	 * 获取合约最高限价和最低限价
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param contractType
	 *            合约类型: this_week:当周 next_week:下周 quarter:季度
	 * @param contract_code
	 *            合约code
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futurePriceLimit(String symbol, String contractType, String contractCode)
			throws HttpException, IOException;

	/**
	 * 获取当前可用合约总持仓量
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param contractType
	 *            合约类型: this_week:当周 next_week:下周 quarter:季度
	 * @param contract_code
	 *            合约code
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureOpenInterest(String symbol, String contractType, String contractCode)
			throws HttpException, IOException;

	/**
	 * 获取行情深度数据
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param type
	 *            step0, step1, step2, step3, step4, step5（合并深度0-5）；step0时，不合并深度
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureMarketDepth(String symbol, String type) throws HttpException, IOException;

	/**
	 * 获取K线数据
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param period
	 *            K线类型 1min, 5min, 15min, 30min, 60min, 1hour,4hour,1day, 1mon
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureMarketHistoryKline(String symbol, String period,String size) throws HttpException, IOException;

	/**
	 * 获取聚合行情
	 * 
	 * @param symbol
	 *            如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureMarketDetailMerged(String symbol) throws HttpException, IOException;

	/**
	 * 获取市场最近成交记录
	 * 
	 * @param symbol
	 *            如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约
	 * @return size 获取交易记录的数量 [1, 2000]
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureMarketDetailTrade(String symbol, String size) throws HttpException, IOException;

	/**
	 * 批量获取最近的交易记录
	 * 
	 * @param symbol
	 *            如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约
	 * @return size 获取交易记录的数量 [1, 2000]
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureMarketHistoryTrade(String symbol, String size) throws HttpException, IOException;

	/**
	 * 获取用户账户信息
	 * 
	 * @param symbol
	 *            "BTC","ETH"...如果缺省，默认返回所有品种
	 * @return size 获取交易记录的数量 [1, 2000]
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractAccountInfo(String symbol) throws HttpException, IOException;

	/**
	 * 获取用户持仓信息
	 * 
	 * @param symbol
	 *            "BTC","ETH"...如果缺省，默认返回所有品种
	 * @return size 获取交易记录的数量 [1, 2000]
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractPositionInfo(String symbol) throws HttpException, IOException;

	/**
	 * 获取用户订单信息
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param contractType
	 *            合约类型: this_week:当周 next_week:下周 month:当月 quarter:季度
	 * @param contractCode
	 *            BTC1403
	 * @param client_order_id
	 *            客户自己填写和维护，这次一定要大于上一次
	 * @param price
	 *            价格
	 * @param volume
	 *            委托数量(张)
	 * @param direction
	 *            "buy":买 "sell":卖
	 * @param offset
	 *            "open":开 "close":平
	 * @param leverRate
	 *            杠杆倍数[“开仓”若有10倍多单，就不能再下20倍多单]
	 * @param orderPriceType
	 *            "limit":限价 "opponent":对手价
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractOrder(String symbol, String contractType, String contractCode, String clientOrderId,
			String price, String volume, String direction, String offset, String leverRate, String orderPriceType)
			throws HttpException, IOException;

	/**
	 * 批量下单
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param contractType
	 *            合约类型: this_week:当周 next_week:下周 month:当月 quarter:季度
	 * @param contractCode
	 *            BTC1403
	 * @param client_order_id
	 *            客户自己填写和维护，这次一定要大于上一次
	 * @param price
	 *            价格
	 * @param volume
	 *            委托数量(张)
	 * @param direction
	 *            "buy":买 "sell":卖
	 * @param offset
	 *            "open":开 "close":平
	 * @param leverRate
	 *            杠杆倍数[“开仓”若有10倍多单，就不能再下20倍多单]
	 * @param orderPriceType
	 *            "limit":限价 "opponent":对手价
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractBatchorder(List<Order> orders) throws HttpException, IOException;

	/**
	 * 撤销订单
	 * 
	 * @param orderId
	 *            订单ID（ 多个订单ID中间以","分隔,一次最多允许撤消50个订单 ）
	 * @return clientOrderId 客户订单ID(多个订单ID中间以","分隔,一次最多允许撤消50个订单)
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractCancel(String orderId, String clientOrderId,String symbol) throws HttpException, IOException;

	/**
	 * 全部撤单
	 * 
	 * @param symbol
	 *            品种代码，如"BTC","ETH"...
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractCancelall(String symbol) throws HttpException, IOException;

	/**
	 * 获取合约订单信息
	 * 
	 * @param orderId
	 *            订单ID（ 多个订单ID中间以","分隔,一次最多允许撤消50个订单 ）
	 * @param clientOrderId
	 *            客户订单ID(多个订单ID中间以","分隔,一次最多允许撤消50个订单)
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractOrderInfo(String orderId, String clientOrderId,String symbol,String orderType) throws HttpException, IOException;

	/**
	 * 获取订单明细信息
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param orderId
	 *            订单id
	 * @param pageIndex
	 *            第几页,不填第一页
	 * @param pageSize
	 *            不填默认20，不得多于50
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractOrderDetail(String symbol, String orderId, String pageIndex, String pageSize,String createdAt,String orderType)
			throws HttpException, IOException;

	/**
	 * 获取合约当前未成交委托
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param pageIndex
	 *            第几页,不填第一页
	 * @param pageSize
	 *            不填默认20，不得多于50
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractOpenorders(String symbol, String pageIndex, String pageSize)
			throws HttpException, IOException;

	/**
	 * 获取合约历史委托
	 * 
	 * @param symbol
	 *            "BTC","ETH"...
	 * @param tradeType
	 *            0:全部,1:买入开多,2: 卖出开空,3: 买入平空,4: 卖出平多,5: 卖出强平,6: 买入强平,7:交割平多,8: 交割平空
	 * @param type
	 *            1:所有订单，2：已结束订单
	 * @param status
	 *            0:全部,3:未成交, 4: 部分成交,5: 部分成交已撤单,6: 全部成交,7:已撤单 createDate
	 *            7，90（7天或者90天）
	 * @param pageIndex
	 *            第几页,不填第一页
	 * @param pageSize
	 *            不填默认20，不得多于50
	 * @throws HttpException
	 * @throws IOException
	 */
	public String futureContractHisorders(String symbol, String tradeType, String type, String status,
			String createDate, String pageIndex, String pageSize) throws HttpException, IOException;

	/******************************************新增*******************************/
	/**
	 * 多空持仓账户数对比
	 * GET api/v1/contract_elite_account_ratio
	 * curl "https://api.hbdm.com/api/v1/contract_elite_account_ratio?symbol=BTC&period=60min"
	 * 请求参数
	 * 参数名称	是否必须	类型	描述	取值范围
	 * symbol	true	string	品种代码	"BTC","ETH"...
	 * period	true	string	周期	5min, 15min, 30min, 60min,4hour,1day
	 */
	public String futureContractEliteAccountRatio(String symbol, String period)
			throws HttpException, IOException;

	/**
	 * 精英账户多空持仓对比-持仓量
	 * 实例
	 * GET api/v1/contract_elite_position_ratio
	 * curl "https://api.hbdm.com/api/v1/contract_elite_position_ratio?symbol=BTC&period=60min"
	 * 请求参数
	 * 参数名称	是否必须	类型	描述	取值范围
	 * symbol	true	string	品种代码	"BTC","ETH"...
	 * period	true	string	周期	5min, 15min, 30min, 60min,4hour,1day
	 */
	public String futureContractElitePositionRatio(String symbol, String period)
			throws HttpException, IOException;
	/**
	 * 基差信息
	 * GET /index/market/history/basis
	 * curl "https://api.hbdm.com/index/market/history/basis?symbol=BTC-USD&period=1min&size=150&basis_price_type=open"
	 * 请求参数
	 * 参数名称	是否必须	类型	描述	默认值	取值范围
	 * symbol	true	string	合约名称		如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约
	 * period	true	string	周期		1min,5min, 15min, 30min, 60min,4hour,1day,1mon
	 * basiså_price_type	false	string	基差价格类型，表示在周期内计算基差使用的价格类型	不填，默认使用开盘价	开盘价：open，收盘价：close，最高价：high，最低价：low，平均价=（最高价+最低价）/2：average
	 * size	true	int	基差获取数量	150	[1,2000]
	 */

	public String futureContractHisbasis(String symbol,String period,String basis_price_type,String size)
			throws HttpException, IOException;

	public String futureContractHisbasisAll(String symbol,String period,String basis_price_type,String size)
			throws HttpException, IOException;


	/**
	 * 查询用户账户和持仓信息
	 * symbol	true	string	品种代码	支持大小写,"BTC","ETH"...
	 * contract_account_position_info
	 */
	String futureContractAccountPositionInfo(String symbol) throws HttpException, IOException;
}
