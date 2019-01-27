package com.zxin.dao;


import com.zxin.bean.NewsLabel;

import java.util.List;

public interface INewsLabelDao {
	List<NewsLabel> selectChildrenByParent(int pid);
}
