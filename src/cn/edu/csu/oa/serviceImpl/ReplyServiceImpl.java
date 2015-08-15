package cn.edu.csu.oa.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.base.DaoSupportImpl;
import cn.edu.csu.oa.domain.Reply;
import cn.edu.csu.oa.service.ReplyService;

@Service
@Transactional
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService {

}
