/**
 * 
 */
package br.com.makersweb.services.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import br.com.makersweb.domain.Hotel;
import br.com.makersweb.repository.HotelRepository;
import br.com.makersweb.services.HotelServices;
import br.com.makersweb.services.exceptions.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Service
@EnableTransactionManagement
public class HotelServicesImpl implements HotelServices {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Hotel create(Hotel hotel) throws BusinessException {
		if (!ObjectUtils.isEmpty(hotel)) {
			if (StringUtils.isEmpty(hotel.getNome()) || StringUtils.isEmpty(hotel.getEndereco())
					|| StringUtils.isEmpty(hotel.getCep())) {
				throw new BusinessException("Por favor informe todos os campos.");
			}
		} else {
			throw new BusinessException("Por favor informe todos os campos.");
		}
		return hotelRepository.save(hotel);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<Hotel> read() throws BusinessException {
		List<Hotel> hotels = hotelRepository.findAll();

		if (ObjectUtils.isEmpty(hotels)) {
			throw new BusinessException("Nenhum Hotel encontrado.");
		}

		return hotels;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void update(Hotel hotel) throws BusinessException {
		checksExistence(hotel);
		hotelRepository.save(hotel);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void delete(Long id) throws BusinessException {
		try {
			hotelRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BusinessException("Nenhum Hotel encontrado.");
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Hotel find(Long id) throws BusinessException {
		Hotel hotel = hotelRepository.findOne(id);

		if (ObjectUtils.isEmpty(hotel)) {
			throw new BusinessException("Nenhum Hotel encontrado.");
		}

		return hotel;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void checksExistence(Hotel hotel) throws BusinessException {
		find(hotel.getId());
	}

}
