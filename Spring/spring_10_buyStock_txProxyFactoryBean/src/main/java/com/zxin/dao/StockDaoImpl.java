package com.zxin.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockDaoImpl extends JdbcDaoSupport implements IStockDao {

	@Override
	public void insertStock(String sname, int amount) {
		String sql = "insert into stock(sname, count) values(?,?)";
		this.getJdbcTemplate().update(sql, sname, amount);
	}

	@Override
	public void updateStock(String sname, int amount, boolean isBuy) {
		String sql = "update stock set count=count-? where sname=?";
		if(isBuy) {
			sql = "update stock set count=count+? where sname=?";
		}
		this.getJdbcTemplate().update(sql, amount, sname);
	}

}
