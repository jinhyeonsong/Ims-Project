package org.bmj.ims.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bmj.ims.service.IdolsService;
import org.bmj.ims.util.FileRenameUtil;
import org.bmj.ims.util.ResizeImageUtil;
import org.bmj.ims.vo.Idol;
import org.bmj.ims.vo.Like;
import org.bmj.ims.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/idol")
public class IdolController {

	@Autowired
	private IdolsService service;
	
	@RequestMapping(value="/like", method = RequestMethod.PUT)
	private String likeIdol(Like like, 
			RedirectAttributes ra) {
		
		try {
			service.likeIdol(like);
		} catch (Exception e) {
			System.out.println("에러발생");
			ra.addFlashAttribute("msg","서버 점검중! 다시 시도해주세요.");
		}
		
		return "redirect:/idol/"+like.getTypeNo();
	}
	
	@RequestMapping(value = "/{idolId}/modify",
			method = RequestMethod.GET)
	private String updateIdolForm(Model model,
			@PathVariable int idolId) {
		
		model.addAllAttributes(service.getIdolUpdateForm(idolId));
		
		return "idolForm";
	}

	@RequestMapping(value="/",
			method=RequestMethod.PUT)
	private String updateIdol(Idol idol) {
		service.updateIdol(idol);
		return "redirect:/idol/"+idol.getIdolId();
	}
	
	@RequestMapping(value = "/register",
			method = RequestMethod.GET)
	private String registerIdol(Model model) {

		model.addAttribute("groups", service.getGroups());

		return "idolForm";
	}

	@RequestMapping(value = "/",
			method = RequestMethod.POST)
	private String registerIdol(
			HttpServletRequest request,
			Idol idol, MultipartFile profile) 
	throws Exception{

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

		String resizePath = rootPath + "img" + File.separator + "idols" + File.separator;

		// 리사이즈
		ResizeImageUtil.resize(file.toString(), resizePath + file.getName(), 200);
		
		//Idol에 profileImage를 세팅(파일의 이름으로)
		idol.setProfileImage(file.getName());
		
		service.registerIdol(idol);

		return "redirect:/idol/"+idol.getIdolId();
	}

	@RequestMapping(value = "/{idolId}",
			method = RequestMethod.DELETE)
	public String deleteIdol(@PathVariable int idolId) {

		service.deleteIdol(idolId);

		return "redirect:/idol/page/1";
	}

	@RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
	private String idols(Model model,
			@PathVariable int page) {
		model.addAllAttributes(service.getIdols(page));
		return "idols";
	}

	@RequestMapping(value = "/{idolId}", 
			method = RequestMethod.GET)
	private String idol(
			@PathVariable int idolId, Model model,
			HttpSession session) {
		
		Member loginMember = 
				(Member)session.getAttribute("loginMember");

		model.addAttribute("idol", service.getIdol(idolId,loginMember.getNo()));
		
		return "idol";
	}

}
