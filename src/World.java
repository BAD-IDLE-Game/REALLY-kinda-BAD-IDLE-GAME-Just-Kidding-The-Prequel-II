import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;

class World extends JPanel{
    /**
     * This function hosts the world map screen with buttons to go to town or dungeon
     * @param player The player character object
     * @throws IOException
     */
    public World(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JButton quit = new JButton("Quit");
        JButton town = new JButton("Town");
        JButton dungeon = new JButton("Dungeon");

        // This section adds the components and controls layout
        add(Box.createVerticalGlue());
        add(quit);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(town);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(dungeon);
        add(Box.createVerticalGlue());

        quit.setAlignmentX(BOTTOM_ALIGNMENT);
        town.setAlignmentX(BOTTOM_ALIGNMENT);
        dungeon.setAlignmentX(BOTTOM_ALIGNMENT);

        // Quit button exits the game
        quit.addActionListener(e -> {
            System.exit(0);
        });

        // Town button takes you to the town
        town.addActionListener(e -> {
            try {
                Driver.changePanel("town");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        // Dungeon button takes you to the dungeon
        dungeon.addActionListener(e -> {
            try {
                Driver.changePanel("dungeon");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }
}