file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Rest/FuncionarioRestController.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 1165
uri: file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Rest/FuncionarioRestController.java
text:
```scala
package com.SistemLoja.SistemaLoja.Rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SistemLoja.SistemaLoja.Service.FuncionarioService;
import com.SistemLoja.SistemaLoja.Entity.FuncionarioEntity;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @Por enquanto ficamos somente assim
 * Mas falta implementar quem sabe mais métodos 
 *  
 */

@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestController {
    
    private FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioRestController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

     @GetMapping("/List@@funcionarios")
     public List<FuncionarioEntity> findAll(){
         return funcionarioService.findAll();
     }

     @GetMapping("/funcionarios/{funcionarioId}")
     public FuncionarioEntity getFuncionario(@PathVariable int funcionarioId){
         FuncionarioEntity funcionario = funcionarioService.findById(funcionarioId);

         if(funcionario == null){
             throw new RuntimeException("Funcionario não encontrado - " + funcionarioId);
         }

         return funcionario;

     }

    @PostMapping("/adicionarFuncionario")
    public FuncionarioEntity addFunc(@RequestBody FuncionarioEntity funcionario){
        funcionarioService.CriarFuncionario(funcionario);
        return funcionario;
    }

    @PostMapping("/atualizarFuncionario")
    public FuncionarioEntity updateFunc(@RequestBody FuncionarioEntity funcionario){
        funcionarioService.updateFuncionario(funcionario);
        return funcionario;
    }
    
    @DeleteMapping("/deletarFuncionario/{funcionarioId}")
    public void deleteFunc(@PathVariable int funcionarioId){

        FuncionarioEntity funcionario = funcionarioService.findById(funcionarioId);

        if(funcionario == null){
            throw new RuntimeException("Funcionario não encontrado - " + funcionarioId);
        }

        funcionarioService.deleteById(funcionarioId);
    }

    @GetMapping("/funcionarios/{cpf}")
    public FuncionarioEntity getByCPF(@PathVariable String cpf){
        FuncionarioEntity func = funcionarioService.findByCpf(cpf);

        if(func == null){
            throw new RuntimeException("Funcionario não encontrado - " + cpf);
        }

        return func;
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
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:36)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:389)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator