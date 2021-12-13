package pakiet.pg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
// rysowanie po prawej stronie x - kwadrat, z - koło
public class Window extends JFrame  {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window frame = new Window();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }
    private Random random = new Random();
    public Window() throws HeadlessException{
        this("Przycisk");
    }
    public Window(String title) throws HeadlessException{
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        JButton button = new JButton("Kliknij");
        button.setBounds(100,100,80,50);
        button.setBackground(Color.BLUE);
        button.setFocusable(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(e.getX()<60) {

                    button.setLocation(random.nextInt(400), random.nextInt(400));
                }
                else
                {
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            button.setLocation(random.nextInt(400), random.nextInt(400));
                        }
                    });
                }
            }
        });
        panel.add(button);
        JButton btn_powrot = new JButton("Powrot");
        btn_powrot.setBounds(400,500,100,50);
        btn_powrot.setBackground(Color.red);
        btn_powrot.setFocusable(false);
        btn_powrot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                button.setLocation(100,100);

            }
        });
        panel.add(btn_powrot);
        this.add(panel);

        JPanel kanwa = new Kanwa();
        kanwa.setBounds(500,0,500,700);
        panel.add(kanwa);
        kanwa.setLayout(null);
    }
}
