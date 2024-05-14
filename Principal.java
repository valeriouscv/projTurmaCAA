import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static class MusicPlayer {
        private List<String> list = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void com() {
            System.out.println("Bem vindo ao CAA Music Player");
            while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Adicionar Música à Playlist");
                System.out.println("2. Tocar Música");
                System.out.println("3. Sair");

                int escolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (escolha) {
                    case 1:
                        addMusic();
                        break;
                    case 2:
                        play();
                        break;
                    case 3:
                        System.out.println("Fechando o CAA Music Player");
                        scanner.close(); // Fechar o Scanner antes de sair
                        return;
                    default:
                        System.out.println("Escolha errada, tente os comandos disponíveis");
                }
            }
        }

        private void addMusic() {
            System.out.println("Digite o caminho do arquivo de áudio (.mp3):");
            String audioFile = scanner.nextLine();
            list.add(audioFile);
            System.out.println("'" + audioFile + "' foi adicionado à playlist.");
        }

        private void play() {
            if (!list.isEmpty()) {
                String audioFile = list.get(0);
                System.out.println("Tocando '" + audioFile + "'...");

                // Verificar se o ambiente suporta a operação de Desktop
                if (Desktop.isDesktopSupported()) {
                    // Obtém a instância do Desktop
                    Desktop desktop = Desktop.getDesktop();

                    // Verificar se o arquivo de áudio existe
                    File file = new File(audioFile);
                    if (file.exists()) {
                        try {
                            // Abre o arquivo de áudio com o player padrão do sistema
                            desktop.open(file);
                        } catch (IOException e) {
                            System.out.println("Erro ao abrir o arquivo de áudio: " + e.getMessage());
                        }
                    } else {
                        System.out.println("O arquivo de áudio não foi encontrado.");
                    }
                } else {
                    System.out.println("O ambiente não suporta a operação de Desktop.");
                }

                // Remover a música da 'list' após ser tocada
                list.remove(0);
            } else {
                System.out.println("Lista vazia. Adicione músicas para ouvi-las");
            }
        }
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.com();
    
        
        //Scanner ler = new Scanner(System.in);
        //System.out.println("Projeto Turma - CAA");
        

    }
}
