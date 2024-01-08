import java.util.*;

public class Main {
    private static ArrayList<Album> albums=new ArrayList<>();
    public static void main(String[] args) {
        Album album=new Album("Album1","AC/DC");
        album.addSong("TNT",4.5);
        album.addSong("Hichvay",3.5);
        album.addSong("Thunder",5.0);
        albums.add(album);

        album=new Album("Album2","Eminem");
        album.addSong("Rap god",4.5);
        album.addSong("Not afraid",3.5);
        album.addSong("Lose",5.5);
        albums.add(album);

        LinkedList<Song> playList_1=new LinkedList<>();

        albums.get(0).addToPlayList("TNT",playList_1);
        albums.get(0).addToPlayList("Hichvay",playList_1);
        albums.get(1).addToPlayList("Rap god",playList_1);
        albums.get(1).addToPlayList("Lose",playList_1);

        play(playList_1);

    }
    private static void play(LinkedList<Song> playlist){
        Scanner scanner=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator=playlist.listIterator();
        if (playlist.size()==0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action=scanner.nextInt();
            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    System.exit(0);
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no somg availble, reached to the end  of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("We are the first song.");
                        forward=false;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if (listIterator.hasPrevious()){
                                System.out.println("now playing "+listIterator.previous().toString());
                            }
                        }
                    }
                    break;
            }
        }

    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0. to quit\n"+
                           "1. to play next song\n"+
                           "2. to play preveios song\n"+
                           "3. to replay the current song\n"+
                           "4. list of all songs\n"+
                           "5. print all avaliable options\n"+
                           "6. delete current song");
    }
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator=playlist.iterator();
        System.out.println("-----------------------");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------------------");
    }
}