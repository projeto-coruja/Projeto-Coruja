package persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import datatype.SimpleDate;


@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"cod", "codiceCaixa"}))
public class DocumentoMO implements EntityModel  {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="cod")
	@NotEmpty
	private String cod;
	
	@NotNull
	@Column(length = 1024)
	private String titulo;
	
	@Column(length = 1024)
	private String local;

	@Column(length = 1024)
	private String url;
	
	@NotNull
	@Column(length = 8192)
	private String resumo;

	@JoinColumn(name="codiceCaixa")
	@ManyToOne
	private CodiceCaixaMO codiceCaixa;
	
	@ManyToOne
	private TipoDocumentoMO tipoDocumento;
	
	@ManyToOne
	private AutorMO autor;
	
	@ManyToOne
	private AutorMO destinatario;
	
	@ManyToOne
	private PalavraChaveMO palavraChave1;
	
	@ManyToOne
	private PalavraChaveMO palavraChave2;
	
	@ManyToOne
	private PalavraChaveMO palavraChave3;
	
	@ManyToOne
	private UserAccountMO uploader;
	
	@Type(type="persistence.util.SimpleDateHibernateType")
	private SimpleDate data;

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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public CodiceCaixaMO getCodiceCaixa() {
		return codiceCaixa;
	}

	public void setCodiceCaixa(CodiceCaixaMO codiceCaixa) {
		this.codiceCaixa = codiceCaixa;
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

	public AutorMO getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(AutorMO destinatario) {
		this.destinatario = destinatario;
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

	public SimpleDate getData() {
		return data;
	}

	public void setData(SimpleDate data) {
		this.data = data;
	}

}
