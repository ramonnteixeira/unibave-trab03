package net.unibave.academico.trab03.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Ncm {

    @Id
    @Column(name = "ncm_id")
    private Long codigo;
    
    @NotNull
    @Size(min = 3, max = 100)
    @Column(length=100, nullable=false)
    private String descricao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "ncm")
    private List<Produto> produtos;
}
