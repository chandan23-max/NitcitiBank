package com.cs.test;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.Logger;

public class ReportingManager {
 private static org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(ReportingManager.class);
 
	public static void main(String[] args) {
		//BasicConfigurator.configure();
		PropertyConfigurator.configure(System.getProperty("user.dir")+File.separator+"log4j.properties");
		log.debug("Testing from debug");
		log.info("Testing from info");
		log.fatal("Testing from fetal");
		log.error("Testing from Eroor");
		log.warn("Testing from warn");
		log.trace("Testing from the trace");
		System.out.println();

	}

}
