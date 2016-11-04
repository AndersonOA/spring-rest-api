/**
 * 
 */
package br.com.makersweb.utils;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public class DefaultResponse {

	private Long id;
	private String message;
	private String typeError;
	private Boolean error;
	private String redirect;
	private Boolean existUser;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the typeError
	 */
	public String getTypeError() {
		return typeError;
	}

	/**
	 * @param typeError
	 *            the typeError to set
	 */
	public void setTypeError(String typeError) {
		this.typeError = typeError;
	}

	/**
	 * @return the error
	 */
	public Boolean getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(Boolean error) {
		this.error = error;
	}

	/**
	 * @return the redirect
	 */
	public String getRedirect() {
		return redirect;
	}

	/**
	 * @param redirect
	 *            the redirect to set
	 */
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	/**
	 * @return the existUser
	 */
	public Boolean getExistUser() {
		return existUser;
	}

	/**
	 * @param existUser
	 *            the existUser to set
	 */
	public void setExistUser(Boolean existUser) {
		this.existUser = existUser;
	}

}
