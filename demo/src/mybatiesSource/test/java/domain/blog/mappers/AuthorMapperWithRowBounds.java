 *							for(var i = 0;i<msgs.length;i++){
� z								var tr = $("<tr resType="+msgs[i].resourceType+" resId="+msgs[i].resourceId+" title="+msgs[i].message+"></tr>");
� F								var td = $("<td width='40' height='60' valign='top'></td>");
� Q								td.append("<img style='width:27px;height:34px;margin:12px 0 0 4px;' src='� &/tc_suite/portal/images/msg.png'>");
� 								tr.append(td);
� 								td = "<td name='replys' valign='top' align='left' style='border-bottom:1px solid #b5b5b5;padding:5px 0px 5px 5px;'>";
� �								td+="<div class='content' style='word-wrap: break-word;  padding-top: 0.5em; line-height: 20px; vertical-align: top;font-size: 12px;'>";
� H								td+="<div style='width:100%;' class='title'>"+msgs[i].message;
� "								td+="</div></div></td>";
 %								tr.bind("click",function(){
 X									openMsg($(this).attr("resType"),$(this).attr("resId"),$(this).attr("title"));
 								});
 "								$("#s