Cufon.replace('h1',{ textShadow: '1px 1px #edde8b'});
Cufon.replace('h2',{ textShadow: '1px 1px #edde8b'});
Cufon.replace('h3',{ textShadow: '1px 1px #000'});
Cufon.replace('.back');

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
	
	function login_checkForm() { 
		$("#id").next(".error").html("");
		$("#password").next(".error").html("");
		
		var id=$("#id").attr('value');
		if (id=="") {
			$("#id").next(".error").html("请填写识别码！");
			return false;
		}
		var password=$("#password").attr('value');
		if (password=="") {
			$("#password").next(".error").html("请填写密码！");
			return false;
		}
		$("#login").submit();
		return true;
	} 
	
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
		
		var password=$("#rg_password").attr('value');
		if (password=="") {
			$("#rg_password").next(".error").html("请填写密码！");
			return false;
		}
		
		var confirmPassword=$("#confirmPassword").attr('value');
		if(confirmPassword=="") {
			$("#confirmPassword").next(".error").html("请再次填写密码！");
			return false;
		} else if (password!=confirmPassword) {
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
	
	$(function() {
		//the form wrapper (includes all forms)
		var $form_wrapper = $('#form_wrapper'),
		//the current form is the one with class active
		$currentForm = $form_wrapper.children('form.active'),
		//the change form links
		$linkform = $form_wrapper.find('.linkform');

		//get width and height of each form and store them for later						
		$form_wrapper.children('form').each(function(i) {
			var $theForm = $(this);
			//solve the inline display none problem when using fadeIn fadeOut
			if (!$theForm.hasClass('active'))
				$theForm.hide();
			$theForm.data({
				width : $theForm.width(),
				height : $theForm.height()
			});
		});

		//set width and height of wrapper (same of current form)
		setWrapperWidth();

		/*
		clicking a link (change form event) in the form
		makes the current form hide.
		The wrapper animates its width and height to the 
		width and height of the new current form.
		After the animation, the new form is shown
		 */
		$linkform.bind('click', function(e) {
			var $link = $(this);
			var target = $link.attr('rel');
			$currentForm.fadeOut(400, function() {
				//remove class active from current form
				$currentForm.removeClass('active');
				//new current form
				$currentForm = $form_wrapper.children('form.' + target);
				//animate the wrapper
				$form_wrapper.stop().animate({
					width : $currentForm.data('width') + 'px',
					height : $currentForm.data('height') + 'px'
				}, 500, function() {
					//new form gets class active
					$currentForm.addClass('active');
					//show the new form
					$currentForm.fadeIn(400);
				});
			});
			e.preventDefault();
		});

		function setWrapperWidth() {
			$form_wrapper.css({
				width : $currentForm.data('width') + 'px',
				height : $currentForm.data('height') + 'px'
			});
		}

		/*
		for the demo we disabled the submit buttons
		if you submit the form, you need to check the 
		which form was submited, and give the class active 
		to the form you want to show
		 */
		$form_wrapper.find('input[type="submit"]').click(function(e) {
			e.preventDefault();
		});
	});