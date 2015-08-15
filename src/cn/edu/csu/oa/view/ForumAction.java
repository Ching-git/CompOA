package cn.edu.csu.oa.view;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.csu.oa.base.BaseAction;
import cn.edu.csu.oa.domain.Forum;

@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class ForumAction extends BaseAction<Forum> {

	/**
	 * 版块列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}

	/**
	 * 显示单个版块
	 * 
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {
		return "show";
	}

}
