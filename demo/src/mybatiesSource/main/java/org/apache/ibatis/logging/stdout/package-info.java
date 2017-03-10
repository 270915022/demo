  height: '500px',\r\n");
      out.write("\t                lock : true,\r\n");
      out.write("\t                parent : this,\r\n");
      out.write("\t                button : [\r\n");
      out.write("\t                          {\r\n");
      out.write("\t                        \t  \"name\":\"保存\",\r\n");
      out.write("\t                        \t  callback:function(){\r\n");
      out.write("\t                        \t\t  var result = this.content.window.saveShare();\r\n");
      out.write("\t                        \t\t  alertOrRefresh(result);\r\n");
      out.write("\t                        \t\t  return false;\r\n");
      out.write("\t                        \t  },\r\n");
 