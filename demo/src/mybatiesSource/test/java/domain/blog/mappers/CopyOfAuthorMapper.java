ine = false,//是否在元素上
C +					passWord  = 123456,//设置的密码
E 						a;
G 			//画入9宫格子
I "			for( var i = 0; i < 3; i++ ){
K #				for( var j = 0; j < 3; j++ ){
M ^					var node = $( document.createElementNS("http://www.w3.org/2000/svg", "circle") ).attr({
O 						'cx': 110*j+90,
Q 						'cy': 110*i+90,
S 						'r': 40,
U *						'stroke': 'rgba(255,255,255,0.5)',
W 						'stroke-width': 2,
Y 						'fill': 'transparent',
[ 						'class':'roundA',
] 						'canDo':true
_ 
					});
a 					$that.append(node);
c 			//画入线段
e \			var DoLine = $( document.createElementNS("http://www.w3.org/2000/svg", "path") ).attr({
g 				'stroke':'#fff',
i 				'stroke-width': 2,
k 				'fill':'transparent',
m 				'd':' '
o 			$that.append(DoLine);
q 			//获取九宫格
s '			var circle = $that.find('circle');
u 			//在格子上按下
w !			circle.mousedown(function(){
y 				//可以画线
{ 				canLine = true;
} "				var Mx =