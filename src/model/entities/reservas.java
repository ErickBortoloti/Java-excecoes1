package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class reservas {
	
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy"); 
	
	
	public reservas(Integer numeroQuarto, Date checkin, Date checkout) {
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}


	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}


	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}


	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}
	
	public long duracao() {
		long diff = checkout.getTime() - checkin.getTime(); // calcular diferença em milissegundos. checkout.gettime e check.gettime = pega a diferenca das duas datas em milissegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //calcular diferenca em dias.
	}
	
	public void mudarDatas(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
		
	}
	
	@Override
	
	public String toString() {
		return "Quarto: " 
			  + numeroQuarto
			  + ", Check-in: "
			  + dma.format(checkin)
			  + ", Check-out: "
			  + dma.format(checkout)
			  + ", "
			  + duracao()
			  + " noites";
		
	}



	
	
	
	

}
