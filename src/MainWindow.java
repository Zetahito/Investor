import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <h1>Hlavní třída aplikace Investor</h1>
 * @since 16.3.2023
 * @author Jakub Štych
 * @version 4.6.2023
 */
public class MainWindow extends JPanel implements ActionListener {

    /**
     * <h3>Štítek nabízených akcií</h3>
     */
    JLabel offeringStocksLabel;

    /**
     * <h3>Štítek vlastněných akcií</h3>
     */
    JLabel owningStocksLabel;

    /**
     * <h3>Nabízené akcie</h3>
     */
    JTextArea offeringStocks;

    /**
     * <h3>Vlastněné akcie</h3>
     */
    JTextArea owningStocks;

    /**
     * <h3>Dostupné finance</h3>
     */
    JTextArea availableMoney;

    /**
     * <h3>Tlačítko stop</h3>
     * Zastaví automatické střídaní dnů a cen akcií.
     */
    JButton stopButton;

    /**
     * <h3>Tlačítko pomalu</h3>
     * Nastaví automatické střídání dnů a cen akcií na pomalou rychlost.
     */
    JButton slowButton;

    /**
     * <h3>Tlačítko rychle</h3>
     * Nastaví automatické střídání dnů a cen akcií na střední rychlost.
     */
    JButton fastButton;

    /**
     * <h3>Tlačítko nejrychleji</h3>
     * Nastaví automatické střídání dnů a cen akcií na nejvyšší rychlost.
     */
    JButton fastestButton;

    /**
     * <h3>Tlačítko koupit</h3>
     * Vytvoří nové okno {@link Buy Nákupu}
     */
    JButton buyButton;

    /**
     * <h3>Tlačítko prodat</h3>
     * Vytvoří nové okno {@link Buy Prodeje} // TODO
     */
    JButton sellButton;

    /**
     * <h3>Tlačítko další den</h3>
     * Posune den a ceny akcií o jedno.
     */
    JButton nextDayButton;

    /**
     * <h3>Tlačítko uložit</h3>
     * Uloží aktuální ceny nabízených akcií a počet vlastněných akcií.
     */
    JButton saveButton;

    /**
     * <h3>Seskupení tlačítek</h3>
     * @see #stopButton  Tlačítko stop
     * @see #slowButton  Tlačítko pomalu
     * @see #fastButton  Tlačítko rychle
     * @see #fastestButton  Tlačítko nejrychleji
     * @see #buyButton  Tlačítko koupit
     * @see #sellButton  Tlačítko prodat
     * @see #nextDayButton  Tlačítko další den
     * @see #saveButton  Tlačítko uložit
     */
    Container buttons;

    /**
     * <h3>Seskupení horního panelu</h3>
     * @see #offeringStocksLabel  Štítek nabízených akcií
     * @see #owningStocksLabel  Štítek vlastněných akcií
     */
    Container top;

    /**
     * <h3>Seskupení prostředního panelu</h3>
     * @see #offeringStocks  Nabízené akcie
     * @see #owningStocks  Vlatněné akcie
     */
    Container middle;

    /**
     * <h3>Seskupení spodního panelu</h3>
     * @see #buttons  Seskupení tlačítek
     * @see #availableMoney  Dostupné finance
     */
    Container bottom;

    /**
     * <h3>Seskupení všech prvků</h3>
     * @see #top  Seskupení horního panelu
     * @see #middle  Seskupení středního panelu
     * @see #bottom  Seskupení spodního panelu
     */
    JFrame window;

    /**
     * <h3>Kolekce akcií</h3>
     */
    ArrayList<Stock> stocks = new ArrayList<>();

