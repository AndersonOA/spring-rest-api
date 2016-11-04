/**
 * 
 */
package br.com.makersweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.domain.Hotel;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
