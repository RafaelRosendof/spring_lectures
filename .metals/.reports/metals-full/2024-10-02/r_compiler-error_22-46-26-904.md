file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Security/SecurityConfig.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 2
uri: file://<WORKSPACE>/SistemaLoja/src/main/java/com/SistemLoja/SistemaLoja/Security/SecurityConfig.java
text:
```scala
/*@@ */
package com.SistemLoja.SistemaLoja.Security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    /* 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /* 
        http.authorizeRequests()
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("GERENTE")
            .antMatchers("/funcionario/**").hasAnyRole("GERENTE", "FUNCIONARIO")
            .and()
            .formLogin()
            .and()
            .logout()
            .permitAll();

        return http.build();
        */
/* 
        http.authorizeRequests(configurer -> 
            configurer 
                .requestMatchers("/").hasRole("FUNCIONARIO")
                .requestMatchers("/admin/**").hasRole("GERENTE")
                .requestMatchers("/funcionario/**").hasAnyRole("GERENTE", "FUNCIONARIO")
                .anyRequest().authenticated()
        )
        .formLogin( form -> 
            form.loginPage("/login")
            .loginProcessingUrl("/loginProcess")
            .permitAll()
        )
        .logout(logout -> logout.permitAll()
        )
        .exceptionHandling(configurer -> 
            configurer.accessDeniedPage("/acesso-negado")
        );

        return http.build();
    }

     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configuração de usuários em memória para testes iniciais
        auth.inMemoryAuthentication()
            .withUser("admin").password(passwordEncoder().encode("admin")).roles("GERENTE")
            .and()
            .withUser("funcionario").password(passwordEncoder().encode("funcionario")).roles("FUNCIONARIO");
    }
}

*/
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