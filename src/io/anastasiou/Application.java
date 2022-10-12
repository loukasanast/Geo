package io.anastasiou;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    private JButton btnSend;
    private JButton btnDetails;
    private JTextField txtSearch;
    private JLabel lblAddress;
    private JLabel lblLat;
    private JLabel lblLng;
    private JLabel lblResult;
    private JComboBox<String> slcColors;
    private Double lat;
    private Double lng;
    private String[] colors = {"BLACK", "BLUE", "YELLOW"};

    public Application() {
        btnSend = new JButton("SEND");
        btnSend.setBounds(10, 310, 100, 40);
        btnSend.addActionListener((e) -> {
            try {
                Connect conn = new Connect(txtSearch.getText());
                this.lat = conn.getData().getLat();
                this.lng = conn.getData().getLng();

                lblResult.setText("Completed!");
                btnDetails.setEnabled(true);
            } catch(Exception exc) {
                lblResult.setText("Error!");
            }
        });

        this.add(btnSend);

        btnDetails = new JButton("DETAILS");
        btnDetails.setBounds(120, 310, 100, 40);
        btnDetails.setEnabled(false);
        btnDetails.addActionListener((e) -> {
            lblLat.setText(String.format("lat: %s", this.lat.toString()));
            lblLng.setText(String.format("lng: %s", this.lng.toString()));

            lblResult.setText("");
            btnDetails.setEnabled(false);
        });

        this.add(btnDetails);

        txtSearch = new JTextField();
        txtSearch.setBounds(10, 45, 268, 40);
        this.add(txtSearch);

        lblAddress = new JLabel("ADDRESS");
        lblAddress.setBounds(10, 10, 268, 40);
        this.add(lblAddress);

        lblLat = new JLabel("lat:");
        lblLat.setBounds(10, 100, 268, 40);
        this.add(lblLat);

        lblLng = new JLabel("lng:");
        lblLng.setBounds(10, 135, 268, 40);
        this.add(lblLng);

        lblResult = new JLabel();
        lblResult.setBounds(10, 200, 268, 40);
        this.add(lblResult);

        slcColors = new JComboBox<>(colors);
        slcColors.setBounds(10, 240, 268, 40);
        slcColors.addActionListener((e) -> {
            switch(slcColors.getSelectedItem().toString()) {
                case "BLACK":
                    lblLat.setForeground(Color.BLACK);
                    lblLng.setForeground(Color.BLACK);
                    break;
                case "BLUE":
                    lblLat.setForeground(Color.BLUE);
                    lblLng.setForeground(Color.BLUE);
                    break;
                case "YELLOW":
                    lblLat.setForeground(Color.YELLOW);
                    lblLng.setForeground(Color.YELLOW);
                    break;
            }
        });

        this.add(slcColors);

        this.setSize(300, 400);
        this.setLayout(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Application();
    }
}
