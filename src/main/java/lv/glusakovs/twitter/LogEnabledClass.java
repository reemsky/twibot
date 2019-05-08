package lv.glusakovs.twitter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LogEnabledClass {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
}