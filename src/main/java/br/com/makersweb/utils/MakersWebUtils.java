/**
 * 
 */
package br.com.makersweb.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public class MakersWebUtils {
	
	/**
	 * CONSTANTES GERAIS
	 */
	public static final String E_USER_NOTICE = "info";
	public static final String E_USER_WARNING = "warning";
	public static final String E_USER_ERROR = "error";
	public static final String E_USER_SUCESS = "success";
	public static final String EMAIL_REGEX = "[a-zA-Z0-9]+[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]*\\.+[a-z]{2,4}";
	public static final String PATTNER_DDMMYYYY_HHMMSS = "dd/MM/yyyy HH:mm:ss";
	public static final String PATTNER_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTNER_YYYYMMDD = "yyyy-MM-dd";
	public static final String PATTNER_DDMMYYYY = "dd/MM/yyyy";
	public static final String PATTNER_HHMM = "HH:mm";
	
	
	/**
	 * CONSTANTES STATUS 
	 */
	public static final String STS_ADD = "ADICIONADO";
	public static final String STS_DEL = "REMOVIDO";
	public static final String STS_UPD = "ATUALIZADO";
	
	
	/**
	 * Método responsavel por validar e-mail
	 * 
	 * Aceita palavras que comecem de a ate z maiúsculo ou minusculo Depois
	 * aceita de a ate z e alguns caracteres especiais como . _ e - Aceita um
	 * único @ Por fim tem que ter de 2 a 4 letras no final da palavra
	 * 
	 * @param email
	 * @return boolean
	 */
	public static boolean isMail(String email) {
		return email.matches(EMAIL_REGEX);
	}

	/**
	 * Método responsavel por deixa string com apenas numeros
	 * 
	 * @param value
	 * @return string
	 */
	public static String somenteNumeros(String value) {
		return value.replaceAll("\\D", "");
	}

	/**
	 * Converte uma String para um objeto Date. Caso a String seja vazia ou
	 * nula, retorna null - para facilitar em casos onde formulários podem ter
	 * campos de datas vazios.
	 * 
	 * @param data String no formato dd/MM/yyyy a ser formatada
	 * @return Date Objeto Date ou null caso receba uma String vazia ou nula
	 * @throws Exception Caso a String esteja no formato errado
	 */
	public static Date formatStringToDate(String data) {
		if (data == null || data.equals(""))
			return null;
		java.sql.Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(PATTNER_DDMMYYYY);
			date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * Formatar String YYYY-MM-dd HH:mm:ss to LocalDateTime
	 * 
	 * @param data
	 * @return LocalDateTime
	 */
	public static LocalDateTime formataStringToLocalDateTime(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTNER_YYYYMMDD_HHMMSS);
		LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
		
		return dateTime;
	}
	
	/**
	 * Formata String YYYY-MM-DD to LocalDate
	 * 
	 * @param data
	 * @return LocalDate
	 */
	public static LocalDate formataStringToLocalDate(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTNER_YYYYMMDD);
		LocalDate date = LocalDate.parse(data, formatter);
		
		return date;
	}
	
	/**
	 * Formata String HH:MM to LocalTime
	 * 
	 * @param hora
	 * @return LocalTime
	 */
	public static LocalTime formataStringToTime(String hora) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTNER_HHMM);
		LocalTime time = LocalTime.parse(hora, formatter);
		
		return time;
	}
	
	/**
	 * Formata String DD/MM/YYYY to LocalDate
	 * 
	 * @param data
	 * @return LocalDate
	 */
	public static LocalDate formtaStringToLocalDateDDMMYYYY(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTNER_DDMMYYYY);
		LocalDate date = LocalDate.parse(data, formatter);
		
		return date;
	}
	
	/**
	 * Formata data para String DD/MM/YYYY
	 * 
	 * @param data
	 * @return
	 */
	public static String formataDataToDDMMYYYY(LocalDate data) {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern(PATTNER_DDMMYYYY);
		return formatador.format(data);
	}
	
	/**
	 * Formata date time para String DD/MM/YYYY hh:mm:ss
	 * 
	 * @param data
	 * @return
	 */
	public static String formataDataTimeDDMMYYYY(LocalDateTime date) {
		DateTimeFormatter  fmt = DateTimeFormatter.ofPattern(PATTNER_DDMMYYYY_HHMMSS);
		return fmt.format(date);
	}
	
	/**
	 * Retorna Data atual do sistema
	 * 
	 * @return LocalDate
	 */
	public static LocalDate retornaDataAtual() {
		 return LocalDate.now();
	}
	
	/**
	 * Retorna Data e hora atual do sistema
	 * 
	 * @return LocalDateTime
	 */
	public static LocalDateTime retornaDataHoraAtual() {
		 return LocalDateTime.now();
	}
	
	/**
	 * Gera Mensagem do Sistema
	 * 
	 * @param ErrMsg
	 * @param ErrNo
	 * @return String
	 */
	public static String AjaxErro(String ErrMsg, String ErrNo) {
		String CssClass = (ErrNo == E_USER_NOTICE ? "trigger_info" : (ErrNo == E_USER_WARNING ? "trigger_alert" : (ErrNo == E_USER_ERROR ? "trigger_error" : "trigger_success")));
		String typeMsg = (ErrNo == E_USER_NOTICE ? "<b>Aviso:</b>" : (ErrNo == E_USER_WARNING ? "<b>Aviso:</b>" : (ErrNo == E_USER_ERROR ? "<b>Erro:</b>" : "<b>Sucesso:</b>")));
		String msg = "<div class='trigger trigger_ajax "+ CssClass + "'\">" + typeMsg + " " + ErrMsg;
		msg += " <span class='ajax_close'></span></div>";
		return msg;
	}

}
