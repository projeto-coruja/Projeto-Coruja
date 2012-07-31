package persistence.dto;

/**
 * Interface nem tão vazia para type safe. <br/>
 * Todos os DTOs devem implementar essa interface.
 */
public interface DTO {
	void setId(Long id);
	Long getId();
}
