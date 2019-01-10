package test2;

import org.apache.log4j.Logger;

public class Test1 {
	private Logger logger = Logger.getLogger(getClass());

	public void view() {
		logger.info("Test1입니다");
	}
}
