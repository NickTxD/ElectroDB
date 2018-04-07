import javax.swing.*;
import java.util.ArrayList;

class StatWindow extends JDialog{

    private Box box1;
    private Box box2;
    private Box box3;
    private Box box4;
    private Box box5;
    private Box box6;
    private Box box7;

    private JLabel initial_settings_label;
    private JLabel preliminary_tests_label;
    private JLabel calibration_label;
    private JLabel verification_tests_label;
    private JLabel allan_variance_and_noise_label;
    private JLabel ready_label;

    private JLabel not_pass1;
    private JLabel not_pass2;
    private JLabel not_pass3;
    private JLabel not_pass4;
    private JLabel not_pass5;

    private JLabel passes1;
    private JLabel passes2;
    private JLabel passes3;
    private JLabel passes4;
    private JLabel passes5;

    private JLabel passed1;
    private JLabel passed2;
    private JLabel passed3;
    private JLabel passed4;
    private JLabel passed5;

    private JLabel failed1;
    private JLabel failed2;
    private JLabel failed3;
    private JLabel failed4;
    private JLabel failed5;

    private JLabel ready;
    private JLabel not_ready;

    private JTextField initial_settings_text_field1;
    private JTextField initial_settings_text_field2;
    private JTextField initial_settings_text_field3;
    private JTextField initial_settings_text_field4;

    private JTextField preliminary_tests_text_field1;
    private JTextField preliminary_tests_text_field2;
    private JTextField preliminary_tests_text_field3;
    private JTextField preliminary_tests_text_field4;

    private JTextField calibration_text_field1;
    private JTextField calibration_text_field2;
    private JTextField calibration_text_field3;
    private JTextField calibration_text_field4;

    private JTextField verification_tests_text_field1;
    private JTextField verification_tests_text_field2;
    private JTextField verification_tests_text_field3;
    private JTextField verification_tests_text_field4;

    private JTextField allan_variance_and_noise_text_field1;
    private JTextField allan_variance_and_noise_text_field2;
    private JTextField allan_variance_and_noise_text_field3;
    private JTextField allan_variance_and_noise_text_field4;

    private JTextField ready_text_field1;
    private JTextField ready_text_field2;

    private JButton cancel_button;

    StatWindow(ArrayList<Chip> chips){
        this.setTitle("Статистика");
        setSize(400,400);
        setResizable(false);
        setLocation(550,200);

        initLabels();
        initTextFields();
        fillTextFiled(chips);
        initButtons();

        initBox1();
        initBox2();
        initBox3();
        initBox4();
        initBox5();
        initBox6();
        initBox7();

        Box mainbox = Box.createVerticalBox();
        mainbox.add(box1);
        mainbox.add(box2);
        mainbox.add(box3);
        mainbox.add(box4);
        mainbox.add(box5);
        mainbox.add(box6);
        mainbox.add(box7);

        setContentPane(mainbox);
    }

    private void initLabels(){
        initial_settings_label = new JLabel("Первоначальная настройка");
        preliminary_tests_label = new JLabel("Предварительные испытания");
        calibration_label = new JLabel("Калибровка");
        verification_tests_label = new JLabel("Проверочные испытания");
        allan_variance_and_noise_label = new JLabel("Вариации Аллана и шум");
        ready_label = new JLabel("Готовность");

        not_pass1 = new JLabel("Не проходил");
        not_pass2 = new JLabel("Не проходил");
        not_pass3 = new JLabel("Не проходил");
        not_pass4 = new JLabel("Не проходил");
        not_pass5 = new JLabel("Не проходил");

        passes1 = new JLabel("Проходит");
        passes2 = new JLabel("Проходит");
        passes3 = new JLabel("Проходит");
        passes4 = new JLabel("Проходит");
        passes5 = new JLabel("Проходит");

        passed1 = new JLabel("Прошел");
        passed2 = new JLabel("Прошел");
        passed3 = new JLabel("Прошел");
        passed4 = new JLabel("Прошел");
        passed5 = new JLabel("Прошел");

        failed1 = new JLabel("Не прошел");
        failed2 = new JLabel("Не прошел");
        failed3 = new JLabel("Не прошел");
        failed4 = new JLabel("Не прошел");
        failed5 = new JLabel("Не прошел");

        ready = new JLabel("Готов");
        not_ready = new JLabel("Не готов");
    }

