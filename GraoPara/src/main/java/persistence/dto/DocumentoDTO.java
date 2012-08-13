package persistence.dto;

import java.util.Calendar;
import java.util.Date;

public class DocumentoDTO implements DTO {
	
	private Long id;
	private OrigemDTO origemDocumento;
	private IdNumDocumentoDTO idNumDocumento;
	private TipoDocumentoDTO tipoDocumento;
	private String autor;
	private String local;
	private String destinatario;
	private String resumo;
	private Calendar dataDocumento;
	private Date dataInclusao;
	private UserDTO uploader;
	private PalavraChaveDTO[] palavrasChaves;
	
	public DocumentoDTO(Long id, OrigemDTO origemDocumento,
			IdNumDocumentoDTO idNumDocumento, TipoDocumentoDTO tipoDocumento,
			String autor, String local, String destinatario, String resumo,
			Calendar dataDocumento, Date dataInclusao, UserDTO uploader,
			PalavraChaveDTO[] palavrasChaves) {
		super();
		this.id = id;
		this.origemDocumento = origemDocumento;
		this.idNumDocumento = idNumDocumento;
		this.tipoDocumento = tipoDocumento;
		this.autor = autor;
		this.local = local;
		this.destinatario = destinatario;
		this.resumo = resumo;
		this.dataDocumento = dataDocumento;
		this.dataInclusao = dataInclusao;
		this.uploader = uploader;
		this.palavrasChaves = palavrasChaves;
	}
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}

	public OrigemDTO getOrigemDocumento() {	return origemDocumento;	}
	public void setOrigemDocumento(OrigemDTO origemDocumento) {	this.origemDocumento = origemDocumento;	}

	public IdNumDocumentoDTO getIdNumDocumento() {	return idNumDocumento;	}
	public void setIdNumDocumento(IdNumDocumentoDTO identDocumento) {	this.idNumDocumento = identDocumento;	}

	public TipoDocumentoDTO getTipoDocumento() {	return tipoDocumento;	}
	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {	this.tipoDocumento = tipoDocumento;	}

	public String getAutor() {	return autor;	}
	public void setAutor(String autor) {	this.autor = autor;	}

	public String getLocal() {	return local;	}
	public void setLocal(String local) {	this.local = local;	}

	public String getDestinatario() {	return destinatario;	}
	public void setDestinatario(String destinatario) {	this.destinatario = destinatario;	}

	public String getResumo() {	return resumo;	}
	public void setResumo(String resumo) {	this.resumo = resumo;	}

	public UserDTO getUploader() {	return uploader;	}
	public void setUploader(UserDTO uploader) {	this.uploader = uploader;	}

	public PalavraChaveDTO[] getPalavrasChaves() {	return palavrasChaves;	}
	public void setPalavrasChaves(PalavraChaveDTO[] palChaves) {	this.palavrasChaves = palChaves;	}

	public Calendar getDataDocumento() {	return dataDocumento;	}
	public void setDataDocumento(Calendar dataDocumento) {	this.dataDocumento = dataDocumento;	}

	public Date getDataInclusao() {	return dataInclusao;	}
	public void setDataInclusao(Date dataInclusao) {	this.dataInclusao = dataInclusao;	}

}
