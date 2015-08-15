package cn.edu.csu.oa.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.base.DaoSupportImpl;
import cn.edu.csu.oa.domain.Topic;
import cn.edu.csu.oa.service.TopicService;

@Service
@Transactional
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements TopicService {

}
