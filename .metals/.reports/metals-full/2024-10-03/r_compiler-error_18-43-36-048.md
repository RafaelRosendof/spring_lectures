file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Rest/ClienteRestController.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Rest/ClienteRestController.java
text:
```scala
package com.SistemLoja.SistemaLoja.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.math.BigDecimal;

import com.SistemLoja.SistemaLoja.Entity.ClienteEntity;
import com.SistemLoja.SistemaLoja.Service.ClienteService;
@RestController
@RequestMapping("/cliente")
public class ClienteRestController{

    private ClienteService clienteService;

    @Autowired
    public ClienteRestController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @DeleteMapping("/deletaCliente/{clienteId}")
    public void deleteCliente(@RequestParam int clienteId){
        ClienteEntity cliente = clienteService.findById(clienteId);

        if(cliente == null){
            throw new RuntimeException("Cliente não encontrado - " + clienteId);
        }
        clienteService.deleteById(clienteId);
    }

    @GetMapping("/ListClientes")
    public List<ClienteEntity> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{clienteId}")
    public ClienteEntity getCliente(@RequestParam int clienteId){
        ClienteEntity cliente = clienteService.findById(clienteId);

        if(cliente == null){
            throw new RuntimeException("Cliente não encontrado - " + clienteId);
        }

        return cliente;

    }

    @PostMapping("{id}/updateCliente")
    public ClienteEntity updateCliente(@PathVariable int id ,  @RequestBody ClienteEntity cliente){
        cliente.setId(id);

        ClienteEntity updateCliente = clienteService.updateCliente(cliente);

        if(updat)
        return cliente;
    }

    @PostMapping("/adicionarCliente")
    public ClienteEntity addCliente(@RequestBody ClienteEntity cliente){
        clienteService.CriarCliente(cliente);
        return cliente;
    }

   @GetMapping("/findSaldo")
   public BigDecimal findSaldo(@RequestParam int id){
       return clienteService.findSaldo(id);
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