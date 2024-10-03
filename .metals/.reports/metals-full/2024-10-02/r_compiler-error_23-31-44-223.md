file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/DAO/FuncionarioImplDAO.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/DAO/FuncionarioImplDAO.java
text:
```scala
package com.SistemLoja.SistemaLoja.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import com.SistemLoja.SistemaLoja.Entity.FuncionarioEntity;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository

public class FuncionarioImplDAO implements CustomFuncDAO{

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public FuncionarioImplDAO(EntityManager em){
        this.em = em;
    }

    @Override
    public FuncionarioEntity findByCpf(String cpf){
        TypedQuery<FuncionarioEntity> query = em.createQuery("SELECT f FROM FuncionarioEntity f WHERE f.cpf = :cpf", FuncionarioEntity.class);
        query.setParameter("cpf", cpf);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public FuncionarioEntity CriarFuncionario(FuncionarioEntity funcionario){
        em.merge(funcionario);
        return funcionario;

    }

    @Override
    @Transactional
    public FuncionarioEntity updateFuncionario(FuncionarioEntity funcionario){
        em.merge(funcionario);

        return funcionario;
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