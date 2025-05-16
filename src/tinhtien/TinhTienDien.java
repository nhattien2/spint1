package tinhtien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TinhTienDien extends JFrame {

    private JTextField txtSoDien;
    private JLabel lblKetQua;

    public TinhTienDien() {
        setTitle("Tính Tiền Điện");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setLayout(new GridLayout(4, 1));

        // Tiêu đề
        JLabel lblTieuDe = new JLabel("Tính Tiền Điện", JLabel.CENTER);
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTieuDe);

        // Nhập số điện
        JPanel panelNhap = new JPanel();
        panelNhap.add(new JLabel("Nhập số điện (kWh):"));
        txtSoDien = new JTextField(10);
        panelNhap.add(txtSoDien);
        add(panelNhap);

        // Nút tính
        JButton btnTinh = new JButton("Tính Tiền");
        add(btnTinh);

        // Kết quả
        lblKetQua = new JLabel("Tiền điện: ", JLabel.CENTER);
        add(lblKetQua);

        // Xử lý nút
        btnTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int soDien = Integer.parseInt(txtSoDien.getText());
                    if (soDien < 0) {
                        JOptionPane.showMessageDialog(null, "Số điện phải >= 0");
                        return;
                    }

                    // Tính tiền điện (giả sử 2000 đồng / 1 kWh)
                    int donGia = 2000;
                    int tienDien = soDien * donGia;

                    lblKetQua.setText("Tiền điện: " + tienDien + " đồng");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên hợp lệ!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TinhTienDien().setVisible(true);
        });
    }
}