    private void initTextFields(){
        initial_settings_text_field1 = new JTextField(20);
        initial_settings_text_field2 = new JTextField(20);
        initial_settings_text_field3 = new JTextField(20);
        initial_settings_text_field4 = new JTextField(20);
        initial_settings_text_field1.setEditable(false);
        initial_settings_text_field2.setEditable(false);
        initial_settings_text_field3.setEditable(false);
        initial_settings_text_field4.setEditable(false);

        preliminary_tests_text_field1 = new JTextField(20);
        preliminary_tests_text_field2 = new JTextField(20);
        preliminary_tests_text_field3 = new JTextField(20);
        preliminary_tests_text_field4 = new JTextField(20);
        preliminary_tests_text_field1.setEditable(false);
        preliminary_tests_text_field2.setEditable(false);
        preliminary_tests_text_field3.setEditable(false);
        preliminary_tests_text_field4.setEditable(false);

        calibration_text_field1 = new JTextField(20);
        calibration_text_field2 = new JTextField(20);
        calibration_text_field3 = new JTextField(20);
        calibration_text_field4 = new JTextField(20);
        calibration_text_field1.setEditable(false);
        calibration_text_field2.setEditable(false);
        calibration_text_field3.setEditable(false);
        calibration_text_field4.setEditable(false);

        verification_tests_text_field1 = new JTextField(20);
        verification_tests_text_field2 = new JTextField(20);
        verification_tests_text_field3 = new JTextField(20);
        verification_tests_text_field4 = new JTextField(20);
        verification_tests_text_field1.setEditable(false);
        verification_tests_text_field2.setEditable(false);
        verification_tests_text_field3.setEditable(false);
        verification_tests_text_field4.setEditable(false);

        allan_variance_and_noise_text_field1 = new JTextField(20);
        allan_variance_and_noise_text_field2 = new JTextField(20);
        allan_variance_and_noise_text_field3 = new JTextField(20);
        allan_variance_and_noise_text_field4 = new JTextField(20);
        allan_variance_and_noise_text_field1.setEditable(false);
        allan_variance_and_noise_text_field2.setEditable(false);
        allan_variance_and_noise_text_field3.setEditable(false);
        allan_variance_and_noise_text_field4.setEditable(false);

        ready_text_field1 = new JTextField(20);
        ready_text_field2 = new JTextField(20);
        ready_text_field1.setEditable(false);
        ready_text_field2.setEditable(false);
    }

    private void fillTextFiled(ArrayList<Chip> chips){

        int initial_settings1 = 0;
        int initial_settings2 = 0;
        int initial_settings3 = 0;
        int initial_settings4 = 0;

        int preliminary_tests1 = 0;
        int preliminary_tests2 = 0;
        int preliminary_tests3 = 0;
        int preliminary_tests4 = 0;

        int calibration1 = 0;
        int calibration2 = 0;
        int calibration3 = 0;
        int calibration4 = 0;

        int verification_tests1 = 0;
        int verification_tests2 = 0;
        int verification_tests3 = 0;
        int verification_tests4 = 0;

        int allan_variance_and_noise1 = 0;
        int allan_variance_and_noise2 = 0;
        int allan_variance_and_noise3 = 0;
        int allan_variance_and_noise4 = 0;

        int ready1 = 0;
        int ready2 = 0;

        for (Chip chip : chips) {
            switch (chip.getInitial_settings()) {
                case "Не проходил":
                    initial_settings1+=1;
                    break;
                case "Проходит":
                    initial_settings2+=1;
                    break;
                case "Прошел":
                    initial_settings3+=1;
                    break;
                case "Не прошел":
                    initial_settings4+=1;
                    break;
            }
            switch (chip.getPreliminary_tests()) {
                case "Не проходил":
                    preliminary_tests1+=1;
                    break;
                case "Проходит":
                    preliminary_tests2+=1;
                    break;
                case "Прошел":
                    preliminary_tests3+=1;
                    break;
                case "Не прошел":
                    preliminary_tests4+=1;
                    break;
            }
            switch (chip.getCalibration()) {
                case "Не проходил":
                    calibration1+=1;
                    break;
                case "Проходит":
                    calibration2+=1;
                    break;
                case "Прошел":
                    calibration3+=1;
                    break;
                case "Не прошел":
                    calibration4+=1;
                    break;
            }
            switch (chip.getVerification_tests()) {
                case "Не проходил":
                    verification_tests1+=1;
                    break;
                case "Проходит":
                    verification_tests2+=1;
                    break;
                case "Прошел":
                    verification_tests3+=1;
                    break;
                case "Не прошел":
                    verification_tests4+=1;
                    break;
            }
            switch (chip.getAllan_variance_and_noise()) {
                case "Не проходил":
                    allan_variance_and_noise1+=1;
                    break;
                case "Проходит":
                    allan_variance_and_noise2+=1;
                    break;
                case "Прошел":
                    allan_variance_and_noise3+=1;
                    break;
                case "Не прошел":
                    allan_variance_and_noise4+=1;
                    break;
            }
            switch (chip.getReady()) {
                case "Не готов":
                    ready1+=1;
                    break;
                case "Готов":
                    ready2+=1;
                    break;
            }
        }

        initial_settings_text_field1.setText(String.valueOf(initial_settings1));
        initial_settings_text_field2.setText(String.valueOf(initial_settings2));
        initial_settings_text_field3.setText(String.valueOf(initial_settings3));
        initial_settings_text_field4.setText(String.valueOf(initial_settings4));

        preliminary_tests_text_field1.setText(String.valueOf(preliminary_tests1));
        preliminary_tests_text_field2.setText(String.valueOf(preliminary_tests2));
        preliminary_tests_text_field3.setText(String.valueOf(preliminary_tests3));
        preliminary_tests_text_field4.setText(String.valueOf(preliminary_tests4));

        calibration_text_field1.setText(String.valueOf(calibration1));
        calibration_text_field2.setText(String.valueOf(calibration2));
        calibration_text_field3.setText(String.valueOf(calibration3));
        calibration_text_field4.setText(String.valueOf(calibration4));

        verification_tests_text_field1.setText(String.valueOf(verification_tests1));
        verification_tests_text_field2.setText(String.valueOf(verification_tests2));
        verification_tests_text_field3.setText(String.valueOf(verification_tests3));
        verification_tests_text_field4.setText(String.valueOf(verification_tests4));

        allan_variance_and_noise_text_field1.setText(String.valueOf(allan_variance_and_noise1));
        allan_variance_and_noise_text_field2.setText(String.valueOf(allan_variance_and_noise2));
        allan_variance_and_noise_text_field3.setText(String.valueOf(allan_variance_and_noise3));
        allan_variance_and_noise_text_field4.setText(String.valueOf(allan_variance_and_noise4));

        ready_text_field1.setText(String.valueOf(ready1));
        ready_text_field2.setText(String.valueOf(ready2));
    }

