import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SpecsWindow extends JDialog{
    private Box box1;
    private Box box2;

    private JLabel zero_offset_label;
    private JLabel coefficient_of_transformation_label;
    private JLabel nonlinearity_of_calibration_characteristic_label;
    private JLabel conversion_factor_change_label;
    private JLabel zero_offset_change_label;
    private JLabel measurement_error_label;

    private JTextField zero_offset_text_filed;
    private JTextField coefficient_of_transformation_text_filed;
    private JTextField nonlinearity_of_calibration_characteristic_text_filed;
    private JTextField conversion_factor_change_text_filed;
    private JTextField zero_offset_change_text_filed;
    private JTextField measurement_error_text_filed;

    private JButton cancel_button;

    SpecsWindow(Chip chip){
        this.setTitle("Параметры "+chip.getChip_name());
        setSize(300,350);
        setResizable(false);
        setLocation(550,200);

        initLabels();
        initTextFields(chip);
        initButtons();

        initBox1();
        initBox2();

        Box mainbox = Box.createVerticalBox();
        mainbox.add(box1);
        mainbox.add(box2);

        setContentPane(mainbox);
    }
    private void initLabels(){
        zero_offset_label = new JLabel("Смещение нуля");
        coefficient_of_transformation_label = new JLabel("Коэффициент трансформации");
        nonlinearity_of_calibration_characteristic_label = new JLabel("Нелинейность градуировочной характеристики");
        conversion_factor_change_label = new JLabel("Изменение коэффициента преобразования");
        zero_offset_change_label = new JLabel("Изменение смещения нуля");
        measurement_error_label = new JLabel("Погрешность измерения");
    }

    private void initTextFields(Chip chip){

        zero_offset_text_filed = new JTextField(20);
        coefficient_of_transformation_text_filed = new JTextField(20);
        nonlinearity_of_calibration_characteristic_text_filed = new JTextField(20);
        conversion_factor_change_text_filed = new JTextField(20);
        zero_offset_change_text_filed = new JTextField(20);
        measurement_error_text_filed = new JTextField(20);

        zero_offset_text_filed.setEditable(false);
        coefficient_of_transformation_text_filed.setEditable(false);
        nonlinearity_of_calibration_characteristic_text_filed.setEditable(false);
        conversion_factor_change_text_filed.setEditable(false);
        zero_offset_change_text_filed.setEditable(false);
        measurement_error_text_filed.setEditable(false);

        zero_offset_text_filed.setText(chip.getZero_offset());
        coefficient_of_transformation_text_filed.setText(chip.getCoefficient_of_transformation());
        nonlinearity_of_calibration_characteristic_text_filed.setText(chip.getNonlinearity_of_calibration_characteristic());
        conversion_factor_change_text_filed.setText(chip.getZero_offset_change());
        zero_offset_change_text_filed.setText(chip.getZero_offset_change());
        measurement_error_text_filed.setText(chip.getMeasurement_error());
    }

    private void initButtons(){

        cancel_button = new JButton("Закрыть");

        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


    private void initBox1(){
        box1 = Box.createVerticalBox();

        box1.add(zero_offset_label);
        box1.add(zero_offset_text_filed);
        box1.add(Box.createVerticalStrut(10));

        box1.add(coefficient_of_transformation_label);
        box1.add(coefficient_of_transformation_text_filed);
        box1.add(Box.createVerticalStrut(10));

        box1.add(nonlinearity_of_calibration_characteristic_label);
        box1.add(nonlinearity_of_calibration_characteristic_text_filed);
        box1.add(Box.createVerticalStrut(10));

        box1.add(conversion_factor_change_label);
        box1.add(conversion_factor_change_text_filed);
        box1.add(Box.createVerticalStrut(10));

        box1.add(zero_offset_change_label);
        box1.add(zero_offset_change_text_filed);
        box1.add(Box.createVerticalStrut(10));

        box1.add(measurement_error_label);
        box1.add(measurement_error_text_filed);
        box1.add(Box.createVerticalStrut(10));
    }

    private void initBox2(){
        box2 = Box.createHorizontalBox();
        box2.add(Box.createHorizontalStrut(100));
        box2.add(cancel_button);
        box2.add(Box.createVerticalStrut(10));
    }

}
