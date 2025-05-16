package tinhtien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TinhDienTichHinhTron extends JFrame {

    private JTextField txtBanKinh;
    private JLabel lblKetQua;

    public TinhDienTichHinhTron() {
        setTitle("Tính Diện Tích Hình Tròn");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setLayout(new GridLayout(4, 1));

        // Tiêu đề
        JLabel lblTieuDe = new JLabel("Tính Diện Tích Hình Tròn", JLabel.CENTER);
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTieuDe);

        // Nhập bán kính
        JPanel panelNhap = new JPanel();
        panelNhap.add(new JLabel("Nhập bán kính:"));
        txtBanKinh = new JTextField(10);
        panelNhap.add(txtBanKinh);
        add(panelNhap);

        // Nút tính toán
        JButton btnTinh = new JButton("Tính Diện Tích");
        add(btnTinh);

        // Kết quả
        lblKetQua = new JLabel("Diện tích: ", JLabel.CENTER);
        add(lblKetQua);

        // Xử lý khi bấm nút
        btnTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double r = Double.parseDouble(txtBanKinh.getText());
                    if (r < 0) {
                        JOptionPane.showMessageDialog(null, "Bán kính phải >= 0");
                        return;
                    }
                    double dienTich = Math.PI * r * r;
                    lblKetQua.setText(String.format("Diện tích: %.2f", dienTich));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TinhDienTichHinhTron().setVisible(true);
        });
    }
}
