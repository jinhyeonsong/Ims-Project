package org.bmj.ims.controller;


import org.bmj.ims.service.GroupsService;
import org.bmj.ims.vo.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GroupController {
	
	// @Autowired setter도 필요없음
	
	@Autowired
	private GroupsService service;
	
	@RequestMapping(value="/group/{groupId}/modify",
			method = RequestMethod.GET)
	private String updateGroupForm(Model model,
			@PathVariable int groupId) {
		
		model.addAttribute("group",service.getGroup(groupId));
		
		return "groupForm";
	}
	
	@RequestMapping(value="/group",
			method = RequestMethod.PUT)
	private String updateGroup(Group group) {
		service.modify(group);
		return "redirect:/group/"+group.getGroupId();
	}
	
	@RequestMapping(
			value="/group/register",
			method=RequestMethod.GET)
	private String registerGroupForm() {
		
		return "groupForm";
	}
	
	@RequestMapping(value="/group/{groupId}",
			method=RequestMethod.DELETE)
	private String deleteGroup(@PathVariable int groupId) {
		
		 service.deleteGroup(groupId);
		
		return "redirect:/group/page/1";
	}
	
	//uri안에 있는 변수를
	//경로안의 변수라고 하여 
	// - 문법은 {}
	// @PathVariable 입니다.
	
	@RequestMapping(value="/group/page/{page}",
			method=RequestMethod.GET)
	public String groups(Model model,
			@PathVariable int page) {
		
		model.addAllAttributes(service.getGroups(page));
		
		return "groupList";
	}
	
	
	@RequestMapping(
			value="/group",
			method=RequestMethod.POST)
	private String registerGroup(
			Group group ) {
		
		service.registerGroup(group);
		
		return "redirect:/group/"+group.getGroupId();
	}
	
	@RequestMapping(value="/group/{groupId}", method = RequestMethod.GET)
	private String group(
	@PathVariable int groupId, Model model) {

		model.addAllAttributes(service.getGroupDetail(groupId));
		
		return "group";
	}

}




