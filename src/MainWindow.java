import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <h1>Hlavní okno aplikace Investor</h1>
 * @author Jakub Štych
 * @version 18.3.2023
 */
public class MainWindow extends JPanel implements ActionListener {

    /**
     * <h3>Komponenty</h3>
     */
    JLabel offeringStocksLabel, owningStocksLabel;
    JTextArea offeringStocks, owningStocks, availableMoney;
    JButton stopButton, slowButton, fastButton, fastestButton, buyButton, sellButton, nextDayButton, saveButton;
    Container timeButtons;
    Container left;
    Container right;
    JFrame window;
    ArrayList<Stock> stocks = new ArrayList<Stock>();

    /**
     * <h2>Konstruktor</h2>
     */
    MainWindow() {

        window = new JFrame("Investor");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(1, 2));
        window.setSize(1800, 960);

        offeringStocksLabel = new JLabel();
        offeringStocksLabel.setText("Nabízené akcie");
        offeringStocksLabel.setOpaque(true);
        offeringStocksLabel.setBackground(new Color(0x000A5A));
        offeringStocksLabel.setForeground(new Color(0xFFFFFF));
        offeringStocksLabel.setFont(new Font("Consolas", Font.BOLD, 70));
        offeringStocksLabel.setVerticalAlignment(SwingConstants.CENTER);
        offeringStocksLabel.setHorizontalAlignment(SwingConstants.CENTER);

        offeringStocks = new JTextArea();
        offeringStocks.setFont(new Font("Consolas", Font.BOLD, 30));
        offeringStocks.setEditable(false);
        offeringStocks.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 25));

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
        owningStocksLabel.setOpaque(true);
        owningStocksLabel.setBackground(new Color(0x000A5A));
        owningStocksLabel.setForeground(new Color(0xFFFFFF));
        owningStocksLabel.setFont(new Font("Consolas", Font.BOLD, 70));
        owningStocksLabel.setVerticalAlignment(SwingConstants.CENTER);
        owningStocksLabel.setHorizontalAlignment(SwingConstants.CENTER);

        owningStocks = new JTextArea();
        owningStocks.setFont(new Font("Consolas", Font.BOLD, 30));
        owningStocks.setEditable(false);
        owningStocks.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 25));

        availableMoney = new JTextArea();
        availableMoney.setBounds(600, 620, 500, 50);
        availableMoney.setFont(new Font("Consolas", Font.BOLD, 30));
        availableMoney.setEditable(false);
        availableMoney.setBorder(BorderFactory.createEmptyBorder(10, 40, 5, 5));

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
        MainWindow mw = new MainWindow();
        mw.loadData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    void loadData() {

        try {
            List<String> lines = Files.readAllLines(Paths.get("Stock.csv"));
            String[] oneLine;
            for (String line : lines) {
                oneLine = line.split(";");
                stocks.add(new Stock(
                        oneLine[0],
                        Integer.parseInt(oneLine[1]),
                        Boolean.parseBoolean(oneLine[2]),
                        Double.parseDouble(oneLine[3]),
                        Double.parseDouble(oneLine[4]),
                        Integer.parseInt(oneLine[5]),
                        Integer.parseInt(oneLine[6]))
                );
            }
            updateData();
        }
        catch (IOException ioe) {
            System.out.println("Soubor nenalezen");
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    void updateData() {

    }

    void setTextToTextArea(JTextArea textArea, String[] content) {
        StringBuilder text = new StringBuilder();
        for (String s : content) {
            text.append(s);
            text.append("\n");
        }
        textArea.setText(text.toString());
    }
}
