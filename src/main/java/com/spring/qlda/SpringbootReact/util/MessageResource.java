package com.spring.qlda.SpringbootReact.util;

public class MessageResource {
	
	/**
	 * For action
	 */
	public static final String GET_SUCCESS = "GET_SUCCESS";
	public static final String GET_NO_DATA = "GET_NO_DATA";
	public static final String GET_FAIL = "GET_FAIL";
	public static final String INSERT_SUCCESS = "INSERT_SUCCESS";
	public static final String INSERT_FAIL = "INSERT_FAIL";
	public static final String UPDATE_SUCCESS = "UPDATE_SUCCESS";
	public static final String UPDATE_FAIL = "UPDATE_FAIL";
	public static final String DELETE_SUCCESS = "DELETE_SUCCESS";
	public static final String DELETE_FAIL = "DELETE_FAIL";
	public static final String EXPORT_SUCCESS = "EXPORT_SUCCESS";
	public static final String EXPORT_FAIL = "EXPORT_FAIL";
	public static final String UPLOAD_SUCCESS = "UPLOADT_SUCCESS";
	public static final String UPLOAD_FAIL = "UPLOAD_FAIL";
	public static final String CRUD = "CRUD";
	
	/**
	 * For exception
	 */
	public static final String IO_EXCEPTION = "IO_EXCEPTION";
	public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
	public static final String DATA_ACCESS_EXCEPTION = "DATA_ACCESS_EXCEPTION";
	public static final String MANIPULATE_DB = "MANIPULATE_DB";
	public static final String ACCESS_DENIED = "ACCESS_DENIED";
	
	
	/**
	 * For API
	 */
	public static final String ADMIN_USERAPI = "/admin/userAPI";
	
	public static final String ADMIN_SERVICE_USER = "/admin/service_user";
	
	
	/**
	 * For Service
	 */
	public static final String USER_SERVICE = "USER_SERVICE";
	
	public static final String SERVICE_USER_SERVICE = "SERVICE_USER_SERVICE";
	
	private MessageResource() {
	}

	public static String toMessage(String function, String action) {
		StringBuilder builder = new StringBuilder();
		builder.append(function);
		builder.append(": ");
		builder.append(action);
		return builder.toString();
	}
}
