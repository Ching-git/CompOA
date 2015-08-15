package cn.edu.csu.oa.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.csu.oa.base.BaseAction;
import cn.edu.csu.oa.domain.Reply;

@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class ReplyAction extends BaseAction<Reply>{

	/**
	 * 发表回复页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		return "addUI";
	}
	
	/**
	 * 发表回复
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		return "toTopicShow";	//转到当前这个新回复所属的主题显示页面
	}
	
}
