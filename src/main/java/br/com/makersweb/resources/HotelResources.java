/**
 * 
 */
package br.com.makersweb.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.domain.Hotel;
import br.com.makersweb.services.HotelServices;
import br.com.makersweb.services.exceptions.BusinessException;
import br.com.makersweb.utils.DefaultResponse;
import br.com.makersweb.utils.MakersWebUtils;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@RestController
@RequestMapping("/api")
public class HotelResources {

	@Autowired
	private HotelServices hotelServices;

	@RequestMapping(value = "/hotel", method = RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<?> create(@RequestBody Hotel hotel) {
		DefaultResponse response = new DefaultResponse();
		try {
			Hotel myHotel = hotelServices.create(hotel);

			response.setId(myHotel.getId());
			response.setError(false);
			response.setTypeError(MakersWebUtils.E_USER_SUCESS);
			response.setMessage(
					MakersWebUtils.AjaxErro("Contato Cadastrado com sucesso!", MakersWebUtils.E_USER_SUCESS));
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(MakersWebUtils.E_USER_WARNING);
			response.setMessage(MakersWebUtils.AjaxErro(e.getMessage(), MakersWebUtils.E_USER_WARNING));
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@RequestMapping(value = "/hotel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Hotel>> read() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(hotelServices.read());
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<Hotel>());
		}
	}

}
