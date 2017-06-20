package kr.ac.hansung;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hansung.jdbc.BookInfo;
import kr.ac.hansung.jdbc.BookInfoDAO;
import kr.ac.hansung.jdbc.RecommandInfo;
import kr.ac.hansung.jdbc.RecommandInfoDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/ac/hansung/beans/beans.xml");
	BookInfoDAO bookInfoDAO = (BookInfoDAO) context.getBean("BookInfoDAO");
	RecommandInfoDAO recommandInfoDAO = (RecommandInfoDAO) context.getBean("RecommandInfoDAO");

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(Locale locale, ModelAndView modelAndView) {
		logger.info("Welcome home! The client locale is {}.", locale);
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@RequestMapping(value = "/register/recommand", method = RequestMethod.GET)
	public ModelAndView register_recommand(HttpServletRequest request, ModelAndView modelAndView) {
		logger.info("Register Button book");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int book_type = 0, notify_type = 0;
		String phone_num = "", email = "", member = "";

		if (request.getParameter("book_type") != null && request.getParameter("notify_type") != null) {

			String[] selectedBookType = request.getParameterValues("book_type");
			for (String string : selectedBookType) {
				book_type += Integer.parseInt(string);
			}
			String[] selectedNotifyType = request.getParameterValues("notify_type");
			for (String string : selectedNotifyType) {
				notify_type += Integer.parseInt(string);
			}
			member = request.getParameter("member_info");
			phone_num = request.getParameter("phone_num");
			email = request.getParameter("email_add");
			RecommandInfo recommandInfo = new RecommandInfo(member, book_type, notify_type, phone_num, email);

			// insert 성공 여부 판단
			if (recommandInfoDAO.insert(recommandInfo))
				modelAndView.setViewName("redirect:/");
			else {
				modelAndView.setViewName("error");
				logger.info("Jump Error Web Page");
			}
		} else {
			modelAndView.setViewName("error");
			logger.info("Jump Error Web Page");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/register/book", method = RequestMethod.GET)
	public ModelAndView buttonAction(HttpServletRequest request, ModelAndView modelAndView) {
		logger.info("Register Button book");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int publish = 0;
		String book_code = null, title = null, author = null, book_type = null;

		if (request.getParameter("publish") != null && request.getParameter("book_code") != null
				&& request.getParameter("title") != null && request.getParameter("author") != null) {
			publish = Integer.parseInt(request.getParameter("publish"));
			book_code = request.getParameter("book_code");
			book_type = request.getParameter("book_type");
			title = request.getParameter("title");
			author = request.getParameter("author");
			BookInfo libInfo = new BookInfo(book_code, book_type, title, author, publish);

			// insert 성공 여부 판단
			if (bookInfoDAO.insert(libInfo)) {
				new EmailSender().sendMail(book_type, title.trim());
				modelAndView.setViewName("redirect:/");
			} else {
				modelAndView.setViewName("error");
				logger.info("Jump Error Web Page");
			}
		} else {
			modelAndView.setViewName("error");
			logger.info("Jump Error Web Page");
		}

		return modelAndView;
	}
}
