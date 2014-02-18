
$(document).ready(function() { 
    $("#childCountDiv").hide(); 
    $("#typeDiv input:radio").click(function(){      
        if($(this).attr("id") == "family" && ($(this).attr("checked") == true || $(this).attr("checked") == "checked")) { 
            $("#childCountDiv").show(); 
        }else{ 
            $("#childCountDiv").hide(); 
        }
    });
}); 

function register_checkForm() { 
	$("#email").next(".error").html("");
	$("#rg_password").next(".error").html("");
	$("#confirmPassword").next(".error").html("");
	$("#family").next(".error").html("");
	$("#childCount").next(".error").html("");
	
	var email=$("#email").attr('value');
	if (email=="") {
		$("#email").next(".error").html("请填写身份证号！");
		return false;
	}
	
	var confirmPassword=$("#confirmPassword").attr('value');
	if (password!=confirmPassword) {
		$("#confirmPassword").next(".error").html("密码不一致！");
		return false;
	}
	
	if(!($("#personal").attr("checked") || $("#family").attr("checked"))) {
		$("#family").next(".error").html("请选择类型！");
		return false;
	}
	
	if ( $("#family").attr("checked") && $("#childCount").attr('value')=="") {
		$("#childCount").next(".error").html("请填写孩子数量！");
		return false;
	}
	
	$("#register").submit();
	return true;
}

function cardIdFormCheck() {
	$("#cardId").next(".error").html("");
	if ( $("#cardId").attr('value') =="") {
		$("#cardId").next(".error").html("请填写银行卡号");
		return false;
	}
}