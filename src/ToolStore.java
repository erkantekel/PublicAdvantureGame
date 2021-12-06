import java.util.Scanner;

public class ToolStore extends NormalLoc {
	Scanner scan =new Scanner(System.in);

	public ToolStore(Player player) {
		super(player, "Tool Store");
		
	}
	
	boolean onLocation(){
		System.out.println("You are at the toolshop please choose that you want to buy");
		System.out.println("1-) Weapons");
		System.out.println("2-) Armors");
		System.out.println("3-) Exit");
		int selectCase = scan.nextInt();
		while (selectCase < 1 || selectCase > 3) {
			System.out.println("Please enter a valid number : ");
			selectCase = scan.nextInt();
		}
		switch(selectCase) {
			case 1 :
				printWeapon();
				buyWeapon();
				break;
			case 2 :
				printArmor();
				buyArmor();
				break;
			case 3 : 
				System.out.println("Hope to see you again");
				return true;
			
		}			
		return true;
	}
	public void printWeapon() {
		System.out.println("-----Weapons-----");
		System.out.println("1-) Sword \t Damage: 2 \t Price: 5");
		System.out.println("2-) Pistol \t Damage: 3 \t Price: 35");
		System.out.println("3-) Rifle \t Damage: 6 \t Price: 55");
		System.out.print("Please choose a weapon : ");
		
		}
		
	
	public void buyWeapon() {
		int selectWeaponID = scan.nextInt();
		while (selectWeaponID < 1 || selectWeaponID > 3) {
			System.out.print("Please enter a valid number : ");
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
		System.out.println("-----Armors-----");
		System.out.println("1-) Light Armor \t Block: 1 \t Price: 15");
		System.out.println("2-) Medium Armor \t Block: 3 \t Price: 25");
		System.out.println("3-) Heavy Armor \t Block: 5 \t Price: 40");
		System.out.println("Please enter a number that you want to buy");
	}
	public void buyArmor() {
		int selectArmorID = scan.nextInt();
		while (selectArmorID < 1 || selectArmorID > 3) {
			System.out.println("Please enter a valid number : ");
			selectArmorID = scan.nextInt();
			}
		
        Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
		
		if(Weapon.getWeaponObjById(selectArmorID) != null) {
			if (selectedArmor.getPrice()>this.getPlayer().getCoin()) {
				System.out.println("You don't have enough coin");
			}
			else {
				System.out.println("You bought"+ selectedArmor.getName());
				int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
				this.getPlayer().setCoin(balance);
				System.out.println("Remaning Coin"+ this.getPlayer().getCoin());
				System.out.println("Previous Armor : " + this.getPlayer().getInventory().getArmor().getName() );
				this.getPlayer().getInventory().setArmor(selectedArmor);
				System.out.println("New Armor : " + this.getPlayer().getInventory().getArmor().getName());
				}
		}
	}
}