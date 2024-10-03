file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/DAO/ProdutoImplDAO.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/DAO/ProdutoImplDAO.java
text:
```scala
package com.SistemLoja.SistemaLoja.DAO;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SistemLoja.SistemaLoja.Entity.ProdutoEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;

@Repository
public class ProdutoImplDAO implements CustomProdDAO{
     
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public ProdutoImplDAO(EntityManager em){
        this.em = em;
    }


    //essa foi feita pelo gpt, vamos ver né 
    @Override
    public ProdutoEntity findByNome(String nome) {
        TypedQuery<ProdutoEntity> aQuery = em.createQuery("SELECT p FROM ProdutoEntity p WHERE p.nome = :nome", ProdutoEntity.class);
        aQuery.setParameter("nome", nome);
        return aQuery.getSingleResult();
}


    @Override
    @Transactional
    public ProdutoEntity CriarProduto(ProdutoEntity produto){
        em.merge(produto); 
        //com o persist deu erro, melhor evitar por enq

        return produto;
    }

    @Override
    @Transactional
    public ProdutoEntity updatePrice(BigDecimal price , int id){
        Query query = em.createQuery("UPDATE ProdutoEntity p SET p.price = :price WHERE p.id = :id");
        query.setParameter("price", price);
        query.setParameter("id", id);
        query.executeUpdate();

        //return custom.findById(id).orElse(null);
        return em.find(ProdutoEntity.class, id);
        
    }

    @Override
    @Transactional
    public ProdutoEntity updateQuantidade(int quantidade , int id){
        Query query = em.createQuery("UPDATE ProdutoEntity p SET p.quantidade = :quantidade WHERE id = :id");
        query.setParameter("quantidade", quantidade);
        query.setParameter("id", id);
        query.executeUpdate();

        return em.find(ProdutoEntity.class, id);
    }
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
	scala.meta.internal.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:28)
	scala.meta.internal.pc.SimpleCollector.<init>(PcCollector.scala:373)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:117)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator