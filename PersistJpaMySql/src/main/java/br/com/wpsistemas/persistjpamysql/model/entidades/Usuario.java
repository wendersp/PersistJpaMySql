package br.com.wpsistemas.persistjpamysql.model.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author wender
 */
@Entity
@Table(name = "usuario", schema = "bd_prog2")
@NamedQueries({
    @NamedQuery(name = "Usuario.findByNome",
            query = "SELECT u FROM Usuario u WHERE u.nome LIKE :nome"),
    @NamedQuery(name = "Usuario.login",
            query = "SELECT u FROM Usuario u WHERE u.email = :email "
                    + "AND u.senha = :senha")
})
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "senha", length = 10)
    private String senha;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    public Usuario() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", cidade=" + cidade.getNome() + '}';
    }
    
    
    
}
