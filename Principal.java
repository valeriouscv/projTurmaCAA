import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static class MusicPlayer {
        private Map<String, List<String>> playlists = new HashMap<>();
        private Scanner scanner = new Scanner(System.in);

        public void com() {
            System.out.println("Bem vindo ao CAA Music Player");
            while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Criar Playlist");
                System.out.println("2. Adicionar Música à Playlist");
                System.out.println("3. Tocar Música");
                System.out.println("4. Sair");

                int escolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (escolha) {
                    case 1:
                        createPlaylist();
                        break;
                    case 2:
                        addMusicToPlaylist();
                        break;
                    case 3:
                        playMusic();
                        break;
                    case 4:
                        System.out.println("Fechando o CAA Music Player");
                        scanner.close(); // Fechar o Scanner antes de sair
                        return;
                    default:
                        System.out.println("Escolha errada, tente os comandos disponíveis");
                }
            }
        }

        private void createPlaylist() {
            System.out.println("Digite o nome da nova playlist:");
            String playlistName = scanner.nextLine();
            playlists.put(playlistName, new ArrayList<>());
            System.out.println("Playlist '" + playlistName + "' criada com sucesso.");
        }

        private void addMusicToPlaylist() {
            if (playlists.isEmpty()) {
                System.out.println("Crie uma playlist primeiro.");
                return;
            }

            System.out.println("Escolha a playlist para adicionar a música:");
            int i = 1;
            for (String playlistName : playlists.keySet()) {
                System.out.println(i + ". " + playlistName);
                i++;
            }
            int playlistIndex = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            List<String> selectedPlaylist = new ArrayList<>(playlists.values()).get(playlistIndex - 1);

            System.out.println("Digite o caminho do arquivo de áudio (.mp3):");
            String audioFile = scanner.nextLine();
            selectedPlaylist.add(audioFile);
            System.out.println("'" + audioFile + "' foi adicionado à playlist '" + selectedPlaylist + "'.");
        }

        private void playMusic() {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Tocar música diretamente");
            System.out.println("2. Tocar música de uma playlist");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Digite o caminho do arquivo de áudio (.mp3):");
                    String audioFile = scanner.nextLine();
                    playAudio(audioFile);
                    break;
                case 2:
                    playPlaylistMusic();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        private void playPlaylistMusic() {
            if (playlists.isEmpty()) {
                System.out.println("Crie uma playlist primeiro.");
                return;
            }

            System.out.println("Escolha a playlist:");
            int i = 1;
            for (String playlistName : playlists.keySet()) {
                System.out.println(i + ". " + playlistName);
                i++;
            }
            int playlistIndex = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            List<String> selectedPlaylist = new ArrayList<>(playlists.values()).get(playlistIndex - 1);

            if (!selectedPlaylist.isEmpty()) {
                String audioFile = selectedPlaylist.get(0);
                System.out.println("Tocando '" + audioFile + "'...");
                playAudio(audioFile);
                selectedPlaylist.remove(0); // Remover a música tocada da playlist
            } else {
                System.out.println("Playlist vazia. Adicione músicas para ouvi-las");
            }
        }

        private void playAudio(String audioFile) {
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
        }
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.com();
        
        //Scanner ler = new Scanner(System.in);
        //System.out.println("Projeto Turma - CAA");
        

    }
}
