package com.SistemLoja.SistemaLoja.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemLoja.SistemaLoja.Entity.ProdutoEntity;
import com.SistemLoja.SistemaLoja.Service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/produto")
public class ProdutoRestController {
    
    private ProdutoService produtoService;


    @Autowired
    public ProdutoRestController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    //métodos a vontade agora 
    /*
     * exemplo de um 
     *     @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    lembrar de manipular isso no postman e usar o navegador para visualizar
     */
    @GetMapping("/ListarProdutos")
    public List<ProdutoEntity> findAll(){
        return produtoService.findAll();
    } 

    @GetMapping("/produtos/{produtoId}")
    public ProdutoEntity getProduto(@PathVariable int produtoId){
        ProdutoEntity produto = produtoService.findById(produtoId);

        if(produto == null){
            throw new RuntimeException("Produto não encontrado - " + produtoId);
        }


        return produto;
    }

    @PostMapping("/adicionarProduto")
    public ProdutoEntity addProduto(@RequestBody ProdutoEntity produto){
        produto.setId(0); //precisa mesmo disso?

        ProdutoEntity dbproduto = produtoService.CriarProduto(produto);

        return dbproduto;
    }
//TODO terminar o restante dos métodos 
}


/*
 * 
 *     @GetMapping
    public List<ProdutoEntity> getAllProducts() {
        return produtoService.findAll();
    }

       * Retorna um produto específico pelo ID.
     * Endpoint: GET /produto/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> getProductById(@PathVariable Long id) {
        ProdutoEntity produto = produtoService.findById(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     * Cria um novo produto.
     * Endpoint: POST /produto
    @PostMapping
    public ProdutoEntity createProduct(@RequestBody ProdutoEntity produto) {
        return produtoService.save(produto);
    }

     * Atualiza um produto existente.
     * Endpoint: PUT /produto/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> updateProduct(@PathVariable Long id, @RequestBody ProdutoEntity produto) {
        ProdutoEntity updatedProduct = produtoService.update(id, produto);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     * Deleta um produto específico pelo ID.
     * Endpoint: DELETE /produto/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (produtoService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 */