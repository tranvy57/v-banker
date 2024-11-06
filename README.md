# Dự án V-Banker

## Giới thiệu
Dự án V-Banker là một ứng dụng quản lý tài khoản ngân hàng mini, cung cấp các API để thực hiện các thao tác đơn giản như đăng nhập, tạo tài khoản, truy vấn số dư, chuyển khoản, và gửi email thông báo.

## Công nghệ sử dụng
- Java
- Spring Boot
- Maven
- MySQL
- Jakarta Mail
- Swagger UI 

## Cài đặt và chạy dự án

### Yêu cầu hệ thống
- JDK 11 trở lên
- Maven 3.6 trở lên
- MySQL 5.7 trở lên

### Cài đặt
1. Clone repository:
    ```bash
    git clone [<repository-url>](https://github.com/tranvy57/v-banker.git)
    cd v-banker
    ```

2. Cấu hình cơ sở dữ liệu:
    - Tạo một cơ sở dữ liệu MySQL mới.
    - Cập nhật thông tin kết nối cơ sở dữ liệu trong file `src/main/resources/application.properties`:
        ```ini
        spring.datasource.url=jdbc:mysql://localhost:3307/v_banker
        spring.datasource.username=<your-username>
        spring.datasource.password=<your-password>
        ```

3. Cấu hình email:
    - Cập nhật thông tin email trong file `src/main/resources/application.properties`:
        ```ini
        spring.mail.username=<your-email>
        spring.mail.password=<your-email-password>
        ```

4. Cài đặt các dependencies:
    ```bash
    mvn clean install
    ```

### Chạy dự án
1. Chạy ứng dụng Spring Boot:
    ```bash
    mvn spring-boot:run
    ```

2. Truy cập Swagger UI để kiểm tra các API:
    ```
    http://localhost:8080/swagger-ui.html
    ```

## Các API chính

