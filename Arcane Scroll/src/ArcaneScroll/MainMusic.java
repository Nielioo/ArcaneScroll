package ArcaneScroll;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.Timer;

public class MainMusic {

    MainScreenHandler msHandler = new MainScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    NextHandler nHandler = new NextHandler();
    TryAgainHandler tryAgainHandler = new TryAgainHandler();
    WinLoseHandler winLoseHandler = new WinLoseHandler();

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MainMusic main = new MainMusic();
        main.frame();

        File file = new File("GameMusic.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();
        clip.loop(100);
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
    }

    // Fonts
    Font nasalizationp16 = new Font("NASALIZATION Rg", Font.PLAIN, 16);
    Font nasalizationp20 = new Font("NASALIZATION Rg", Font.PLAIN, 20);
    Font nasalizationp30 = new Font("NASALIZATION Rg", Font.PLAIN, 30);
    Font nasalizationp50 = new Font("NASALIZATION Rg", Font.PLAIN, 50);
    Font nasalizationb20 = new Font("NASALIZATION Rg", Font.BOLD, 20);
    Font nasalizationb25 = new Font("NASALIZATION Rg", Font.BOLD, 25);
    Font nasalizationb30 = new Font("NASALIZATION Rg", Font.BOLD, 30);
    Font nasalizationb60 = new Font("NASALIZATION Rg", Font.BOLD, 60);
    Font nasalizationb80 = new Font("NASALIZATION Rg", Font.BOLD, 80);

    // ImageIcon
    ImageIcon titleImage = new ImageIcon("TitleBox.png");
    ImageIcon startImage = new ImageIcon("StartButton.png");
    ImageIcon exitImage = new ImageIcon("ExitButton.png");

    ImageIcon backImage = new ImageIcon("BackButton.png");
    ImageIcon nameImage = new ImageIcon("NameBox.png");
    ImageIcon submitImage = new ImageIcon("SubmitButton.png");

    ImageIcon storyImage = new ImageIcon("StoryBoxRev.png");
    ImageIcon nextImage = new ImageIcon("NextButton.png");

    ImageIcon questionImage = new ImageIcon("QuestionBoxRev.png");
    ImageIcon choiceImage = new ImageIcon("ChoiceButtonRev.png");
    ImageIcon choice2Image = new ImageIcon("ChoiceButtonRev2.png");
    ImageIcon statusImage = new ImageIcon("StatusBoxRev.png");
    ImageIcon timerImage = new ImageIcon("TimerBox.png");

    ImageIcon tryAgainImage = new ImageIcon("TryAgainBox.png");
    ImageIcon yesImage = new ImageIcon("yesButton.png");
    ImageIcon noImage = new ImageIcon("noButton.png");
    ImageIcon homeImage = new ImageIcon("HomeButton.png");

    ImageIcon aerialImage = new ImageIcon("AerialScroll.png");
    ImageIcon crystalineImage = new ImageIcon("CrystalineScroll.png");
    ImageIcon aqueousImage = new ImageIcon("AqueousScroll.png");
    ImageIcon cryoImage = new ImageIcon("CryoScroll.png");
    ImageIcon pyroImage = new ImageIcon("PyroScroll.png");
    ImageIcon luminousImage = new ImageIcon("LuminousScroll.png");
    ImageIcon dendroImage = new ImageIcon("DendroScroll.png");
    ImageIcon umbraImage = new ImageIcon("UmbraScroll.png");

    ImageIcon aerial2Image = new ImageIcon("AerialScroll2.png");
    ImageIcon crystaline2Image = new ImageIcon("CrystalineScroll2.png");
    ImageIcon aqueous2Image = new ImageIcon("AqueousScroll2.png");
    ImageIcon cryo2Image = new ImageIcon("CryoScroll2.png");
    ImageIcon pyro2Image = new ImageIcon("PyroScroll2.png");
    ImageIcon luminous2Image = new ImageIcon("LuminousScroll2.png");
    ImageIcon dendro2Image = new ImageIcon("DendroScroll2.png");
    ImageIcon umbra2Image = new ImageIcon("UmbraScroll2.png");

    ImageIcon mainImage = new ImageIcon("BackgroundImage.png");

    // Anything needed
    JFrame mainMenu;
    JPanel mTitlePanel, mButtonPanel,
            pPlayerPanel, pNamePanel, pBackPanel,
            storyPanel, storyNextPanel,
            scrollResultPanel, scrollNextPanel,
            mainTextPanel, choiceButtonPanel, statusPanel, timePanel, scrollPanel,
            tryAgainTitlePanel, tryAgainTextPanel, tryAgainBtnPanel,
            winLoseTitlePanel, winLoseBtnPanel,
            mainMenuBGPanel;
    JLabel mTitleLabel, pPlayerLabel,
            scrollResultLabel, scrollResult2Label, scrollResult3Label,
            statusLabel,
            tryAgainTitleLabel, tryAgainTextLabel,
            winLoseTitleLabel,
            timeLabel,
            titleTextBGLabel, storyTextBGLabel, mainTextBGLabel, statusTextBGLabel, timerTextBGLabel,
            taTextBGLabel, wlTextBGLabel, mainBGLabel, nameTextBGLabel,
            aerialLabel, aqueousLabel, cryoLabel, crystalineLabel, dendroLabel, luminousLabel, pyroLabel, umbraLabel;
    JTextArea mainTextArea, storyTextArea;
    JTextField pNameTField;
    JButton mStartBtn, mQuitBtn,
            pNameBtn, pBackBtn,
            storyNextBtn,
            scrollNextBtn,
            choice1, choice2, choice3, choice4, choice5,
            tryAgainYesBtn, tryAgainNoBtn,
            winLoseBtn;
    JLayeredPane mLayeredPane, pLayeredPane, storyLayeredPane, sLayeredPane, tLayeredPane,
            wlLayeredPane, scrollLayeredPane, srLayeredPane;
    Timer timer;
    Container con;
    GridBagConstraints gbc;

    String position, soal, answer, nama;
    int life, scroll, cd;
    char U;
    boolean c1Bool, c2Bool, c3Bool, c4Bool, c5Bool;
    String[] UrutanJawaban = new String[5];

    private void frame() {
        // Game JFrame
        mainMenu = new JFrame();
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setLayout(null);
        mainMenu.setSize(1280, 720);
        mainMenu.setResizable(false);
        mainMenu.setLocationRelativeTo(null);
        con = mainMenu.getContentPane();

        mainMenu();
    }

    private void mainMenu() {
        position = "mainMenu";
        gbc = new GridBagConstraints();

        // Title
        mTitlePanel = new JPanel();
        mTitlePanel.setBounds(290, 225, 700, 150);
        mTitlePanel.setOpaque(false);

        mTitleLabel = new JLabel("Arcane Scroll");
        mTitleLabel.setFont(nasalizationb80);
        mTitleLabel.setForeground(Color.white);

        // Title Image
        titleTextBGLabel = new JLabel();
        titleTextBGLabel.setIcon(titleImage);
        titleTextBGLabel.setBounds(115, 50, 1050, 350);

        // Main Menu Buttons
        mButtonPanel = new JPanel();
        mButtonPanel.setBounds(465, 400, 350, 200);
        mButtonPanel.setOpaque(false);
        mButtonPanel.setLayout(new GridBagLayout());

        mStartBtn = new JButton();
        mStartBtn.setIcon(startImage);
        mStartBtn.setBorderPainted(false);
        mStartBtn.setFocusPainted(false);
        mStartBtn.setContentAreaFilled(false);
        mStartBtn.addActionListener(msHandler);
        mStartBtn.setActionCommand("cStart");
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mButtonPanel.add(mStartBtn, gbc);

        mQuitBtn = new JButton();
        mQuitBtn.setIcon(exitImage);
        mQuitBtn.setBorderPainted(false);
        mQuitBtn.setFocusPainted(false);
        mQuitBtn.setContentAreaFilled(false);
        mQuitBtn.addActionListener(msHandler);
        mQuitBtn.setActionCommand("cQuit");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mButtonPanel.add(mQuitBtn, gbc);

        // Background
        mainMenuBGPanel = new JPanel();
        mainMenuBGPanel.setBounds(0, 0, 1280, 720);
        mainMenuBGPanel.setBackground(Color.black);

        mainBGLabel = new JLabel();
        mainBGLabel.setIcon(mainImage);
        mainBGLabel.setBounds(0, 0, 1285, 725);

        // Main Menu Adds
        mTitlePanel.add(mTitleLabel);

        // Main Menu Layered Pane
        mLayeredPane = new JLayeredPane();
        mLayeredPane.setBounds(0, 0, 1280, 720);
        mLayeredPane.add(mTitlePanel);
        mLayeredPane.add(mButtonPanel);
        mLayeredPane.add(titleTextBGLabel);
        mLayeredPane.add(mainBGLabel);

        // Life
        life = 10;

        // Container Adds
        con.add(mLayeredPane);

        // Game JFrame Visibility
        mainMenu.setVisible(true);
    }

