 			$("#msg-content").hide();
m 		$("#msg-navi").show();
o 	function showInfo() {
q 		TC.topWin.$.dialog({
s 			title : '个人设置',
u 			max : false,
w 			min : false,
y 			width : '500px',
{ 			height : '420px',
}  			content : 'url:'+person+'',
 			lock : true,
� 			parent : this,
� 			button : [ {
� 				name : '确定',
� 				callback : function() {
� 					var api = this;
� +					this.content.savePerson(function() {
� �						$("#personPicon").attr("src", $("#personPicon").attr("src") + "&r=" + new Date().getTime()+"&width:100,height:100");// 刷新头像
� 						api.close();
� 					}); //提交并关闭
� 					return false;
� 				},
� 				focus : true
� 				}, {
� 				name : '取消'
� 			}]
� 	}
� 	function showUserInfo(obj){
� 		var off = $(obj).offset();
� /		$(".userInfo").css("left",off.left-2+"px");
� -		$(".userInfo").css("top",off.top-