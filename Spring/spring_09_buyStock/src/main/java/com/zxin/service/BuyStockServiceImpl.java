package com.zxin.service;


import com.zxin.dao.IAccountDao;
import com.zxin.dao.IStockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("buyStockService")
public class BuyStockServiceImpl implements IBuyStockService {

	@Autowired
	@Qualifier("accountDao")
	private IAccountDao adao;
	@Autowired
	@Qualifier("stockDao")
	private IStockDao sdao;
	
//	public void setAdao(IAccountDao adao) {
//		this.adao = adao;
//	}

//	public void setSdao(IStockDao sdao) {
//		this.sdao = sdao;
//	}

	@Override
	public void openAccount(String aname, double money) {
		adao.insertAccount(aname, money);
	}

	@Override
	public void openStock(String sname, int amount) {
		sdao.insertStock(sname, amount);
	}

	@Override
	public void buyStock(String aname, double money, String sname, int amount) throws BuyStockException{
		boolean isBuy = true;
		adao.updateAccount(aname, money, isBuy);
//		if (1 == 1) {
//			throw new BuyStockException("购买股票异常");
//		}
		sdao.updateStock(sname, amount, isBuy);
	}

}
