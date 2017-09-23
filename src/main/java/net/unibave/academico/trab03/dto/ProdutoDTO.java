package net.unibave.academico.trab03.dto;

import lombok.Data;
import net.unibave.academico.trab03.model.Ncm;
import net.unibave.academico.trab03.model.Produto;

@Data
public class ProdutoDTO {

    private Long codigo;
    private String nome;
    private Long codigoNcm;
    private Long codigoBarras;
    
    public ProdutoDTO() {
    }
    
    public ProdutoDTO(Produto produto) {
        codigo = produto.getCodigo();
        nome = produto.getNome();
        codigoNcm = produto.getNcm().getCodigo();
        codigoBarras = produto.getCodigoBarras();
    }
    
    public Produto toEntity() {
        return Produto.builder()
                .codigo(codigo)
                .codigoBarras(codigoBarras)
                .nome(nome)
                .ncm(Ncm.builder().codigo(codigoNcm).build())
                .build();
    }
}
