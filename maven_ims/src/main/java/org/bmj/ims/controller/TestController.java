package org.bmj.ims.controller;



import org.bmj.ims.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
/*
 * ajax 응답이 json
 * 
 * 1) MappingJacksonJsonView : 잭슨 제이슨 라이브러리가 해줌 
 * -객체
 * -Map 객체
 * 
 * ------------
 * List 객체, 배열 : json 배열
 * 
 *
 * 2) 우리가 직접 
 * 
 * 
 * */
	
	@Autowired
	private GroupsService service;
	
	/*
	@RequestMapping(value="/REST.ims",
			method=RequestMethod.GET) 
	public void rest() {
		
	}
	
	@RequestMapping(value="/rest.ims",
			method = RequestMethod.DELETE) 
	public void restDELETE() {
		System.out.println("DELETE /rest.ims");
	}
	@RequestMapping(value="/rest.ims",
			method = RequestMethod.GET) 
	public void restGET() {
		System.out.println("GET /rest.ims");
	}
	@RequestMapping(value="/rest.ims",
			method = RequestMethod.POST) 
	public void restPOST() {
		System.out.println("POST /rest.ims");
	}
	@RequestMapping(value="/rest.ims",
			method = RequestMethod.PUT) 
	public void restPUT() {
		System.out.println("PUT /rest.ims");
	}
	
	
	// @ ResponseBody 없으면 인터널 리소스 뷰가 리턴됨
	@RequestMapping(value="/ajax/idol.ims", method = RequestMethod.GET)
	@ResponseBody
	public Idol test2() {
		return new Idol("박지효",160,46);
	}
	
	@RequestMapping(value="/ajax/test3.ims", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> test3(){
		Map<String, Object> map=new HashMap();
		
		map.put("name","박지효");
		map.put("height", 180);
		map.put("weight", 100);
		
		return map;
	}
	
	@RequestMapping(value="/upload.ims",
			method = RequestMethod.GET)
	private String asfdasf() {
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload.ims",
			method=RequestMethod.POST)
	private void sdfasdfasdfa(Idol idol,//name,height,weight
			HttpServletRequest request,//경로
			MultipartFile zzz//업로드된 파일
			) throws Exception {
		/*form
		  요소안에 존재하는 input type=file요소의 이름과
		  같게 MultipartFile을 받으면 됨
		  
		  데이터베이스에는 파일이름만 저장함!!!
		  
		  자, 이제부터 서버컴퓨터의 경로에 제대로 파일을
		  옮겨야 합니다.
		  
		  파일시스템의 경로를 알아야 하기 때문에
		  HttpServletRequest객체에서 ServletContext객체를
		  얻어와야 합니다.
		  
		 
		
		//서버
		ServletContext application = 
				request.getServletContext();
		
		//기본경로
		String rootPath = application.getRealPath("/");
		
		//System.out.println(rootPath);
		
		//업로드 폴더 경로
		String uploadPath = rootPath+"img"+File.separator
				+"upload"+File.separator;
		
		//System.out.println(uploadPath);
		
		//파일의 실제 이름
		String fileName = zzz.getOriginalFilename();
		
		//절대로 중복되지 않을 랜덤한 값
		//UUID uuid = UUID.randomUUID();
		
		//System.out.println(uuid.toString());
		
		//파일 객체 생성
		File file = new File(uploadPath+fileName);
		
		//파일이름이 같다면 숫자가 붙음
		file = FileRenameUtil.rename(file);
		
		System.out.println(file);
		
		//임시폴더에 우리 업로드폴더로 이동
		zzz.transferTo(file);
		
		//리사이즈가 필요한 경우 하면 됨
		
		String resizePath = rootPath+"img" + File.separator +
				"resize"+File.separator;
		
		//리사이즈
		ResizeImageUtil.resize(
				file.toString(),
				resizePath+file.getName(), 200);
		
	}
	
	@RequestMapping(value="/ajax/test.ims",method=RequestMethod.GET)
	@ResponseBody
	private List<Integer> sdfasdf(){
		
		List<Integer> nums=new ArrayList<Integer>();
		
		nums.add(3);
		nums.add(5);
		
		return nums;
	}
	
	/*
	 * 
	 * ajax를 할때는 일반컨트롤러에 @ResponseBody
	 * 
//	@RequestMapping(value="/ajax/getGroups.ims", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Group> getGroups(){
//		return service.getGroups();
//	}
//	
	/*
	 * 
	 * String으로 리턴할 경우
	 * 기본이 content-type:text/html
	 * 
	 * 
	 * json으로 하고 싶으면
	 * produces = "applicaion/json;charset=UTF-8"
	 *
	@RequestMapping(value="/ajax/test.ims", method=RequestMethod.GET,produces = "applicaion/json; charset=UTF-8")
	@ResponseBody
	public String test() {
		return "{\"result\":true}";
	}
	
	@RequestMapping(value="/test.ims",method = RequestMethod.GET)
	public void test1111(Member member,BindingResult br) {
		System.out.println(member.getNo());
	}
	
	*/
	
}
