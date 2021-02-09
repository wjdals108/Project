<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="login-container">
                <div class="login-form-container">
                    <form id="frm">
                        <div class="login-top">
                            <label for="input_id">ID : </label>
                            <input type="text" name="userId" id="input_id" placeholder="ID">
                            <label for="input_pw">Password : </label>
                            <input type="password" name="userPw" id="input_pw" placeholder="PASSWORD">
                        </div>
                        <div class="login-bottom">
                            <a href="/user/join">회원이 아니신가요?</a>
                            <button type="button" id="login-submit-btn">Login</button>
                        </div>
                    </form>
                </div>

            </div>