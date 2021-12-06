import java.util.Scanner;

public class Game {
	private Scanner scan = new Scanner(System.in);
	public void start() {
		
		System.out.println("Macera Oyununa Hosgeldiniz");
		System.out.println("Lütfen bir isim giriniz: ");
		String playerName = scan.nextLine();
		Player player = new Player (playerName);
		System.out.println(player.getName() + " Hosgeldiniz umarim keyif alirsiniz. ");
		System.out.println("lutfen bir karakter secin");
		player.selectChar();
		while (true) {
			player.printInfo();
			Location location;
			System.out.println("Bolgeler");
			System.out.println("1-) \t Guvenli Ev");
			System.out.println("2-) \t Magaza");
			System.out.println("Lutfen gitmek istediginiz bolgeyi seciniz");
			int selectLoc = scan.nextInt();
			
			switch(selectLoc) {
			case 1 :
				location = new SafeHouse(player);
				break;
			case 2 : 
				location = new ToolStore(player);
				break;
			default :
				location = new SafeHouse(player);
			}
			if(location.onLocation() == false) {
				System.out.println("GAME OVER !!");
				break;
			}
			
		}
	}

}