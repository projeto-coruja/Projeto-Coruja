package Persistence.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_documentos")
public class Documento implements Serializable{

	//Serializável por necessidade
	private static final long serialVersionUID = 8543050270396423210L;

	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tipo_origem", referencedColumnName = "tipo_origem"),
		@JoinColumn(name = "cod_origem", referencedColumnName = "cod_origem")
	})
	private Origem origemDocumento;

	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tipo_id", referencedColumnName = "tipo_id"),
		@JoinColumn(name = "cod_id", referencedColumnName = "cod_id")
	})
	private IdNumDocumento idNumDocumento;

	@NotNull
	@ManyToOne
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
	private Date dataDocumento;

	@OneToMany
	@OrderColumn
	private PalavraChave[] palavrasChaves;// = new PalavraChave[3];
	
	@OneToMany
	@Column(name = "uploader")
	private User uploader;

	@Override
	public boolean equals(Object outro) {
		if(this == outro) return true;

		if(!(outro instanceof Documento)) return false;

		final Documento comp = (Documento) outro;
		if(!(comp.getIdNumDocumento().equals(getIdNumDocumento()))) return false;
		if(!(comp.getOrigemDocumento().equals(getOrigemDocumento()))) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		result = getIdNumDocumento().hashCode();
		result = result*31 + getOrigemDocumento().hashCode();
		return result;
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

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public PalavraChave[] getPalChaves() {
		return palavrasChaves;
	}

	public void setPalChaves(PalavraChave[] palChaves) {
		this.palavrasChaves = palChaves;
	}

	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}
	
	

}
