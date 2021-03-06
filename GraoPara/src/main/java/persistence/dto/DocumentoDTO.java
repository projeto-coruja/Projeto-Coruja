package persistence.dto;

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
	private Date dataDocumento;
	private Date dataInclusao;
	private UserDTO uploader;
	private PalavraChaveDTO palavrasChaves1;
	private PalavraChaveDTO palavrasChaves2;
	private PalavraChaveDTO palavrasChaves3;

	public DocumentoDTO(Long id, OrigemDTO origemDocumento,
			IdNumDocumentoDTO idNumDocumento, TipoDocumentoDTO tipoDocumento,
			String autor, String local, String destinatario, String resumo,
			Date dataDocumento, Date dataInclusao, UserDTO uploader,
			PalavraChaveDTO palavrasChaves1, PalavraChaveDTO palavrasChaves2,
			PalavraChaveDTO palavrasChaves3) {
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
		this.palavrasChaves1 = palavrasChaves1;
		this.palavrasChaves2 = palavrasChaves2;
		this.palavrasChaves3 = palavrasChaves3;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrigemDTO getOrigemDocumento() {
		return origemDocumento;
	}

	public void setOrigemDocumento(OrigemDTO origemDocumento) {
		this.origemDocumento = origemDocumento;
	}

	public IdNumDocumentoDTO getIdNumDocumento() {
		return idNumDocumento;
	}

	public void setIdNumDocumento(IdNumDocumentoDTO identDocumento) {
		this.idNumDocumento = identDocumento;
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

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public UserDTO getUploader() {
		return uploader;
	}

	public void setUploader(UserDTO uploader) {
		this.uploader = uploader;
	}

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public PalavraChaveDTO getPalavrasChaves1() {
		return palavrasChaves1;
	}

	public void setPalavrasChaves1(PalavraChaveDTO palavrasChaves1) {
		this.palavrasChaves1 = palavrasChaves1;
	}

	public PalavraChaveDTO getPalavrasChaves2() {
		return palavrasChaves2;
	}

	public void setPalavrasChaves2(PalavraChaveDTO palavrasChaves2) {
		this.palavrasChaves2 = palavrasChaves2;
	}

	public PalavraChaveDTO getPalavrasChaves3() {
		return palavrasChaves3;
	}

	public void setPalavrasChaves3(PalavraChaveDTO palavrasChaves3) {
		this.palavrasChaves3 = palavrasChaves3;
	}

}
