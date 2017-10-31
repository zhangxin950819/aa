package zhang.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import util.FinalUtil;
import util.VerifyCodeUtils;

public class VerifyImgAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public void creatVerifyImg() throws IOException {
		HttpServletRequest  request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse ();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession();
		session.setAttribute(FinalUtil.VERIFYCODE_IN_SESSION, verifyCode.toLowerCase());
		// 生成图片
		int w = 200, h = 80;
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
	}
}
