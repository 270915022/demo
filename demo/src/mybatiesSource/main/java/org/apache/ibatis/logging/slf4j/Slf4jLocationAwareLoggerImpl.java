te("\t\t\t\t\t\t\t\t<a href=\"#\" id=\"smallView\"  onclick=\"viewChange('smallImg')\" title=\"列表展示\"  class=\"glyphicon glyphicon-list-alt current\"></a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"search-nav\" id=\"searchId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:searchObj.filtrate.byDateRange()\" class=\"current\">全部</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span style=\"color:#ccc;\">|</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a id=\"actionbar-btn-upload-createDate\" href=\"javascript:searchObj.orderBy('createDate', 1, $('#actionbar-btn-upload-createDate'))\" class=\"\" data=\"createDate\">最新上传</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span style=\"color:#ccc;\">|</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a id=\"actionbar-btn-upload-downloadTimes\" href=\"javascript:searchObj.orderBy('downloadTimes', 1, $('#actionbar-btn-upload-downloadTimes'))\" class=\"\" data=\"downloadTimes\">最多下载</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span style=\"color:#ccc;\">|</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span style=\"margin-left:40px;color:#808080;\">发布时间：</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:searchObj.filtrate.byDateRange('week')\" style=\"border:none;\">本周</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span style=\"color:#ccc;\">|</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:searchObj.filtrate.byDateRange('1M')\" style=\"border:none;\">本月</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span style=\"color:#ccc;\">|</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:searchObj.filtrate.byDateRange('3M')\" style=\"border:none;\">本季度</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t      <div cl