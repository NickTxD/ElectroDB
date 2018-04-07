import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

class MainWindow extends JFrame {

    protected static final int ADD = 0;
    protected static final int EDIT = 1;

    private JToolBar toolBar;
    private DefaultTableModel tableModel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JTable tabel;

    private boolean admin;

    static DataBase dataBase;

    MainWindow(boolean access){

        super("База данных испытаний");
        setSize(800,500);
        setLocation(600,300);
        setResizable(false);

        admin=access;

        menuBar=new JMenuBar();
        fileMenu = new JMenu("Файл");
        toolBar= new JToolBar();

        Object[] colum_names={"Название","Тип","Вид","ИС", "ПН", "ПИ", "Калибровка", "Пр.Исп.", "ВАиШ", "Готовность"};
        toolBar = new JToolBar();

        dataBase = new DataBase();

        tableModel = new DefaultTableModel(null, colum_names);
        tabel = new JTable(tableModel);
        for (int c = 0; c < tabel.getColumnCount(); c++){
            Class<?> col_class = tabel.getColumnClass(c);
            tabel.setDefaultEditor(col_class, null);
        }

        tabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int selectedRow = tabel.getRowSorter().convertRowIndexToModel(tabel.getSelectedRow());
                    Chip selectedChip = dataBase.getChipByName(
                            tableModel.getValueAt(selectedRow, 0).toString());
                    SpecsWindow specsWindow = new SpecsWindow(selectedChip);
                    specsWindow.setModal(true);
                    specsWindow.setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        tabel.setAutoCreateRowSorter(true);

        getContentPane().add(toolBar, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(tabel);
        getContentPane().add(scrollPane,BorderLayout.CENTER);

        updateTable();

        this.addWindowListener(new WindowListener() {
            public void windowClosing(WindowEvent event) {
                if (JOptionPane.showConfirmDialog(null,"Хотите выйти?","Сообщение",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                        System.exit(0);
            }
            public void windowActivated(WindowEvent arg0) {	}
            public void windowClosed(WindowEvent arg0) {}
            public void windowDeactivated(WindowEvent arg0) {}
            public void windowDeiconified(WindowEvent arg0) {}

            public void windowIconified(WindowEvent arg0) {}

            public void windowOpened(WindowEvent arg0) {}
        });

        initMenu();
        initBar();

    }

    private void clearTable(){
        for(int i=tableModel.getRowCount()-1; i>=0; i--)
            tableModel.removeRow(i);
    }

    private void updateTable(){
        ArrayList<Chip> listOfAllTests;
        try{
            if(tableModel.getRowCount()>0)
                clearTable();
            listOfAllTests = dataBase.getAllChips();
            if (listOfAllTests == null)
                return;
            for (Chip listOfAllTest : listOfAllTests) {
                tableModel.addRow(new String[]{listOfAllTest.getChip_name(), listOfAllTest.getSensor_type(),
                        listOfAllTest.getProduct_type(), listOfAllTest.getIntegrated_circuit_type(),
                        listOfAllTest.getInitial_settings(), listOfAllTest.getPreliminary_tests(),
                        listOfAllTest.getCalibration(), listOfAllTest.getVerification_tests(),
                        listOfAllTest.getAllan_variance_and_noise(), listOfAllTest.getReady()});
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initBar() {

        JButton editButton = new JButton("Редактировать");
        editButton.setFocusable(false);
        JButton searchButton = new JButton("Поиск");
        searchButton.setFocusable(false);
        JButton addButton = new JButton("Добавить");
        addButton.setFocusable(false);
        JButton deleteButton = new JButton("Удалить");
        deleteButton.setFocusable(false);
        JButton updateButton = new JButton("Обновить");
        updateButton.setFocusable(false);
        JButton statButton = new JButton("Статистика");
        statButton.setFocusable(false);
        toolBar.add(addButton, BorderLayout.NORTH);
        toolBar.add(editButton, BorderLayout.NORTH);
        toolBar.add(deleteButton, BorderLayout.NORTH);
        toolBar.add(searchButton, BorderLayout.NORTH);
        toolBar.add(updateButton, BorderLayout.NORTH);
        toolBar.add(statButton);

        toolBar.add(Box.createHorizontalStrut(300));

        addButton.addActionListener(event -> {
            if(admin){
                EditWindow editWindow = new EditWindow(null, 0);
                editWindow.setModal(true);
                editWindow.setVisible(true);
                updateTable();
            }
            else{
                JOptionPane.showMessageDialog(null,"Нет прав доступа для операции");
            }
        });
        editButton.addActionListener(event -> {
            if(admin){
                int selectedRow = tabel.getRowSorter().convertRowIndexToModel(tabel.getSelectedRow());
                if(selectedRow !=-1) {
                    Chip selectedChip = dataBase.getChipByName(
                            tableModel.getValueAt(selectedRow, 0).toString());
                    EditWindow editWindow = new EditWindow(selectedChip, 1);
                    editWindow.setModal(true);
                    editWindow.setVisible(true);
                    updateTable();
                }
                else
                    JOptionPane.showMessageDialog(null,"Выделите строку для внесения изменений");
            }
            else
                JOptionPane.showMessageDialog(null,"Нет прав доступа для операции");
        });
        deleteButton.addActionListener(event -> {
            if(admin){
                int selectedRow = tabel.getRowSorter().convertRowIndexToModel(tabel.getSelectedRow());
                if(selectedRow !=-1) {
                    dataBase.deleteChipByName(tableModel.getValueAt(selectedRow, 0).toString());
                    updateTable();
                }else
                    JOptionPane.showMessageDialog(null,"Выделите строку для удаления");
            }else
                JOptionPane.showMessageDialog(null,"Нет прав доступа для операции");
        });
        searchButton.addActionListener(event -> {
            SearchWindow searchWindow = new SearchWindow(tableModel);
            searchWindow.setModal(true);
            searchWindow.setVisible(true);
        });
        updateButton.addActionListener(e -> updateTable());
        statButton.addActionListener(e -> {
            StatWindow statWindow = new StatWindow(dataBase.getAllChips());
            statWindow.setModal(true);
            statWindow.setVisible(true);
        });

        toolBar.setFloatable(false);

    }
    private void initMenu() {

        menuBar.add(fileMenu);
        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);

        JMenuItem open=new JMenuItem("Загрузить из файла");
        open.addActionListener(event -> {
            FileDialog openF = new FileDialog(this,"Открыть",FileDialog.LOAD);
            openF.setVisible(true);
            openF.setModal(true);
            String fileName = openF.getDirectory() + openF.getFile();
            if(fileName != null || fileName.contains("null")) {
                readDataFromFile(fileName);
                updateTable();
            }
        });

        JMenuItem save=new JMenuItem("Сохранить отчет");
        save.addActionListener(event -> {
            FileDialog saveF = new FileDialog(this,"Сохранить",FileDialog.SAVE);
            saveF.setFile("Report.dat");
            saveF.setVisible(true);
            saveF.setModal(true);
            String fileName = saveF.getDirectory() + saveF.getFile();
            if(fileName != null || fileName.contains("null")) {
                saveDataToFile(fileName);
            }
        });

        JMenuItem reLog=new JMenuItem("Сменить пользователя");
        reLog.addActionListener(event -> {
            PasswordWindow h=new PasswordWindow();
            h.setVisible(true);
            dispose();

        });

        JMenuItem exit = new JMenuItem("Выйти");
        exit.addActionListener(event -> {
            if (JOptionPane.showConfirmDialog(null,"Хотите выйти?","Сообщение",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        });

        fileMenu.add(save);
        fileMenu.add(open);
        fileMenu.add(reLog);
        fileMenu.add(exit);

    }

    private void readDataFromFile(String fileName){
        try{

            FileInputStream fileInputStream =  new FileInputStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, "Cp1251"));

            String rawString;
                do{
                rawString = reader.readLine();
                String[] rawSplit;
                if(rawString != null){
                        rawSplit = rawString.split("\\|");
                    dataBase.addChip(new Chip(
                            rawSplit[0], rawSplit[1], rawSplit[2], rawSplit[3],
                            rawSplit[4], rawSplit[5], rawSplit[6], rawSplit[7],
                            rawSplit[8], rawSplit[9], rawSplit[10], rawSplit[11],
                            rawSplit[12], rawSplit[13], rawSplit[14], rawSplit[15]));
                    }

            }while(rawString != null);

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveDataToFile(String fileName){
        try {
            FileOutputStream fileOutputStream =  new FileOutputStream(fileName);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "Cp1251"));
            for(int i=0; i<tableModel.getRowCount(); i++){
                Chip chip = dataBase.getChipByName(String.valueOf(tableModel.getValueAt(i,0)));
                writer.write(chip.getChip_name()+"|"+chip.getSensor_type()+"|"+
                        chip.getProduct_type()+"|"+chip.getIntegrated_circuit_type()+"|"+
                        chip.getInitial_settings()+"|"+chip.getPreliminary_tests()+"|"+
                        chip.getCalibration()+"|"+chip.getVerification_tests()+"|"+
                        chip.getAllan_variance_and_noise()+"|"+chip.getReady()+"|"+
                        chip.getZero_offset()+"|"+chip.getCoefficient_of_transformation()+"|"+
                        chip.getNonlinearity_of_calibration_characteristic()+"|"+
                        chip.getConversion_factor_change()+"|"+chip.getZero_offset_change()+"|"+
                        chip.getMeasurement_error());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
