package xt.surge.swingset.util;

/**
 * The Constants class defines all system constants, such as the version and
 * environment variables.
 * 
 * @author Surge
 * @version 1.0
 */
public final class Constants {
	
	//Engine version
	public static final int VERSION_MAJOR = 0;
	public static final int VERSION_MINOR = 2;
	public static final int VERSION_PATCH = 1;

	//LOGGERS

	public static final Logger RESLGR = new Logger("Resources", Logger.INFO);
	public static final Logger MAINLGR = new Logger("Main", Logger.INFO);
	public static final Logger THRLGR = new Logger("Worker", Logger.DEBUG);

}
