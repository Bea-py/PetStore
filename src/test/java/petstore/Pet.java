//1 - Pacote
package petstore;

//2 - Bibliotecas


import com.beust.jcommander.Strings;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

//3- Classe
public class Pet {
    // 3.1 - Atributos - Características
    String uri = "https://petstore.swagger.io/v2/pet"; //endereço do endpoint PET

    //3.2 - Métodos e Funções
    public String  lerJson(String caminhoJson) throws IOException { // irá pegar tudo o que está no pet1json e mostrar aqui
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
        // caminho JSON vai ser lido pelo Path> depois o caminho Path vai ser lido pelo Files e retornar os arquivos dentro do caminho, e transforma em string
    }

    // Método Incluir - Create -- Post (CRUD)
    @Test //identifica o método ou função como um teste para o TesteNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");
//a estrutura é a mesma , o que muda é somente o caminho que vou testar e o endereço aonde está o arquivo

    //sintaxe Gherkin
    // Dado - Quando - Então
    // Given - When - Then

        given() //Dado
            .contentType("application/json") //comum em APIs REST - as antigas era "txt/xml"
            .log().all()
            .body(jsonBody)

        .when() // Quando
                .post(uri)

        .then() //Então
                .log().all()
                .statusCode(200)
        ;


    }



}