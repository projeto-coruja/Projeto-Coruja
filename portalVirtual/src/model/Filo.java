package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import annotation.RequiredField;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "filo") //Criando Tabela Filo

public class Filo extends Entity {
	@Id
	@GeneratedValue
	@Column(name = "id_filo")
	private long id;
	@Column(name = "nome")
	@RequiredField //Indica que este é um campo obrigatório
	private String filo;
	@ManyToOne(optional = false, targetEntity = Reino.class) //(inverso do que foi declarado no Reino) dizendo que é um atributo obrigatório (false para optional) e que ele vem da classe Reino;
	@JoinColumn(name = "id_reino", referencedColumnName =
			"id_reino") //informa o nome da coluna de destino “id_reino”, na tabela filo, e o nome da coluna de origem, também “id_reino”, na tabela reino (definido pelo targetEntity do @ManyToOne).

	@RequiredField
	private Reino reino;
	public Filo() {}
	public Filo (long id, String filo, Reino reino) {
		this.id = id;
		this.filo = filo;
		this.reino = reino;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFilo() {
		return filo;
	}
	public void setFilo(String filo) {
		this.filo = filo;
	}
	public Reino getReino() {
		return reino;
	}
	public void setReino(Reino reino) {
		this.reino = reino;
	}
	@Override
	public String getSearchColumnEntity() {
		return "filo";
	}
	@Override
	public String getSearchColumnTable() {
		return "nome";
	}
}
