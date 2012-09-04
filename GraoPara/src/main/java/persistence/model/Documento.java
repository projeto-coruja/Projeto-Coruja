package persistence.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
@Table(name = "tbl_documentos")
public class Documento implements Serializable,Entidade{

	//Serializável por necessidade
	private static final long serialVersionUID = 8543050270396423210L;
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumns({
		@JoinColumn(name = "tipo_origem", referencedColumnName = "tipo_origem"),
		@JoinColumn(name = "cod_origem", referencedColumnName = "cod_origem"),
		@JoinColumn(name = "titulo_origem", referencedColumnName = "titulo")
	})
	private Origem origemDocumento;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumns({
		@JoinColumn(name = "tipo_id", referencedColumnName = "tipo_id"),
		@JoinColumn(name = "cod_id", referencedColumnName = "cod_id")
	})
	private IdNumDocumento idNumDocumento;

	@NotNull
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento")
	private TipoDocumento tipoDocumento;

	@NotNull
	@Column(name = "autor", length = 48)
	private String autor;

	@NotNull
	@Column(name = "destinatario", length = 48)
	private String destinatario;

	@NotNull
	@Column(name = "local", length = 48)
	private String local;

	@NotNull
	@Column(name = "resumo", length = 2048)
	private String resumo;

	@NotNull
	@Column(name = "data_inclusao")
	private Date dataInclusao;
	
	@NotNull
	@Column(name = "data_documento")
	@Temporal(TemporalType.DATE)
	private Calendar dataDocumento;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "palavra_chave_1", referencedColumnName = "palavra")
	private PalavraChave palavrasChaves1;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "palavra_chave_2", referencedColumnName = "palavra")
	private PalavraChave palavrasChaves2;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "palavra_chave_3", referencedColumnName = "palavra")
	private PalavraChave palavrasChaves3;
	
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "email_uploader", referencedColumnName = "endereco")
	private User uploader;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Origem getOrigemDocumento() {
		return origemDocumento;
	}

	public void setOrigemDocumento(Origem origemDocumento) {
		this.origemDocumento = origemDocumento;
	}

	public IdNumDocumento getIdNumDocumento() {
		return idNumDocumento;
	}

	public void setIdentDocumento(IdNumDocumento identDocumento) {
		this.idNumDocumento = identDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Calendar getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Calendar dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}

	public PalavraChave getPalavrasChaves1() {
		return palavrasChaves1;
	}

	public void setPalavrasChaves1(PalavraChave palavrasChaves1) {
		this.palavrasChaves1 = palavrasChaves1;
	}

	public PalavraChave getPalavrasChaves2() {
		return palavrasChaves2;
	}

	public void setPalavrasChaves2(PalavraChave palavrasChaves2) {
		this.palavrasChaves2 = palavrasChaves2;
	}

	public PalavraChave getPalavrasChaves3() {
		return palavrasChaves3;
	}

	public void setPalavrasChaves3(PalavraChave palavrasChaves3) {
		this.palavrasChaves3 = palavrasChaves3;
	}	

}
