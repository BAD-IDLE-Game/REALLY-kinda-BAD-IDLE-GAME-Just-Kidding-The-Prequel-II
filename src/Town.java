import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

class Town extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        try {
            g.drawImage(ImageIO.read(new File("assets/images/town3.png")), 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * This function hosts the town screen with buttons to buy potions or leave
     * 
     * @param player The player character object
     * @throws IOException
     */
    public Town() throws IOException {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        Color customColorBeige = new Color(253, 236, 166);
        Color customColorBrown = new Color(102, 72, 54);
      
        JButton bazaar = new JButton("💰 Bazaar");
        buttons.add(bazaar);
        JButton leave = new JButton("← Leave");
        buttons.add(leave);
        JButton tavern = new JButton("🍺 Tavern");
        buttons.add(tavern);
        JButton library = new JButton("📚 Library");
        buttons.add(library);
        JButton inventory = new JButton("👜 Inventory");
        buttons.add(inventory);

        // Adding the buttons to the start panel and controlling layout
        add(Box.createVerticalGlue());
        add(bazaar);
        add(Box.createRigidArea(new Dimension(100, 20)));
        add(tavern);
        add(Box.createRigidArea(new Dimension(100, 20)));
        add(library);
        add(Box.createRigidArea(new Dimension(100, 20)));
        add(inventory);
        add(Box.createRigidArea(new Dimension(100, 20)));
        add(leave);
        add(Box.createVerticalGlue());

        // For loop that formats all the buttons
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setAlignmentX(CENTER_ALIGNMENT);
            buttons.get(i).setPreferredSize(new Dimension(200, 80));
            buttons.get(i).setMaximumSize(new Dimension(200, 80));
            buttons.get(i).setBackground(customColorBrown);
            buttons.get(i).setForeground(customColorBeige);
            buttons.get(i).setFont(new Font("Serif", Font.BOLD, 24));
        }

        this.setAlignmentX(CENTER_ALIGNMENT);

        // Button that takes player to bazaar panel
        bazaar.addActionListener(e -> {
            try{
                SFX.stopAllSounds();
                SFX.playSound("assets/SFX/interface1.wav");
                Driver.changePanel("bazaar");
                MusicPlayer.playMusic("assets/Music/Turku, Nomads of the Silk Road - -Uskudara Gideriken.wav");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        // Button that takes player to tavern panel
        tavern.addActionListener(e -> {
            try{
                SFX.stopAllSounds();
                SFX.playSound("assets/SFX/interface1.wav");
                SFX.playSound("assets/SFX/door-open.wav");
                Driver.changePanel("tavern");
                MusicPlayer.playMusic("assets/Music/alexander-nakarada-tavern-loop-one.wav");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        // Button that takes player to library panel
        library.addActionListener(e -> {
            try{
                SFX.stopAllSounds();
                SFX.playSound("assets/SFX/interface1.wav");
                Driver.changePanel("library");
                MusicPlayer.playMusic("assets/Music/library2-bgm.wav");
            } catch (Exception e1){
                e1.printStackTrace();
            }
        });

        // Button that takes player to inventory panel
        inventory.addActionListener(e -> {
            try {
                Driver.player.inventory.backToTown = true;
                SFX.playSound("assets/SFX/interface1.wav");
                Driver.changePanel("inventory");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        // Button that takes player to world panel
        leave.addActionListener(e -> {
            try{
                SFX.stopAllSounds();
                Driver.player.inventory.backToTown = false;
                SFX.playSound("assets/SFX/interface1.wav");
                Driver.changePanel("world");
                MusicPlayer.playMusic("assets/Music/now-we-ride.wav");
                SFX.stopAllSounds();
                Driver.savePlayer(Driver.getPlayer(), "save-files/saveFile1.sav"); // save player data to save slot 1 by default
            } catch (Exception e1){
                e1.printStackTrace();
            }
        });
    }
}