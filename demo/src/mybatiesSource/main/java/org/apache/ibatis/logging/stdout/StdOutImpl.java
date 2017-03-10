t.write("\t            searchObj.filtrate.flag = false;//重置搜索标志\r\n");
      out.write("\t            //重新初始化图片浏览\r\n");
      out.write("\t            dummyPhotoviewAuto(\"arctable\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("            });\r\n");
      out.write("    }  \r\n");
      out.write("\tfunction treeOpenFolder(dom){\r\n");
      out.write("        var $source = $(dom);\r\n");
      out.write("\t\tvar sourceId = $source.attr(\"data-files-id\");\r\n");
      out.write("\t\tvar sourceName = $source.attr(\"data-full-title\");\r\n");
      out.write("\t\tvar dataUrl = $source.attr(\"data-url\");\r\n");
      out.write("\t\tcurFolderId = sourceId;\r\n");
      out.write("\t\t//改变字体样式\r\n");
      out.write("\t\t$(\"span[name=folderNameSpan]\").css({\"color\":\"#333\",\"font-size\":\"14px\"});\r\n");
      out.write("\t\t$source.find(\"span[name=folderNameSpan]\").css({\"color\":\"blue\",\"font-size\":\"14px\"});\r\n");
      out.write("\t\tvar args = {\"m\": \"showFolder\",\"ownerType\": \"10000001\",\"viewType\":vie