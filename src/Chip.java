
class Chip {

    private String chip_name;                                   //Название
    private String sensor_type;                                 //ММА или ММГ
    private String product_type;                                //Изделие или микромодуль
    private String integrated_circuit_type;                     //Тип нтегральной схемы: Sina или Sara
    private String initial_settings;                            //Первоначальная настройка
    private String preliminary_tests;                           //Предварительные испытания
    private String calibration;                                 //Калибровка
    private String verification_tests;                          //Проверочные испытания
    private String allan_variance_and_noise;                    //Вариации Аллана и шум
    private String ready;                                       //Готовность

    private String zero_offset;                                 //Смещение нуля
    private String coefficient_of_transformation;               //Коэффициент трансформации
    private String nonlinearity_of_calibration_characteristic;  //Нелинейность градуировочной характеристики
    private String conversion_factor_change;                    //Изменение коэффициента преобразования
    private String zero_offset_change;                          //Изменение смещения нуля
    private String measurement_error;                           //Погрешность измерения

    Chip(String chip_name, String sensor_type, String product_type, String integrated_circuit_type,
         String initial_settings, String preliminary_tests, String calibration,
         String verification_tests, String allan_variance_and_noise, String ready,
         String zero_offset, String coefficient_of_transformation,
         String nonlinearity_of_calibration_characteristic, String conversion_factor_change,
         String zero_offset_change, String measurement_error) {
        this.chip_name = chip_name;
        this.sensor_type = sensor_type;
        this.product_type = product_type;
        this.integrated_circuit_type = integrated_circuit_type;
        this.initial_settings = initial_settings;
        this.preliminary_tests = preliminary_tests;
        this.calibration = calibration;
        this.verification_tests = verification_tests;
        this.allan_variance_and_noise = allan_variance_and_noise;
        this.ready = ready;
        this.zero_offset = zero_offset;
        this.coefficient_of_transformation = coefficient_of_transformation;
        this.nonlinearity_of_calibration_characteristic = nonlinearity_of_calibration_characteristic;
        this.conversion_factor_change = conversion_factor_change;
        this.zero_offset_change = zero_offset_change;
        this.measurement_error = measurement_error;

    }
    public String getChip_name() {
        return chip_name;
    }

    public String getSensor_type() {
        return sensor_type;
    }

    public String getProduct_type() {
        return product_type;
    }

    public String getIntegrated_circuit_type() {
        return integrated_circuit_type;
    }

    public String getInitial_settings() {
        return initial_settings;
    }

    public String getPreliminary_tests() {
        return preliminary_tests;
    }

    public String getCalibration() {
        return calibration;
    }

    public String getVerification_tests() {
        return verification_tests;
    }

    public String getAllan_variance_and_noise() {
        return allan_variance_and_noise;
    }

    public String getReady() {
        return ready;
    }

    public String getZero_offset() {
        return zero_offset;
    }

    public String getCoefficient_of_transformation() {
        return coefficient_of_transformation;
    }

    public String getNonlinearity_of_calibration_characteristic() {
        return nonlinearity_of_calibration_characteristic;
    }

    public String getConversion_factor_change() {
        return conversion_factor_change;
    }

    public String getZero_offset_change() {
        return zero_offset_change;
    }

    public String getMeasurement_error() {
        return measurement_error;
    }
}