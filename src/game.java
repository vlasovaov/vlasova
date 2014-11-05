/**
 * Created by Admin on 22.09.2014.
 **/
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
class JDrawPanel extends JPanel {
    iteration One;
    JButton submit = new JButton("шаг");
    JButton submit1 = new JButton("игра");

    boolean flag=false;
    public JDrawPanel(int size) {
        setLayout(null);

        One = new iteration(size);
        One.print();

        submit1.setBounds(5,5, 80,20);
        submit.setBounds(95, 5, 80, 20);
        add(submit);add(submit1);
        submit.setVisible(false);
        // ActionListener actionListener = new TestActionListener();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                repaint();

                System.out.println("");
                One.Done();
                One.print();
            }
        });
        submit1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               submit.setVisible(true);

            }
        });
        //One.Done();
        // One.print();
    }
    public void set(int x, int y){One.setZnach(x,y,true); repaint();}
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g.create();

//http://math.sgu.ru/sites/chairs/prinf/materials/java/lesson8.htm
// РРЅРёС†РёР°Р»РёР·Р°С†РёСЏ РїРµСЂРµРјРµРЅРЅС‹С… РїСЂРѕРІРµСЂРєР° РїСЂРѕРІРµСЂРєР°
        int Wd = (getWidth()-4)/One.size();
        int Hg = (getHeight()-30)/One.size();
        int gw = getHeight();
        int min = Wd<Hg?Wd:Hg;
        boolean ar[][] = new boolean[One.size()][One.size()];
        //lk;lkl;k
        ar = One.getTable();

// РЈСЃС‚Р°РЅРѕРІРєР° Р°С‚СЂРёР±СѓС‚РѕРІ РІС‹РІРѕРґР°
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));// РЁРёСЂС‚РЅР° Р»РёРЅРёРё
// РџРѕСЃС‚СЂРѕРµРЅРёРµ РѕРїРёСЃР°РЅРЅРѕР№ РѕРєСЂСѓР¶РЅРѕСЃС‚Рё
        g2.setPaint(new GradientPaint(0, 0, Color.YELLOW,
                getWidth(), getHeight(), Color.RED));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
// РџРѕСЃС‚СЂРѕРµРЅРёРµ "СЃРµС‚РєРё"
        g2.setPaint(Color.BLUE);
        g2.translate(2, 30);
        for(int i = 0; i <= One.size(); ++i) {

            g2.drawLine(0,i*Hg,getWidth(),i*Hg);
            g2.drawLine(i*Wd, 0 ,i*Wd ,getHeight());
        }
        g2.setStroke(new BasicStroke(4));
// РџРѕСЃС‚СЂРѕРµРЅРёРµ "РєР»РµС‚РєРё"
        for(int i = 0; i < One.size(); ++i)
        {
            for(int j = 0; j < One.size(); ++j)
            {
                if(ar[i][j]==true) g2.fillRect(j * Wd + Wd / 5, i * Hg + Hg / 5, Wd - Wd / 5 * 2, Hg - Hg / 5 * 2);

            }
        }

        g2.dispose();
    }

}

public class game extends JFrame{
    int s;
    JDrawPanel MyJDrawPanel;
    public game(int size) {
     s = size;

        MyJDrawPanel = new JDrawPanel(s);

        MyJDrawPanel.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent event) {
                int Wd = (getWidth()-20)/s;
                int gw = getHeight();
                int Hg = (getHeight()-68)/s;
                JOptionPane.showMessageDialog(null,event.getX());
               int x=(event.getX()-2)/Wd;
                int y=(event.getY()-30)/Hg;
                MyJDrawPanel.set(y,x);


            }

        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().add(MyJDrawPanel);
        setSize(300, 300);
    }
    public static void main(String[] args)
    {
        int size;
        System.out.println("n=");
        Scanner in = new Scanner(System.in);
        size=in.nextInt();
        new game(size).setVisible(true);

    }

}
