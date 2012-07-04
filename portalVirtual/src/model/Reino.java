package model;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import annotation.RequiredField;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "reino") // @Table(name) informa o nome da tabela correspondente ao objeto, ou seja, no nosso banco de dados criamos a tabela “reino” e nossa classe Reino faz referencia a essa tabela.


public class Reino extends Entity {
	@Id //determina que esse atributo é a primary key do objeto;

	@GeneratedValue //marcação para que quando a entidade for persistida gere um valor automaticamente, ou seja, não há necessidade de defini-la quando quiser salvar um novo registro;

	@OneToMany(targetEntity = Filo.class, mappedBy = "reino") //essa annotation é do tipo relacional, serve para dizer que esse atributo é uma foreign key de outra tabela, veja que foi definido os atributos targetEntity e mappedBy, o targetEntity é para onde esse valor vai, ou seja, onde ele será a foreign key, o mappedBy quer dizer quem está o mapeando, de onde deve se pegar esse valor (a primary key da tabela reino);

	@Column(name = "id_reino") //nessa annotation você define	qual o nome da coluna no banco de dados.

	private long id;
	@Column(name = "nome")
	@RequiredField
	private String reino;
	public Reino() {
	}
	public Reino(long id, String reino) {
		this.id = id;
		this.reino = reino;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getReino() {
		return reino;
	}
	public void setReino(String reino) {
		this.reino = reino;
	}
	@Override
	public String getSearchColumnTable() { //retorna o nome da coluna no banco de dados que usamos para pesquisa
		return "nome";
	}
	@Override
	public String getSearchColumnEntity() { //retorna o nome do atributo que representa a coluna de pesquisa, ou seja o próprio atributo reino.
		return "reino";
	}
}


