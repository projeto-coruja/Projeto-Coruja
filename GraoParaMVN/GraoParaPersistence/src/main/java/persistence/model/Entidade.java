package persistence.model;

/**
 * Interface vazia para type safe. <br/>
 * Todas as entidades devem implementar essa interface.
 */
public interface Entidade {
	void setId(Long id);
	Long getId();
}
