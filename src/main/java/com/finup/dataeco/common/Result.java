package com.finup.dataeco.common;

/**
 * An usual, simple java bean which encapsulate the returned object for the ajax
 * request or the application/json type The data propertity which contains the
 * needed business data will be returned when the request was completed Usage:
 * the simplest way if success, you should only execute Result.success(); if
 * failed, you should only execute Result.failed();
 * 
 * @author Shu Zong Rui
 * @date 2012-10-16
 */
public class Result<T> {
	private static final String FAILED_CODE = "0";
	private static final String SUCCESS_CODE = "200";
	private static final String PLACEHOLDER = "";
	private static final String DEFAULT_MESSAGE_FAILED = "failed";
	private static final String DEFAULT_MESSAGE_SUCCESS = "success";

	public static final Result SUCCESSED = new ResultFacade(SUCCESS_CODE, DEFAULT_MESSAGE_SUCCESS);
	public static final Result FAILED = new ResultFacade(FAILED_CODE, DEFAULT_MESSAGE_FAILED);

	/**
	 * The status code, Marking success or faild for the action Usually, this is
	 * a ajax action Anthor, maybe the code are 1001, 1002, and so on
	 */
	private String code = SUCCESS_CODE;

	/**
	 * The message that usually will be showed on the web client Usually, this
	 * is a message for a faild ajax action
	 */
	private String message;

	/**
	 * Data will be a Map or List or Java Bean ...... Sometimes, data also may
	 * be a complex Json Style Object such as Map<String,List<SomeBean>> ......
	 */
	private T data;

	/**
	 * <p>
	 * You should call this method when the action is executed successfully
	 * 
	 * @return Result that contain the success status code and the return data
	 *         (data)
	 */
	public Result<T> success() {
		return success(SUCCESS_CODE, null);
	}

	/**
	 * @param data
	 *            a Object that contain the specific data
	 * @return Result
	 */
	public Result<T> success(T data) {
		return success(SUCCESS_CODE, DEFAULT_MESSAGE_SUCCESS, data);
	}

	/**
	 * @param code
	 * @param message
	 *            a String Object that contain the specific message for current
	 *            code
	 * @return
	 */
	public Result<T> success(String code, String message) {
		return success(code, message, null);
	}

	/**
	 * @param code
	 * @param message
	 * @param data
	 *            data a Object that contain the specific data for return
	 * @return
	 */
	public Result<T> success(String code, String message, T data) {
		return this.setCode(code).setMessage(message).setData(data);
	}

	/**
	 * <p>
	 * You should call this method when the action is failed. usually, the
	 * failed with a Exception
	 * 
	 * @param message
	 *            a String Object that contain the specific faild message
	 * @return Result that contain the faild status code and the null faild
	 *         message
	 */
	public Result<T> faild(String message) {
		return faild(FAILED_CODE, message, null);
	}

	/**
	 * <p>
	 * You should call this method when the action is failed. usually, the
	 * failed with a Exception
	 * 
	 * @param code
	 *            the user-defined code
	 * @param message
	 *            a String Object that contain the specific faild message
	 * @return Result
	 */
	public Result<T> faild(String code, String message) {
		return faild(code, message, null);
	}

	/**
	 * <p>
	 * You should call this method when the action is failed. usually, the
	 * failed with a Exception
	 * 
	 * @param code
	 * @param message
	 * @param data
	 * @return
	 */
	public Result<T> faild(String code, String message, T data) {
		return this.setCode(code).setMessage(message).setData(data);
	}

	// getter and setter
	public String getCode() {
		return code;
	}

	public Result<T> setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Result<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

	private static class ResultFacade extends Result<String> {

		private final String code;
		private final String message;

		public ResultFacade(String code, String message) {
			super();
			this.code = code;
			this.message = message;
		}

		@Override
		public String getCode() {
			return code;
		}

		@Override
		public Result setCode(String code) {
			throw new UnsupportedOperationException("not supported for this operation!");
		}

		@Override
		public Result setMessage(String message) {
			throw new UnsupportedOperationException("not supported for this operation!");
		}

		@Override
		public String getMessage() {
			return message;
		}

		@Override
		public Result setData(String data) {
			throw new UnsupportedOperationException("not supported for this operation!");
		}

		@Override
		public String getData() {
			return PLACEHOLDER;
		}
	}

}
