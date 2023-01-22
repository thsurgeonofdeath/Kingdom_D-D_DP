package org.example;

import org.example.Dragon.*;
import org.example.Hero.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Game {
    String text;
    int i=0;
    String characterName = "";
    HeroRace characterRace = HeroRace.HUMAN;
    HairColor characterHairColor = null;
    HairType characterHairType = null;
    Armor characterArmor = null;
    SwordType characterSword = null;
    Dragon dragon = new SimpleDragon();
    JFrame gameWindow = new JFrame(); // Application window
    Container gameContainer = gameWindow.getContentPane(); // Container for elements
    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel,playerNamePanel,dragonHealthPanel,dragonPanel,dragonPanel1; // Displays panel on screen
    JLabel titleLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName,dragonHealthLabel; // Displays text on screen
    Font titleFont = new Font("Book Antiqua", Font.BOLD, 60); // Creates customized font
    Font startButtonFont = new Font("Times New Roman", Font.BOLD, 45);
    Font gameFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4,choice5;
    JTextArea mainTextArea;
    JTextField playerName;
    int monsterHP;
    int monsterDamage;
    int playerHP;
    int playerDamage;
    int silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler cHandler = new ChoiceHandler();
    Hero.Builder builder = new Hero.Builder(characterRace, characterName);
    Hero character = new Hero(new meleeStrategy(), builder);
    static int dragonPower =0;
    static int heroAttack =0;
    static int dragonHealth=0;






    public static void main(String[] args) {

        new Game();
    }

    public Game() {
        // JFrame
        gameWindow.setSize(800, 600); // Sets size of window
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Creates an exit button on window
        gameWindow.getContentPane().setBackground(Color.black); // Creates black background on window
        gameWindow.setLayout(null); // Disables default layout with null


        titlePanel = new JPanel();
        titlePanel.setBounds(100, 10, 600, 80); // (x,y) is the position in pixels from the upper-left of the window.
        titlePanel.setBackground(Color.black); // (width, height) is the size of the title panel.
        titleLabel = new JLabel("Dungeons & Dragons");
        titleLabel.setForeground(Color.white); // Adds the white text over the blue panel. Set foreground after making
        // new JLabel.
        titleLabel.setFont(titleFont); // Sets font for title label.

        // JPanel
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        dragonPanel = new JPanel();
        dragonPanel.setBounds(250, 80, 320, 325);
        dragonPanel.setBackground(Color.BLACK);

        dragonPanel1 = new JPanel();
        dragonPanel1.setBounds(220, 150, 577, 433);
        dragonPanel1.setBackground(Color.BLACK);
        dragonPanel1.setVisible(false);



        // JButton
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(startButtonFont);
        startButton.addActionListener((ActionListener) tsHandler);
        startButton.setFocusPainted(false);
        BufferedImage myPicture;
        {
            try {
                myPicture = ImageIO.read(new File("C:/Users/PC/Desktop/info1/Semester 5/Design Patterns/CastleGame/src/main/java/org/example/myDragon.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        // Adds JComponents, JPanel to Container.
        startButtonPanel.add(startButton);
        titlePanel.add(titleLabel);
        dragonPanel.add(picLabel);
        gameContainer.add(titlePanel);
        gameContainer.add(startButtonPanel);
        gameContainer.add(dragonPanel);
        gameContainer.add(dragonPanel1);
        gameWindow.setVisible(true); // Makes sure your window is visible

    }

    public void createGameScreen() {
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        gameContainer.add(mainTextPanel);



        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 350);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(gameFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 320, 300, 200);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(5, 1));



        playerNamePanel = new JPanel();
        playerNamePanel.setBounds(100, 250, 300, 150);
        playerNamePanel.setBackground(Color.black);


        gameContainer.add(choiceButtonPanel);
        gameContainer.add(playerNamePanel);
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(gameFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(gameFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(gameFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(gameFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        choice5 = new JButton("Choice 5");
        choice5.setBackground(Color.black);
        choice5.setForeground(Color.white);
        choice5.setFont(gameFont);
        choice5.setFocusPainted(false);
        choice5.addActionListener(cHandler);
        choice5.setActionCommand("c5");
        choice5.setVisible(false);
        choiceButtonPanel.add(choice5);



        playerName = new JTextField("Enter your name here : ");
        playerName.setBackground(Color.black);
        playerName.setForeground(Color.gray.brighter());
        playerName.setFont(gameFont);
        playerNamePanel.add(playerName);


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));

        dragonHealthPanel = new JPanel();
        dragonHealthPanel.setBounds(450,500,250,100);
        dragonHealthPanel.setBackground(Color.black);
        gameContainer.add(playerPanel);
        gameContainer.add(dragonHealthPanel);


        playerSetup();

    }

    public void playerSetup() {
        townGate();
    }

    public void townGate() {
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        dragonPanel.setVisible(false);
        position = "townGate";
        playerName.setVisible(false);

//        mainTextArea.setText("Welcome to the Kingdom Game \nFirst, you need to build a character, chose a name for your character :");
        text = "Welcome to Dungeons & Dragons Game \nFirst, you need to build a character, chose a name for your character :";
        prepareText();
        playerName.setVisible(true);
        playerName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String name = playerName.getText();
                    characterName = name;
                    getRace();
                }
            }

        });
//        choice1.setText("Talk to the guard");
//        choice2.setText("Attack the guard");
//        choice3.setText("Leave");
//        choice4.setVisible(false);
    }

    Timer timer = new Timer(25, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char character[] = text.toCharArray();
            int arryNumber= character.length;

            String addedCharacter = "";
            String blank = "";

            addedCharacter = blank + character[i];
            mainTextArea.append(addedCharacter);

            i++;

            if(i == arryNumber)
            {
                i=0;
                timer.stop();
            }

        }
    });
    private  void prepareText()
    {
        mainTextArea.setText("");
        timer.start();

    }


    private void getRace()
    {
        position = "getRace";
//        mainTextArea.setText("Very good, now it's time to chose the race of your \n character :\n");
        text = "Very good, now it's time to chose the race of your \n character :\n";
        prepareText();
        playerName.setVisible(false);
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(true);
        choice5.setVisible(true);
        choice1.setText("Elf");
        choice2.setText("Dwarf");
        choice3.setText("Orc");
        choice4.setText("Goblin");
        choice5.setText("Human");
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(gameFont);
        hpLabelNumber.setForeground(Color.white);
        hpLabelNumber.setText("Character : " + characterName);
        playerPanel.add(hpLabelNumber);
    }
    private void playerHairType()
    {
        position = "hairType";
//        mainTextArea.setText("Excellent! now it's time to customize your character . \n let's start with Hair type, pick one of the following :\n");
        text = "Excellent! now it's time to customize your character . \nlet's start with Hair type, pick one of the following :\n";
        prepareText();
        choice1.setText("short hair");
        choice2.setText("curly hair");
        choice3.setText("long straight hair");
        choice4.setText("long curly hair");
        choice5.setText("Skip");
        choice5.setVisible(true);
    }

    private void playerHairColor()
    {
        position = "hairColor";
//        mainTextArea.setText("Maybe time to chose a color for that hair now? :\n");
        text = "Maybe time to chose a color for that hair now? :\n";
        prepareText();
        choice1.setText("Black");
        choice2.setText("Blond");
        choice3.setText("Red");
        choice4.setText("Brown");
        choice5.setText("Skip");


    }

    private void playerArmor()
    {
        position = "armor";
//        mainTextArea.setText("good, we're almost done, time to chose what kind of armor you want <<" +characterName+">> to wear :\n");
        text = "good, we're almost done, time to chose what kind of \n armor you want " +characterName+" to wear :\n";
        prepareText();
        choice1.setText("Leather Armor");
        choice2.setText("Iron Armor");
        choice3.setText("Copper Armor");
        choice4.setText("Diamond Armor");
        choice5.setText("Skip");
//        System.out.println("Hello your characterRace is : " + characterRace + " and  characterHairType " + characterHairType + "and characterHairColor " + characterHairColor );
    }
    private void playerSword()
    {
        position = "sword";
//        mainTextArea.setText("and one final step, you need to chose what kind of sword you want <<"+characterName+">> to weild :\n");
        text = "and one final step, you need to chose what kind of " +
                "\nsword you want "+characterName+" to weild," +
                "\nYou really don't want a warrior without a weapon ";
        prepareText();
        choice1.setText("Strone Sword");
        choice2.setText("Iron Sword");
        choice3.setText("Diamond Sword");
        choice4.setText("Netherite Sword");
        choice5.setVisible(false);
        System.out.println("Hello your characterRace is : " + characterRace + " and  characterHairType " + characterHairType + "and characterHairColor " + characterHairColor );
    }

    private void playerBuild()
    {
        String lol;
        var builder = new Hero.Builder(characterRace, characterName);
        StringBuilder HeroPresentation = new StringBuilder("Well Done! You built a "+characterRace+" named "+characterName+"\n");
        if(characterHairType != null){
            builder = builder.withHairType(characterHairType);
            HeroPresentation.append("You gave him a "+characterHairType.toString()+"\n");
        }
        if(characterHairColor != null){
            builder = builder.withHairColor(characterHairColor);
            HeroPresentation.append("The color of his hair is "+characterHairColor.toString()+"\n");
        }
        if(characterArmor != null){
            builder = builder.withArmor(characterArmor);
            HeroPresentation.append("He is wearing a "+characterArmor.toString()+"\n");
        }
        if(characterSword != null){
            builder = builder.withWeapon(characterSword);
            HeroPresentation.append(characterName.toString()+" is weilding a "+characterSword.toString());
        }
        var ElfHero = new Hero(new meleeStrategy(), builder);

        position = "builder";
//        mainTextArea.setText(HeroPresentation.toString());
        text = HeroPresentation.toString();
        prepareText();
        choice1.setText("Continue");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    private void dragonBuild()
    {
        position = "dragonBuilder";

        StringBuilder dragonPresentation = new StringBuilder("");

        Random randomPower = new Random();
        int answer = randomPower.nextInt(4) + 1;
        switch (answer){
            case 1:
                dragon = new SimpleDragon();
                dragonPresentation.append("A level 1 dragon was generated, his health is "+dragon.getAttackpower()+" HP\n"+dragon.attack());
                break;
            case 2:
                dragon = new ArmoredDragon(new SimpleDragon());
                dragonPresentation.append("A level 2 dragon was generated, his health is "+dragon.getAttackpower()+" HP\n"+dragon.attack());

                break;
            case 3:
                dragon = new FireDragon(new SimpleDragon());
                dragonPresentation.append("A level 3 dragon was generated, his health is "+dragon.getAttackpower()+" HP\n"+dragon.attack());

                break;
            case 4:
                dragon = new IceBreathDragon(new SimpleDragon());
                dragonPresentation.append("A level 4 dragon was generated, his health is "+dragon.getAttackpower()+" HP\n"+dragon.attack());

                break;
            case 5:
                dragon = new IceBreathDragon(new FireDragon(new SimpleDragon()));
                dragonPresentation.append("A level 5 dragon was generated, his health is "+dragon.getAttackpower()+" HP\n"+dragon.attack());

                break;
            case 6:
                dragon = new ArmoredDragon(new IceBreathDragon(new FireDragon(new SimpleDragon())));
                dragonPresentation.append("A level 6 dragon was generated, his health is "+dragon.getAttackpower()+" HP\n"+dragon.attack());
                break;
        }
        choiceButtonPanel.setBounds(250, 380, 300, 200);
        choice1.setVisible(true);
        choice1.setText("Start Fighting . . .");
        dragonHealth += dragon.getAttackpower();
//        mainTextArea.setText("So far, you did all the work, now it's our turn, we will generate a dragon with a random difficulty ... \n \n" +
//                dragonPresentation.toString()

        text =   " So far, you did all the work, now it's our turn, we\nwill generate a dragon with a random difficulty ... \n"
               + "The higher the power of a dragon is, the higher his \nhealth is, and the harder he will be to defeat... \n\n " + dragonPresentation.toString() ;
        prepareText();
        System.out.println("dragon health : " + dragonHealth);
    }

    private void dragonFight()
    {
        choiceButtonPanel.setBounds(150, 350, 500, 150);
        position = "dragonFight";
//        mainTextArea.setText("now it's time to take down the Dragon you're responsible for spawning,\n first you need to choose an attack strategy :");
        text = "now it's time to take down the Dragon you're  \n responsible for spawning,\n first you need to choose an attack strategy :";
        prepareText();
        choice1.setText("Melee Strategy (5 damage)");
        choice2.setText("Projectile Strategy (10 damage)");
        choice3.setText("Spell  Strategy (15 damage)");
        choice2.setVisible(true);
        choice3.setVisible(true);
        dragonHealthLabel = new JLabel();
        dragonHealthLabel.setFont(gameFont);
        dragonHealthLabel.setForeground(Color.white);
        dragonHealthLabel.setText("Dragon health : " + String.valueOf(dragonHealth)+" HP");
        dragonHealthPanel.add(dragonHealthLabel);
        System.out.println("dragon health : " + dragonHealth);
    }
    private void dragonKillFirstStrike()
    {

//        mainTextArea.setText("WOW! You defeated the dragon from the first strike, \n I mean you got lucky given you got a low level dragon but Impressive");
        text = "WOW! You defeated the dragon from the first strike, \n I mean you got lucky given you got a \n low level dragon but Impressive";
        prepareText();
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
    }

    private void dragonHit()
    {
        position = "dragonHit";
        System.out.println("dragon health : " + dragonHealth);
//        mainTextArea.setText("That was a good hit, but dragon is still standing, you still need to attack him, chose another strategy, or... use the same one again i guess : ");
        text =  character.goToBattle() +  "\n That was a good hit, but dragon is still standing, \n you still need to attack him, chose another strategy, \n or... use the same one again i guess : ";
        prepareText();
        choice1.setText("Melee Strategy (5 damage)");
        choice2.setText("Projectile Strategy (10 damage)");
        choice3.setText("Spell Strategy (15 damage) ");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(true);
        dragonHealthLabel.setText("Dragon health : " + String.valueOf(dragonHealth));
        dragonHealthPanel.add(dragonHealthLabel);
    }

    private void dragonDefeate()
    {
        mainTextPanel.setBounds(100, 30, 600, 250);

        mainTextArea.setBounds(100, 30, 600, 350);
        BufferedImage myPicture;
        {
            try {
                myPicture = ImageIO.read(new File("C:/Users/PC/Desktop/info1/Semester 5/Design Patterns/CastleGame/src/main/java/org/example/dragonSlayer.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        dragonPanel1.add(picLabel);
        dragonPanel1.setVisible(true);
        mainTextArea.setBackground(null);
    mainTextArea.setForeground(Color.decode("#fff3d0"));
        text =  "                       CONGRATULATIONS!\n" +
                "                   YOU KILLED THE BEAST!\n" +
                "YOU'RE OFFICALLY A DRAGON SLAYER NOW\n\n " ;
        prepareText();
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choiceButtonPanel.setVisible(false);
        dragonHealthPanel.setVisible(false);
    }

//    private void dragonAttack()
//    {
//        position = "dragonAttack";
//        character.goToBattle();
//
//        int dragonPower = dragon.getAttackpower();
//        int heroAttack = character.strategy.strategyPower();
//    }
    private void ending() {
        position = "ending";
        mainTextArea.setText("Guard: I see that you have obtained a Silver Ring.\nWelcome to the town!\nTHE END");
        choice1.setText("Play Again");
        choice2.setText("Exit");
        choice3.setVisible(false);
        choice4.setVisible(false);

    }

    public void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("You're at a crossroad. If you go south, you \nwill go back into the town.");
        choice1.setText("Go north");
        choice2.setText("Go south");
        choice3.setText("Go east");
        choice4.setText("Go west");
    }

    public void north() {
        position = "north";
        mainTextArea.setText("There is a river. You drink the water and rest at the riverside.\nYou have recovered 1 HP.");
        if(playerHP<15) {
            playerHP++;
            hpLabelNumber.setText("" + playerHP);
        }
        else {
            hpLabelNumber.setText("" + playerHP);
        }
        choice1.setText(">");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void east() {
        position = "east";
        mainTextArea.setText("You walked into the forest and found a Long Sword!\nYou equipped the Long Sword.");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);
        choice1.setText(">");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }


    public void west() {
        position = "west";
        mainTextArea.setText("You encountered a goblin!");
        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void fight() {
        position = "fight";
        mainTextArea.setText("Goblin HP: " + monsterHP);
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void playerAttack() {
        position = "playerAttack";
        playerDamage = 0;
        if(playerHP<1) {
            gameOver();
        }
        else {
            if(weapon.equals("Knife")) {
                playerDamage = new java.util.Random().nextInt(5);
            }
            else if(weapon.equals("Long Sword")) {
                playerDamage = new java.util.Random().nextInt(8);
            }
            mainTextArea.setText("You attacked the monster and dealt " + playerDamage + " damage!");
            monsterHP = monsterHP - playerDamage;

            choice1.setText(">");
            choice2.setVisible(false);
            choice3.setVisible(false);
            choice4.setVisible(false);
        }

    }
    public void monsterAttack() {
        position = "monsterAttack";
        monsterDamage = 0;
        if (monsterHP<1) {
            win();
        }
        else {
            monsterDamage = 0;

            monsterDamage = new java.util.Random().nextInt(4);
            mainTextArea.setText("The monster attacked you and dealt " + monsterDamage + " damage!");
            playerHP = playerHP - monsterDamage;
            hpLabelNumber.setText("" + playerHP);

            choice1.setText(">");
            choice2.setVisible(false);
            choice3.setVisible(false);
            choice4.setVisible(false);
        }
    }
    private void win() {
        // TODO Auto-generated method stub
        position = "win";
        mainTextArea.setText("You killed the monster!\nThe monster dropped an item...\nYou obtained a Silver Ring!!");
        silverRing = 1;
        choice1.setText(">");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void guardDialogue() {
        position = "guardDialogue";
        if(silverRing == 1) {
            ending();
        }
        else {
            mainTextArea.setText(
                    "Guard: Hello there, stranger.\nSorry but we cannot let you enter our town unless\nyou have a Silver Ring.");
            choice1.setText(">");
            choice2.setVisible(false);
            choice3.setVisible(false);
            choice4.setVisible(false);
        }
    }

    public void attackGuard() {
        position = "attackGuard";
        mainTextArea.setText(
                "You tried to attack the guard, but he fought back for 3 damage. Maybe you shouldn't attack him.");
        playerHP = playerHP - 3;
        if (playerHP <= 0) {
            gameOver();
        }
        hpLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void gameOver() {
        position = "gameOver";
        mainTextArea.setText("You are dead....\nGAME OVER");
        choice1.setText(">");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch (position) {
                case "getRace" :
                    switch (yourChoice) {
                        case "c1":
                            characterRace = HeroRace.ELF;
                            playerHairType();
                            break;
                        case "c2":
                            characterRace = HeroRace.DWARF;
                            playerHairType();
                            break;
                        case "c3":
                            characterRace = HeroRace.ORC;
                            playerHairType();
                            break;
                        case "c4" :
                            characterRace = HeroRace.GOBLIN;
                            playerHairType();
                            break;
                        case "c5" :
                            characterRace = HeroRace.HUMAN;
                            playerHairType();
                    }
                    break;
                case "hairType" :
                    switch (yourChoice) {
                        case "c1":
                            characterHairType = HairType.SHORT;
                            playerHairColor();
                            break;
                        case "c2":
                            characterHairType = HairType.CURLY;
                            playerHairColor();
                            break;
                        case "c3":
                            characterHairType = HairType.LONG_STRAIGHT;
                            playerHairColor();
                            break;
                        case "c4" :
                            characterHairType = HairType.LONG_CURLY;
                            playerHairColor();
                            break;
                        case "c5" :
                            characterHairType = null;
                            playerHairColor();
                            break;
                    }
                    break;
                case "hairColor" :
                    switch (yourChoice) {
                        case "c1":
                            characterHairColor = HairColor.BLACK;
                            playerArmor();
                            break;
                        case "c2":
                            characterHairColor = HairColor.BLOND;
                            playerArmor();
                            break;
                        case "c3":
                            characterHairColor = HairColor.RED;
                            playerArmor();
                            break;
                        case "c4" :
                            characterHairColor = HairColor.BROWN;
                            playerArmor();
                            break;
                        case "c5" :
                            characterHairColor = null;
                            playerArmor();
                            break;
                    }
                    break;
                case "armor" :
                    switch (yourChoice) {
                        case "c1":
                            characterArmor = Armor.LEATHER_ARMOR;
                            playerSword();
                            break;
                        case "c2":
                            characterArmor = Armor.IRON_ARMOR;
                            playerSword();
                            break;
                        case "c3":
                            characterArmor = Armor.COPPER_ARMOR;
                            playerSword();
                            break;
                        case "c4" :
                            characterArmor = Armor.DIAMOND_ARMOR;
                            playerSword();
                            break;
                        case "c5" :
                            characterArmor = null;
                            playerSword();
                            break;
                    }
                    break;
                case "sword" :
                    switch (yourChoice) {
                        case "c1":
                            characterSword = SwordType.STONE_SWORD;
                            playerBuild();
                            break;
                        case "c2":
                            characterSword = SwordType.IRON_SWORD;
                            playerBuild();
                            break;
                        case "c3":
                            characterSword = SwordType.DIAMOND_SWORD;
                            playerBuild();
                            break;
                        case "c4" :
                            characterSword = SwordType.NETHERITE_SWORD;
                            playerBuild();
                            break;
                    }
                    weaponLabelName = new JLabel();
                    weaponLabelName.setFont(gameFont);
                    weaponLabelName.setForeground(Color.white);
                    weaponLabelName.setText("Sword : " + String.valueOf(characterSword));
                    playerPanel.add(weaponLabelName);
                    break;
                case "builder" :
                    switch (yourChoice) {
                        case "c1":
                            dragonBuild();
                            break;

                    }
                    break;
                case "dragonBuilder" :
                    switch (yourChoice) {
                        case "c1":
                            dragonFight();
                            break;
                    }
                    break;
                case "dragonFight" :
                    switch (yourChoice) {
                        case "c1":
                            character = new Hero(new meleeStrategy(), builder);
                            break;
                        case "c2":
                            character = new Hero(new projectileStrategy(), builder);
                            break;
                        case "c3":
                            character = new Hero(new spellStrategy(), builder);
                            break;
                    }

                    dragonPower += dragon.getAttackpower();
                    int oldHeroAttack = character.strategy.strategyPower();
                    heroAttack += character.strategy.strategyPower();
                    if(dragonPower <= heroAttack){
                        dragonHealth -= oldHeroAttack;
                        dragonKillFirstStrike();
                    }
                    if(dragonPower > heroAttack){
                        dragonHealth -= heroAttack;
                        dragonHit();
                    }
                    else{
                        dragonDefeate();
                    }
                    break;
                case "dragonHit":
                    switch (yourChoice) {
                        case "c1":
                            character = new Hero(new meleeStrategy(), builder);
                            break;
                        case "c2":
                            character = new Hero(new projectileStrategy(), builder);
                            break;
                        case "c3":
                            character = new Hero(new spellStrategy(), builder);
                            break;
                    }
                    character.goToBattle();
                    int oldHeroAttack1 = character.strategy.strategyPower();
                    heroAttack = heroAttack + character.strategy.strategyPower();
                    if(dragonPower > heroAttack){
                        dragonHealth -= oldHeroAttack1;
                        dragonHit();
                    }
                    else{
                        dragonDefeate();
                    }
                    break;
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            guardDialogue();
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            crossRoad();
                            choice4.setVisible(true);
                            break;
                    }
                    break;
                case "guardDialogue":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            break;
                    }
                    break;
                case "attackGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            break;
                    }
                    break;

                case "crossRoad":
                    switch (yourChoice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            townGate();
                            choice4.setVisible(false);
                            break;
                        case "c3":
                            east();
                            break;
                        case "c4":
                            west();
                            break;
                    }
                    break;

                case "north":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            choice4.setVisible(true);
                            break;
                    }
                    break;
                case "east":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            choice4.setVisible(true);
                            break;
                    }
                    break;
                case "west":
                    switch (yourChoice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            crossRoad();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            choice4.setVisible(true);
                            break;
                    }
                    break;
                case "fight":
                    switch (yourChoice) {
                        case "c1":
                            playerAttack();
                            break;
                        case "c2":
                            crossRoad();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            choice4.setVisible(true);
                            break;
                        default:
                            break;
                    }
                    break;
                case "playerAttack":
                    switch(yourChoice) {
                        case "c1":
                            monsterAttack();
                            break;
                    }
                    break;
                case "monsterAttack":
                    switch (yourChoice) {
                        case "c1":
                            fight();
                            choice2.setVisible(true);
                            break;
                    }
                    break;
                case "win":
                    switch (yourChoice){
                        case "c1":
                            crossRoad();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            choice4.setVisible(true);
                            break;
                    }
                    break;
                case "gameOver":
                    switch (yourChoice) {
                        case "c1":
                            playerSetup();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            break;
                    }
                    break;
                case "ending":
                    switch (yourChoice) {
                        case "c1":
                            playerSetup();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            break;
                        case "c2":
                            System.exit(0);
                            break;
                    }
                    break;
            }

        }
    }
}
