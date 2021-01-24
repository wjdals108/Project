var date = new Date();
var day = document.querySelector(".day");
day.innerHTML= (date.getMonth()+1) + "/" + date.getDate() + getday(date.getDay());
function getday(getday){
    switch(getday){
        case 0:
            return "    일";
        case 1:
            return "    월";
        case 2:
            return "    화";
        case 3:
            return "    수";
        case 4:
            return "    목";
        case 5:
            return "    금";
        case 6:
            return "    토";
    }
}

var eleCount = document.querySelector(".hidden-count");
var count = parseInt(eleCount.value);

var left_item_num = count;  //count세서 숫자값 받아오자


function check(num){
	console.log(num);
    var task = document.getElementById(num);
    if(event.target.checked){
        task.style.textDecoration = "line-through";
		left_item_num--;
		print_left_item();
    } else {
        task.style.textDecoration = "none";
		left_item_num++;
		print_left_item();
    }
}

var left_item = document.querySelector(".left-item");
print_left_item();
function print_left_item() {
    left_item.innerHTML = "남은 할일 : " + left_item_num;
}