    /**
     * <h2>Hlavní okno aplikace</h2>
     */
    public MainWindow() {

        // ---===--- Horní část ---===--- //

        offeringStocksLabel = new JLabel("Nabízené akcie");
        offeringStocksLabel.setOpaque(true);
        offeringStocksLabel.setBackground(new Color(0x000A5A));
        offeringStocksLabel.setForeground(new Color(0xFFFFFF));
        offeringStocksLabel.setFont(new Font("Consolas", Font.BOLD, 70));
        offeringStocksLabel.setVerticalAlignment(SwingConstants.CENTER);
        offeringStocksLabel.setHorizontalAlignment(SwingConstants.CENTER);
        offeringStocksLabel.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));

        owningStocksLabel = new JLabel("Vlastněné akcie");
        owningStocksLabel.setOpaque(true);
        owningStocksLabel.setBackground(new Color(0x000A5A));
        owningStocksLabel.setForeground(new Color(0xFFFFFF));
        owningStocksLabel.setFont(new Font("Consolas", Font.BOLD, 70));
        owningStocksLabel.setVerticalAlignment(SwingConstants.CENTER);
        owningStocksLabel.setHorizontalAlignment(SwingConstants.CENTER);
        owningStocksLabel.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));

        top = new Container();
        top.setLayout(new GridLayout(1, 2));
        top.add(offeringStocksLabel);
        top.add(owningStocksLabel);

        // ---===--- Střední část ---===--- //

        offeringStocks = new JTextArea();
        offeringStocks.setFont(new Font("Consolas", Font.BOLD, 50));
        offeringStocks.setBackground(new Color(0x323232));
        offeringStocks.setForeground(new Color(0xFFFFFFFF, true));
        offeringStocks.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));

        owningStocks = new JTextArea();
        owningStocks.setFont(new Font("Consolas", Font.BOLD, 50));
        owningStocks.setBackground(new Color(0x323232));
        owningStocks.setForeground(new Color(0xFFFFFFFF, true));
        owningStocks.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));

        middle = new Container();
        middle.setLayout(new GridLayout(1, 2));
        middle.add(offeringStocks);
        middle.add(owningStocks);

        // ---===--- Dolní část ---===--- //

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

        saveButton = new JButton("Uložit");
        saveButton.addActionListener(this);
        saveButton.setFont(new Font("Consolas", Font.BOLD, 30));
        saveButton.setFocusable(false);

        buttons = new Container();
        buttons.setLayout(new GridLayout(2, 4));
        buttons.add(stopButton);
        buttons.add(slowButton);
        buttons.add(fastButton);
        buttons.add(fastestButton);
        buttons.add(buyButton);
        buttons.add(sellButton);
        buttons.add(nextDayButton);
        buttons.add(saveButton);

        availableMoney = new JTextArea("Finance: 0 Kč");
        availableMoney.setFont(new Font("Consolas", Font.BOLD, 30));
        availableMoney.setFocusable(false);
        availableMoney.setEditable(false);
        availableMoney.setBorder(BorderFactory.createEmptyBorder(35,10,35,10));

        bottom = new Container();
        bottom.setLayout(new GridLayout(1, 2));
        bottom.add(buttons);
        bottom.add(availableMoney);

        // ---===--- Okno celkově ---===--- //

        window = new JFrame("Investor");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setSize(1800, 960);
        window.setMinimumSize(new Dimension(1550, 825));
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.add(top, BorderLayout.NORTH);
        window.add(middle);
        window.add(bottom, BorderLayout.SOUTH);
        window.setVisible(true);
    }

    /**
     * <h2>Main metoda</h2>
     * Vstupní bod programu
     * @param args Argumenty
     */
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.loadData();
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == buyButton) {
            new Buy();
        }
    }

    void loadData() {

        try {
            List<String> lines = Files.readAllLines(Paths.get("Stock.txt"));
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
            StringBuilder offering = new StringBuilder();
            for (Stock stock : stocks) {
                offering.append(stock.name)
                        .append('\t')
                        .append(" (")
                        .append(stock.offering)
                        .append(") ")
                        .append('\t')
                        .append(stock.price)
                        .append(" Kč")
                        .append('\n');
            }
            offeringStocks.setText(offering.toString());

            //setTextToTextArea(offeringStocks);
        }
        catch (NumberFormatException nfe) {
            System.out.println("Špatný formát čísla ceny akcie");
            System.out.println(nfe.getMessage());
            nfe.printStackTrace();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("Soubor nenalezen");
            System.out.println(fnfe.getMessage());
            fnfe.printStackTrace();
        }
        catch (IOException ioe) {
            System.out.println("Nespecifikovaná výjimka spojená se souborem Stock.txt");
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    void setTextToTextArea(JTextArea textArea) {

    }
}
