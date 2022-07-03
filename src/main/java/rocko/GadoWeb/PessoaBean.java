package rocko.GadoWeb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import rocko.dao.DaoGeneric;
import rocko.modelo.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
		listarPessoas();
		return "";
	}

	public String novo() {
		pessoa = new Pessoa();
		return "";
	}
	
	public String delete() {
		daoGeneric.deletePorId(pessoa);
		pessoa = new Pessoa();
		listarPessoas();
		return "";
	}
	
	public void listarPessoas() {
		pessoas = daoGeneric.getListEntity(Pessoa.class);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
}
