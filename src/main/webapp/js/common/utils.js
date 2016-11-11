var long2date = function(value,longOrShort){
	var d = new Date();
	d.setTime(value);
	var year = d.getFullYear();
    var month = (d.getMonth()+1)*1 > 9?(d.getMonth()+1):("0"+(d.getMonth()+1));
    var date = d.getDate()*1 > 9?d.getDate():"0"+d.getDate();
    
    var hour = d.getHours();
    var minute  = d.getMinutes();
    var second = d.getSeconds();
    
    var result = "";
    if(longOrShort=="short"){
    	result = year+"-"+month+"-"+date;
    }else if(longOrShort=="long"){
    	result = year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
    }else{
    	result = year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
    }
	return result;
}