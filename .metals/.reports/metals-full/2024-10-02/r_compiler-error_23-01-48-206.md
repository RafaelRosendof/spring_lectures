file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Service/FuncionarioService.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Service/FuncionarioService.java
text:
```scala
package com.SistemLoja.SistemaLoja.Service;

import com.SistemLoja.SistemaLoja.DAO.FuncionarioDAO;
import com.SistemLoja.SistemaLoja.Entity.FuncionarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemLoja.SistemaLoja.DAO.CustomFuncDAO;
import java.util.List;

/*
 * 
 *     FuncionarioEntity findByCpf(String cpf); 

    void CriarFuncionario(FuncionarioEntity funcionario);

    void updateFuncionario(FuncionarioEntity funcionario);
 */

@Service
public class FuncionarioService{

    @Autowired
    private final FuncionarioDAO funcionarioDAO;
    private final CustomFuncDAO customFuncDAO;

    public FuncionarioService(FuncionarioDAO funcionarioDAO , CustomFuncDAO customFuncDAO){
        this.funcionarioDAO = funcionarioDAO;
        this.customFuncDAO = customFuncDAO;
    }

    public void deleteById(int id){
        funcionarioDAO.deleteById(id);
    }

    public FuncionarioEntity findById(int id){
        return funcionarioDAO.findById(id).orElse(null);
    }

    public FuncionarioEntity findByCpf(String cpf){
        return customFuncDAO.findByCpf(cpf);
    }

    public FuncionarioEntity CriarFuncionario(FuncionarioEntity funcionario){
        customFuncDAO.CriarFuncionario(funcionario);
        return funcionario;
    }

    public FuncionarioEntity updateFuncionario(FuncionarioEntity funcionario){
        customFuncDAO.updateFuncionario(funcionario);
        return funcionario;
    }

    public List<FuncionarioEntity> findAll(){
        return funcionarioDAO.findAll();
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