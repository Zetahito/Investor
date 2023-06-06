import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buy implements ActionListener {

    // Prvky Swingu
    JFrame window = new JFrame("Nákup");
    JButton buyButton = new JButton("Koupit");
    JLabel offeringStocksLabel = new JLabel();
    JLabel stocksAmountLabel = new JLabel();

    SpinnerNumberModel stocksAmountSpinner = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner stocksAmount = new JSpinner(stocksAmountSpinner);

    String[] stocks = {" ", "Apple", "Tesla", "Amazon", "Netflix", "Google", "SpaceX", "Samsung", "Valve", "PMDP" };
    JComboBox<String> selectStock = new JComboBox<>(stocks);

    // Font
    Font buyingFont = new Font("Consolas", Font.BOLD, 30);

    // Nastaví grafickou část
    Buy() {

        offeringStocksLabel.setBounds(25, 15, 300, 50);
        offeringStocksLabel.setFont(buyingFont);
        offeringStocksLabel.setText("Vyberte akcii: ");

        selectStock.setBounds(300, 20, 200, 40);
        selectStock.setFont(buyingFont);

        stocksAmountLabel.setBounds(25, 100, 350, 50);
        stocksAmountLabel.setFont(buyingFont);
        stocksAmountLabel.setText("Zadejte množství: ");

        stocksAmount.setBounds(350, 100, 150, 35);
        stocksAmount.setFont(buyingFont);

        buyButton.setBounds(25, 175, 475, 40);
        buyButton.setFont(buyingFont);
        buyButton.setFocusable(false);
        buyButton.addActionListener(this);

        window.add(selectStock);
        window.add(buyButton);
        window.add(offeringStocksLabel);
        window.add(stocksAmountLabel);
        window.add(stocksAmount);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(540, 280);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == buyButton) {
            //HlavniOkno.nakupAkcie((int)mnozstvi.getValue(), vyberAkcii.getSelectedIndex());

            window.dispose();
        }
    }
}
