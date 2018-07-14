    //过程：求m到n之间的和
	function QH(startNum, endNum) {
		var totalNum = 0;

		//求和过程
		for (var i = startNum; i <= endNum; i++) {
			totalNum = totalNum + i;
		}

		//输出过程
		alert(totalNum);

	}

  //======================================================================================
    //函数：求数字转为对应的星期
    function WeekChange(num)
    {
    	var week;
    	
    	switch(num){
    	
    	case "1":week="星期一";break;
    	case "2":week="星期二";break;
    	case "3":week="星期三";break;
    	case "4":week="星期四";break;
    	case "5":week="星期五";break;
    	case "6":week="星期六";break;
    	case "7":week="星期日";break;
    	default:week="无法识别的学号";break;
    	}
    	return week;
    }
    
    //过程：求数字转为星期
    function NumToWeek(){
    	var changedWeek;
    	
    	var num=prompt("请输入要转化的数字：",1);
    	
    	//调用变化过程
    	changedWeek=WeekChange(num);
    	//输出星期
    	alert(changedWeek);
    }
    
