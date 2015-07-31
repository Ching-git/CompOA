package cn.edu.csu.oa;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog {
	
	private Log log = LogFactory.getLog("TestLog");
	
	@Test
	public void test() throws Exception {
		log.debug("debug错误");
		log.info("info错误");
		log.warn("warn错误");
		log.error("error错误");
		log.fatal("fatal错误");
	}
}
