
package br.com.wpsistemas.persistjpamysql.testes;

import br.com.wpsistemas.persistjpamysql.model.dao.CidadeDao;
import br.com.wpsistemas.persistjpamysql.model.entidades.Cidade;
import java.util.List;

/**
 *
 * @author wender
 */
public class TesteCidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //incluirCidade();
//        alterarCidade();
            pesquisarCidadePorId();
//        pesquisarCidadePorNome();
//        pesquisarCidadePorUF();
//        pesquisarCidadeAll();
//        excluirCidade();
    }

    public static void incluirCidade() {
        Cidade c1 = new Cidade();
        c1.setNome("TURVANIA");
        c1.setUf("GO");

        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.salvar(c1);

    }

    public static void alterarCidade() {
         CidadeDao cidadeDao = new CidadeDao();
         Cidade c1 = cidadeDao.pesquisar(5l);
         System.out.println(c1.toString());
         c1.setNome("GOIANIA");
         c1.setUf("GO");
         cidadeDao.salvar(c1);
         System.out.println(c1.toString());
    }
    
    public static void excluirCidade() {
        System.out.println("Excluir ciade...");
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.excluir(3l);       
        
    }
    
    public static void pesquisarCidadePorNome() {
        System.out.println("Pesquisar cidades por Nome.");
        CidadeDao cidadeDao = new CidadeDao();
        List<Cidade> listCidade = cidadeDao.pesquisar("T");
        for (Cidade cid : listCidade) {
            System.out.println(cid.toString());
        }        
    }

    private static void pesquisarCidadePorId() {
        System.out.println("Pesquisar cidades por id.");
        CidadeDao cidadeDao = new CidadeDao();
        Cidade cidade = cidadeDao.pesquisar(1l);
        System.out.println(cidade.toString());
        
    }
    
    
}
