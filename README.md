# Dự án V-Banker

## Giới thiệu
Dự án V-Banker là một ứng dụng quản lý tài khoản ngân hàng mini, cung cấp các API để thực hiện các thao tác như đăng nhập, tạo tài khoản, truy vấn số dư, chuyển khoản, và gửi email thông báo.

## Công nghệ sử dụng
- Java
- Spring Boot
- Spring Security
- Maven
- MySQL
- Jakarta Mail

## Cài đặt và chạy dự án

### Yêu cầu hệ thống
- JDK 11 trở lên
- Maven 3.6 trở lên
- MySQL 5.7 trở lên

### Cài đặt
1. Clone repository:
    ```bash
    git clone https://github.com/tranvy57/v-banker.git
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

2. Sử dụng postman hoặc trình duyệt để truy cập vào các API.


## Các API chính

### Users

| Phương thức | Url                 | Mô tả                          | Request Body / Params     |    
|-------------|---------------------|--------------------------------|---------------------------|
| POST        | /api/user           | Tạo tài khoản mới              | [JSON](#create-user)      |
| POST        | /api/login          | Đăng nhập (token)              | [JSON](#login)            |
| GET         | /api/balanceEnquiry | Kiểm tra số dư                 | [Param](#balanceEnquiry)  |
| POST        | /api/credit         | Thêm tiền vào tài khoản        | [JSON](#credit-and-debit) |
| POST        | /api/debit          | Trừ tiền trong tài khoản       | [JSON](#credit-and-debit) |
| POST        | /api/transfer       | Chuyển tiền giữa các tài khoản | [JSON](#transfer)         |


### Statements
| Phương thức | Url              | Mô tả                    | Request Body / Params |    
|-------------|------------------|--------------------------|-----------------------|
| GET         | /bankStatement   | Gửi bảng sao kê về email | [Param](#createUser)  |

## Mẫu request

##### <a id="create-user">Create user-> /api/user </a>
```json
{
   "firstName": "Tran",
   "lastName": "Vy",
   "otherName": "Thi Thuy",
   "gender": "Female",
   "address": "Go Vap",
   "email": "a@gmail",
   "password": "1234",
   "phoneNumber": "0962527550",
   "alternativePhoneNumber": "01233444"
}
```

##### <a id="login">Login -> /api/login </a>
```json
{
   "email": "tranvy.art@gmail.com",
   "password": "1234"
}
```
##### <a id="balanceEnquiry">Balance Enquiry -> /api/balanceEnquiry</a>
```json
{
   "accountNumber" : "123456789" 
}
```

##### <a id="credit-and-debit">Credit and Debit -> /api/transfer </a>
```json
{
   "accountNumber": "123456789",
   "amount": 1000
}
```

##### <a id="transfer">Transfer -> /api/transfer </a>
```json

{
   "sourceAccountNumber": "2024212916",
   "destinationAccountNumber": "2024313662",
   "amount": 5000
}
```




