package xt.surge.swingset.util;

import java.time.LocalDateTime;

/**
 * The Time class defines the API for getting the current system time and date. This isn't
 * strictly neccessary, however it allows for an easier time to get the current time
 * and date.
 * 
 * @author SUrge
 * @version 1.0
 */
public class Time {
	
	/**
	 * Gets the current time in the format HH:mm:ss
	 * 
	 * @returns The time in format HH:mm:ss as a string
	 */
	public static String getTimeString() {
		LocalDateTime time = LocalDateTime.now();
		return new StringBuilder()
				.append(time.getHour())
				.append(":")
				.append(time.getMinute())
				.append(":")
				.append(time.getSecond())
				.toString();
	}

}
