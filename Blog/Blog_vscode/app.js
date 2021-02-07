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