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
	private PalavraChaveMO atores;
	
	@ManyToOne
	private PalavraChaveMO instituicao;
	
	@ManyToOne
	private PalavraChaveMO acao;
	
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

	public PalavraChaveMO getAtores() {
		return atores;
	}

	public void setAtores(PalavraChaveMO atores) {
		this.atores = atores;
	}

	public PalavraChaveMO getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(PalavraChaveMO instituicao) {
		this.instituicao = instituicao;
	}

	public PalavraChaveMO getAcao() {
		return acao;
	}

	public void setAcao(PalavraChaveMO acao) {
		this.acao = acao;
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
