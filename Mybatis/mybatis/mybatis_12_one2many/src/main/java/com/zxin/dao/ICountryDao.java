package com.zxin.dao;

import com.zxin.bean.Country;

public interface ICountryDao {

    public Country selectCountryById(int cid);
}
