package com.kruger.practica.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
	
	private static Validaciones instance;
	
	public static Validaciones getInstance() {
		synchronized (Validaciones.class) {
			if(instance == null) {
				instance = new Validaciones();
			}
		}
		return instance;
		
	}
	
	public boolean validarCedula(String cedula) {
		try {
			if (cedula.length() == 10) {
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9,10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}
					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						return true;
					} else if ((10 - (suma % 10)) == verificador) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
			
		} catch (NumberFormatException nfe) {
			return false;
		} catch (Exception err) {
			return false;
		}
	}
	
	/**
	 * Validar correoelectronico de una persona
	 * @param correo
	 * @return
	 */
	public boolean validarCorreo(String correo) {
        Pattern pat = Pattern.compile("^(.+)@(.+)$");
        Matcher mat = pat.matcher(correo);
        return mat.matches();
	}
	
	public boolean validarTexto(String texto) {
		 Pattern pat = Pattern.compile("[a-zA-Z]{2,}");
	     Matcher mat = pat.matcher(texto);
		//return mat.matches();
	     return true;
		
	}
}
