import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import java.awt.Color;
import java.awt.Font;

public class StickersMaker {

    

    public void cria() throws IOException {
        // leitura da imagem
        
        BufferedImage imagemOriginal = ImageIO.read(new File("C:/Users/Afonso/Desktop/Ws-java-alura/STICKERS/img/filmemaior.jpg"));

        
        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        // insere 200 pixels
        int novaAltura = altura + 200;

        // nova imagem com fundo transparente "alfa"
        var novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        // copiar a imagem original para novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        //configurar a fonte
       int tamanhoFonte = largura/10;
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD,tamanhoFonte);
        graphics.setFont(fonte);
        graphics.setColor(Color.RED);
        // escrever uma frase na nova imagem
        String text ="TOPZERA";
        int tamText = text.length();
        //
        graphics.drawString(text ,(largura)-(tamText*tamanhoFonte),novaAltura - 100);

        System.out.println("largura: "+largura);
        System.out.println("altura: "+altura);
        System.out.println(tamText);
        System.out.println(tamText*tamanhoFonte);
        System.out.println("tamfonte"+tamanhoFonte);
        // escrever a nova imagem em um arquivo
     
      
        ImageIO.write(novaImagem, "png", new File ("C:/Users/Afonso/Desktop/Ws-java-alura/STICKERS/saida/poster.png"));
    }
   
    public static void main(String[] args) throws IOException {
        StickersMaker gerada = new StickersMaker();
        gerada.cria();
        
    }
}
