package registro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Documentos")
public class Documentos {
	
	@JoinColumns({
		@JoinColumn(name = "tipoOrigem", referencedColumnName = "tipoOrigem"),
		@JoinColumn(name = "numOrigem", referencedColumnName = "numOrigem")
	})
	private Origem origemDocumento;
	
	@JoinColumns({
		@JoinColumn(name = "tipoId", referencedColumnName = "tipoId"),
		@JoinColumn(name = "codId", referencedColumnName = "codId")
	})
	private IdNumDocumento identDocumento;
	
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
	
}
