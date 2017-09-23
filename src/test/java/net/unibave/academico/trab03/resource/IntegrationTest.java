package net.unibave.academico.trab03.resource;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import javax.inject.Inject;
import net.unibave.academico.trab03.dto.ProdutoDTO;
import net.unibave.academico.trab03.dto.ProdutoTributacaoDTO;
import net.unibave.academico.trab03.dto.TributacaoDTO;
import net.unibave.academico.trab03.model.Ncm;
import net.unibave.academico.trab03.model.Produto;
import net.unibave.academico.trab03.model.Tributacao;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntegrationTest {

    @Inject
    private TestRestTemplate restTemplate;

    private static final String BASE_URI = "/api/tributacoes";

    @Test
    public void _001_criar() {
        final Ncm ncm = Ncm.builder().codigo(123456L).descricao("Teste").build();        
        ResponseEntity<Ncm> responseNcm = restTemplate
                .postForEntity("/api/ncms", ncm, Ncm.class);
        
        final ProdutoDTO produto1 = new ProdutoDTO(Produto.builder()
                .nome("Teste")
                .codigoBarras(789001002L)
                .ncm(ncm)
                .build());        
        
        final ProdutoDTO produto2 = new ProdutoDTO(Produto.builder()
                .nome("Teste 2")
                .codigoBarras(789001999L)
                .ncm(ncm)
                .build());        
        
        ResponseEntity<ProdutoDTO> responseProduto = restTemplate
                .postForEntity("/api/produtos", produto1, ProdutoDTO.class);
        
        ResponseEntity<ProdutoDTO> responseProduto2 = restTemplate
                .postForEntity("/api/produtos", produto2, ProdutoDTO.class);
        
        TributacaoDTO tributacao = new TributacaoDTO( 
            Tributacao.builder()
                .estado("SC")
                .inicioVigencia("2017-09-23")
                .ncm(ncm)
                .percentualIcms(17.0)
                .build() 
        );
        
        ResponseEntity<TributacaoDTO> responseTrib = restTemplate
                .postForEntity(BASE_URI, tributacao, TributacaoDTO.class);
        
        assertThat(responseTrib.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void _002_alterarProduto() {
        final ProdutoDTO produto1 = new ProdutoDTO(Produto.builder()
                .codigo(1L)
                .nome("Teste2")
                .codigoBarras(789001002L)
                .ncm(Ncm.builder().codigo(123456L).build())
                .build());  
        
        ResponseEntity<ProdutoDTO> response = restTemplate
                .exchange("/api/produtos/1", HttpMethod.PUT, new HttpEntity<>(produto1), ProdutoDTO.class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void _003_buscarTributacao() {
        ResponseEntity<List<ProdutoTributacaoDTO>> response = restTemplate
                .exchange(BASE_URI + "?vigencia=2017-09-23&estado=SC", 
                        HttpMethod.GET, null, getListTributacao());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void _004_listarProduto() {
        ResponseEntity<List<ProdutoDTO>> response = restTemplate
                .exchange("/api/produtos", 
                        HttpMethod.GET, null, getPageProduto());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void _005_buscarProduto() {
        ResponseEntity<ProdutoDTO> response = restTemplate
                .exchange("/api/produtos/1", 
                        HttpMethod.GET, null, ProdutoDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getCodigo()).isEqualTo(1L);
    }

    @Test
    public void _006_deletarProduto() {
        ResponseEntity<ProdutoDTO> response = restTemplate
                .exchange("/api/produtos/1", 
                        HttpMethod.DELETE, null, ProdutoDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    private ParameterizedTypeReference<List<ProdutoTributacaoDTO>> getListTributacao() {
        return new ParameterizedTypeReference<List<ProdutoTributacaoDTO>>(){
        };
    }

    private ParameterizedTypeReference<List<ProdutoDTO>> getPageProduto() {
        return new ParameterizedTypeReference<List<ProdutoDTO>>(){
        };
    }
}
