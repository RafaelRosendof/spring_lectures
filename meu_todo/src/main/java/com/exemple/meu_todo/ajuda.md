

```javascript
fetch('http://localhost:8080/api/todos', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        "titulo": "Titulo do Todo",
        "completo": false
    })
})
.then(response => response.json())
.then(data => console.log(data))
.catch(error => console.error('Error:', error));
```



fetch('http://localhost:8080/api/todos': Este é o método fetch, uma API moderna para fazer solicitações HTTP em navegadores da web. Ele recebe como argumento a URL para onde deseja enviar a solicitação POST.

method: 'POST': Define o método HTTP da solicitação como POST, indicando que você está enviando dados para o servidor.

headers: {'Content-Type': 'application/json'}: Define os cabeçalhos da solicitação. Neste caso, estamos especificando que estamos enviando dados JSON, portanto, o tipo de conteúdo é definido como application/json.

body: JSON.stringify({...}): O corpo da solicitação é onde você envia os dados para o servidor. Aqui, usamos JSON.stringify() para converter um objeto JavaScript em uma string JSON. Este objeto contém os detalhes do novo todo que você deseja criar.

.then(response => response.json()): Esta é uma maneira de processar a resposta da solicitação. Aqui, estamos usando uma função de seta para converter a resposta da solicitação em JSON.

.then(data => console.log(data)): Após a resposta ser convertida em JSON, esta parte do código registra os dados retornados no console do navegador. Isso permite que você veja se o todo foi criado com sucesso ou se houve algum erro.

.catch(error => console.error('Error:', error));: Se ocorrer algum erro durante a solicitação, este bloco de código captura o erro e o registra no console do navegador.





### Código para os outros aqui GET

```javascript
fetch('http://localhost:8080/api/todos')
.then(response => {
    if (response.ok) {
        return response.json();
    } else {
        throw new Error('Erro ao obter os todos.');
    }
})
.then(data => {
    console.log('Todos:', data);
})
.catch(error => console.error('Erro:', error));
```

### Código para Delete 

```javascript
fetch('http://localhost:8080/api/todos/1', {
    method: 'DELETE'
})
.then(response => {
    if (response.ok) {
        console.log('Todo excluído com sucesso!');
    } else {
        console.error('Erro ao excluir o todo:', response.statusText);
    }
})
.catch(error => console.error('Erro:', error));

```


### Código para o Put

```javascript
fetch('http://localhost:8080/api/todos/1', {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        "titulo": "Novo Título",
        "completo": true
    })
})
.then(response => {
    if (response.ok) {
        console.log('Todo atualizado com sucesso!');
    } else {
        console.error('Erro ao atualizar o todo:', response.statusText);
    }
})
.catch(error => console.error('Erro:', error));
```

