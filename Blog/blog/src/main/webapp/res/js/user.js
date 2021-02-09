  function nmUpdate(boardNum) {
    var frmElem = document.getElementById(boardNum)
    var boardNmElem = frmElem.boardNm
    var boardNmUpdateBtnElem = frmElem.boardNmUpdateBtn

    
    boardNmElem.removeAttribute('disabled')
    boardNmElem.focus();
    boardNmUpdateBtnElem.style.display = 'inline-block'
  }


//아이디 중복확인
var chkIdElem = document.querySelector('#chkId');
if(chkIdElem){
	function ajax () {
		var frmElem = document.querySelector('#frm')
		var userIdElem = frmElem.userId
		var userIdValue = userIdElem.value
		
		if(userIdValue===''){
			alert('아이디를 입력하세요')
			userIdElem.focus()
			return
		}
		
		fetch(`/user/chkId/${userIdValue}`)
			.then(function(res) {
				return res.json()
			})
			.then(function(myJson) {
				if(myJson.result==1){
					alert('중복된 아이디가 있습니다.')
				} else {
					alert('사용할 수 있는 아이디 입니다.')
				}
			})
		}
	chkIdElem.addEventListener('click', ajax)
}



//닉네임 중복확인
var chkNicknameElem = document.querySelector('#chkNickname');
if(chkNicknameElem){
	function ajax () {
		var frmElem = document.querySelector('#frm')
		var nicknameElem = frmElem.nickname
		var nicknameValue = nicknameElem.value
		
		if(nicknameValue===''){
			alert('닉네임을 입력하세요')
			nicknameElem.focus()
			return
		}
		
		fetch(`/user/chkNickname/${nicknameValue}`)
			.then(function(res) {
				return res.json()
			})
			.then(function(myJson) {
				if(myJson.result==1){
					alert('중복된 닉네임이 있습니다.')
				} else {
					alert('사용할 수 있는 닉네임 입니다.')
				}
			})
		}
	chkNicknameElem.addEventListener('click', ajax)
}


//회원가입
var joinBtnElem = document.querySelector('#join-submit-btn')
if(joinBtnElem){
		var frmElem = document.querySelector('#frm')
		var userIdElem = frmElem.userId
		var userNicknameElem = frmElem.nickname
		var userPwElem = frmElem.userPw
		var userPwReElem = frmElem.userPwRe
		
	function ajax() {
		
		if(userIdElem.value === '') {
			alert('아이디를 입력해 주세요')
			userIdElem.focus()
			return
		} else if(userNicknameElem.value === '') {
			alert('닉네임을 입력해 주세요')
			userNicknameElem.focus()
			return
		} else if(userPwElem.value === '') {
			alert('비밀번호를 입력해 주세요')
			userPwElem.focus()
			return
		} else if(userPwElem.value !== userPwReElem.value){
			alert('비밀번호가 일치하지 않습니다.')
			userPwElem.focus()
			return
		}
		
		var param = {
			userId: userIdElem.value,
			nickname: userNicknameElem.value,
			userPw: userPwElem.value
		}
		
		fetch('/user/join', {
			method: 'post',
			headers: {
				'Content-Type': 'application/json',
		},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		})
		.then(function(myJson) {
			proc(myJson)
		})
	}
		
	function proc(myJson) {
		console.log(myJson)
		if(myJson.result === 0){
			alert('회원가입에 실패하였습니다.')
			return
		}
		alert('회원가입에 성공하였습니다.')
		location.href = '/user/login'
	}
		
	joinBtnElem.addEventListener('click', ajax)
}



//로그인
var loginBtnElem = document.querySelector('#login-submit-btn')
if(loginBtnElem){
	
	function ajax () {
		var frmElem = document.querySelector('#frm')
		var userIdElem = frmElem.userId
		var userPwElem = frmElem.userPw
	
		if(userIdElem.value === '') {
			alert('아이디를 입력해 주세요')
			return
		} else if(userPwElem.value === '') {
			alert('비밀번호를 입력해 주세요')
			return
		}
	
		var param = {
			userId: userIdElem.value,
			userPw: userPwElem.value
		}
		
		fetch('/user/login', {
			method: 'post',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(param)
			}).then(function(res) {
				return res.json()
			}).then(function(myJson) {
				console.log(myJson)
				proc(myJson)	
			})		
		}
		
		function proc(myJson) {
			switch(myJson.result){
				case 1:
					location.href = '/board/home'
					return
				case 2:
					alert('아이디를 확인해 주세요!!!')
					return
				case 3:
					alert('비밀번호를 확인해 주세요!!!')
					return
			}
		}
		loginBtnElem.addEventListener('click', ajax)
}