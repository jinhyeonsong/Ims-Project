package org.bmj.ims.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bmj.ims.service.MembersService;
import org.bmj.ims.util.FileRenameUtil;
import org.bmj.ims.util.ResizeImageUtil;
import org.bmj.ims.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {
	
	@Autowired
	private MembersService service;

	@RequestMapping(value= {"/","/index"},
			method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/session",
			method=RequestMethod.POST)
	public String log(Member member,
			HttpSession session,RedirectAttributes ra) {
		/*
		 * RedirectAttributes의 FlashAttribute는 한 번만 사용하고 사라지는 attribute
		 * */

		Member loginMember = 
				service.login(member);
		
		if(loginMember!=null) {
			session.setAttribute("loginMember", loginMember);
		}else {
			ra.addFlashAttribute("msg", "아이디나 비밀번호가 틀렸습니다.");
		}
	
		return "redirect:/";
	}
	
	@RequestMapping(value="/session",
			method=RequestMethod.DELETE)
	public String log(HttpSession session) {
		session.removeAttribute("loginMember");
		return "redirect:/";
	}
	
	@RequestMapping(value="/join",method = RequestMethod.GET)
	public void join() {
		
	}
	
	@RequestMapping(value="/ajax/profile",
			method=RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	private String uploadProfile(String type, 
			MultipartFile profile, 
			HttpServletRequest request) throws Exception {
		
		// 서버
		ServletContext application = request.getServletContext();

		// 기본경로
		String rootPath = application.getRealPath("/");

		// 업로드 폴더 경로
		String uploadPath = rootPath + "img" + File.separator + "upload" + File.separator;

		// 파일의 실제 이름
		String fileName = profile.getOriginalFilename();

		// 파일 객체 생성
		File file = new File(uploadPath + fileName);

		// 파일이름이 같다면 숫자가 붙음
		file = FileRenameUtil.rename(file);

		System.out.println(file);

		// 임시폴더에 우리 업로드폴더로 이동
		profile.transferTo(file);

		// 리사이즈가 필요한 경우 하면 됨
		String resizePath = rootPath + "img" +
		File.separator + "members" + File.separator;

		// 리사이즈
		ResizeImageUtil.resize(file.toString(), resizePath + file.getName(), 200);
		
		return "{\"profileName\":\""+file.getName()+"\"}";
	}
	
	@RequestMapping(value="/ajax/check/id", 
			method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String checkId(String id){
		return "{\"result\":"+service.checkId(id)+"}";
	}
	
	@RequestMapping(value="/ajax/check/nickname", 
			method=RequestMethod.GET,
			produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String checkNickname(String nickname) {
		return "{\"result\":"+service.checkNickname(nickname)+"}";
	}
	
	
}
