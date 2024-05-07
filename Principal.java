import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Principal{
   
    public class MusicPlayer{
        private List<String> playlist= new ArrayList<>();
        private Scanner scanner = new Scanner (System.in);

        public void com() { //começar
            System.out.println("Bem vindo ao CAA Music Player //nome temporário ");
            while(true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1.Adicionar Música");
                System.out.println("2.Tocar Música");
                System.out.println("3.Sair");

                int esco=scanner.nextInt();
                scanner.nextLine(); //Limpar o buffer

                switch (esco){
                    case 1:
                        addMusic();
                        break;

                    case 2:
                        play();
                        break;

                    case 3:
                        System.out.println("Fechando o CAA Music Player");
                        return;
                    default:
                        System.out.println("Escolha errada, tente os comandos disponiveis");
                } 
    }
        }

private void addMusic(){
    System.out.println("Digite o nome da música: ");
    String music = scanner.nextLine();
    playlist.add(music);
    System.out.println("'" + music + "' foi adicionada á playlist.");
}

private void play(){
    if(!playlist.isEmpty()){
        String music = playlist.remove(0);
        System.out.println("Tocando '" + music + "'...");
    }else{
        System.out.println("Playlist vazia. Adicione músicas para ouvi-las");
    }
}       
    
    
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.start();
        
        //Scanner ler = new Scanner(System.in);
        //System.out.println("Projeto Turma - CAA");
        

    }
}
