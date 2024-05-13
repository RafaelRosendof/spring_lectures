//to-do fazer a implementação da interface usuário 

package com.crudEscola.escola.dao;
import com.crudEscola.escola.entidade.Usuario;
import java.util.List;

/**
 * UsuarioDAO
 */
public interface UsuarioDAO {

    void save(Usuario theUsuario);

    Usuario findById(Integer id);

    List<Usuario> findAll();

    List<Usuario> findBySobrenome(String theSobrenome);
    //método para retornar os sobrenomes 

    void update(Usuario theUsuario);

    void delete(Integer id);

    int deleteAll();

    //todo{ mais métodos }
    
}