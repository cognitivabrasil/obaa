Biblioteca OBAA para Java
=====================================================
Biblioteca que implementa o padrão de metadados OBAA em Java. 
Com ela é possível instanciar e gerar objetos OBAA a partir de um XML no padrão, além de se obter 
os valores possíveis para cada metadado e ainda obter a tradução de seus valores em português.

A partir do objeto OBAA, é possível também, gerar o XML no padrão e um JSON para exibição na web, este em português e em inglês. 

Mais informações sobre o padrão de metadados OBAA se encontra em http://www.portalobaa.org/

Licença
-------------------------------------------------------------
A biblioteca OBAA para Java está liberada sob licença LGPL (http://www.gnu.org/licenses/lgpl.html) e pode ser usada para fins comerciais.


Maven
-------------------------------------------------------------

### Repositório ###
```
<repositories>
        <repository>
            <id>cognitivabrasil</id>
            <url>http://143.54.83.93/maven/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
</repositories>
```

### Dependência ###

```
<dependency>
    <groupId>cognitivabrasil</groupId>
    <artifactId>obaa</artifactId>
    <version>2.2-SNAPSHOT</version>
</dependency>
```

Contato
-------------------------------------------------------------

A biblioteca é mantida pela Cognitiva Brasil http://cognitivabrasil.com.br

Se estiver interessado em colaborar com esse projeto entre em contato pelo e-mail contato@cognitivabrasil.com.br