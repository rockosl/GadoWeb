package rocko.GadoWeb;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean(name = "gadoBean")
@Entity
public class GadoBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomeBrinco;
	private int pesoInicial;
	private int pesoFinal;
	private String apelido;

	public GadoBean() {
		super();
	}

	public GadoBean(String nomeBrinco, int pesoInicial, int pesoFinal, String apelido) {
		super();
		this.nomeBrinco = nomeBrinco;
		this.pesoInicial = pesoInicial;
		this.pesoFinal = pesoFinal;
		this.apelido = apelido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeBrinco() {
		return nomeBrinco;
	}

	public void setNomeBrinco(String nomeBrinco) {
		this.nomeBrinco = nomeBrinco;
	}

	public int getPesoInicial() {
		return pesoInicial;
	}

	public void setPesoInicial(int pesoInicial) {
		this.pesoInicial = pesoInicial;
	}

	public int getPesoFinal() {
		return pesoFinal;
	}

	public void setPesoFinal(int pesoFinal) {
		this.pesoFinal = pesoFinal;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

}
