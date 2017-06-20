package kr.ac.hansung;

import java.util.List;
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
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/ac/hansung/beans/beans.xml");
	BookInfoDAO bookInfoDAO = (BookInfoDAO) context.getBean("BookInfoDAO");
	RecommandInfoDAO recommandInfoDAO = (RecommandInfoDAO) context.getBean("RecommandInfoDAO");

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelAndView modelAndView) {
		logger.info("Welcome home! The client locale is {}.", locale);

		List<BookInfo> bookInfos = bookInfoDAO.getTotalBook();
		List<RecommandInfo> recommandInfos = recommandInfoDAO.getTotalRecommand();

		modelAndView.setViewName("home");
		modelAndView.addObject("bookInfos", bookInfos);
		modelAndView.addObject("recommandInfos", recommandInfos);
		modelAndView.addObject("emailsenders", new EmailSender());
		return modelAndView;
	}

	@RequestMapping(value = "/newArrival", method = RequestMethod.GET)
	public ModelAndView recommand(Locale locale, ModelAndView modelAndView) {
		logger.info("Welcome home! The client locale is {}.", locale);

		// List<BookInfo> bookInfos = bookInfoDAO.getTotalBook();
		// List<BookInfo> divisionInfos = gradeInfoDAO.getTotalDivision();

		modelAndView.setViewName("newArrival");
		// modelAndView.addObject("bookInfos", bookInfos);
		// modelAndView.addObject("divisionInfos", divisionInfos);
		return modelAndView;
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public ModelAndView addBook(Locale locale, ModelAndView modelAndView) {
		logger.info("Welcome home! The client locale is {}.", locale);

		modelAndView.setViewName("addBook");
		return modelAndView;
	}

}
