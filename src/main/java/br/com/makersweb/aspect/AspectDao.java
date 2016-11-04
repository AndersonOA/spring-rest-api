/**
 * 
 */
package br.com.makersweb.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;

import br.com.makersweb.domain.DefaultDomain;


/**
 *
 * @author Anderson O. Aristides
 *
 */
public class AspectDao {

	public Object doBasicDomainInformation(ProceedingJoinPoint pjp) throws Throwable {
		Object myEntity = pjp.getArgs()[0];
		if (myEntity instanceof DefaultDomain) {
			myEntity = setDefaultValues((DefaultDomain) myEntity);
		}
		Object retVal = pjp.proceed();
		return retVal;
	}

	private DefaultDomain setDefaultValues(DefaultDomain defaultDomain) {
		if (defaultDomain.getId() != null) {
			defaultDomain.setUpdated(LocalDateTime.now());
			defaultDomain.setUpdatedBy("suporte@makersweb.com.br");
		} else {
			defaultDomain.setCreated(LocalDateTime.now());
			defaultDomain.setCreatedBy("suporte@makersweb.com.br");
		}
		return defaultDomain;
	}
}
