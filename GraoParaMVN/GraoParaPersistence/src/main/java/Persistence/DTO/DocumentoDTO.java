package Persistence.DTO;

import java.util.Date;

public class DocumentoDTO {

	private OrigemDTO origemDocumento;
	private IdNumDocumentoDTO identDocumento;
	private TipoDocumentoDTO tipoDocumento;
	private String autor;
	private String local;
	private String destinatário;
	private String resumo;
	private Date data;
	private UserDTO uploader;

	private PalavraChaveDTO[] palChaves;

	public OrigemDTO getOrigemDocumento() {
		return origemDocumento;
	}

	public void setOrigemDocumento(OrigemDTO origemDocumento) {
		this.origemDocumento = origemDocumento;
	}

	public IdNumDocumentoDTO getIdentDocumento() {
		return identDocumento;
	}

	public void setIdentDocumento(IdNumDocumentoDTO identDocumento) {
		this.identDocumento = identDocumento;
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDestinatário() {
		return destinatário;
	}

	public void setDestinatário(String destinatário) {
		this.destinatário = destinatário;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public UserDTO getUploader() {
		return uploader;
	}

	public void setUploader(UserDTO uploader) {
		this.uploader = uploader;
	}

	public PalavraChaveDTO[] getPalChaves() {
		return palChaves;
	}

	public void setPalChaves(PalavraChaveDTO[] palChaves) {
		this.palChaves = palChaves;
	}

}