    private void initButtons(){
        cancel_button = new JButton("Закрыть");
        cancel_button.addActionListener(e -> dispose());
    }

    private void initBox1(){

        Box box1_1_1 = Box.createVerticalBox();
        box1_1_1.add(not_pass1);
        box1_1_1.add(initial_settings_text_field1);
        Box box1_1_2 = Box.createVerticalBox();
        box1_1_2.add(passes1);
        box1_1_2.add(initial_settings_text_field2);
        Box box1_1_3 = Box.createVerticalBox();
        box1_1_3.add(passed1);
        box1_1_3.add(initial_settings_text_field3);
        Box box1_1_4 = Box.createVerticalBox();
        box1_1_4.add(failed1);
        box1_1_4.add(initial_settings_text_field4);

        Box box1_1 = Box.createHorizontalBox();
        box1_1.add(Box.createHorizontalStrut(30));
        box1_1.add(box1_1_1);
        box1_1.add(Box.createHorizontalStrut(30));
        box1_1.add(box1_1_2);
        box1_1.add(Box.createHorizontalStrut(30));
        box1_1.add(box1_1_3);
        box1_1.add(Box.createHorizontalStrut(30));
        box1_1.add(box1_1_4);
        box1_1.add(Box.createHorizontalStrut(30));

        box1 = Box.createVerticalBox();
        box1.add(initial_settings_label);
        box1.add(box1_1);
    }

    private void initBox2(){
        Box box2_1_1 = Box.createVerticalBox();
        box2_1_1.add(not_pass2);
        box2_1_1.add(preliminary_tests_text_field1);
        Box box2_1_2 = Box.createVerticalBox();
        box2_1_2.add(passes2);
        box2_1_2.add(preliminary_tests_text_field2);
        Box box2_1_3 = Box.createVerticalBox();
        box2_1_3.add(passed2);
        box2_1_3.add(preliminary_tests_text_field3);
        Box box2_1_4 = Box.createVerticalBox();
        box2_1_4.add(failed2);
        box2_1_4.add(preliminary_tests_text_field4);

        Box box2_1 = Box.createHorizontalBox();
        box2_1.add(Box.createHorizontalStrut(30));
        box2_1.add(box2_1_1);
        box2_1.add(Box.createHorizontalStrut(30));
        box2_1.add(box2_1_2);
        box2_1.add(Box.createHorizontalStrut(30));
        box2_1.add(box2_1_3);
        box2_1.add(Box.createHorizontalStrut(30));
        box2_1.add(box2_1_4);
        box2_1.add(Box.createHorizontalStrut(30));

        box2 = Box.createVerticalBox();
        box2.add(preliminary_tests_label);
        box2.add(box2_1);
    }

