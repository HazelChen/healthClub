function checkForm() { 
		$("#cardId").next(".error").html("");
		
		var cardId=$("#cardId").attr('value');
		if (cardId=="") {
			$("#cardId").next(".error").html("请填写银行卡号！");
			return false;
		}
		return true;
	} 