package cn.itcast.web.vote.domain;

//候选人详细信息
public class Content {
	 //编号
	 private int id; 
	 //年龄
	 private int age;
	 //描述
	 private String description;
	 //候选人（一对一关系）
	 private Vote vote;
	 public Content() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Vote getVote() {
		return vote;
	}
	public void setVote(Vote vote) {
		this.vote = vote;
	}
}
