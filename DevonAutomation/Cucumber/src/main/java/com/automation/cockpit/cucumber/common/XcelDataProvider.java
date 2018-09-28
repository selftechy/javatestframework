package com.automation.cockpit.cucumber.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.automation.cockpit.cucumber.exceptions.WebshopDataFailureException;
import com.google.common.base.CaseFormat;

@Component
public class XcelDataProvider {


	@Autowired
	Environment properties;

	@Autowired
	ScenarioContext sc;

	FileInputStream file = null;
	String xlSheetTobeRead = null;

	private static final String XCEL_DATA_FILE_PATH="xceldata.path";

	private static final Logger LOGGER = Logger.getLogger(XcelDataProvider.class);

	@Autowired
	public XcelDataProvider(Environment prop) throws WebshopDataFailureException{

		try {
			this.file = new FileInputStream(new File(prop.getProperty(XCEL_DATA_FILE_PATH)));
		} catch (FileNotFoundException e) {
			throw new WebshopDataFailureException("Could not read xcel file: "+e);
		}
	}




}
