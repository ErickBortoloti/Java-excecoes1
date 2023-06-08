package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.reservas;

public class Principal {

	public static void main(String[] args) throws ParseException {
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat ds = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Quarto Nº: ");
		int numero = teclado.nextInt();
		System.out.print("Data de check-in - dd/mm/aaaa: ");
		Date check = ds.parse(teclado.next());
		System.out.print("Data de check-out - dd/mm/aaaa: ");
		Date checkout = ds.parse(teclado.next());
		
		if (!checkout.after(check)) { //serve para ver se a data eh anterior, nesse caso: ! se a data de checkout for menor que checkin
		System.out.println("ERRO DE RESERVA: Dia de check-out posterior ao dia de check-in");	
		
		}
		else {
			reservas reserva = new reservas(numero, check, checkout);
			System.out.println(reserva);
		
		System.out.println();
		System.out.println("Entre com os dados para atualizar a reserva ");
		
		System.out.print("Data de check-in - dd/mm/aaaa: ");
		check = ds.parse(teclado.next());
		System.out.print("Data de check-out - dd/mm/aaaa: ");
		checkout = ds.parse(teclado.next());
		
		
		Date now = new Date();
		if(check.before(now) || checkout.before(now)) {
			System.out.println("Erro na reserva: as datas de reservas tem que ser datas futuras");
		}
		else if (!checkout.after(check)) {
			System.out.println("Erro na reserva: as datas de reservas tem que ser datas futuras");
		}
		else {
			reserva.mudarDatas(check, checkout);
			System.out.println("Reserva: " + reserva);
		}
		
		

		}

	}

}