    private void playerName() {
        position = "playerName";
        gbc = new GridBagConstraints();

        // Title Text
        pPlayerPanel = new JPanel();
        pPlayerPanel.setBounds(240, 225, 800, 100);
        pPlayerPanel.setOpaque(false);

        pPlayerLabel = new JLabel("Masukkan Nickname");
        pPlayerLabel.setFont(nasalizationb60);
        pPlayerLabel.setForeground(Color.white);
        pPlayerLabel.setHorizontalAlignment(JLabel.CENTER);
        pPlayerPanel.add(pPlayerLabel);

        // Player Text Field
        pNamePanel = new JPanel();
        pNamePanel.setBounds(140, 300, 1000, 200);
        pNamePanel.setOpaque(false);
        pNamePanel.setLayout(new GridBagLayout());

        pNameTField = new JTextField("Nickname");
        pNameTField.setHorizontalAlignment(JTextField.RIGHT);
        pNameTField.setPreferredSize(new Dimension(390, 70));
        pNameTField.setFont(nasalizationp30);
        pNameTField.setForeground(Color.white);
        pNameTField.setOpaque(false);
        pNameTField.setCaretColor(Color.white);
        pNameTField.setBorder(BorderFactory.createEmptyBorder());
        gbc.insets = new Insets(0, 5, 0, 15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        pNamePanel.add(pNameTField, gbc);

        // Player Buttons
        pNameBtn = new JButton();
        pNameBtn.setIcon(submitImage);
        pNameBtn.setBorderPainted(false);
        pNameBtn.setFocusPainted(false);
        pNameBtn.setContentAreaFilled(false);
        pNameBtn.addActionListener(msHandler);
        pNameBtn.setActionCommand("cSubmit");
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 0;
        pNamePanel.add(pNameBtn, gbc);

        pBackPanel = new JPanel();
        pBackPanel.setBounds(0, 550, 150, 150);
        pBackPanel.setOpaque(false);

        pBackBtn = new JButton();
        pBackBtn.setIcon(backImage);
        pBackBtn.setBorderPainted(false);
        pBackBtn.setFocusPainted(false);
        pBackBtn.setContentAreaFilled(false);
        pBackBtn.addActionListener(msHandler);
        pBackBtn.setActionCommand("cBack");
        pBackPanel.add(pBackBtn);

        scroll();

        // Name Image
        nameTextBGLabel = new JLabel();
        nameTextBGLabel.setIcon(nameImage);
        nameTextBGLabel.setBounds(270, 355, 420, 90);

        // Player Layered Pane
        pLayeredPane = new JLayeredPane();
        pLayeredPane.setBounds(0, 0, 1280, 720);
        pLayeredPane.add(pPlayerPanel);
        pLayeredPane.add(nameTextBGLabel);
        pLayeredPane.add(pNamePanel);
        pLayeredPane.add(pBackPanel);
        pLayeredPane.add(mainBGLabel);

        // Con Adds
        con.add(pLayeredPane);
    }

    private void story() {
//        position = "story";

        // Story Text
        storyPanel = new JPanel();
        storyPanel.setBounds(100, 125, 1050, 400);
        storyPanel.setOpaque(false);

        storyTextArea = new JTextArea();
        storyTextArea.setBounds(100, 125, 1050, 400);
        storyTextArea.setForeground(Color.white);
        storyTextArea.setOpaque(false);
        storyTextArea.setFont(nasalizationp20);
        storyTextArea.setLineWrap(true);
        storyTextArea.setEditable(false);
        storyPanel.add(storyTextArea);

        // Story Image
        storyTextBGLabel = new JLabel();
        storyTextBGLabel.setIcon(storyImage);
        storyTextBGLabel.setBounds(20, 20, 1290, 550);

        // Story Buttons
        storyNextPanel = new JPanel();
        storyNextPanel.setBounds(1130, 550, 150, 150);
        storyNextPanel.setOpaque(false);

        storyNextBtn = new JButton();
        storyNextBtn.setIcon(nextImage);
        storyNextBtn.setBorderPainted(false);
        storyNextBtn.setFocusPainted(false);
        storyNextBtn.setContentAreaFilled(false);
        storyNextBtn.addActionListener(nHandler);
        storyNextBtn.setActionCommand("cNext");
        storyNextPanel.add(storyNextBtn);

        // Story Layered Pane
        storyLayeredPane = new JLayeredPane();
        storyLayeredPane.setBounds(0, 0, 1280, 720);
        storyLayeredPane.add(storyPanel);
        storyLayeredPane.add(storyNextPanel);
        storyLayeredPane.add(storyTextBGLabel);
        storyLayeredPane.add(mainBGLabel);

        // Con Adds
        con.add(storyLayeredPane);
    }

    private void storyText() {
        switch (position) {
            case "story0":
                storyTextArea.setText(U + " : *Bangun dari tidur*\n"
                        + U + " : Siapa anda?\n"
                        + "D : Hai... sebelumnya perkenalkan aku Daniel\n"
                        + U + " : Hai juga, aku " + nama + ". Omong-omong dimana kita sekarang?\n"
                        + "D : Apakah kamu lupa bahwa kita terkena bencana tadi malam? Bencana tersebut membuat kita\n"
                        + "      terperangkap dalam labirin matematika ini.\n"
                        + "D : Tadi sempat aku cek di ujung lorong ini. Terdapat sebuah alat teleporter besar bertuliskan\n"
                        + "      \"Arcane Port\" , mungkin saja itu merupakan jalan keluar kita satu-satunya.\n"
                        + "      Disana tertulis keterangan bahwa kita harus mengumpulkan kedelapan Arcane Scroll yang\n"
                        + "      memliki kekuatan elemental untuk mengaktifkan teleporter tersebut.\n"
                        + "      Kuy, kita cari bersama-sama scroll tersebut\n");
                break;
            case "story1.0":
                storyTextArea.setText("*Jalan buntu dengan pintu terkunci*\n"
                        + "\n"
                        + U + " : *Brr* urghh disini anginnya tiba-tiba berhembus sangat kencang.\n"
                        + "D : Hey, kemarilah, disini ada sebuah panel yang berisikan teka-teki.\n"
                        + U + " : *Menghampiri Daniel*\n"
                        + "\n"
                        + "System : *Angin bertiup lebih kencang lagi, banyak serpihan-serpihan kaca yang ikut bertebangan*");
                break;
            case "story1.1":
                storyTextArea.setText("*Pintu terbuka*\n"
                        + "\n"
                        + "*Seseorang muncul dari balik pintu tersebut*\n"
                        + "\n"
                        + U + " : Angkat Tangan. Siapa kamu?\n"
                        + "B : *Sambil mengangkat tangan* Aku juga merupakan korban dari bencana ini.\n"
                        + "D : Oh.. Tenang dia Bryan, ilmuwan yang terkenal, mungkin saja dia dapat\n"
                        + "      membantu perjalanan kita. Tidak ada salahnya untuk mengajaknya.");
                break;
            case "story2.0":
                storyTextArea.setText("*Memasuki ruangan baru. Ada sebuah pintu di ujung jalan*\n"
                        + "\n"
                        + "D : Hey " + nama + ", kita sepertinya harus bergegas. Lihatlah \n"
                        + "      langit-langit batu di atas sepertinya mau runtuh.\n"
                        + "\n"
                        + "*Berlari menuju pintu yang terkunci dengan panel teka-teki*\n"
                        + "\n"
                        + "D : Wah... lagi-lagi pintu ini terkunci. Tolong bantu untuk menyelesaikan\n"
                        + "      teka-teki pada panel ini sebelum langit-langit batu di atas kita runtuh.");
                break;
            case "story3.0":
                storyTextArea.setText("*Pintu terbuka dan setelah itu langit-langit runtuh*\n"
                        + "\n"
                        + "*Seluruh pintu tiba-tiba terkunci rapat. Ada satu pintu dengan panel di\n"
                        + "ujung jalan*\n"
                        + "\n"
                        + "*Tiba-tiba keluar aliran air dari tiap sudut ruangan*\n"
                        + "\n"
                        + "D : Wah, kalau begini terus kita bakal tenggelam. Yuk cepat selesaikan \n"
                        + "      teka-teki di panel pintu tersebut.");
                break;
            case "story4.0":
                storyTextArea.setText("*Pintu terbuka dan air tiba-tiba surut*\n"
                        + "\n"
                        + U + " : *Memasuki ruangan baru dan tidak sengaja menginjak jebakan*\n"
                        + "\n"
                        + "*Keluar gas yang berwarna putih salju dari lantai*\n"
                        + "\n"
                        + "D : Aku merasakan ada hawa sejuk dari bawah lantai.\n"
                        + U + " : Iya mungkin setelah kita keluar dari ruangan air sebelumnya.\n"
                );
                break;
            case "story4.1":
                storyTextArea.setText("*Udara semakin dingin dan pergerakan semakin melambat*\n"
                        + "\n"
                        + "D : Bahaya! Aku baru saja menyadarinya, ternyata ini bukanlah gas biasa. \n"
                        + "      Ini merupakan gas pembeku yang dapat menghentikan seluruh aktivitas\n"
                        + "      tubuh kita. Sebaiknya kita bergegas menyelesaikan teka-teki di \n"
                        + "      panel pintu tersebut, sebelum kita beku.");
                break;
            case "story5.0":
                storyTextArea.setText("*Pintu terbuka*\n"
                        + "\n"
                        + "D : Setelah hampir beku akhirnya ada tempat yang hangat.\n"
                        + "\n"
                        + "*suhu mengalami anomali*\n"
                        + "\n"
                        + "D : Aku rasa suhu meningkat secara perlahan. Feeling ku buruk mengenai hal ini.\n"
                        + "      Yuk segera selesaikan panel agar kita tidak jadi manusia bakar hehe");
                break;
            case "story6.0":
                storyTextArea.setText("*Pintu terbuka dan suhu kembali normal*\n"
                        + "\n"
                        + "*Muncul sebuah sinar terang saat pintu terbuka*\n"
                        + "\n"
                        + "D : Huff... Sudah lima scroll telah terkumpul saat ini. Yuk kita lanjutkan mengerjakan\n"
                        + "      panel teka-teki ini.");
                break;
            case "story6.1":
                storyTextArea.setText("System : *Restore life to 10* Selamat anda telah sembuh dari segala jenis\n"
                        + "                     kesakitan yang telah dialami");
                life = 10;
                break;
            case "story7.0":
                storyTextArea.setText("*Pintu terbuka*\n"
                        + "\n"
                        + "*Ketika anda memasuki ruangan baru, tanaman rambat duri tiba-tiba menjalar kemana-mana*\n"
                        + "\n"
                        + "D : Waduh apa-apa an ini? Cepat! Kita harus segera menyelesaikan panel teka-teki ini\n"
                        + "      sebelum panelnya tertutup akar rambat duri ini.");
                break;
            case "story8.0":
                storyTextArea.setText("*Pintu terbuka*\n"
                        + "\n"
                        + "*Seketika saat memasuki ruangan berikutnya, semua perangkat listrik padam*\n"
                        + "\n"
                        + "D : Disini sangat gelap, sampai-sampai aku tak bisa melihatmu, " + nama + "\n"
                        + U + " : *Secara tidak sengaja mengaktifkan kemampuan luminous scroll*\n"
                        + "\n"
                        + "System : Kemampuan luminous scroll telah diaktifkan untuk sementara. \n"
                        + "                   Anda dapat melihat panel teka-teki hanya dalam beberapa menit.\n"
                        + "                   Segera selesaikan tantangan terakhir ini!");
                break;
            case "story9.0":
                storyTextArea.setText("*Setelah selesai, " + nama + " dkk bergegas menuju ke \"Arcane Port\".\n"
                        + "Setelah itu, " + nama + " mengaktifkan kedelapan Arcane Scroll dan teleporter pun aktif.\n"
                        + "\n"
                        + "System : Selamat anda telah menyelesaikan labirin matematika, sertifikat pemenang game\n"
                        + "                   akan segera dikirimkan ke email anda :D");
                break;
        }
    }

    private void scrollResult() {
        // Scroll Result
        scrollResultPanel = new JPanel();
        scrollResultPanel.setBounds(140, 50, 1000, 600);
        scrollResultPanel.setOpaque(false);
        scrollResultPanel.setLayout(new GridBagLayout());

        // Title Text 1
        scrollResultLabel = new JLabel();
        scrollResultLabel.setText("You Have Obtained");
        scrollResultLabel.setForeground(Color.white);
        scrollResultLabel.setFont(nasalizationb60);
        gbc.insets = new Insets(0, 0, 50, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        scrollResultPanel.add(scrollResultLabel, gbc);

        // Scroll Image
        scrollResult2Label = new JLabel();
        scrollResult2Label.setPreferredSize(new Dimension(300, 300));
        gbc.insets = new Insets(0, 0, 50, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        scrollResultPanel.add(scrollResult2Label, gbc);

        // Title Text 2
        scrollResult3Label = new JLabel();
        scrollResult3Label.setForeground(Color.white);
        scrollResult3Label.setFont(nasalizationb60);
        gbc.gridx = 0;
        gbc.gridy = 2;
        scrollResultPanel.add(scrollResult3Label, gbc);

        // Scroll Result Image
        scrollResultImage();

        // Scroll Buttons
        scrollNextPanel = new JPanel();
        scrollNextPanel.setBounds(1130, 550, 150, 150);
        scrollNextPanel.setOpaque(false);

        scrollNextBtn = new JButton();
        scrollNextBtn.setIcon(nextImage);
        scrollNextBtn.setBorderPainted(false);
        scrollNextBtn.setFocusPainted(false);
        scrollNextBtn.setContentAreaFilled(false);
        scrollNextBtn.addActionListener(nHandler);
        scrollNextBtn.setActionCommand("cNext");
        scrollNextPanel.add(scrollNextBtn);

        // Scroll Result Layered Pane
        srLayeredPane = new JLayeredPane();
        srLayeredPane.setBounds(0, 0, 1280, 720);
        srLayeredPane.add(scrollResultPanel);
        srLayeredPane.add(scrollNextPanel);
        srLayeredPane.add(mainBGLabel);

        con.add(srLayeredPane);
    }

    private void scrollResultImage() {
        switch (position) {
            case "scrollResultAerial":
                scrollResult2Label.setIcon(aerial2Image);
                scrollResult3Label.setText("An Aerial Scroll");
                break;
            case "scrollResultCrystaline":
                scrollResult2Label.setIcon(crystaline2Image);
                scrollResult3Label.setText("A Crystaline Scroll");
                break;
            case "scrollResultAqueous":
                scrollResult2Label.setIcon(aqueous2Image);
                scrollResult3Label.setText("An Aqueous Scroll");
                break;
            case "scrollResultCryo":
                scrollResult2Label.setIcon(cryo2Image);
                scrollResult3Label.setText("A Cryo Scroll");
                break;
            case "scrollResultPyro":
                scrollResult2Label.setIcon(pyro2Image);
                scrollResult3Label.setText("A Pyro Scroll");
                break;
            case "scrollResultLuminous":
                scrollResult2Label.setIcon(luminous2Image);
                scrollResult3Label.setText("A Luminous Scroll");
                break;
            case "scrollResultDendro":
                scrollResult2Label.setIcon(dendro2Image);
                scrollResult3Label.setText("A Dendro Scroll");
                break;
            case "scrollResultUmbra":
                scrollResult2Label.setIcon(umbra2Image);
                scrollResult3Label.setText("An Umbra Scroll");
                break;
        }
    }

    private void scroll() {
        // Scrolls
        scrollPanel = new JPanel();
        scrollPanel.setBounds(10, 100, 250, 720);
        scrollPanel.setOpaque(false);
        scrollPanel.setLayout(null);

        aerialLabel = new JLabel();
        aerialLabel.setIcon(aerialImage);
        aerialLabel.setBounds(10, 25, 100, 100);
        aerialLabel.setVisible(false);
        scrollPanel.add(aerialLabel);

        crystalineLabel = new JLabel();
        crystalineLabel.setIcon(crystalineImage);
        crystalineLabel.setBounds(85, 70, 100, 100);
        crystalineLabel.setVisible(false);
        scrollPanel.add(crystalineLabel);

        aqueousLabel = new JLabel();
        aqueousLabel.setIcon(aqueousImage);
        aqueousLabel.setBounds(10, 115, 100, 100);
        aqueousLabel.setVisible(false);
        scrollPanel.add(aqueousLabel);

        cryoLabel = new JLabel();
        cryoLabel.setIcon(cryoImage);
        cryoLabel.setBounds(85, 160, 100, 100);
        cryoLabel.setVisible(false);
        scrollPanel.add(cryoLabel);

        pyroLabel = new JLabel();
        pyroLabel.setIcon(pyroImage);
        pyroLabel.setBounds(10, 205, 100, 100);
        pyroLabel.setVisible(false);
        scrollPanel.add(pyroLabel);

        luminousLabel = new JLabel();
        luminousLabel.setIcon(luminousImage);
        luminousLabel.setBounds(85, 250, 100, 100);
        luminousLabel.setVisible(false);
        scrollPanel.add(luminousLabel);

        dendroLabel = new JLabel();
        dendroLabel.setIcon(dendroImage);
        dendroLabel.setBounds(10, 295, 100, 100);
        dendroLabel.setVisible(false);
        scrollPanel.add(dendroLabel);

        umbraLabel = new JLabel();
        umbraLabel.setIcon(umbraImage);
        umbraLabel.setBounds(85, 340, 100, 100);
        umbraLabel.setVisible(false);
        scrollPanel.add(umbraLabel);

        // Scroll Layered Pane
        scrollLayeredPane = new JLayeredPane();
        scrollLayeredPane.setBounds(0, 0, 1280, 720);
        scrollLayeredPane.add(scrollPanel);

        // Con Adds
        con.add(scrollLayeredPane);
    }

    private void soal() {
        // Soal Text
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(265, 100, 800, 200);
        mainTextPanel.setOpaque(false);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(265, 100, 800, 200);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setOpaque(false);
        mainTextArea.setFont(nasalizationp16);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        // Soal Image
        mainTextBGLabel = new JLabel();
        mainTextBGLabel.setIcon(questionImage);
        mainTextBGLabel.setBounds(195, 25, 950, 350);

        // Choice Buttons
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(450, 375, 350, 300);
        choiceButtonPanel.setOpaque(false);
        choiceButtonPanel.setLayout(new GridBagLayout());

        choice1 = new JButton();
        choice1.setIcon(choiceImage);
        choice1.setBorderPainted(false);
        choice1.setFocusPainted(false);
        choice1.setContentAreaFilled(false);
        choice1.setForeground(Color.white);
        choice1.setFont(nasalizationb20);
        choice1.setHorizontalTextPosition(JButton.CENTER);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("choice1");
        gbc.insets = new Insets(0, 0, -5, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        choiceButtonPanel.add(choice1, gbc);

        choice2 = new JButton();
        choice2.setIcon(choice2Image);
        choice2.setBorderPainted(false);
        choice2.setFocusPainted(false);
        choice2.setContentAreaFilled(false);
        choice2.setForeground(Color.white);
        choice2.setFont(nasalizationb20);
        choice2.setHorizontalTextPosition(JButton.CENTER);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("choice2");
        gbc.insets = new Insets(0, 0, -5, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        choiceButtonPanel.add(choice2, gbc);

        choice3 = new JButton();
        choice3.setIcon(choiceImage);
        choice3.setBorderPainted(false);
        choice3.setFocusPainted(false);
        choice3.setContentAreaFilled(false);
        choice3.setForeground(Color.white);
        choice3.setFont(nasalizationb20);
        choice3.setHorizontalTextPosition(JButton.CENTER);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("choice3");
        gbc.insets = new Insets(0, 0, -5, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        choiceButtonPanel.add(choice3, gbc);

        choice4 = new JButton();
        choice4.setIcon(choice2Image);
        choice4.setBorderPainted(false);
        choice4.setFocusPainted(false);
        choice4.setContentAreaFilled(false);
        choice4.setForeground(Color.white);
        choice4.setFont(nasalizationb20);
        choice4.setHorizontalTextPosition(JButton.CENTER);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("choice4");
        gbc.insets = new Insets(0, 0, -5, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        choiceButtonPanel.add(choice4, gbc);

        choice5 = new JButton();
        choice5.setIcon(choiceImage);
        choice5.setBorderPainted(false);
        choice5.setFocusPainted(false);
        choice5.setContentAreaFilled(false);
        choice5.setForeground(Color.white);
        choice5.setFont(nasalizationb20);
        choice5.setHorizontalTextPosition(JButton.CENTER);
        choice5.addActionListener(choiceHandler);
        choice5.setActionCommand("choice5");
        gbc.gridx = 0;
        gbc.gridy = 4;
        choiceButtonPanel.add(choice5, gbc);

        // Status Player
        statusPanel = new JPanel();
        statusPanel.setBounds(1122, 90, 100, 200);
        statusPanel.setOpaque(false);

        statusLabel = new JLabel();
        statusLabel.setText("Life : " + life);
        statusLabel.setFont(nasalizationb20);
        statusLabel.setForeground(Color.white);
        statusPanel.add(statusLabel);

        // Status Image
        statusTextBGLabel = new JLabel();
        statusTextBGLabel.setIcon(statusImage);
        statusTextBGLabel.setBounds(1095, 80, 150, 55);

        // Timer
        cd = 60;

        timePanel = new JPanel();
        timePanel.setBounds(1147, 218, 50, 50);
        timePanel.setOpaque(false);

        timeLabel = new JLabel(String.valueOf(cd));
        timeLabel.setFont(nasalizationb30);
        timeLabel.setForeground(Color.white);
        timePanel.add(timeLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLabel.setText(String.valueOf(cd));
                cd--;

                if (cd < 0) {
                    lifeCheck();
                }
            }
        });

        timer.setInitialDelay(0);

        // Timer Image
        timerTextBGLabel = new JLabel();
        timerTextBGLabel.setIcon(timerImage);
        timerTextBGLabel.setBounds(1095, 140, 200, 200);

        // Soal Layered Pane
        sLayeredPane = new JLayeredPane();
        sLayeredPane.setBounds(0, 0, 1280, 720);
        sLayeredPane.add(mainTextPanel);
        sLayeredPane.add(choiceButtonPanel);
        sLayeredPane.add(statusPanel);
        sLayeredPane.add(timePanel);
        sLayeredPane.add(mainTextBGLabel);
        sLayeredPane.add(statusTextBGLabel);
        sLayeredPane.add(timerTextBGLabel);
        sLayeredPane.add(mainBGLabel);

        con.add(sLayeredPane);
    }

    private void SPLDV() {
        int kotakPensil, buku, hargaTotal1, hargaTotal2, hargaTotal3;
        int orangPensil1, orangBuku1, orangPensil2, orangBuku2, orangPensil3, orangBuku3;

        kotakPensil = 1000 * RNG(1, 20);
        buku = 1000 * RNG(1, 20);

        orangBuku1 = RNG(1, 10);
        orangPensil1 = RNG(1, 10);
        hargaTotal1 = orangBuku1 * buku + orangPensil1 * kotakPensil;

        orangBuku2 = RNG(1, 10);
        while (orangBuku2 == orangBuku1) {
            orangBuku2 = RNG(1, 10);
        }

        orangPensil2 = RNG(1, 10);
        while (orangPensil2 == orangPensil1) {
            orangPensil2 = RNG(1, 10);
        }

        hargaTotal2 = orangBuku2 * buku + orangPensil2 * kotakPensil;

        orangBuku3 = RNG(1, 10);
        orangPensil3 = RNG(1, 10);
        hargaTotal3 = orangBuku3 * buku + orangPensil3 * kotakPensil;

        soal = "Daniel dan Bryan membeli buku dan kotak pensil sejenis di toko yang sama.\n"
                + "Daniel membeli " + orangBuku1 + " buku dan " + orangPensil1
                + " kotak pensil dengan harga " + String.format("Rp %,d", hargaTotal1) + ".\n"
                + "Bryan membeli " + orangBuku2 + " buku dan " + orangPensil2
                + " kotak pensil dengan harga " + String.format("Rp %,d", hargaTotal2) + ".\n\n"
                + "Harga yang harus dibayar " + nama + " jika ia membeli " + orangBuku3
                + " buku dan " + orangPensil3 + " kotak pensil\nadalah….";

        answer = String.format("Rp %,d", hargaTotal3);

        UrutanJawaban[0] = String.format("Rp %,d", hargaTotal3);
        UrutanJawaban[1] = String.format("Rp %,d", hargaTotal3 + (RNG(4, 10)) * 1000);
        UrutanJawaban[2] = String.format("Rp %,d", Math.abs(hargaTotal3 - (RNG(6, 8)) * 1000));
        UrutanJawaban[3] = String.format("Rp %,d", hargaTotal1 + hargaTotal2);
        UrutanJawaban[4] = String.format("Rp %,d", Math.abs(hargaTotal3 - hargaTotal1) + (RNG(5, 10) * 1000));

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void akar() {

        int random;
        int angkaDepan, angkaDepan2, angkaAkar;
        double hasil;
        String[] operasi = {"+", "-", "x", ":"};

        angkaDepan = ((int) (Math.random() * 50) + 1) * 2;
        angkaDepan2 = RNG(10, 100);
        angkaAkar = (int) Math.pow(RNG(2, 10), 2);

        hasil = angkaDepan * (int) Math.sqrt(angkaAkar);

        random = RNG(0, 4);

        soal = "Selesaikan operasi berikut!\n";

        if (random == 0) {
            hasil += angkaDepan2;
            soal += angkaDepan + "√" + angkaAkar + " + " + angkaDepan2 + " =";
        } else if (random == 1) {
            hasil += Math.abs(hasil - angkaDepan2);
            soal += angkaDepan + "√" + angkaAkar + " - " + angkaDepan2 + " =";
        } else if (random == 2) {
            hasil *= angkaDepan2;
            soal += angkaDepan + "√" + angkaAkar + " * " + angkaDepan2 + " =";
        } else {
            while ((hasil / angkaDepan2) % 1 != 0) {
                angkaDepan2 = (int) (Math.random() * angkaDepan) + 1;
            }
            hasil /= angkaDepan2;
            soal += angkaDepan + "√" + angkaAkar + " : " + angkaDepan2 + " =";
        }

        answer = String.valueOf((int) hasil);

        UrutanJawaban[0] = String.valueOf((int) hasil);
        UrutanJawaban[1] = String.valueOf((int) hasil + (RNG(1, 5)));
        UrutanJawaban[2] = String.valueOf((int) hasil + (RNG(6, 10)));
        UrutanJawaban[3] = String.valueOf((int) hasil + angkaDepan);
        UrutanJawaban[4] = String.valueOf((int) angkaAkar + angkaDepan + angkaDepan2);

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void aritmatikaSosial() {

        int persen, uangAwal, hasilAkhir, choice;
        double hasilPersen;
        String ur;

        persen = RNG(1, 19) * 5;
        uangAwal = RNG(1, 999) * 1000;

        hasilPersen = ((double) persen / 100) * (uangAwal);

        while (hasilPersen % 1 != 0) {
            uangAwal = RNG(1, 999) * 1000;
            hasilPersen = ((double) persen / 100) * (uangAwal);
        }

        choice = RNG(0, 2);

        if (choice == 0) {
            ur = " kerugian ";
            hasilAkhir = uangAwal - (int) hasilPersen;
        } else {
            ur = " keuntungan ";
            hasilAkhir = uangAwal + (int) hasilPersen;
        }

        soal = nama + " menjual aksesoris seharga " + String.format("Rp %,d", uangAwal)
                + " dan mengalami" + ur + "\nsebesar " + persen + "% dari harga pembelian."
                + "\n\nMaka harga beli aksesoris tersebut adalah … ";

        answer = String.format("Rp %,d", hasilAkhir);

        UrutanJawaban[0] = String.format("Rp %,d", hasilAkhir);
        UrutanJawaban[1] = String.format("Rp %,d", hasilAkhir + (RNG(11, 15) * 1000));
        UrutanJawaban[2] = String.format("Rp %,d", hasilAkhir + (RNG(1, 10) * 1000));
        UrutanJawaban[3] = String.format("Rp %,d", Math.abs(hasilAkhir - (RNG(5, 10) * 1000)));
        UrutanJawaban[4] = String.format("Rp %,d", Math.abs(hasilAkhir - (RNG(11, 20) * 1000)));

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void barisDeretAritmatikaType1() {

        //ditanya salah satu (a/n/b/un)
        // baris = un
        // deret = penjumlahan baris
        int a, n, b, un, random;
        random = RNG(0, 3);
        a = RNG(5, 100);
        n = RNG(1, 10);
        b = RNG(5, 75);
        un = a + (n - 1) * b;

        // yang ditanya
        // 0 = a
        // 1 = n
        // 2 = b
        // 3 = un
        switch (random) {
            case 0:
                soal = "Jika suku ke-" + n + " sebuah baris aritmatika adalah " + un
                        + ", dengan beda setiap sukunya\nadalah " + b
                        + ", berapakah suku pertamanya?";

                answer = String.valueOf(a);

                UrutanJawaban[0] = String.valueOf(a);
                UrutanJawaban[1] = String.valueOf(a + RNG(1, 3));
                UrutanJawaban[2] = String.valueOf(a + RNG(4, 5));
                UrutanJawaban[3] = String.valueOf(Math.abs(a - RNG(1, 3)));
                UrutanJawaban[4] = String.valueOf(Math.abs(a - RNG(4, 5)));
                break;
            case 1:
                soal = "Sebuah baris aritmatika memiliki beda setiap sukunya yaitu " + b
                        + " dengan suku\npertamanya adalah " + a
                        + ". Jika suatu suku pada baris tersebut bernilai " + un
                        + ", suku ke\nberapakah nilai tersebut?";

                answer = String.valueOf(n);

                UrutanJawaban[0] = String.valueOf(n);
                UrutanJawaban[1] = String.valueOf(n + RNG(1, 2));
                UrutanJawaban[2] = String.valueOf(n + RNG(3, 4));
                UrutanJawaban[3] = String.valueOf(n + RNG(5, 6));
                UrutanJawaban[4] = String.valueOf(n + RNG(7, 8));
                break;
            case 2:
                soal = "Jika suku ke-" + n + " sebuah baris aritmatika adalah " + un
                        + " dan suku pertamanya\nadalah " + a
                        + ", berapakah beda dari setiap sukunya?";

                answer = String.valueOf(b);

                UrutanJawaban[0] = String.valueOf(b);
                UrutanJawaban[1] = String.valueOf(b + RNG(1, 3));
                UrutanJawaban[2] = String.valueOf(b + RNG(4, 5));
                UrutanJawaban[3] = String.valueOf(Math.abs(b - RNG(1, 3)));
                UrutanJawaban[4] = String.valueOf(Math.abs(b - RNG(4, 5)));
                break;
            case 3:
                soal = "Berapakah nilai dari suku ke-" + n
                        + " apabila suku pertamanya adalah " + a
                        + " dan beda\nsetiap sukunya adalah " + b + "?";

                answer = String.valueOf(un);

                UrutanJawaban[0] = String.valueOf(un);
                UrutanJawaban[1] = String.valueOf(un + (RNG(1, 3) * b));
                UrutanJawaban[2] = String.valueOf(un + (RNG(4, 6) * b));
                UrutanJawaban[3] = String.valueOf(Math.abs(un - (RNG(1, 3) * b)));
                UrutanJawaban[4] = String.valueOf(Math.abs(un - (RNG(4, 6) * b)));
                break;
        }

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void barisDeretAritmatikaType2() {
        //ditanya (a dan b)
        int un1, un2, n1, n2, a, b;

        a = RNG(1, 50);
        n1 = RNG(1, 10);
        n2 = RNG(1, 10);
        b = RNG(1, 50);
        un1 = a + (n1 - 1) * b;
        un2 = a + (n2 - 1) * b;

        while (n1 == n2) {
            n2 = n2 = RNG(1, 10);
            un2 = a + (n2 - 1) * b;
        }

        soal = "Sebuah baris aritmatika memiliki nilai suku ke-" + n1
                + " yaitu " + un1 + " dan nilai suku ke-" + n2
                + "\nyaitu " + un2 + ". Berapakah nilai suku pertamanya dan bedanya secara berurutan?";

        answer = String.valueOf(a) + " dan " + String.valueOf(b);

        UrutanJawaban[0] = String.valueOf(a) + " dan " + String.valueOf(b);
        UrutanJawaban[1] = String.valueOf(a + RNG(1, 5)) + " dan " + String.valueOf(b);
        UrutanJawaban[2] = String.valueOf(a) + " dan " + String.valueOf(b + RNG(1, 5));
        UrutanJawaban[3] = String.valueOf(a + RNG(1, 3)) + " dan " + String.valueOf(b + RNG(1, 3));
        UrutanJawaban[4] = String.valueOf(a + RNG(4, 5)) + " dan " + String.valueOf(b + RNG(4, 5));

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void barisDeretAritmatikaType3() {
        //ditanya (sn)
        int a, b, n, un, sn;

        a = RNG(5, 50);
        n = RNG(5, 10);
        b = RNG(5, 50);
        un = a + (n - 1) * b;

        sn = (n / 2) * (a + un);

        soal = "Sebuah deret aritmatika memiliki suku pertamanya yaitu " + a
                + " dengan beda\nsukunya " + b + ". Berapakah jumlah dari " + n
                + " suku pertama dari deret tersebut?";

        answer = String.valueOf(sn);

        UrutanJawaban[0] = String.valueOf(sn);
        UrutanJawaban[1] = String.valueOf(sn + (a + (RNG(1, 3) * b)));
        UrutanJawaban[2] = String.valueOf(sn + (a + (RNG(4, 5) * b)));
        UrutanJawaban[3] = String.valueOf(Math.abs(sn - a));
        UrutanJawaban[4] = String.valueOf(Math.abs(sn - un));

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void barisDeretAritmatikaType4() {
        //ditanya (un yang kosong)
        int a, b, n, random, jawaban;

        a = RNG(1, 50);
        b = RNG(5, 50);
        n = RNG(5, 10);
        random = RNG(0, n);

        jawaban = a + b * random;

        soal = "Tentukan nilai suku yang hilang dari baris aritmatika berikut:\n";

        if (random == 0) {
            soal += "...";
        } else {
            soal += a;
        }

        for (int i = 1; i < n; i++) {
            if (random != i) {
                soal += ", " + (a + b * i);
            } else {
                soal += ", ...";
            }
        }

        answer = String.valueOf(jawaban);

        UrutanJawaban[0] = String.valueOf(jawaban);
        UrutanJawaban[1] = String.valueOf(jawaban + (RNG(1, b - 1)));
        UrutanJawaban[2] = String.valueOf(Math.abs(jawaban - (RNG(1, b - 1))));
        UrutanJawaban[3] = String.valueOf(jawaban + b - (RNG(1, b - 1)));
        UrutanJawaban[4] = String.valueOf(Math.abs(jawaban - b + (RNG(1, b - 1))));

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void barisDeretGeometriType1() {
        //ditanya salah satu (a/n/r/un)

        /*
        un = a*r^(n-1)
        a = randomSoalDeret[0]
        n = randomSoalDeret[1]
        r = randomSoalDeret[2]
        un = randomSoalDeret[3]
         */
        int a, n, r, un, random;
        random = RNG(0, 3);
        a = RNG(1, 10);
        n = RNG(1, 5);
        r = RNG(2, 5);
        un = a * (int) Math.pow(r, n - 1);

        // yang ditanya
        // 0 = a
        // 1 = n
        // 2 = r
        // 3 = un
        switch (random) {
            case 0:
                soal = "Jika suku ke-" + n + " sebuah baris geometri adalah " + un
                        + ", dengan rasio sukunya\nadalah " + r
                        + ",berapakah suku pertamanya?";

                answer = String.valueOf(a);

                UrutanJawaban[0] = String.valueOf(a);
                UrutanJawaban[1] = String.valueOf(a + 1);
                UrutanJawaban[2] = String.valueOf(a + RNG(2, 3));
                UrutanJawaban[3] = String.valueOf(a + RNG(4, 5));
                UrutanJawaban[4] = String.valueOf(Math.abs(a - 1));
                break;
            case 1:
                soal = "Sebuah baris geometri memiliki rasio yaitu " + r
                        + " dengan suku pertamanya\nadalah " + a
                        + ". Jika suatu suku pada baris tersebut bernilai " + un
                        + ", suku ke berapakah\nnilai tersebut?";

                answer = String.valueOf(n);

                UrutanJawaban[0] = String.valueOf(n);
                UrutanJawaban[1] = String.valueOf(n + RNG(1, 2));
                UrutanJawaban[2] = String.valueOf(n + RNG(3, 4));
                UrutanJawaban[3] = String.valueOf(n + RNG(5, 6));
                UrutanJawaban[4] = String.valueOf(n + RNG(7, 8));
                break;
            case 2:
                soal = "Jika suku ke-" + n + " sebuah baris geometri adalah " + un
                        + " dan suku pertamanya adalah " + a
                        + ",\nberapakah rasio dari sukunya?";

                answer = String.valueOf(r);

                UrutanJawaban[0] = String.valueOf(r);
                UrutanJawaban[1] = String.valueOf(r + 1);
                UrutanJawaban[2] = String.valueOf(r + RNG(2, 3));
                UrutanJawaban[3] = String.valueOf(r + RNG(4, 5));
                UrutanJawaban[4] = String.valueOf(Math.abs(r - 1));
                break;
            case 3:
                soal = "Berapakah nilai dari suku ke-" + n
                        + " apabila suku pertamanya adalah " + a
                        + " dan rasio\nsukunya adalah " + r + "?";

                answer = String.valueOf(un);

                UrutanJawaban[0] = String.valueOf(un);
                UrutanJawaban[1] = String.valueOf(un + (RNG(1, 2) * r));
                UrutanJawaban[2] = String.valueOf(un + (RNG(3, 4) * r));
                UrutanJawaban[3] = String.valueOf(Math.abs(un - (RNG(1, 2) * r)));
                UrutanJawaban[4] = String.valueOf(Math.abs(un - (RNG(3, 4) * r)));
                break;
        }

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void barisDeretGeometriType2() {
        //ditanya (sn, r > 1)
        int a, n, r, sn;

        a = RNG(1, 10);
        n = RNG(2, 5);
        r = RNG(2, 5);
        sn = (a * (int) (Math.pow(r, n) - 1)) / (r - 1);

        soal = "Sebuah deret geometri memiliki suku pertamanya yaitu " + a
                + " dengan rasio\nsukunya " + r + ". Berapakah jumlah dari " + n
                + " suku pertama dari deret tersebut?";

        answer = String.valueOf(sn);

        UrutanJawaban[0] = String.valueOf(sn);
        UrutanJawaban[1] = String.valueOf(sn + a);
        UrutanJawaban[2] = String.valueOf(sn + (a * r));
        UrutanJawaban[3] = String.valueOf(Math.abs(sn - a));
        UrutanJawaban[4] = String.valueOf(Math.abs(sn - (a * r)));

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void barisDeretGeometriType3() {
        //ditanya (sn, 0 < r < 1)
        int random;
        double a, n, sn, jawaban;
        double[] r = {1.0 / 2, 1.0 / 4, 1.0 / 5, 1.0 / 8, 1.0 / 10};

        random = RNG(0, 4);
        a = RNG(2, 10);
        n = RNG(2, 5);
        sn = (a * (1 - Math.pow(r[random], n))) / (1 - r[random]);

        jawaban = (int) (sn * 100) / 100;

        soal = "Sebuah deret geometri memiliki suku pertamanya yaitu " + decimal(a)
                + " dengan rasio\nsukunya " + decimal(r[random]) + ". Berapakah jumlah dari " + decimal(n)
                + " suku pertama dari deret tersebut?";

        answer = String.valueOf(decimal(jawaban));

        UrutanJawaban[0] = String.valueOf(decimal(jawaban));
        UrutanJawaban[1] = String.valueOf(decimal(jawaban + a));
        UrutanJawaban[2] = String.valueOf(decimal(jawaban + (a * r[random])));
        UrutanJawaban[3] = String.valueOf(decimal(Math.abs(jawaban - a)));
        UrutanJawaban[4] = String.valueOf(decimal(Math.abs(jawaban - (a * r[random]))));

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void pemusatanData() {
        int siswaAsli, siswaTambah, siswaTotal, nilaiAsli, nilaiTambah, rata;

        siswaAsli = RNG(12, 20) * 2;
        siswaTambah = RNG(2, 5);
        siswaTotal = siswaAsli + siswaTambah;

        nilaiAsli = RNG(60, 90);
        rata = nilaiAsli - RNG(1, 5);
        nilaiTambah = ((siswaTotal * rata) - (siswaAsli * nilaiAsli)) / siswaTambah;

        while (nilaiTambah < 0) {
            nilaiAsli = RNG(60, 90);
            rata = nilaiAsli - RNG(1, 5);
            nilaiTambah = ((siswaTotal * rata) - (siswaAsli * nilaiAsli)) / siswaTambah
        }
        soal = "Nilai ulangan matematika " + siswaAsli + " siswa adalah " + nilaiAsli
                + ". Setelah " + siswaTambah
                + " orang siswa ikut\nulangan susulan, nilai rata-ratanya menjadi " + rata
                + ".\n\nNilai rata-rata " + siswaTambah
                + " siswa yang ikut ulangan susulan adalah …";

        answer = String.valueOf(nilaiTambah);

        UrutanJawaban[0] = String.valueOf((int) nilaiTambah);
        UrutanJawaban[1] = String.valueOf((int) nilaiTambah + (RNG(1, 5)));
        UrutanJawaban[2] = String.valueOf((int) nilaiTambah + (RNG(6, 10)));
        UrutanJawaban[3] = String.valueOf((int) nilaiTambah - (RNG(1, 2)));
        UrutanJawaban[4] = String.valueOf((int) nilaiTambah - (RNG(3, 4)));

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void tabelDiagramLingkaran() {
        int random = RNG(1, 4);
        int a, b, c, d, orang;

        a = RNG(20, 40);
        b = RNG(20, 49 - a);
        c = RNG(20, 49 - b);
        d = 100 - a - b - c;

        orang = RNG(50, 100);

        switch (random) {
            case 1:
                soal = String.format("Di sebuah perumahan terdapat %d%% orang yang mengikuti tim basket,\n"
                        + "%d%% orang yang mengikuti tim futsal,\n dan %d%% orang yang mengikuti tim voli.\n"
                        + "Jika jumlah penghuni di perumahan tersebut sebanyak %d orang,\n"
                        + "maka berapa persentase orang yang mengikuti tim bulutangkis?", b, c, d, orang);

                answer = String.valueOf(a);

                UrutanJawaban[0] = String.valueOf(a);
                UrutanJawaban[1] = String.valueOf(a + RNG(1, 3));
                UrutanJawaban[2] = String.valueOf(a + RNG(4, 5));
                UrutanJawaban[3] = String.valueOf(Math.abs(a - RNG(1, 3)));
                UrutanJawaban[4] = String.valueOf(Math.abs(a - RNG(4, 5)));

                break;
            case 2:
                soal = String.format("Pada saat liburan, terdapat %d%% orang yang bermain game PUBG,\n"
                        + "%d%% game Genshin Impact, dan %d%% game Mobile Legends. Jika jumlah pemain game \n"
                        + "sebanyak %d orang, maka berapa persentase orang yang bermain game Arcane Scroll?", a, c, d, orang);

                answer = String.valueOf(b);

                UrutanJawaban[0] = String.valueOf(b);
                UrutanJawaban[1] = String.valueOf(b + RNG(1, 3));
                UrutanJawaban[2] = String.valueOf(b + RNG(4, 5));
                UrutanJawaban[3] = String.valueOf(Math.abs(b - RNG(1, 3)));
                UrutanJawaban[4] = String.valueOf(Math.abs(b - RNG(4, 5)));

                break;
            case 3:
                soal = String.format("Sebanyak %d%% orang suka memakai baju berwarna kuning,\n"
                        + "%d%% baju berwarna hijau, dan %d%% baju berwarna biru.\n"
                        + "Jika jumlah orang yang mengikuti survey tersebut sebanyak %d orang,\n"
                        + "maka berapa persentase orang yang suka memakai baju berwarna pelangi?", a, b, d, orang);

                answer = String.valueOf(c);

                UrutanJawaban[0] = String.valueOf(c);
                UrutanJawaban[1] = String.valueOf(c + RNG(1, 3));
                UrutanJawaban[2] = String.valueOf(c + RNG(4, 5));
                UrutanJawaban[3] = String.valueOf(Math.abs(c - RNG(1, 3)));
                UrutanJawaban[4] = String.valueOf(Math.abs(c - RNG(4, 5)));

                break;
            case 4:
                soal = String.format("Di sebuah sekolah terdapat %d%% orang yang suka pelajaran IPA,\n"
                        + "%d%% IPS, dan %d%% bahasa Indonesia. Jika jumlah siswa di sekolah tersebut sebanyak %d orang,\n"
                        + "maka berapa persentase orang yang suka pelajaran matematika?", a, b, c, orang);

                answer = String.valueOf(d);

                UrutanJawaban[0] = String.valueOf(d);
                UrutanJawaban[1] = String.valueOf(d + RNG(1, 3));
                UrutanJawaban[2] = String.valueOf(d + RNG(4, 5));
                UrutanJawaban[3] = String.valueOf(Math.abs(d - RNG(1, 3)));
                UrutanJawaban[4] = String.valueOf(Math.abs(d - RNG(4, 5)));

                break;
        }

        RandomChoice(UrutanJawaban);

        System.out.println(answer);
        mainTextArea.setText(soal);
    }

    private void RandomChoice(String[] array) {
        int random;
        String temp;

        for (int i = 0; i < array.length; i++) {
            random = RNG(0, array.length - 1);
            temp = array[random];
            array[random] = array[i];
            array[i] = temp;
        }

        choice1.setText(String.valueOf(array[0]));
        choice2.setText(String.valueOf(array[1]));
        choice3.setText(String.valueOf(array[2]));
        choice4.setText(String.valueOf(array[3]));
        choice5.setText(String.valueOf(array[4]));
    }

    private int RNG(int min, int max) {
        int rng = (int) (Math.random() * (max - min + 1)) + min;
        return rng;
    }

    private String decimal(double hasil) {
        if (hasil % 1 != 0) {
            return String.valueOf(hasil);
        } else {
            return String.valueOf((int) hasil);
        }
    }

    private void lifeCheck() {
        life--;
        timer.stop();
        sLayeredPane.setVisible(false);
        scrollLayeredPane.setVisible(false);

        if (life < 1) {
            winLose();
        } else {
            tryAgain();
            if (cd < 0) {
                tryAgainTitleLabel.setText("Times Up!");
            } else {
                tryAgainTitleLabel.setText("Wrong Answer");
            }
        }
    }

    private void tryAgain() {
//        position = "tryAgain";

        // Try Again Title
        tryAgainTitlePanel = new JPanel();
        tryAgainTitlePanel.setBounds(340, 200, 600, 50);
        tryAgainTitlePanel.setOpaque(false);

        tryAgainTitleLabel = new JLabel();
        tryAgainTitleLabel.setFont(nasalizationb30);
        tryAgainTitleLabel.setForeground(Color.white);
        tryAgainTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        tryAgainTitlePanel.add(tryAgainTitleLabel);

        // Try Again Text
        tryAgainTextPanel = new JPanel();
        tryAgainTextPanel.setBounds(340, 250, 600, 50);
        tryAgainTextPanel.setOpaque(false);

        tryAgainTextLabel = new JLabel("Try Again?");
        tryAgainTextLabel.setForeground(Color.white);
        tryAgainTextLabel.setFont(nasalizationb20);
        tryAgainTextLabel.setHorizontalAlignment(JLabel.CENTER);
        tryAgainTextPanel.add(tryAgainTextLabel);

        // Try Again Buttons
        tryAgainBtnPanel = new JPanel();
        tryAgainBtnPanel.setBounds(490, 300, 300, 150);
        tryAgainBtnPanel.setOpaque(false);
        tryAgainBtnPanel.setLayout(new GridBagLayout());

        tryAgainYesBtn = new JButton();
        tryAgainYesBtn.setIcon(yesImage);
        tryAgainYesBtn.setBorderPainted(false);
        tryAgainYesBtn.setFocusPainted(false);
        tryAgainYesBtn.setContentAreaFilled(false);
        tryAgainYesBtn.addActionListener(tryAgainHandler);
        tryAgainYesBtn.setActionCommand("yes");
        gbc.insets = new Insets(0, 0, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        tryAgainBtnPanel.add(tryAgainYesBtn);

        tryAgainNoBtn = new JButton();
        tryAgainNoBtn.setIcon(noImage);
        tryAgainNoBtn.setBorderPainted(false);
        tryAgainNoBtn.setFocusPainted(false);
        tryAgainNoBtn.setContentAreaFilled(false);
        tryAgainNoBtn.addActionListener(tryAgainHandler);
        tryAgainNoBtn.setActionCommand("no");
        gbc.gridx = 0;
        gbc.gridy = 1;
        tryAgainBtnPanel.add(tryAgainNoBtn);

        // Try Again Image
        taTextBGLabel = new JLabel();
        taTextBGLabel.setIcon(tryAgainImage);
        taTextBGLabel.setBounds(140, 25, 1050, 650);

        // Try Again Layered Pane
        tLayeredPane = new JLayeredPane();
        tLayeredPane.setBounds(0, 0, 1280, 720);
        tLayeredPane.add(tryAgainTitlePanel);
        tLayeredPane.add(tryAgainTextPanel);
        tLayeredPane.add(tryAgainBtnPanel);
        tLayeredPane.add(taTextBGLabel);
        tLayeredPane.add(mainBGLabel);

        // Con Adds
        con.add(tLayeredPane);
    }

    private void winLose() {
//        position = "winLose";

        // Win Lose Title
        winLoseTitlePanel = new JPanel();
        winLoseTitlePanel.setBounds(340, 200, 600, 50);
        winLoseTitlePanel.setOpaque(false);

        winLoseTitleLabel = new JLabel();
        winLoseTitleLabel.setFont(nasalizationb30);
        winLoseTitleLabel.setForeground(Color.white);
        winLoseTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        winLoseTitlePanel.add(winLoseTitleLabel);

        // Win Lose Buttons
        winLoseBtnPanel = new JPanel();
        winLoseBtnPanel.setBounds(570, 310, 150, 150);
        winLoseBtnPanel.setOpaque(false);

        winLoseBtn = new JButton();
        winLoseBtn.setIcon(homeImage);
        winLoseBtn.setBorderPainted(false);
        winLoseBtn.setFocusPainted(false);
        winLoseBtn.setContentAreaFilled(false);
        winLoseBtn.addActionListener(winLoseHandler);
        winLoseBtn.setActionCommand("menu");
        winLoseBtnPanel.add(winLoseBtn);

        // Win or Lose Title Text
        if (life < 1) {
            winLoseTitleLabel.setText("You Lose!");
        } else {
            winLoseTitleLabel.setText("You Win!");
        }

        // Win Lose Image
        wlTextBGLabel = new JLabel();
        wlTextBGLabel.setIcon(tryAgainImage);
        wlTextBGLabel.setBounds(140, 25, 1050, 650);

        // Win Lose Layered Pane
        wlLayeredPane = new JLayeredPane();
        wlLayeredPane.setBounds(0, 0, 1280, 720);
        wlLayeredPane.add(winLoseTitlePanel);
        wlLayeredPane.add(winLoseBtnPanel);
        wlLayeredPane.add(wlTextBGLabel);
        wlLayeredPane.add(mainBGLabel);

        // Con Adds
        con.add(wlLayeredPane);
    }

    public class MainScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String mChoice = event.getActionCommand();

            switch (mChoice) {
                case "cStart":
                    mLayeredPane.setVisible(false);
                    playerName();
                    break;
                case "cQuit":
                    System.exit(0);
                    break;
                case "cSubmit":
                    position = "story0";
                    pLayeredPane.setVisible(false);
                    nama = pNameTField.getText();
                    U = nama.charAt(0);
                    story();
                    storyText();
                    break;
                case "cBack":
                    pLayeredPane.setVisible(false);
                    mainMenu();
                    break;
            }
        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            if ((yourChoice.equalsIgnoreCase("choice1") && UrutanJawaban[0].equalsIgnoreCase(answer))
                    || (yourChoice.equalsIgnoreCase("choice2") && UrutanJawaban[1].equalsIgnoreCase(answer))
                    || (yourChoice.equalsIgnoreCase("choice3") && UrutanJawaban[2].equalsIgnoreCase(answer))
                    || (yourChoice.equalsIgnoreCase("choice4") && UrutanJawaban[3].equalsIgnoreCase(answer))
                    || (yourChoice.equalsIgnoreCase("choice5") && UrutanJawaban[4].equalsIgnoreCase(answer))) {

                timer.stop();
                switch (position) {
                    case "SPLDV1":
                        position = "akar1";
                        akar();
                        cd = 60;
                        timer.start();
                        break;
                    case "akar1":
                        position = "aritmatikaSosial1";
                        aritmatikaSosial();
                        cd = 60;
                        timer.start();
                        break;
                    case "aritmatikaSosial1":
                        sLayeredPane.setVisible(false);
                        scrollLayeredPane.setVisible(false);
                        position = "scrollResultAerial";
                        scrollResult();
                        break;

                    case "barisDeretAritmatikaType11":
                        position = "barisDeretAritmatikaType21";
                        barisDeretAritmatikaType2();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretAritmatikaType21":
                        position = "barisDeretAritmatikaType31";
                        barisDeretAritmatikaType3();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretAritmatikaType31":
                        sLayeredPane.setVisible(false);
                        scrollLayeredPane.setVisible(false);
                        position = "scrollResultCrystaline";
                        scrollResult();
                        break;

                    case "barisDeretGeometriType11":
                        position = "barisDeretGeometriType21";
                        barisDeretGeometriType2();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretGeometriType21":
                        position = "barisDeretGeometriType31";
                        barisDeretGeometriType3();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretGeometriType31":
                        sLayeredPane.setVisible(false);
                        scrollLayeredPane.setVisible(false);
                        position = "scrollResultAqueous";
                        scrollResult();
                        break;

                    case "pemusatanData1":
                        position = "tabelDiagramLingkaran1";
                        tabelDiagramLingkaran();
                        cd = 60;
                        timer.start();
                        break;
                    case "tabelDiagramLingkaran1":
                        position = "barisDeretAritmatikaType41";
                        barisDeretAritmatikaType4();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretAritmatikaType41":
                        sLayeredPane.setVisible(false);
                        scrollLayeredPane.setVisible(false);
                        position = "scrollResultCryo";
                        scrollResult();
                        break;

                    case "SPLDV2":
                        position = "akar2";
                        akar();
                        cd = 60;
                        timer.start();
                        break;
                    case "akar2":
                        position = "aritmatikaSosial2";
                        aritmatikaSosial();
                        cd = 60;
                        timer.start();
                        break;
                    case "aritmatikaSosial2":
                        sLayeredPane.setVisible(false);
                        scrollLayeredPane.setVisible(false);
                        position = "scrollResultPyro";
                        scrollResult();
                        break;

                    case "barisDeretAritmatikaType12":
                        position = "barisDeretAritmatikaType22";
                        barisDeretAritmatikaType2();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretAritmatikaType22":
                        position = "barisDeretAritmatikaType32";
                        barisDeretAritmatikaType3();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretAritmatikaType32":
                        sLayeredPane.setVisible(false);
                        scrollLayeredPane.setVisible(false);
                        position = "scrollResultLuminous";
                        scrollResult();
                        break;

                    case "barisDeretGeometriType12":
                        position = "barisDeretGeometriType22";
                        barisDeretGeometriType2();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretGeometriType22":
                        position = "barisDeretGeometriType32";
                        barisDeretGeometriType3();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretGeometriType32":
                        sLayeredPane.setVisible(false);
                        scrollLayeredPane.setVisible(false);
                        position = "scrollResultDendro";
                        scrollResult();
                        break;

                    case "pemusatanData2":
                        position = "tabelDiagramLingkaran2";
                        tabelDiagramLingkaran();
                        cd = 60;
                        timer.start();
                        break;
                    case "tabelDiagramLingkaran2":
                        position = "barisDeretAritmatikaType42";
                        barisDeretAritmatikaType4();
                        cd = 60;
                        timer.start();
                        break;
                    case "barisDeretAritmatikaType42":
                        sLayeredPane.setVisible(false);
                        scrollLayeredPane.setVisible(false);
                        position = "scrollResultUmbra";
                        scrollResult();
                        break;
                }
            } else {
                lifeCheck();
            }
        }
    }

    public class NextHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String nChoice = event.getActionCommand();

            switch (nChoice) {
                case "cNext":
                    switch (position) {
                        case "story0":
                            position = "story1.0";
                            storyText();
                            break;
                        case "story1.0":
                            position = "SPLDV1";
                            storyLayeredPane.setVisible(false);
                            soal();
                            timer.start();
                            scroll();
                            SPLDV();
                            break;
                        case "story1.1":
                            position = "story2.0";
                            storyText();
                            break;
                        case "story2.0":
                            position = "barisDeretAritmatikaType11";
                            storyLayeredPane.setVisible(false);
                            soal();
                            timer.start();
                            scrollLayeredPane.setVisible(true);
                            aerialLabel.setVisible(true);
                            barisDeretAritmatikaType1();
                            break;
                        case "story3.0":
                            position = "barisDeretGeometriType11";
                            storyLayeredPane.setVisible(false);
                            soal();
                            timer.start();
                            scrollLayeredPane.setVisible(true);
                            crystalineLabel.setVisible(true);
                            barisDeretGeometriType1();
                            break;
                        case "story4.0":
                            position = "story4.1";
                            storyText();
                            break;
                        case "story4.1":
                            position = "pemusatanData1";
                            storyLayeredPane.setVisible(false);
                            soal();
                            timer.start();
                            scrollLayeredPane.setVisible(true);
                            aqueousLabel.setVisible(true);
                            pemusatanData();
                            break;
                        case "story5.0":
                            position = "SPLDV2";
                            storyLayeredPane.setVisible(false);
                            soal();
                            timer.start();
                            scrollLayeredPane.setVisible(true);
                            cryoLabel.setVisible(true);
                            SPLDV();
                            break;
                        case "story6.0":
                            storyLayeredPane.setVisible(false);
                            soal();
                            timer.start();
                            position = "barisDeretAritmatikaType12";
                            scrollLayeredPane.setVisible(true);
                            pyroLabel.setVisible(true);
                            barisDeretAritmatikaType1();
                            break;
                        case "story6.1":
                            position = "story7.0";
                            storyText();
                            break;
                        case "story7.0":
                            storyLayeredPane.setVisible(false);
                            soal();
                            timer.start();
                            position = "barisDeretGeometriType12";
                            scrollLayeredPane.setVisible(true);
                            luminousLabel.setVisible(true);
                            barisDeretGeometriType1();
                            break;
                        case "story8.0":
                            storyLayeredPane.setVisible(false);
                            soal();
                            timer.start();
                            position = "pemusatanData2";
                            scrollLayeredPane.setVisible(true);
                            dendroLabel.setVisible(true);
                            pemusatanData();
                            break;
                        case "story9.0":
                            storyLayeredPane.setVisible(false);
                            winLose();
                            break;
                        case "scrollResultAerial":
                            position = "story1.1";
                            srLayeredPane.setVisible(false);
                            story();
                            storyText();
                            break;
                        case "scrollResultCrystaline":
                            position = "story3.0";
                            srLayeredPane.setVisible(false);
                            story();
                            storyText();
                            break;
                        case "scrollResultAqueous":
                            position = "story4.0";
                            srLayeredPane.setVisible(false);
                            story();
                            storyText();
                            break;
                        case "scrollResultCryo":
                            position = "story5.0";
                            srLayeredPane.setVisible(false);
                            story();
                            storyText();
                            break;
                        case "scrollResultPyro":
                            position = "story6.0";
                            srLayeredPane.setVisible(false);
                            story();
                            storyText();
                            break;
                        case "scrollResultLuminous":
                            position = "story6.1";
                            srLayeredPane.setVisible(false);
                            story();
                            storyText();
                            break;
                        case "scrollResultDendro":
                            position = "story8.0";
                            srLayeredPane.setVisible(false);
                            story();
                            storyText();
                            break;
                        case "scrollResultUmbra":
                            position = "story9.0";
                            srLayeredPane.setVisible(false);
                            story();
                            storyText();
                            break;
                    }
                    break;
            }
        }
    }

    public class TryAgainHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String taChoice = event.getActionCommand();

            switch (taChoice) {
                case "yes":
                    tLayeredPane.setVisible(false);
                    scrollLayeredPane.setVisible(true);
                    soal();
                    timer.start();
                    switch (position) {
                        case "SPLDV1":
                        case "SPLDV2":
                            SPLDV();
                            break;
                        case "akar1":
                        case "akar2":
                            akar();
                            break;
                        case "aritmatikaSosial1":
                        case "aritmatikaSosial2":
                            aritmatikaSosial();
                            break;
                        case "pemusatanData1":
                        case "pemusatanData2":
                            pemusatanData();
                            break;
                        case "barisDeretAritmatikaType11":
                        case "barisDeretAritmatikaType12":
                            barisDeretAritmatikaType1();
                            break;
                        case "barisDeretAritmatikaType21":
                        case "barisDeretAritmatikaType22":
                            barisDeretAritmatikaType2();
                            break;
                        case "barisDeretAritmatikaType31":
                        case "barisDeretAritmatikaType32":
                            barisDeretAritmatikaType3();
                            break;
                        case "barisDeretAritmatikaType41":
                        case "barisDeretAritmatikaType42":
                            barisDeretAritmatikaType4();
                            break;
                        case "barisDeretGeometriType11":
                        case "barisDeretGeometriType12":
                            barisDeretGeometriType1();
                            break;
                        case "barisDeretGeometriType21":
                        case "barisDeretGeometriType22":
                            barisDeretGeometriType2();
                            break;
                        case "barisDeretGeometriType31":
                        case "barisDeretGeometriType32":
                            barisDeretGeometriType3();
                            break;
                        case "tabelDiagramLingkaran1":
                        case "tabelDiagramLingkaran2":
                            tabelDiagramLingkaran();
                            break;
                    }
                    break;
                case "no":
                    tLayeredPane.setVisible(false);
                    mainMenu();
                    break;
            }
        }
    }

    public class WinLoseHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String wlChoice = event.getActionCommand();

            switch (wlChoice) {
                case "menu":
                    wlLayeredPane.setVisible(false);
                    scrollLayeredPane.setVisible(false);
                    mainMenu();
                    break;
            }
        }
    }
}
