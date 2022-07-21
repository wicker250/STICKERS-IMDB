import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.io.InputStream;
import java.io.OutputStream;
public class StickersMaker {

    

    public void cria() throws IOException {
        // leitura da imagem
        
        BufferedImage imagemOriginal = ImageIO.read(new File("C:/Users/Afonso/Desktop/Ws-java-alura/STICKERS/img/filme.jpg"));

        
        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        // insere 200 pixels
        int novaAltura = altura + 200;

        // nova imagem com fundo transparente "alfa"
        var novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        // copiar a imagem original para novo imagem (em memória)
        Graphics2D graphics2D = (Graphics2D) novaImagem.getGraphics();
        graphics2D.drawImage(imagemOriginal, 0, 0, null);


        // escrever uma frase na nova imagem

        // escrever a nova imagem em um arquivo
     
      
        ImageIO.write(novaImagem, "png", new File ("C:/Users/Afonso/Desktop/Ws-java-alura/STICKERS/saida/poster.png"));
    }
   
    public static void main(String[] args) throws IOException {
        StickersMaker gerada = new StickersMaker();
        gerada.cria();
    }
}
