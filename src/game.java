/**
 * Created by Admin on 22.09.2014.
 **/
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class JDrawPanel extends JPanel {
    iteration One;
    JButton submit = new JButton("Шаг");
    public JDrawPanel(int size, boolean [][]ar) {
        setLayout(null);
        One = new iteration(size, ar);
        One.print();
        submit.setBounds(5,5, 80,20);
        add(submit);
       // ActionListener actionListener = new TestActionListener();
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                repaint();

                System.out.println("");
                One.Done();
                One.print();
            }
        });
        //One.Done();
       // One.print();
        }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();

//http://math.sgu.ru/sites/chairs/prinf/materials/java/lesson8.htm
// Инициализация переменных проверка проверка
        int Wd = (getWidth()-4)/One.size();
       int Hg = (getHeight()-30)/One.size();
        boolean ar[][] = new boolean[One.size()][One.size()];
        ar = One.getTable();

// Установка атрибутов вывода
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));// Ширтна линии
// Построение описанной окружности
        g2.setPaint(new GradientPaint(0, 0, Color.YELLOW,
                getWidth(), getHeight(), Color.RED));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
// Построение "сетки"
        g2.setPaint(Color.BLUE);
        g2.translate(2, 30);
        for(int i = 0; i <= One.size(); ++i) {

            g2.drawLine(0,i*Hg,getWidth(),i*Hg);
            g2.drawLine(i*Wd, 0 ,i*Wd ,getHeight());
        }
        g2.setStroke(new BasicStroke(4));
// Построение "клетки"
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

    public game() {
        int size;
        System.out.println("n=");
        Scanner in = new Scanner(System.in);
        size=in.nextInt();
        boolean ar[][] = new boolean[size][size];
        for ( int i = 0; i <= size-1; i++)
            for ( int j = 0; j <= size-1; j++)
            {
                int k = in.nextInt();
                if (k == 1) ar[i][j] = true;
                else ar[i][j] = false;
            }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new JDrawPanel(size, ar));
        setSize(300, 300);
    }
    public static void main(String[] args)
    {

        new game().setVisible(true);

    }

}
