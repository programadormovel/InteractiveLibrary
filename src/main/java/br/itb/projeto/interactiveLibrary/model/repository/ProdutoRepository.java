package br.itb.projeto.interactiveLibrary.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.itb.projeto.interactiveLibrary.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	// Query Method: PERMITE FAZER A CONSULTA DE ACORDO COM AS DEFINIÇÕES DO SPRING DATA JPA
	// ref: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	// na seção 5.1.3
	List<Produto> findByStatusProduto(String statusProduto);

	// JPQL: A CONSULTA É FEITA NO OBJETO REFERENTE À TABELA
	@Query("SELECT p FROM Produto p WHERE p.statusProduto = 'ATIVO'")
	List<Produto> listarProdutosAtivos();

	@Query("SELECT p FROM Produto p WHERE p.nome like %?1%")
	List<Produto> listarProdutosFiltro(@Param("nome") String nome);

	// O MESMO QUE O DE CIMA MAS UTILIZANDO Query Method
	List<Produto> findByNomeContaining(String nome);

	// nativeQuery: PERMITE FAZER O COMANDO TAL QUAL NO SQL
	@Query(value = "SELECT TOP 3 * FROM Produto p WHERE p.categoria = 'Algo' ORDER BY p.id DESC", nativeQuery = true)
	List<Produto> listar3ProdutosPelaCategoria();

	// nativeQuery: PERMITE FAZER O COMANDO TAL QUAL NO SQL
	// COM PASSAGEM DE PARÂMETRO COM CARACTERE "?"
	@Query(value = "SELECT TOP (?1) * FROM Produto p WHERE p.categoria = 'Algo' ORDER BY p.id DESC", nativeQuery = true)
	List<Produto> listarMaisProdutosPelaCategoria(int qtdeProdutos);

	// nativeQuery: PERMITE FAZER O COMANDO TAL QUAL NO SQL
	// COM PASSAGEM DE PARÂMETRO NOMEADO
	// passar o parâmetro depois dos ":" e declarar com a anotação @Param na lista
	// de argumentos do método
	@Query(value = "SELECT TOP (:qtdeProdutos) * FROM Produto p WHERE p.categoria = 'Algo' ORDER BY p.id DESC", nativeQuery = true)
	List<Produto> listarMaisProdutosPelaCategoria2(@Param("qtdeProdutos") int qtdeProdutos);
	
	// OU
	@Query(value = "SELECT * FROM Produto p WHERE p.categoria = :categoria ORDER BY p.id DESC", nativeQuery = true)
	List<Produto> listarProdutosPelaCategoria(@Param("categoria") String categoria);

}
