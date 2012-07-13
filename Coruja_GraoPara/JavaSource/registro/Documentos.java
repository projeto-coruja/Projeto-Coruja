package registro;

import java.io.Serializable;

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
@Table(name = "Documentos")
public class Documentos implements Serializable{
	
	//Serializável por necessidade
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tipo_Origem", referencedColumnName = "tipo_Origem"),
		@JoinColumn(name = "cod_Origem", referencedColumnName = "cod_Origem")
	})
	private Origem origemDocumento;
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tipo_Id", referencedColumnName = "tipo_Id"),
		@JoinColumn(name = "cod_Id", referencedColumnName = "cod_Id")
	})
	private IdNumDocumento identDocumento;
	
	@NotNull
	@JoinColumn(name = "tipo_De_Documento", referencedColumnName = "tipo_De_Documento")
	private TipoDocumento tipoDeDocumento;
	
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
	@Column(name = "data")
	private java.util.Date data;
	
	@OneToMany
	@OrderColumn
	private PalavraChave[] palChaves;// = new PalavraChave[3];

	public Origem getOrigemDocumento() {
		return origemDocumento;
	}

	public void setOrigemDocumento(Origem origemDocumento) {
		this.origemDocumento = origemDocumento;
	}

	public IdNumDocumento getIdentDocumento() {
		return identDocumento;
	}

	public void setIdentDocumento(IdNumDocumento identDocumento) {
		this.identDocumento = identDocumento;
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

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public PalavraChave[] getPalChaves() {
		return palChaves;
	}

	public void setPalChaves(PalavraChave[] palChaves) {
		this.palChaves = palChaves;
	}

	public TipoDocumento getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public void setTipoDeDocumento(TipoDocumento tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}
	
	@Override
	public boolean equals(Object outro) {
		if(this == outro) return true;
		
		if(!(outro instanceof Documentos)) return false;
		
		final Documentos comp = (Documentos) outro;
		if(!(comp.getIdentDocumento().equals(getIdentDocumento()))) return false;
		if(!(comp.getOrigemDocumento().equals(getOrigemDocumento()))) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result;
		result = getIdentDocumento().hashCode();
		result = result*31 + getOrigemDocumento().hashCode();
		return result;
	}
	
}
