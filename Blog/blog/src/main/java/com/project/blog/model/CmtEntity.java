package com.project.blog.model;

public class CmtEntity {

	private int cmtPk;
	private int boardPk;
	private String nickname;
	private String ctnt;
	private String regDt;
	
	public int getCmtPk() {
		return cmtPk;
	}
	public void setCmtPk(int cmtPk) {
		this.cmtPk = cmtPk;
	}
	public int getBoardPk() {
		return boardPk;
	}
	public void setBoardPk(int boardPk) {
		this.boardPk = boardPk;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	
}
