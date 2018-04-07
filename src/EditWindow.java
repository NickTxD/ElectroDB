import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EditWindow extends JDialog{
    private Box box1;
    private Box box2;

    private JLabel chip_name_label;
    private JLabel sensor_type_label;
    private JLabel product_type_label;
    private JLabel integrated_circuit_type_label;
    private JLabel initial_settings_label;
    private JLabel preliminary_tests_label;
    private JLabel calibration_label;
    private JLabel verification_tests_label;
    private JLabel allan_variance_and_noise_label;
    private JLabel ready_label;
    private JLabel zero_offset_label;
    private JLabel coefficient_of_transformation_label;
    private JLabel nonlinearity_of_calibration_characteristic_label;
    private JLabel conversion_factor_change_label;
    private JLabel zero_offset_change_label;
    private JLabel measurement_error_label;

    private JTextField chip_name_text_filed;
    private JComboBox sensor_type_combo;
    private JComboBox product_type_combo;
    private JComboBox integrated_circuit_type_combo;
    private JComboBox initial_settings_combo;
    private JComboBox preliminary_tests_combo;
    private JComboBox calibration_combo;
    private JComboBox verification_tests_combo;
    private JComboBox allan_variance_and_noise_combo;
    private JComboBox ready_combo;
    private JTextField zero_offset_text_filed;
    private JTextField coefficient_of_transformation_text_filed;
    private JTextField nonlinearity_of_calibration_characteristic_text_filed;
    private JTextField conversion_factor_change_text_filed;
    private JTextField zero_offset_change_text_filed;
    private JTextField measurement_error_text_filed;

    private JButton ok_button;
    private JButton cancel_button;

    EditWindow(Chip chip, int mode){
        if(mode == MainWindow.EDIT)
            this.setTitle("Редактирование "+chip.getChip_name());
        if(mode == MainWindow.ADD)
            this.setTitle("Добавление");
        setSize(350,800);
        setResizable(false);
        setLocation(600,300);

        initLabels(mode);
        initCombo(chip, mode);
        initTextFields(chip, mode);

        if(mode == MainWindow.EDIT)
            initButtons(chip.getChip_name(), mode);
        if(mode == MainWindow.ADD)
            initButtons(null, mode);

        initBox1(mode);
        initBox2();

        Box mainbox = Box.createVerticalBox();
        mainbox.add(box1);
        mainbox.add(box2);

        setContentPane(mainbox);
    }
    private void initLabels(int mode){
        if(mode == MainWindow.ADD)
            chip_name_label = new JLabel("Название");

        sensor_type_label = new JLabel("Тип датчика");
        product_type_label = new JLabel("Вид модуля");
        integrated_circuit_type_label = new JLabel("Тип ИС");
        initial_settings_label = new JLabel("Первоначальная настройка");
        preliminary_tests_label = new JLabel("Предварительные испытания");
        calibration_label = new JLabel("Калибровка");
        verification_tests_label = new JLabel("Проверочные испытания");
        allan_variance_and_noise_label = new JLabel("Вариации Аллана и шум");
        ready_label = new JLabel("Готовность");
        zero_offset_label = new JLabel("Смещение нуля");
        coefficient_of_transformation_label = new JLabel("Коэффициент трансформации");
        nonlinearity_of_calibration_characteristic_label = new JLabel("Нелинейность градуировочной характеристики");
        conversion_factor_change_label = new JLabel("Изменение коэффициента преобразования");
        zero_offset_change_label = new JLabel("Изменение смещения нуля");
        measurement_error_label = new JLabel("Погрешность измерения");
    }

    private void initCombo(Chip chip, int mode){
        sensor_type_combo = new JComboBox(new String[]{"ММА", "ММГ"});
        product_type_combo = new JComboBox(new String[]{"Микромодуль", "Изделие"});
        integrated_circuit_type_combo = new JComboBox(new String[]{"Sina", "Sara"});
        initial_settings_combo = new JComboBox(new String[]{"Не проходил", "Проходит", "Прошел", "Не прошел"});
        preliminary_tests_combo = new JComboBox(new String[]{"Не проходил", "Проходит", "Прошел", "Не прошел"});
        calibration_combo = new JComboBox(new String[]{"Не проходил", "Проходит", "Прошел", "Не прошел"});
        verification_tests_combo = new JComboBox(new String[]{"Не проходил", "Проходит", "Прошел", "Не прошел"});
        allan_variance_and_noise_combo = new JComboBox(new String[]{"Не проходил", "Проходит", "Прошел", "Не прошел"});
        ready_combo = new JComboBox(new String[]{"Не готов", "Готов"});

        if (mode == MainWindow.EDIT){
            sensor_type_combo.setSelectedItem(chip.getSensor_type());
            product_type_combo.setSelectedItem(chip.getProduct_type());
            integrated_circuit_type_combo.setSelectedItem(chip.getIntegrated_circuit_type());
            initial_settings_combo.setSelectedItem(chip.getInitial_settings());
            preliminary_tests_combo.setSelectedItem(chip.getPreliminary_tests());
            calibration_combo.setSelectedItem(chip.getCalibration());
            verification_tests_combo.setSelectedItem(chip.getVerification_tests());
            allan_variance_and_noise_combo.setSelectedItem(allan_variance_and_noise_combo);
            ready_combo.setSelectedItem(chip.getReady());
        }
    }

    private void initTextFields(Chip chip, int mode){
        if(mode == MainWindow.ADD)
            chip_name_text_filed = new JTextField(20);

        zero_offset_text_filed = new JTextField(20);
        coefficient_of_transformation_text_filed = new JTextField(20);
        nonlinearity_of_calibration_characteristic_text_filed = new JTextField(20);
        conversion_factor_change_text_filed = new JTextField(20);
        zero_offset_change_text_filed = new JTextField(20);
        measurement_error_text_filed = new JTextField(20);

        if(mode == MainWindow.EDIT){
            zero_offset_text_filed.setText(chip.getZero_offset());
            coefficient_of_transformation_text_filed.setText(chip.getCoefficient_of_transformation());
            nonlinearity_of_calibration_characteristic_text_filed.setText(chip.getNonlinearity_of_calibration_characteristic());
            conversion_factor_change_text_filed.setText(chip.getZero_offset_change());
            zero_offset_change_text_filed.setText(chip.getZero_offset_change());
            measurement_error_text_filed.setText(chip.getMeasurement_error());
        }
    }

    private void initButtons(String chip_name, int mode){
        switch(mode){
            case MainWindow.ADD:
                ok_button = new JButton("Добавить");
                break;
            case MainWindow.EDIT:
                ok_button = new JButton("Изменить");
                break;
        }
        cancel_button = new JButton("Отменить");

        ok_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chip chip = null;
                if(isEmpty()){
                    JOptionPane.showMessageDialog(null,"Заполнены не все поля");
                    return;
                }
                chip = getChip(chip_name, mode);
                switch(mode){
                    case MainWindow.ADD:
                        MainWindow.dataBase.addChip(chip);
                        break;
                    case MainWindow.EDIT:
                        MainWindow.dataBase.editChip(chip);
                        break;
                }
                dispose();
            }
        });

        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


    private void initBox1(int mode){
        box1 = Box.createVerticalBox();

        if(mode == MainWindow.ADD) {
            box1.add(chip_name_label);
            box1.add(chip_name_text_filed);
            box1.add(Box.createVerticalStrut(10));
        }

        box1.add(sensor_type_label);
        box1.add(sensor_type_combo);
        box1.add(Box.createVerticalStrut(10));

        box1.add(product_type_label);
        box1.add(product_type_combo);
        box1.add(Box.createVerticalStrut(10));

        box1.add(integrated_circuit_type_label);
        box1.add(integrated_circuit_type_combo);
        box1.add(Box.createVerticalStrut(10));

        box1.add(initial_settings_label);
        box1.add(initial_settings_combo);
        box1.add(Box.createVerticalStrut(10));

        box1.add(preliminary_tests_label);
        box1.add(preliminary_tests_combo);
        box1.add(Box.createVerticalStrut(10));

        box1.add(calibration_label);
        box1.add(calibration_combo);
        box1.add(Box.createVerticalStrut(10));

        box1.add(verification_tests_label);
        box1.add(verification_tests_combo);
        box1.add(Box.createVerticalStrut(10));

        box1.add(allan_variance_and_noise_label);
        box1.add(allan_variance_and_noise_combo);
        box1.add(Box.createVerticalStrut(10));

        box1.add(ready_label);
        box1.add(ready_combo);
        box1.add(Box.createVerticalStrut(10));

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

        box2.add(Box.createHorizontalStrut(10));
        box2.add(ok_button);
        box2.add(Box.createHorizontalStrut(100));
        box2.add(cancel_button);
        box2.add(Box.createVerticalStrut(10));
    }

    private boolean isEmpty(){
        return zero_offset_text_filed.getText().isEmpty() ||
                coefficient_of_transformation_text_filed.getText().isEmpty() ||
                nonlinearity_of_calibration_characteristic_text_filed.getText().isEmpty() ||
                conversion_factor_change_text_filed.getText().isEmpty() ||
                zero_offset_text_filed.getText().isEmpty() ||
                measurement_error_text_filed.getText().isEmpty();
    }

    private Chip getChip(String chip_name, int mode){
        Chip chip = null;
        if(mode == MainWindow.ADD)
            chip_name = chip_name_text_filed.getText();
        chip = new Chip(chip_name, sensor_type_combo.getSelectedItem().toString(), product_type_combo.getSelectedItem().toString(),
                integrated_circuit_type_combo.getSelectedItem().toString(), initial_settings_combo.getSelectedItem().toString(),
                preliminary_tests_combo.getSelectedItem().toString(), calibration_combo.getSelectedItem().toString(),
                verification_tests_combo.getSelectedItem().toString(),
                allan_variance_and_noise_combo.getSelectedItem().toString(), ready_combo.getSelectedItem().toString(),
                zero_offset_text_filed.getText(), coefficient_of_transformation_text_filed.getText(),
                nonlinearity_of_calibration_characteristic_text_filed.getText(),
                conversion_factor_change_text_filed.getText(), zero_offset_change_text_filed.getText(),
                measurement_error_text_filed.getText());

        return chip;
    }
}
