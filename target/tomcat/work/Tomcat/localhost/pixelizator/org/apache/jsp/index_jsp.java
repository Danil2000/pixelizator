/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-21 19:25:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Title</title>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Pixelizator</h1>\n");
      out.write("    <p>Вберите изображение</p>\n");
      out.write("    <div class=\"box\">\n");
      out.write("        <label class=\"headers\">Load image</label>\n");
      out.write("        <input id=\"file\" class=\"buttons\" type=\"file\">\n");
      out.write("        <label>Pixel scale</label>\n");
      out.write("        <input type=\"range\" id=\"volume\" name=\"volume\"\n");
      out.write("               min=\"1\" max=\"50\" onchange=\"setLblValue()\">\n");
      out.write("        <label id=\"lblValue\" for=\"volume\"></label>\n");
      out.write("        <input id=\"fileClear\" class=\"buttons\" type=\"button\" value=\"send\" onclick=\"send()\">\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"js/form.js\"></script>\n");
      out.write("    <img id=\"imgAltered\" alt=\"\" src=\"\" style=\"transform: rotateZ(90deg) scale(1,-1);\">\n");
      out.write("    <div id=\"info\">\n");
      out.write("        <label id=\"size\"></label> <br>\n");
      out.write("        <label id=\"sizePicture\"> </label>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ls<div id = \"download\">\n");
      out.write("        <a id=\"linkDownload\" href=\"\" download=\"pixel.jpeg\">.jpeg</a>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}