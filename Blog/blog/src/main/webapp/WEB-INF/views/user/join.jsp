<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="join-container">
	<div class="join-form-container">
	    <form id="frm">
	        <div class="join-top">
	            <div class="join-input-id-container">
	                <label for="input_id">ID : </label>
	                <button id="chkId" type="button">중복확인</button>
	            </div>
	            <input type="text" name="userId" id="input_id" placeholder="ID">
	            <div class="join-input-nickname-container">
		            <label for="input_nickname">NICKNAME : </label>
		            <button id="chkNickname" type="button">중복확인</button>	
	            </div>
	            <input type="text" name="nickname" id="input_nickname" placeholder="NICKNAME">
	            <label for="input_pw">Password : </label>
	            <input type="password" name="userPw" id="input_pw" placeholder="PASSWORD">
	            <label for="input_pw">Password Check : </label>
	            <input type="password" name="userPwRe" id="input_pw_check" placeholder="PASSWORD CHECK">
	        </div>
	        <div class="join-bottom">
	            <a href="/user/login">이미 가입하셨나요?</a>
	            <button type="button" id="join-submit-btn">Join</button>
	        </div>
	    </form>
	</div>
</div>