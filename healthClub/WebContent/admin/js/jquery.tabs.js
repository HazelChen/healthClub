// Jquery.tabs Document download by http://www.codefans.net
// Ŀ�ģ�Ϊȫվ����tabs�л����ܽű��Ա�ҳ��ű�ͳһ����
// ��д����˧
// ʱ�䣺2012��4��26��
(function($){
	$.fn.extend({ 
		"tabs":function(options){    
			options=$.extend({
				_event:0,
				index:0,
				animateSpeed:500,
				tabWidth:930,
				tabHeight:550,
				listHeight:37,
				opacity:false,
				xScroll:false,
				yScroll:false
		    },options);	
		    
			if(!$(this).hasClass("tabs")){
				$(this).addClass("tabs")
			};
			
			//������
			var obj = $(this),
				  list = $(".tabs-list",obj),
				  _option = $(".tabs-option",list),
				  box = $(".tabs-box",obj),
				  content = $(".tabs-content",box);
			
			//����	  
			var index = options.index,
				 tabWidth = options.tabWidth,
				 tabHeight = options.tabHeight,
				 listHeight = options.listHeight;
			
			//��ʽ����
			obj.css({"width":tabWidth,"height":tabHeight});
			list.css("width",tabWidth-8);
			box.css({"width":tabWidth-2});
			content.css({"width":tabWidth-2,"display":"none"}).eq(index).css("display","block");
			_option.eq(index).addClass("selected");
			
			//�����ж�
			if(options._event==1){
				_option.click(function(){
					index=_option.index(this);
					_animate(index);
				});
			}else{
				_option.mouseenter(function(){
					index=_option.index(this);
					_animate(index);
				});	
			}
			
			if(options.xScroll){
				content.css({"display":"block","float":"left"});
				$(".fatbox",box).css({"width":(tabWidth-2)*content.length});
			}else if(options.yScroll){
				content.css({"display":"block","height":tabHeight-listHeight});
				box.css({"height":tabHeight-listHeight-1});
				$(".fatbox",box).css({"width":(tabWidth-2),"height":(tabHeight-listHeight-1)*content.length});
			}
			
			
			function _animate(index){
				if(options.opacity){
					opacityPlay(index);
				}else if(options.xScroll){
					xScrollPlay(index);
				}else if(options.yScroll){
					yScrollPlay(index);
				}else{
					Play(index);
				};
			};
			
			function Play(index){
				_option.removeClass("selected").eq(index).addClass("selected");
				content.css("display","none").eq(index).css("display","block");
			};
			
			function opacityPlay(index){
				_option.removeClass("selected").eq(index).addClass("selected");
				if(content.eq(index).css("display")== "none"){
					content.css("display","none").eq(index).fadeIn(options.animateSpeed);
				}
			};
			
			function xScrollPlay(index){
				_option.removeClass("selected").eq(index).addClass("selected");
				$(".fatbox",box).animate({
						marginLeft:-(tabWidth-2)*index
				},options.animateSpeed)
			}
			
			function yScrollPlay(index){
				_option.removeClass("selected").eq(index).addClass("selected");
				$(".fatbox",box).animate({
						marginTop:-(tabHeight-listHeight)*index
				},options.animateSpeed)
			}
			
			
			
		}
	})
})(jQuery)