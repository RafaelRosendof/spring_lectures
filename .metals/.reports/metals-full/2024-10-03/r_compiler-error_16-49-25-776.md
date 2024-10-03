file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Rest/ProdutoRestController.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 2854
uri: file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Rest/ProdutoRestController.java
text:
```scala
package com.SistemLoja.SistemaLoja.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemLoja.SistemaLoja.Entity.ProdutoEntity;
import com.SistemLoja.SistemaLoja.Service.ProdutoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.math.BigDecimal;



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
    update price
    update quantidade
    update nome
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
        ProdutoEntity dbproduto = produtoService.CriarProduto(produto);

        return dbproduto;
    }

    @PostMapping("/{id}/updatePrice")
    public ProdutoEntity updateProduto(@PathVariable int id , @RequestBody BigDecimal price){
       ProdutoEntity produto = produtoService.updatePrice(price , id);

       if(produto == null){
           throw new RuntimeException("Produto não encontrado - " + id);
       }

       return produto;

    }

    @PostMapping("/{id}/updateQuantidade")
    public ProdutoEntity updateQuantidade(@PathVariable int id , @RequestBody int value){
        ProdutoEntity produto = produtoService.updateQuantidade(value , id);

        if(produto == null){
            throw new RuntimeException("Produto não encontrado - " + id);
        }

        return produto;
    }

    @DeleteMapping("/delete/{produtoId}")
    public void deleteProduto(@PathVariable int produtoId){
        ProdutoEntity produto = produtoService.findById(produtoId);

        if(produto == null){
            throw new RuntimeException("Produto não encontrado - " + produtoId);
        }

        produtoService.deleteById(produtoId);
    }
}

/*@@ */
```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:48)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:155)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator