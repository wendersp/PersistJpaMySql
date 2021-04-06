
package br.com.wpsistemas.persistjpamysql.testes;

import br.com.wpsistemas.persistjpamysql.model.dao.UsuarioDao;
import br.com.wpsistemas.persistjpamysql.model.entidades.Cidade;
import br.com.wpsistemas.persistjpamysql.model.entidades.Usuario;

/**
 *
 * @author wender
 */
public class TesteUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testeIncluir();
//        testeAlterar();
//        testePesquisar();
//        testeExcluir();
        
    }

    private static void testeIncluir() {
        Usuario u = new Usuario();
        u.setNome("Sebastião");
        u.setEmail("tiao@gmail.com");
        Cidade c = new Cidade();
        c.setNome("FIRMINOPOLIS");
        c.setUf("GO");
        u.setCidade(c);        
        new UsuarioDao().salvar(u);
    }

    private static void testeAlterar() {
        
    }

    private static void testePesquisar() {
        
    }

    private static void testeExcluir() {
        
    }
    
}