    private void initBox3(){
        Box box3_1_1 = Box.createVerticalBox();
        box3_1_1.add(not_pass3);
        box3_1_1.add(calibration_text_field1);
        Box box3_1_2 = Box.createVerticalBox();
        box3_1_2.add(passes3);
        box3_1_2.add(calibration_text_field2);
        Box box3_1_3 = Box.createVerticalBox();
        box3_1_3.add(passed3);
        box3_1_3.add(calibration_text_field3);
        Box box3_1_4 = Box.createVerticalBox();
        box3_1_4.add(failed3);
        box3_1_4.add(calibration_text_field4);

        Box box3_1 = Box.createHorizontalBox();
        box3_1.add(Box.createHorizontalStrut(30));
        box3_1.add(box3_1_1);
        box3_1.add(Box.createHorizontalStrut(30));
        box3_1.add(box3_1_2);
        box3_1.add(Box.createHorizontalStrut(30));
        box3_1.add(box3_1_3);
        box3_1.add(Box.createHorizontalStrut(30));
        box3_1.add(box3_1_4);
        box3_1.add(Box.createHorizontalStrut(30));

        box3 = Box.createVerticalBox();
        box3.add(calibration_label);
        box3.add(box3_1);
    }

    private void initBox4(){
        Box box4_1_1 = Box.createVerticalBox();
        box4_1_1.add(not_pass4);
        box4_1_1.add(verification_tests_text_field1);
        Box box4_1_2 = Box.createVerticalBox();
        box4_1_2.add(passes4);
        box4_1_2.add(verification_tests_text_field2);
        Box box4_1_3 = Box.createVerticalBox();
        box4_1_3.add(passed4);
        box4_1_3.add(verification_tests_text_field3);
        Box box4_1_4 = Box.createVerticalBox();
        box4_1_4.add(failed4);
        box4_1_4.add(verification_tests_text_field4);

        Box box4_1 = Box.createHorizontalBox();
        box4_1.add(Box.createHorizontalStrut(30));
        box4_1.add(box4_1_1);
        box4_1.add(Box.createHorizontalStrut(30));
        box4_1.add(box4_1_2);
        box4_1.add(Box.createHorizontalStrut(30));
        box4_1.add(box4_1_3);
        box4_1.add(Box.createHorizontalStrut(30));
        box4_1.add(box4_1_4);
        box4_1.add(Box.createHorizontalStrut(30));

        box4 = Box.createVerticalBox();
        box4.add(verification_tests_label);
        box4.add(box4_1);
    }

    private void initBox5(){
        Box box5_1_1 = Box.createVerticalBox();
        box5_1_1.add(not_pass5);
        box5_1_1.add(allan_variance_and_noise_text_field1);
        Box box5_1_2 = Box.createVerticalBox();
        box5_1_2.add(passes5);
        box5_1_2.add(allan_variance_and_noise_text_field2);
        Box box5_1_3 = Box.createVerticalBox();
        box5_1_3.add(passed5);
        box5_1_3.add(allan_variance_and_noise_text_field3);
        Box box5_1_4 = Box.createVerticalBox();
        box5_1_4.add(failed5);
        box5_1_4.add(allan_variance_and_noise_text_field4);

        Box box5_1 = Box.createHorizontalBox();
        box5_1.add(Box.createHorizontalStrut(30));
        box5_1.add(box5_1_1);
        box5_1.add(Box.createHorizontalStrut(30));
        box5_1.add(box5_1_2);
        box5_1.add(Box.createHorizontalStrut(30));
        box5_1.add(box5_1_3);
        box5_1.add(Box.createHorizontalStrut(30));
        box5_1.add(box5_1_4);
        box5_1.add(Box.createHorizontalStrut(30));

        box5 = Box.createVerticalBox();
        box5.add(allan_variance_and_noise_label);
        box5.add(box5_1);
    }

    private void initBox6(){
        Box box6_1_1 = Box.createVerticalBox();
        box6_1_1.add(not_ready);
        box6_1_1.add(ready_text_field1);
        Box box6_1_2 = Box.createVerticalBox();
        box6_1_2.add(ready);
        box6_1_2.add(ready_text_field2);

        Box box6_1 = Box.createHorizontalBox();
        box6_1.add(Box.createHorizontalStrut(30));
        box6_1.add(box6_1_1);
        box6_1.add(Box.createHorizontalStrut(100));
        box6_1.add(box6_1_2);
        box6_1.add(Box.createHorizontalStrut(30));

        box6 = Box.createVerticalBox();
        box6.add(ready_label);
        box6.add(box6_1);
    }

    private void initBox7(){
        box7 = Box.createHorizontalBox();

        box7.add(Box.createHorizontalStrut(150));
        box7.add(cancel_button);
        box7.add(Box.createVerticalStrut(10));
    }
}
