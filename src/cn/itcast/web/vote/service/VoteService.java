package cn.itcast.web.vote.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.web.vote.dao.ContentDao;
import cn.itcast.web.vote.dao.VoteDao;
import cn.itcast.web.vote.domain.Content;
import cn.itcast.web.vote.domain.Vote;

public class VoteService {
	private VoteDao voteDao = new VoteDao();
	private ContentDao contentDao = new ContentDao();
	//����ID��ѯ��ѡ����ϸ��Ϣ
	public Content findContentById(int id) throws Exception {
		try {
			//�ֶ�װ�������ϵ
			Content content = contentDao.findContentById(id);
			Vote vote = voteDao.findVoteById(id);
			content.setVote(vote);
			return content;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	//��ѯ���еĺ�ѡ����Ϣ
	public List<Vote> findAllVote() throws Exception{
		try {
			return voteDao.findAllVote();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
}
