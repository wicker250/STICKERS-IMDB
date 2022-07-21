import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        //fazendo uma conexao HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        HttpClient client = HttpClient.newHttpClient();
        
        
        URI endereco = URI.create(url);
        HttpRequest  request =  HttpRequest.newBuilder(endereco).GET().build(); 
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
       
        
        //extrair só os dados que interessam
        JsonParser parser = new JsonParser();

        List<Map<String,String>> listaDeFilmes = parser.parse(body);
        //exibir e manipular os dados
       
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }


    }
}
