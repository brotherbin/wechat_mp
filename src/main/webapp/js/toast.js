/**
 * 用Jquery仿照Android的Toast效果
 * 用法：new Toast("msg").show();
 */
var Toast = function(msg) {
	this.context = $("body");
	this.message = msg;
	this.fadeTime = 1000;
	this.showTime = 2000;
	this.bottom = 50;
	this.left;
	this.init();
}
var msgEntity;
Toast.prototype = {
	init : function() {
		$("#t-o-a-s-t-M-s-g").remove();
		var msgDiv = "<div id='t-o-a-s-t-M-s-g'><span>" + this.message + "</span></div>";
		this.context.append(msgDiv);
		msgEntity = $("#t-o-a-s-t-M-s-g");
		this.left = this.context.width()/2 - msgEntity.find('span').width()/2 - 20;
		msgEntity.css({
			'position': 'fixed',
			'bottom': this.bottom,
			'left': this.left,
			'background-color': '#000000',
			'color': '#fff',
			'font-size': '1.0em',
			'font-family': '微软雅黑',
			'padding': 10,
			'margin': 10,
			'border-radius': 10,
			'z-index': 999
		})
		msgEntity.hide();
	},
	show: function() {
		msgEntity.fadeIn(this.fadeTime);
		msgEntity.delay(this.showTime);
		msgEntity.fadeOut(this.fadeTime);
	}
}