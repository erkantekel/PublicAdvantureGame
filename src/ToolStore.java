import java.util.Scanner;

public class ToolStore extends NormalLoc {
	Scanner scan =new Scanner(System.in);

	public ToolStore(Player player) {
		super(player, "Tool Store");
		
	}
	
	boolean onLocation(){
		System.out.println("Magazadasiniz almak istediginiz urunu secin");
		System.out.println("1-) Silahlar");
		System.out.println("2-) Zirhlar");
		System.out.println("3-) Cikis Yap");
		int selectCase = scan.nextInt();
		while (selectCase < 1 || selectCase > 3) {
			System.out.println("lütfen 1, 2 veya 3 değerlerini giriniz : ");
			selectCase = scan.nextInt();
		}
		switch(selectCase) {
			case 1 :
				printWeapon();
				buyWeapon();
				break;
			case 2 :
				printArmor();
				break;
			case 3 : 
				System.out.println("Bir daha bekleriz");
				return true;
			
		}			
		return true;
	}
	public void printWeapon() {
		System.out.println("-----Silahlar-----");
		System.out.println("1-) Kılıc \t Hasar: 2 \t Para: 5");
		System.out.println("2-) Tabanca \t Hasar: 3 \t Para: 35");
		System.out.println("3-) Tüfek \t Hasar: 6 \t Para: 55");
		System.out.println("Lutfen bir silah seciniz");
		
		}
		
	
	public void buyWeapon() {
		int selectWeaponID = scan.nextInt();
		while (selectWeaponID < 1 || selectWeaponID > 3) {
			System.out.println("lütfen geçerli bir deger giriniz : ");
			selectWeaponID = scan.nextInt();
			}
			
        Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
		
		if(Weapon.getWeaponObjById(selectWeaponID) != null) {
			if (selectedWeapon.getPrice()>this.getPlayer().getCoin()) {
				System.out.println("yeterli paraniz yok");
			}
			else {
				System.out.println(selectedWeapon.getName()+ " silahini satin aldiniz");
				int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
				this.getPlayer().setCoin(balance);
				System.out.println("kalan paraniz"+ this.getPlayer().getCoin());
				System.out.println("onceki silahiniz : " + this.getPlayer().getInventory().getWeapon().getName() );
				this.getPlayer().getInventory().setWeapon(selectedWeapon);
				System.out.println("yeni silahiniz : " + this.getPlayer().getInventory().getWeapon().getName());
			}
		}
	}
	
	
	public void printArmor() {
		System.out.println("-----Zirhlar-----");
		System.out.println("1-) Kiliç \t Hasar: 2 \t Para: 25");
		System.out.println("2-) Tabanca \t Hasar: 3 \t Para: 35");
		System.out.println("3-) Tüfek \t Hasar: 6 \t Para: 55");
		System.out.println("Lutfen bir zirh seciniz");
		int selectArmor = scan.nextInt();
		while (selectArmor < 1 || selectArmor > 3) {
			System.out.println("lütfen geçerli bir deger giriniz : ");
			selectArmor = scan.nextInt();
		}
	}

}
