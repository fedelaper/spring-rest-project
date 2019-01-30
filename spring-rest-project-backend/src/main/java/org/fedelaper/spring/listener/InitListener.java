package org.fedelaper.spring.listener;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 
 * <b>Project/Module:</b> spring-rest-project-backend<br/>
 * 
 * <b>Package:</b> org.fedelaper.spring.listener<br/>
 * 
 * <b>Class:</b> InitListener<br/>
 * 
 * <b>Description:</b> Init listener that prints the release information.<br/>
 * 
 * <b>Creation Date:</b> 07/02/2017<br/>
 * 
 * @author Federico G. Lapertosa<br/>
 * <br/>
 */
public class InitListener implements ServletContextListener {

	/*
	 * classpath release info resource path.
	 */
	private static final String RELEASE_PROPERTIES_PATH = "release.properties";
	
	/*
	 * Info Grid width.
	 */
	private static final Integer GRID_WIDTH = 74;
	/*
	 * Log4j Logger.
	 */
	private static Logger log = Logger.getLogger(InitListener.class);

	/***
	 * {@inheritDoc}
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("CLOSING THE APPLICATION: " + new Date().toString());
	}

	/***
	 * {@inheritDoc}
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		Properties releaseProperties = new Properties();

		try {
			releaseProperties.load(getClass().getClassLoader().getResourceAsStream(RELEASE_PROPERTIES_PATH));

			log.info("############################################################################");
			log.info("##               INITIALIZING MAVEN REST PROJECT BACKEND                  ##");
			log.info("############################################################################");
			log.info(StringUtils.rightPad("## Project Name: " + releaseProperties.getProperty("project.name"), GRID_WIDTH)
					+ "##");
			log.info(StringUtils.rightPad("## Project Version: " + releaseProperties.getProperty("project.version"), GRID_WIDTH)
					+ "##");
			log.info(StringUtils.rightPad("## Project Revision: " + releaseProperties.getProperty("project.revision"),
					GRID_WIDTH) + "##");
			log.info(StringUtils.rightPad(
					"## Project Build Date: " + releaseProperties.getProperty("project.build.date"), GRID_WIDTH)
					+ "##");
			log.info(StringUtils.rightPad(
					"## Project Build Package: " + releaseProperties.getProperty("project.build.package"), GRID_WIDTH)
					+ "##");
			log.info(StringUtils.rightPad("## Project Stage: " + releaseProperties.getProperty("project.stage"), GRID_WIDTH)
					+ "##");
			log.info("############################################################################");
		} catch (IOException e) {
			log.error("Could not load release info properties file.");
		}

	}
}
