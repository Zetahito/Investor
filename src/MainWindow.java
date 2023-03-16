import javax.swing.*;
import java.awt.*;

/**
 * <h1>Hlavní okno aplikace Investor</h1>
 * @author Jakub Štych
 * @version 16.3.2023
 */
public class MainWindow extends JPanel {

    /**
     * <h3>Komponenty</h3>
     */
    JLabel titleLabel, offeringStocksLabel, owningStocksLabel;
    TextArea offeringStocks, owningStocks, availableMoney;
    Button stopButton, slowButton, fastButton, fastestButton, buyButton, sellButton, nextDayButton;
    Container titles;
    Container left;
    Container right;

    /**
     * <h2>Konstruktor</h2>
     */
    MainWindow() {

        titleLabel = new JLabel();
        titleLabel.setText("Investor");
        titleLabel.setBackground(new Color(0x000A5A));
        titleLabel.setForeground(new Color(0xFFFFFF));
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 32));

        offeringStocksLabel = new JLabel();
        offeringStocksLabel.setText("Nabízené akcie");
        offeringStocksLabel.setBackground(new Color(0x000A5A));
        offeringStocksLabel.setForeground(new Color(0xFFFFFF));
        offeringStocksLabel.setFont(new Font("Consolas", Font.BOLD, 25));

        owningStocksLabel = new JLabel();
        owningStocksLabel.setText("Nabízené akcie");
        owningStocksLabel.setBackground(new Color(0x000A5A));
        owningStocksLabel.setForeground(new Color(0xFFFFFF));
        owningStocksLabel.setFont(new Font("Consolas", Font.BOLD, 25));
    }

    public static void main(String[] args) {

    }
}
