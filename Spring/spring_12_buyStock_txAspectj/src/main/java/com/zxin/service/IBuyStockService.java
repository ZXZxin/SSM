package com.zxin.service;


// 这些不像之前的增删改查,　这就是所谓的业务
public interface IBuyStockService {

	// 开账号
	void openAccount(String aname, double money);

	// 开股票
	void openStock(String sname, int amount);

	// 用银行里的这些money 去买名字叫做sname的amount数量的股票
	// 如果是买股票: 银行账户会减钱,  股票(自己的股票)增加
	// 如果是卖股票: 银行账户会加钱，　股票(自己的股票)减少
	void buyStock(String aname, double money, String sname, int amount) throws BuyStockException;
}
