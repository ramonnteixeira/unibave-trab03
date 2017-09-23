package net.unibave.academico.trab03.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.unibave.academico.trab03.model.Ncm;
import net.unibave.academico.trab03.model.Tributacao;

@Data
@NoArgsConstructor
public class TributacaoDTO {

    private Long codigo;
    
    @NotNull
    private String estado;

    @NotNull
    private Long codigoNcm;

    @NotNull
    private Double percentualIcms;

    @NotNull
    private String inicioVigencia;

    public TributacaoDTO(Tributacao tributacao) {
        this.codigo = tributacao.getCodigo();
        this.estado = tributacao.getEstado();
        this.codigoNcm = tributacao.getNcm().getCodigo();
        this.percentualIcms = tributacao.getPercentualIcms();
        this.inicioVigencia = tributacao.getInicioVigencia();
    }

    public Tributacao toEntity() {
        return Tributacao.builder()
                .codigo(codigo)
                .estado(estado)
                .inicioVigencia(inicioVigencia)
                .ncm(Ncm.builder().codigo(codigoNcm).build())
                .percentualIcms(percentualIcms)
                .build();
    }
    
}
