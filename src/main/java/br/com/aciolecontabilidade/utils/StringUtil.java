package br.com.aciolecontabilidade.utils;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

	private StringUtil() {
	}

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static String mascaraCPF(String numero) {
		String partes = "$1.$2.$3-$4";
		String formato = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";

		return numero.replaceFirst(formato, partes);
	}

	public static String removerMascara(String valor) {
		Pattern numericos = Pattern.compile("([0-9])");
		Matcher encaixe = numericos.matcher(valor);
		StringBuilder saida = new StringBuilder();

		while (encaixe.find()) {
			saida.append(encaixe.group());
		}
		return saida.toString();
	}

	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean validarEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
