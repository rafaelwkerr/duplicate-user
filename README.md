# Duplicate User Challenge
Esse repositório é um App android com o objetivo de solucionar um problema de usuário duplicado

## Libs usadas

As bibliotecas de terceiros usadas foram:

```groovy
RxKotlin
Joda
Fresco
Moshi
Dagger2

Junit
Hamcrest
Mockito
```

## Solução do problema de usuário duplicado

Para resolver o problema do usuário duplciado, usei 2 soluções:

* Usando Set ao invés de List, pois ele já elimina os objetos duplicados, e usei data class que já implementa ```Hascode/Equals```

* Usando List, mas usando o operador ```distinct```do Kotlin para elimiar os objetos duplicados das Collections

Para decidir qual opção usar, criei um teste de performance chamado ``` UserBenchTest ``` que tem basicamente duas functions: ``` bench_getAllUsers_usingSet``` e ```bench_getAllUsers_usingListDistinct``` e usei a function ```measureNanoTime```para medir qual a soluço mais performática.

Set | Distinct
--- | ---
953000 | 1045000 

![alt text](https://github.com/rafaelwkerr/my-files/blob/master/Screen%20Shot%202017-09-12%20at%2012.48.39%20AM.png "Output: ")
