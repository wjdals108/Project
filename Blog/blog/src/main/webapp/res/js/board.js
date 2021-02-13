function resize(obj) {
    obj.style.height = "1px";
    obj.style.height = (12+obj.scrollHeight)+"px";
}

function nmUpdate(boardNum) {
  var frmElem = document.getElementById(boardNum)
  var boardNmElem = frmElem.boardNm
  var boardNmUpdateBtnElem = frmElem.boardNmUpdateBtn
  
  boardNmElem.removeAttribute('disabled')
  boardNmElem.focus();
  boardNmUpdateBtnElem.style.display = 'inline-block'
}

//글쓰기
var writeBtnElem = document.querySelector('#write-submit-btn')

if(writeBtnElem){
		var frmElem = document.querySelector('#write-form')
		var selectBoardElem = frmElem.board
		var titleElem = frmElem.title
		var ctntElem = frmElem.ctnt
		
	function ajax() {
		
		if(selectBoardElem.value == 0) {
			alert('게시판을 선택해 주세요')
			selectBoardElem.focus()
			return
		} else if(titleElem.value === '') {
			alert('제목을 입력해 주세요')
			titleElem.focus()
			return
		} else if(ctntElem.value === '') {
			alert('글 내용을 입력해 주세요')
			ctntElem.focus()
			return
		}
		
		var param = {
			category: selectBoardElem.value,
			title: titleElem.value,
			ctnt: ctntElem.value
		}
		
		fetch('/board/write', {
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
			alert('글쓰기에 실패하였습니다.')
			return
		}
		alert('글 등록 완료')
		location.href = `/board/list?category=${selectBoardElem.value}`
	}
		
	writeBtnElem.addEventListener('click', ajax)
}


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


//cmt 부분
var cmtElem = document.querySelector('.cmt-article-container')
if(cmtElem) {
	
	selCmtList()
	
	function selCmtList() {
		cmtElem.innerHTML = ''
		
		var getBoardPkElem = document.querySelector('#getBoardPk')
		
		fetch(`/cmt?boardPk=${getBoardPkElem.value}`)
			.then(function(res) {
				return res.json()
			}).then(function(myJson) {
				myJson.forEach(function (item) {
					makeCmt(item)
				})
			})
		
	}
	
	function makeCmt(item) {
		var article = document.createElement('article')
		article.className = 'cmt-article'
		
		article.innerHTML = 
		`
		<span><strong>${item.nickname}</strong></span>
		<p>${item.ctnt}</p>
		<div class="cmt-article-bottom">
			<span class="cmt-dt">${item.regDt}</span>
			<button id="cmt-del-btn" type="button" onclick="delCmt(${item.cmtPk}, '${item.nickname}')">삭제</button>
		</div>
		`
		cmtElem.append(article)
	}
}

//댓글삭제
function delCmt(cmtPk, cmtNickname) {
	if(cmtNickname !== loginNicknameElem.value) {
		alert('삭제권한이 없습니다.')
		return
	}
	
	if(confirm('정말 삭제하시겠습니까?')){
		fetch(`/cmt?cmtPk=${cmtPk}`, {
			method: 'delete'
		}).then(res => res.json())
		.then(myJson => {
			if(myJson === 1) {
				selCmtList()
			} else {
				alert('삭제를 실패하였습니다.')
			}
		})
	}
}

var inputCmtBtnElem = document.querySelector('#input_cmt_btn')
var loginNicknameElem = document.querySelector('#login-cmt-nickname')
if(inputCmtBtnElem) {
	var getBoardPkElem = document.querySelector('#getBoardPk')
	var cmtCtntElem = document.querySelector('#input_cmt')
	
	function writeCmt(){
		
		if(cmtCtntElem.value === '') {
			alert('댓글을 입력해 주세요')
			cmtCtntElem.focus()
			return
		}
		
		var param = {
			boardPk: getBoardPkElem.value,
			nickname: loginNicknameElem.value,
			ctnt: cmtCtntElem.value
		}
		
		fetch('/cmt', {
			method: 'post',
			headers: {
				'Content-Type': 'application/json',
		},
			body: JSON.stringify(param)
		}).then(function(res){
			return res.json()
		}).then(function(myJson) {
			if(myJson==1) {
				cmtCtntElem.value = ''
				selCmtList()
			} else {
				alert('댓글등록 실패')
			}
		})
	
	
	}
	inputCmtBtnElem.addEventListener('click', writeCmt)
}