package lv.glusakovs.twitter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class LogEnabledClass {
	protected Logger log = LogManager.getLogger(this.getClass().getName());
}