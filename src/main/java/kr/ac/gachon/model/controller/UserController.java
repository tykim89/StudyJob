package kr.ac.gachon.model.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.gachon.model.service.UserService;
import kr.ac.gachon.model.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes({ "member_id" })
@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/controller/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("member_id") String member_id,
			@RequestParam("password") String password, Model model) {

		int flag = userService.login(member_id, password);

		switch (flag) {
		case UserService.LOGIN_SUCCESS:
			model.addAttribute("member_id", member_id);
			model.addAttribute("loginFlag", "true");
			return "/result/login_success";
		case UserService.LOGIN_ID_FAIL:
			model.addAttribute("failMessage", "1");
			return "/login";
		default:
			model.addAttribute("failMessage", "2");
			return "/login";
		}
	}

	@RequestMapping("/result/login_success")
	public String loginSuccess() {
		return "/result/login_success";
	}

	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping("/controller/logout.do")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

	@RequestMapping("/insert")
	public String insert() {
		return "/insert";
	}

	@RequestMapping(value = "/controller/insert.do", method = RequestMethod.POST)
	public void insert(@RequestParam("member_id") String member_id,
			String member_name, String social_security_number, String password,
			String phone_number, String email, String postal_number,
			String address, String profile) {

		/* System.out.println(member_id); */

		userService.insert(member_id, member_name, social_security_number,
				password, phone_number, email, postal_number, address, profile);

	}

	@RequestMapping(value = "/controller/get_user.do", method = RequestMethod.POST)
	public String member(String id, HttpSession session, Model model) {

		if (id != null) {
			Member member = userService.getUserById(id);
			model.addAttribute("member", member);

			return "/user/view";
		} else {
			String member_id = (String) session.getAttribute("member_id");
			Member member = userService.getUserById(member_id);
			model.addAttribute("member", member);

			return "/user/view";
		}
	}

	/*
	 * @RequestMapping(value="/controller/get_user.do",
	 * method=RequestMethod.POST) public String member1(String id, Model model){
	 * 
	 * Member member = userService.getUserById(id);
	 * model.addAttribute("member",member);
	 * 
	 * return "/user/view"; }
	 */

	@RequestMapping(value = "/controller/get_user_list.do", method = RequestMethod.POST)
	public String getUserList(Model model) {
		List<Member> memberList = userService.getUserList();

		model.addAttribute("member", memberList);
		/*
		 * for (Member member : memberList) {
		 * System.out.println(member.toString()); }
		 */

		return "/user/list";
	}

	@RequestMapping(value = "/controller/get_user_list.do", method = RequestMethod.GET)
	public String getUserList2(Model model) {
		List<Member> memberList = userService.getUserList();

		model.addAttribute("member", memberList);
		/*
		 * for (Member member : memberList) {
		 * System.out.println(member.toString()); }
		 */

		return "/user/list";
	}

	@RequestMapping(value = "/controller/update.do", method = RequestMethod.POST)
	public void update(@RequestParam("member_id") String member_id,
			String member_name, String social_security_number,
			@RequestParam("password") String password, String phone_number,
			String email, String postal_number, String address, String profile) {
		userService.update(member_id, member_name, social_security_number,
				password, phone_number, email, postal_number, address, profile);

	}

	@RequestMapping("/delete")
	public String delete() {
		return "/delete";
	}

	@RequestMapping(value = "/controller/delete.do", method = RequestMethod.POST)
	public String delete(String id, HttpSession session, String password,
			Model model) {

		if (id != null) {

			userService.remove2(id);

			return "redirect:/controller/get_user_list.do";
		} else {
			String member_id = (String) session.getAttribute("member_id");

			int flag = userService.remove(member_id, password);

			switch (flag) {
			case UserService.DELETE_SUCCESS:
				System.out.println("성공");
				model.addAttribute("failMessage", "3");
				return "/delete";

			default:
				System.out.println("실패");
				model.addAttribute("failMessage", "4");
				return "/delete";
			}
		}
	}

}
