package persistence;

import java.util.List;
import model.Entity;

/* Logo após o nome da interface temos o uso de Generics (<E>), essa
pratica é utilizada pelo Java no ArrayList, HashMap, entre outros. Serve
para não precisarmos definir o tipo do elemento para a 
classe,
generalizamos para um tipo E (Elemento) e quando instânciamos a classe
que definimos qual é o tipo dela, exemplo, no ArrayList se usa generics,
mas só quando você da um new ArrayList<E> você define o tipo que o
ArrayList irá utilizar. O mesmo acontece com nossa interface, ela persiste o
tipo E que extende de Entity, não sabemos qual é o tipo, apenas obrigamos
que qualquer classe que seja usada no Generics, tenha extendido o Entity.
Segue, na interface, as assinaturas dos métodos de salvar, atualizar,
deletar, procurar e listar a entidade.
 */

public interface IGenericDAO <E extends Entity>{
	public long save(E entity);
	public void update(E entity);
	public void delete(E entity);
	public List<E> findByCriteria(E entity, String value);
	public List<E> findByHQL(E entity, String value);
	List<E> getList(E entity);
}
