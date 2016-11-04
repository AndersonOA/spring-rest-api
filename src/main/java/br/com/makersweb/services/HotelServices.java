/**
 * 
 */
package br.com.makersweb.services;

import java.util.List;

import br.com.makersweb.domain.Hotel;
import br.com.makersweb.services.exceptions.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface HotelServices {
	
	Hotel create(Hotel hotel) throws BusinessException;
	
	List<Hotel> read() throws BusinessException;
	
	void update(Hotel hotel) throws BusinessException;
	
	void delete(Long id) throws BusinessException;
	
	Hotel find(Long id) throws BusinessException;
	
	void checksExistence(Hotel hotel) throws BusinessException;

}
