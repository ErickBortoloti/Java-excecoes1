package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.reservas;
import model.exceptions.DominioException;

public class Principal {

	public static void main(String[] args) throws ParseException {
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat ds = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
			System.out.print("Quarto Nº: ");
			int numero = teclado.nextInt();
			System.out.print("Data de check-in - dd/mm/aaaa: ");
			Date check = ds.parse(teclado.next());
			System.out.print("Data de check-out - dd/mm/aaaa: ");
			Date checkout = ds.parse(teclado.next());
		
			reservas reserva = new reservas(numero, check, checkout);
			System.out.println(reserva);
		
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva ");
			
			System.out.print("Data de check-in - dd/mm/aaaa: ");
			check = ds.parse(teclado.next());
			System.out.print("Data de check-out - dd/mm/aaaa: ");
			checkout = ds.parse(teclado.next());
			
			reserva.mudarDatas(check, checkout);
			System.out.println("Reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválido");

	}
		catch(DominioException e) {
			System.out.println("Erro na reserva:" + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Erro na reserva: Digite o numero do quarto");
			
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}

	}
}
