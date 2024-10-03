file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Service/ProdutoService.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 1702
uri: file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Service/ProdutoService.java
text:
```scala
package com.SistemLoja.SistemaLoja.Service;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SistemLoja.SistemaLoja.DAO.ProdutoDAO;
import com.SistemLoja.SistemaLoja.Entity.ProdutoEntity;
import com.SistemLoja.SistemaLoja.DAO.CustomProdDAO;

/*
 * 
 *     ProdutoEntity findByNome(String nome);
    void CriarProduto(ProdutoEntity produto);
    void updatePrice(BigDecimal price , int id);
    void updateQuantidade(int value , int id);
    post put delete get
 */

@Service
public class ProdutoService{
    private final ProdutoDAO produtoDAO;
    private final CustomProdDAO customDAOProduto;

    public ProdutoService(ProdutoDAO produtoDAO , CustomProdDAO customDAOProduto){
        this.produtoDAO = produtoDAO;
        this.customDAOProduto = customDAOProduto;
    }

    public ProdutoEntity findByNome(String nome){
        return customDAOProduto.findByNome(nome);
    }

    public ProdutoEntity CriarProduto(ProdutoEntity produto){
        return customDAOProduto.CriarProduto(produto);
    }

    public ProdutoEntity updatePrice(BigDecimal price , int id){
        return customDAOProduto.updatePrice(price , id);
    }
    
    public ProdutoEntity updateQuantidade(int value , int id){
        return customDAOProduto.updateQuantidade(value , id);
    }

    public ProdutoEntity findById(int id){
        return produtoDAO.findById(id).orElse(null);
    }

    public void deleteById(int id){
        produtoDAO.deleteById(id);
    }

    public List<ProdutoEntity> findAll(){
        return produtoDAO.findAll();
    }

    String nome = "Notebook";
    String marca = "Dell";
    String categoria = "Eletrônicos";
    c@@

}

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