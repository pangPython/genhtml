package cn.pangpython.sohu.dao;

import cn.pangpython.sohu.model.po.NewsInfo;
import cn.pangpython.sohu.model.query.NewsInfoQuery;


import java.util.List;

/**
 * Description: NewsInfoDao
 * Author: curd generator
 * Create: 2016-02-18 11:45
 */

public interface NewsInfoDao {

    int insert(NewsInfo po);

    int update(NewsInfo po);

    List<NewsInfo> query(NewsInfoQuery query);

    long count(NewsInfoQuery query);

}