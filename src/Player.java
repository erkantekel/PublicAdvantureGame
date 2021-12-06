import java.util.Scanner;

public class Player {
	private int damage;
	private int health;
	private int coin;
	private String name;
	private String charName;
	private int block;
	private Scanner scan = new Scanner(System.in);
	private Player player;
	private Inventory inventory;
	

	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}
	
	public void selectChar() {
		
		GameChar[] charList = {new Samurai(),new Knight(),new Archer()};
		
		for (GameChar gameChar : charList) {
			System.out.println("id:"+gameChar.getId()+
					"\t Karakter: "+ gameChar.getName()+
					"\t Hasar: "+ gameChar.getDamage()+
					"\t Block: " + gameChar.getBlock()+
					"\t Saglik: "+ gameChar.getHealth()+
					"\t Para: "+ gameChar.getCoin());
		}
		
			int selectChar = scan.nextInt();
			switch (selectChar) {
				case 1 :
					initPlayer(new Samurai());
					break;
				case 2 :
					initPlayer(new Knight());
					break;
				case 3 :
					initPlayer(new Archer());
					break;
				default:
					initPlayer(new Archer());
			}
		
	}
	
	public void initPlayer (GameChar gameChar) {
		this.setDamage(gameChar.getDamage());
		this.setHealth(gameChar.getHealth());
		this.setCharName(gameChar.getName());
		this.setCoin(gameChar.getCoin());
		
	}
	
	public void printInfo() {
		System.out.println("\t Weapon: "+ this.getInventory().getWeapon().getName()+
				"\t Damage: "+ this.getDamage()+
				"\t Armor: "+this.getInventory().getArmor().getName()+
				"\t Block: "+this.getBlock()+
				"\t Health: "+ this.getHealth()+
				"\t Money: "+ this.getCoin());
	}
	
	public int getDamage() {
		return damage + this.getInventory().getWeapon().getDamage();
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public String getCharName() {
		return charName;
	}
	public void setCharName(String charName) {
		this.charName = charName;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getBlock() {
		return block+ this.getInventory().getArmor().getBlock();
	}

	public void setBlock(int block) {
		this.block = block;
	}
	

	
}