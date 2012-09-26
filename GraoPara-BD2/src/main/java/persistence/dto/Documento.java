package persistence.dto;

import java.util.Date;

import org.jdto.annotation.DTOCascade;


public class Documento implements DTO {
	
	private Long id;
	
	private String cod;
	
	private String titulo;
	
	private String resumo;

	@DTOCascade
	private CodiceCaixa codiceCaixa;
	
	@DTOCascade
	private TipoDocumento tipoDocumento;
	
	@DTOCascade
	private Autor autor;
	
	@DTOCascade
	private PalavraChave palavraChave1;
	
	@DTOCascade
	private PalavraChave palavraChave2;
	
	@DTOCascade
	private PalavraChave palavraChave3;
	
	@DTOCascade
	private UserAccount uploader;
	
	private Date data;

	public Long getId() {
		return this.id;
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

	public CodiceCaixa getCodiceCaixa() {
		return codiceCaixa;
	}

	public void setCodiceCaixa(CodiceCaixa codiceCaixa) {
		this.codiceCaixa = codiceCaixa;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public PalavraChave getPalavraChave1() {
		return palavraChave1;
	}

	public void setPalavraChave1(PalavraChave palavraChave1) {
		this.palavraChave1 = palavraChave1;
	}

	public PalavraChave getPalavraChave2() {
		return palavraChave2;
	}

	public void setPalavraChave2(PalavraChave palavraChave2) {
		this.palavraChave2 = palavraChave2;
	}

	public PalavraChave getPalavraChave3() {
		return palavraChave3;
	}

	public void setPalavraChave3(PalavraChave palavraChave3) {
		this.palavraChave3 = palavraChave3;
	}

	public UserAccount getUploader() {
		return uploader;
	}

	public void setUploader(UserAccount uploader) {
		this.uploader = uploader;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
