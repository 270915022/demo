       }
� %        if(title.indexOf("《")>0){
� ,        	var start = title.indexOf("《");
� *        	var end = title.indexOf("》");
� 0        	title = title.substring(start+1,end);
� 4        TC.ui.openResource({label:title,url:url});
� 	function loginDwr(){
� 		DwrMessageManager.login('� ',function(result){
� 			if(result === true){
� R				DwrMessageManager.addOnlineTotalChangeListener("onlineTotalChangeListener");
� T				DwrMessageManager.addOnlinePersonChangeListener("onlinePersonChangeListener");
� h				DwrMessageManager.addCommunityMessageListener("communityMessageManager.communityMessageListener");
� 				$.getScript("� */tc_ttp/common/datacache.js",function(){
� .					TC.topWin.dataCache.personCache.init();
� 4					TC.topWin.dataCache.LastContactsCache.init();
� !				TC.message.listenMessage();
� 4				DwrMessageManager.setReviveMethod("loginDwr");