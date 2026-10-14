package com.finan.orcamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="usuario")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="nome_usuario")
    private String nomeUsuario;

    @Column(name="cpf")
    private String cpf;

    @Column(name="nome_mae")
    private String nomeMae;

    @Column(name="email")
    private String email;

    @Column(name="telefone")
    private String telefone;

    @Column(name="data_nascimento")
    private LocalDate dataNascimento;

    @Column(name="endereco")
    private String endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<OrcamentoModel> orcamentos = new ArrayList<>();

    public UsuarioModel(){}

    public UsuarioModel(Long id, String nomeUsuario, String cpf, String nomeMae, String email, String telefone, LocalDate dataNascimento, String endereco, List<OrcamentoModel> orcamentos) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.cpf = cpf;
        this.nomeMae = nomeMae;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.orcamentos = orcamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<OrcamentoModel> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<OrcamentoModel> orcamentos) {
        this.orcamentos = orcamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioModel that = (UsuarioModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
