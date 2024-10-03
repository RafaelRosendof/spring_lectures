file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Service/ClienteService.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Service/ClienteService.java
text:
```scala
package com.SistemLoja.SistemaLoja.Service;

import java.util.List;
import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemLoja.SistemaLoja.DAO.ClienteDAO;
import com.SistemLoja.SistemaLoja.Entity.ClienteEntity;

import jakarta.transaction.Transactional;

import com.SistemLoja.SistemaLoja.DAO.CustomDAOCliente;


@Service
public class ClienteService{
    private final ClienteDAO clienteDAO;
    private final CustomDAOCliente customDAOCliente;

    @Autowired
    public ClienteService(ClienteDAO clienteDAO, CustomDAOCliente customDAOCliente){
        this.clienteDAO = clienteDAO;
        this.customDAOCliente = customDAOCliente;
    }

    //TODO

    public ClienteEntity findById(int id){
        Optional<ClienteEntity> cliente = clienteDAO.findById(id);
        return cliente.orElse(null);
    }

    public void deleteById(int id){
        clienteDAO.deleteById(id);
    }

    @Transactional
    public ClienteEntity updateCliente(ClienteEntity cliente){
        customDAOCliente.updateCliente(cliente);
        return cliente;
    }

    @Transactional
    public ClienteEntity CriarCliente(ClienteEntity cliente){
        customDAOCliente.CriarCliente(cliente);
        return cliente;
    }

    public ClienteEntity findConta(int id){
        return customDAOCliente.findConta(id);
    }

    public ClienteEntity findByCpf(String cpf){
        return customDAOCliente.findByCpf(cpf);
    }

    public BigDecimal findSaldo(int id){
        return customDAOCliente.findSaldo(id);
    }

    public List<ClienteEntity> findAll(){
        return clienteDAO.findAll();
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