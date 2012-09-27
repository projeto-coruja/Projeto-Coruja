package persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class DocumentoMO {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	@NaturalId
	private String cod;
	
	@NotNull
	@Column(length = 1024)
	private String titulo;
	
	@NotNull
	@Column(length = 4096)
	private String resumo;

	@ManyToOne
	private CodiceCaixaMO codiceCaixa;
	
	@ManyToOne
	private TipoDocumentoMO tipoDocumento;
	
	@ManyToOne
	private AutorMO autor;
	
	@ManyToOne
	private PalavraChaveMO palavraChave1;
	
	@ManyToOne
	private PalavraChaveMO palavraChave2;
	
	@ManyToOne
	private PalavraChaveMO palavraChave3;
	
	@ManyToOne
	private UserAccountMO uploader;
	
	@Past
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public CodiceCaixaMO getOrigem() {
		return codiceCaixa;
	}

	public void setOrigem(CodiceCaixaMO origem) {
		this.codiceCaixa = origem;
	}

	public TipoDocumentoMO getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoMO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public AutorMO getAutor() {
		return autor;
	}

	public void setAutor(AutorMO autor) {
		this.autor = autor;
	}

	public PalavraChaveMO getPalavraChave1() {
		return palavraChave1;
	}

	public void setPalavraChave1(PalavraChaveMO palavraChave1) {
		this.palavraChave1 = palavraChave1;
	}

	public PalavraChaveMO getPalavraChave2() {
		return palavraChave2;
	}

	public void setPalavraChave2(PalavraChaveMO palavraChave2) {
		this.palavraChave2 = palavraChave2;
	}

	public PalavraChaveMO getPalavraChave3() {
		return palavraChave3;
	}

	public void setPalavraChave3(PalavraChaveMO palavraChave3) {
		this.palavraChave3 = palavraChave3;
	}

	public UserAccountMO getUploader() {
		return uploader;
	}

	public void setUploader(UserAccountMO uploader) {
		this.uploader = uploader;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
