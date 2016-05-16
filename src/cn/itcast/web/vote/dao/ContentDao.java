package cn.itcast.web.vote.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.web.vote.domain.Content;
import cn.itcast.web.vote.util.JdbcUtil;

public class ContentDao {
	//����ID��ѯ��ѡ����ϸ��Ϣ
	public Content findContentById(int id) throws SQLException {
		Content content = null;
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from content where vid = ?";
		content = (Content) runner.query(sql, id, new BeanHandler(Content.class));
		return content;
	}
}
