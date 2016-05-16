package cn.itcast.web.vote.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.web.vote.domain.Vote;
import cn.itcast.web.vote.util.JdbcUtil;

public class VoteDao {
	
	//根据ID查询候选人详细信息
	public Vote findVoteById(int id) throws SQLException {
		Vote vote = null;
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from vote where id = ?";
		vote = (Vote) runner.query(sql, id, new BeanHandler(Vote.class));
		return vote;
	}
	
	//查询所有的候选人信息
	public List<Vote> findAllVote() throws SQLException {
		List<Vote> voteList = new ArrayList<Vote>();
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from vote";
		voteList = (List<Vote>) runner.query(sql, new BeanListHandler(Vote.class));
		return voteList;
	}
}
