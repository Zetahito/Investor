import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <h1>Hlavní okno aplikace Investor</h1>
 * @author Jakub Štych
 * @version 18.3.2023
 */
public class MainWindow extends JPanel implements ActionListener {

    /**
     * <h3>Komponenty</h3>
     */
    JLabel titleLabel, offeringStocksLabel, owningStocksLabel;
    JTextArea offeringStocks, owningStocks, availableMoney;
    JButton stopButton, slowButton, fastButton, fastestButton, buyButton, sellButton, nextDayButton, saveButton;
    Container titles;
    Container timeButtons;
    Container left;
    Container right;
    JPanel panel;
    JFrame window;

    /**
     * <h2>Konstruktor</h2>
     */
    MainWindow() {

        window = new JFrame("Investor");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setLocationRelativeTo(null);
        window.setLayout(new GridLayout(1, 2));
        window.setSize(1800, 960);

        titleLabel = new JLabel();
        titleLabel.setText("Investor");
        titleLabel.setBackground(new Color(0x000A5A));
        titleLabel.setForeground(new Color(0xFFFFFF));
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 32));

        // Left Container
        offeringStocksLabel = new JLabel();
        offeringStocksLabel.setText("Nabízené akcie");
        offeringStocksLabel.setBackground(new Color(0x000A5A));
        offeringStocksLabel.setForeground(new Color(0xFFFFFF));
        offeringStocksLabel.setFont(new Font("Consolas", Font.BOLD, 25));

        offeringStocks = new JTextArea();
        offeringStocks.setFont(new Font("Consolas", Font.BOLD, 30));
        offeringStocks.setEditable(false);
        offeringStocks.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 25));
        offeringStocks.setText("Kobylka");

        // Time buttons Container
        stopButton = new JButton("||");
        stopButton.addActionListener(this);
        stopButton.setFont(new Font("Consolas", Font.BOLD, 30));
        stopButton.setFocusable(false);

        slowButton = new JButton(">");
        slowButton.addActionListener(this);
        slowButton.setFont(new Font("Consolas", Font.BOLD, 30));
        slowButton.setFocusable(false);

        fastButton = new JButton(">>");
        fastButton.addActionListener(this);
        fastButton.setFont(new Font("Consolas", Font.BOLD, 30));
        fastButton.setFocusable(false);

        fastestButton = new JButton(">>>");
        fastestButton.addActionListener(this);
        fastestButton.setFont(new Font("Consolas", Font.BOLD, 30));
        fastestButton.setFocusable(false);

        buyButton = new JButton("Koupit");
        buyButton.addActionListener(this);
        buyButton.setFont(new Font("Consolas", Font.BOLD, 30));
        buyButton.setFocusable(false);

        sellButton = new JButton("Prodat");
        sellButton.addActionListener(this);
        sellButton.setFont(new Font("Consolas", Font.BOLD, 30));
        sellButton.setFocusable(false);

        nextDayButton = new JButton("Další den");
        nextDayButton.addActionListener(this);
        nextDayButton.setFont(new Font("Consolas", Font.BOLD, 30));
        nextDayButton.setFocusable(false);

        saveButton = new JButton("Další den");
        saveButton.addActionListener(this);
        saveButton.setFont(new Font("Consolas", Font.BOLD, 30));
        saveButton.setFocusable(false);

        timeButtons = new Container();
        timeButtons.setLayout(new GridLayout(2, 4));
        timeButtons.add(stopButton);
        timeButtons.add(slowButton);
        timeButtons.add(fastButton);
        timeButtons.add(fastestButton);
        timeButtons.add(buyButton);
        timeButtons.add(sellButton);
        timeButtons.add(nextDayButton);
        timeButtons.add(saveButton);

        left = new Container();
        left.setLayout(new GridLayout(3, 1));
        left.add(offeringStocksLabel);
        left.add(offeringStocks);
        left.add(timeButtons);

        // Right Container
        owningStocksLabel = new JLabel();
        owningStocksLabel.setText("Vlastněné akcie");
        owningStocksLabel.setBackground(new Color(0x000A5A));
        owningStocksLabel.setForeground(new Color(0xFFFFFF));
        owningStocksLabel.setFont(new Font("Consolas", Font.BOLD, 25));

        owningStocks = new JTextArea();
        owningStocks.setFont(new Font("Consolas", Font.BOLD, 30));
        owningStocks.setEditable(false);
        owningStocks.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 25));
        owningStocks.setText("Kobylkaa");

        availableMoney = new JTextArea();
        availableMoney.setBounds(600, 620, 500, 50);
        availableMoney.setFont(new Font("Consolas", Font.BOLD, 30));
        availableMoney.setEditable(false);
        availableMoney.setBorder(BorderFactory.createEmptyBorder(10, 40, 5, 5));
        availableMoney.setText("Kobylka");
        //availableMoney.setText("Celkové peníze: " + formatPenez.format(pevneFinance.getHodnota()) + "Kč");

        right = new Container();
        right.setLayout(new GridLayout(3, 1));
        right.add(owningStocksLabel);
        right.add(owningStocks);
        right.add(availableMoney);

        window.add(left);
        window.add(right);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
