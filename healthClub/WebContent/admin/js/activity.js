$(document).ready(function() { 
    $(".reserve").click(function(){      
    	$(this).hide();
    	$(this).next().find(".reserve-input").show();
    	$(this).next().find(".right_button").show();
    });
}); 

