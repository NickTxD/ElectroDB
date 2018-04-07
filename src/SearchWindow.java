import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class SearchWindow extends JDialog{
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

    private JLabel from_label1;
    private JLabel to_label1;
    private JLabel from_label2;
    private JLabel to_label2;
    private JLabel from_label3;
    private JLabel to_label3;
    private JLabel from_label4;
    private JLabel to_label4;
    private JLabel from_label5;
    private JLabel to_label5;
    private JLabel from_label6;
    private JLabel to_label6;

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
    private JTextField zero_offset_text_filed_min;
    private JTextField zero_offset_text_filed_max;
    private JTextField coefficient_of_transformation_text_filed_min;
    private JTextField coefficient_of_transformation_text_filed_max;
    private JTextField nonlinearity_of_calibration_characteristic_text_filed_min;
    private JTextField nonlinearity_of_calibration_characteristic_text_filed_max;
    private JTextField conversion_factor_change_text_filed_min;
    private JTextField conversion_factor_change_text_filed_max;
    private JTextField zero_offset_change_text_filed_min;
    private JTextField zero_offset_change_text_filed_max;
    private JTextField measurement_error_text_filed_min;
    private JTextField measurement_error_text_filed_max;

    private JButton ok_button;
    private JButton cancel_button;

    SearchWindow(DefaultTableModel tableModel){
        this.setTitle("Поиск");
        setSize(350,800);
        setResizable(false);
        setLocation(550,200);

        initLabels();
        initCombo();
        initTextFields();
        initButtons(tableModel);

        initBox1();
        initBox2();

        Box mainbox = Box.createVerticalBox();
        mainbox.add(box1);
        mainbox.add(box2);

        setContentPane(mainbox);
    }
    private void initLabels(){
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

        from_label1 = new JLabel("От");
        to_label1 = new JLabel("До");
        from_label2 = new JLabel("От");
        to_label2 = new JLabel("До");
        from_label3 = new JLabel("От");
        to_label3 = new JLabel("До");
        from_label4 = new JLabel("От");
        to_label4 = new JLabel("До");
        from_label5 = new JLabel("От");
        to_label5 = new JLabel("До");
        from_label6 = new JLabel("От");
        to_label6 = new JLabel("До");
    }

    private void initCombo(){
        sensor_type_combo = new JComboBox(new String[]{"", "ММА", "ММГ"});
        product_type_combo = new JComboBox(new String[]{"","Микромодуль", "Изделие"});
        integrated_circuit_type_combo = new JComboBox(new String[]{"","Sina", "Sara"});
        initial_settings_combo = new JComboBox(new String[]{"","Не проходил", "Проходит", "Прошел", "Не прошел"});
        preliminary_tests_combo = new JComboBox(new String[]{"","Не проходил", "Проходит", "Прошел", "Не прошел"});
        calibration_combo = new JComboBox(new String[]{"","Не проходил", "Проходит", "Прошел", "Не прошел"});
        verification_tests_combo = new JComboBox(new String[]{"","Не проходил", "Проходит", "Прошел", "Не прошел"});
        allan_variance_and_noise_combo = new JComboBox(new String[]{"","Не проходил", "Проходит", "Прошел", "Не прошел"});
        ready_combo = new JComboBox(new String[]{"","Не готов", "Готов"});

    }

    private void initTextFields(){
        chip_name_text_filed = new JTextField(20);
        zero_offset_text_filed_min = new JTextField(20);
        zero_offset_text_filed_max = new JTextField(20);
        coefficient_of_transformation_text_filed_min = new JTextField(20);
        coefficient_of_transformation_text_filed_max = new JTextField(20);
        nonlinearity_of_calibration_characteristic_text_filed_min = new JTextField(20);
        nonlinearity_of_calibration_characteristic_text_filed_max = new JTextField(20);
        conversion_factor_change_text_filed_min = new JTextField(20);
        conversion_factor_change_text_filed_max = new JTextField(20);
        zero_offset_change_text_filed_min = new JTextField(20);
        zero_offset_change_text_filed_max = new JTextField(20);
        measurement_error_text_filed_min = new JTextField(20);
        measurement_error_text_filed_max = new JTextField(20);
    }

    private void initButtons(DefaultTableModel tableModel){
        ok_button = new JButton("Найти");
        cancel_button = new JButton("Отменить");

        ok_button.addActionListener(e -> {
            String query = createQuery();
            if(query == null) {
                JOptionPane.showMessageDialog(null, "Должно быть заполнено минимум одно поле");
                return;
            }
            ArrayList<Chip> listOfChips = null;
            listOfChips = MainWindow.dataBase.getChipsByParams(query);
            if(listOfChips == null) {
                JOptionPane.showMessageDialog(null, "Ничего не найдено");
                return;
            }

            clearTable(tableModel);
            fillTable(tableModel, listOfChips);

            dispose();
        });

        cancel_button.addActionListener(e -> dispose());
    }

    private void initBox1(){
        box1 = Box.createVerticalBox();

        box1.add(chip_name_label);
        box1.add(chip_name_text_filed);
        box1.add(Box.createVerticalStrut(10));

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
        Box box_h1 = Box.createHorizontalBox();
        box_h1.add(from_label1);
        box_h1.add(zero_offset_text_filed_min);
        box_h1.add(to_label1);
        box_h1.add(zero_offset_text_filed_max);
        box1.add(box_h1);
        box1.add(Box.createVerticalStrut(10));

        box1.add(coefficient_of_transformation_label);
        Box box_h2 = Box.createHorizontalBox();
        box_h2.add(from_label2);
        box_h2.add(coefficient_of_transformation_text_filed_min);
        box_h2.add(to_label2);
        box_h2.add(coefficient_of_transformation_text_filed_max);
        box1.add(box_h2);
        box1.add(Box.createVerticalStrut(10));

        box1.add(nonlinearity_of_calibration_characteristic_label);
        Box box_h3 = Box.createHorizontalBox();
        box_h3.add(from_label3);
        box_h3.add(nonlinearity_of_calibration_characteristic_text_filed_min);
        box_h3.add(to_label3);
        box_h3.add(nonlinearity_of_calibration_characteristic_text_filed_max);
        box1.add(box_h3);
        box1.add(Box.createVerticalStrut(10));

        box1.add(conversion_factor_change_label);
        Box box_h4 = Box.createHorizontalBox();
        box_h4.add(from_label4);
        box_h4.add(conversion_factor_change_text_filed_min);
        box_h4.add(to_label4);
        box_h4.add(conversion_factor_change_text_filed_max);
        box1.add(box_h4);
        box1.add(Box.createVerticalStrut(10));

        box1.add(zero_offset_change_label);
        Box box_h5 = Box.createHorizontalBox();
        box_h5.add(from_label5);
        box_h5.add(zero_offset_change_text_filed_min);
        box_h5.add(to_label5);
        box_h5.add(zero_offset_change_text_filed_max);
        box1.add(box_h5);
        box1.add(Box.createVerticalStrut(10));

        box1.add(measurement_error_label);
        Box box_h6 = Box.createHorizontalBox();
        box_h6.add(from_label6);
        box_h6.add(measurement_error_text_filed_min);
        box_h6.add(to_label6);
        box_h6.add(measurement_error_text_filed_max);
        box1.add(box_h6);
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

    private String createQuery(){
        boolean first = true;
        String query = "SELECT * FROM tests WHERE ";
        if(!chip_name_text_filed.getText().isEmpty()) {
            if(first)
                first = false;
            query += "chip_name = " + "\"" + chip_name_text_filed.getText() + "\"";
        }

        if(!sensor_type_combo.getSelectedItem().toString().isEmpty()) {
            if (first)
                first = false;
            else query += " AND ";
            query += "sensor_type = " + "\"" + sensor_type_combo.getSelectedItem().toString() + "\"";
        }

        if(!product_type_combo.getSelectedItem().toString().isEmpty()) {
            if(first)
                first = false;
            else query+=" AND ";
            query += "product_type = " + "\"" + product_type_combo.getSelectedItem().toString() + "\"";
        }

        if(!integrated_circuit_type_combo.getSelectedItem().toString().isEmpty()) {
            if(first)
                first = false;
            else query+=" AND ";
            query += "integrated_circuit_type = " + "\"" + integrated_circuit_type_combo.getSelectedItem().toString() + "\"";
        }

        if(!initial_settings_combo.getSelectedItem().toString().isEmpty()) {
            if(first)
                first = false;
            else query+=" AND ";
            query += "initial_settings = " + "\"" + initial_settings_combo.getSelectedItem().toString() + "\"";
        }

        if(!preliminary_tests_combo.getSelectedItem().toString().isEmpty()) {
            if(first)
                first = false;
            else query+=" AND ";
            query += "preliminary_tests = " + "\"" + preliminary_tests_combo.getSelectedItem().toString() + "\"";
        }

        if(!calibration_combo.getSelectedItem().toString().isEmpty()) {
            if(first)
                first = false;
            else query+=" AND ";
            query += "calibration = " + "\"" + calibration_combo.getSelectedItem().toString() + "\"";
        }

        if(!verification_tests_combo.getSelectedItem().toString().isEmpty()) {
            if(first)
                first = false;
            else query+=" AND ";
            query += "verification_tests = " + "\"" + verification_tests_combo.getSelectedItem().toString() + "\"";
        }

        if(!allan_variance_and_noise_combo.getSelectedItem().toString().isEmpty()) {
            if(first)
                first = false;
            else query+=" AND ";
            query += "allan_variance_and_noise = " + "\"" + allan_variance_and_noise_combo.getSelectedItem().toString() + "\"";
        }

        if(!ready_combo.getSelectedItem().toString().isEmpty()) {
            if(first)
                first = false;
            else query+=" AND ";
            query += "ready = " + "\"" + ready_combo.getSelectedItem().toString() + "\"";
        }

        if(!zero_offset_text_filed_min.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="zero_offset > "+"\""+zero_offset_text_filed_min.getText()+"\"";
        }

        if(!zero_offset_text_filed_max.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="zero_offset < "+"\""+zero_offset_text_filed_max.getText()+"\"";
        }

        if(!coefficient_of_transformation_text_filed_min.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="coefficient_of_transformation > "+"\""+coefficient_of_transformation_text_filed_min.getText()+"\"";
        }

        if(!coefficient_of_transformation_text_filed_max.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="coefficient_of_transformation < "+"\""+coefficient_of_transformation_text_filed_max.getText()+"\"";
        }

        if(!nonlinearity_of_calibration_characteristic_text_filed_min.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="nonlinearity_of_calibration_characteristic > "+"\""+nonlinearity_of_calibration_characteristic_text_filed_min.getText()+"\"";
        }

        if(!nonlinearity_of_calibration_characteristic_text_filed_max.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="nonlinearity_of_calibration_characteristic < "+"\""+nonlinearity_of_calibration_characteristic_text_filed_max.getText()+"\"";
        }

        if(!conversion_factor_change_text_filed_min.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="conversion_factor_change > "+"\""+conversion_factor_change_text_filed_min.getText()+"\"";
        }

        if(!conversion_factor_change_text_filed_max.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="conversion_factor_change < "+"\""+conversion_factor_change_text_filed_max.getText()+"\"";
        }

        if(!zero_offset_change_text_filed_min.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="zero_offset_change > "+"\""+zero_offset_change_text_filed_min.getText()+"\"";
        }

        if(!zero_offset_change_text_filed_max.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="zero_offset_change < "+"\""+zero_offset_change_text_filed_max.getText()+"\"";
        }

        if(!measurement_error_text_filed_min.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="measurement_error > "+"\""+measurement_error_text_filed_min.getText()+"\"";
        }

        if(!measurement_error_text_filed_max.getText().isEmpty()){
            if(first)
                first = false;
            else query+=" AND ";
            query+="measurement_error < "+"\""+measurement_error_text_filed_max.getText()+"\"";
        }

        if(query.equals("SELECT * FROM tests WHERE "))
            return null;
        return query;
    }

    private void clearTable(DefaultTableModel tableModel){
        for(int i=tableModel.getRowCount()-1; i>=0; i--)
            tableModel.removeRow(i);
    }

    private void fillTable(DefaultTableModel tableModel, ArrayList<Chip> listOfChips){
        for (Chip listOfAllTest : listOfChips) {
            tableModel.addRow(new String[]{listOfAllTest.getChip_name(), listOfAllTest.getSensor_type(),
                    listOfAllTest.getProduct_type(), listOfAllTest.getIntegrated_circuit_type(),
                    listOfAllTest.getInitial_settings(), listOfAllTest.getPreliminary_tests(),
                    listOfAllTest.getCalibration(), listOfAllTest.getVerification_tests(),
                    listOfAllTest.getAllan_variance_and_noise(), listOfAllTest.getReady()});
        }
    }

}
