package edu.iuh.fit.v_banker.services.impl;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.iuh.fit.v_banker.entities.Transaction;
import edu.iuh.fit.v_banker.entities.User;
import edu.iuh.fit.v_banker.repositories.TransactionRepository;
import edu.iuh.fit.v_banker.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class BankStatement {

    private TransactionRepository transactionRepository;
    private UserRepository userRepository;

    private static final String FILE = System.getProperty("user.home") + "/Desktop/MysStatement.pdf";

    /*
    * retrieve list of transactions within a date range for a given account number
    * generate a pdf file for the transactions
    * send the file via email
    */

    public List<Transaction> generateStatement(String accountNumber, LocalDateTime startDate, LocalDateTime endDate) throws FileNotFoundException, DocumentException {
        List<Transaction> transactions = transactionRepository.findTransactionsByTransactionDateBetween(startDate, endDate);
        User user = userRepository.findByAccountNumber(accountNumber);
        String customerName = user.getFirstName() + " " + user.getLastName();

        Rectangle statementSize = new Rectangle(PageSize.A4);
        Document document = new Document(statementSize);
        OutputStream outputStream = new FileOutputStream(FILE);
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Bank Info Table
        PdfPTable bankInfoTable = new PdfPTable(1);
        PdfPCell bankName = new PdfPCell(new Phrase("V-Banker", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE)));
        bankName.setBorder(0);
        bankName.setBackgroundColor(BaseColor.BLUE);
        bankName.setPadding(10f);
        bankName.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell bankAddress = new PdfPCell(new Phrase("12 Nguyen Van Bao, Ward 4, Go Vap District, Ho Chi Minh City"));
        bankAddress.setBorder(0);
        bankAddress.setPadding(5f);
        bankAddress.setHorizontalAlignment(Element.ALIGN_CENTER);

        bankInfoTable.addCell(bankName);
        bankInfoTable.addCell(bankAddress);

        // Statement Info Table
        PdfPTable statementInfo = new PdfPTable(2);
        statementInfo.setWidthPercentage(100);
        PdfPCell statementTitle = new PdfPCell(new Phrase("STATEMENT OF ACCOUNT", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
        statementTitle.setColspan(2);
        statementTitle.setBorder(0);
        statementTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
        statementTitle.setPadding(10f);

        PdfPCell startDateCell = new PdfPCell(new Phrase("Start Date: " + startDate.toLocalDate()));
        startDateCell.setBorder(0);
        PdfPCell endDateCell = new PdfPCell(new Phrase("End Date: " + endDate.toLocalDate()));
        endDateCell.setBorder(0);

        PdfPCell name = new PdfPCell(new Phrase("Customer Name: " + customerName));
        name.setBorder(0);
        PdfPCell address = new PdfPCell(new Phrase("Customer Address: " + user.getAddress()));
        address.setBorder(0);

        statementInfo.addCell(statementTitle);
        statementInfo.addCell(startDateCell);
        statementInfo.addCell(endDateCell);
        statementInfo.addCell(name);
        statementInfo.addCell(address);

        // Transaction Table
        PdfPTable transactionTable = new PdfPTable(4);
        transactionTable.setWidthPercentage(100);

        PdfPCell date = new PdfPCell(new Phrase("Date", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
        date.setBackgroundColor(BaseColor.LIGHT_GRAY);
        date.setPadding(5f);

        PdfPCell transactionType = new PdfPCell(new Phrase("Transaction Type", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
        transactionType.setBackgroundColor(BaseColor.LIGHT_GRAY);
        transactionType.setPadding(5f);

        PdfPCell transactionAmount = new PdfPCell(new Phrase("Transaction Amount", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
        transactionAmount.setBackgroundColor(BaseColor.LIGHT_GRAY);
        transactionAmount.setPadding(5f);

        PdfPCell status = new PdfPCell(new Phrase("Status", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
        status.setBackgroundColor(BaseColor.LIGHT_GRAY);
        status.setPadding(5f);

        transactionTable.addCell(date);
        transactionTable.addCell(transactionType);
        transactionTable.addCell(transactionAmount);
        transactionTable.addCell(status);

        transactions.forEach(transaction -> {
            transactionTable.addCell(new Phrase(transaction.getTransactionDate().toString()));
            transactionTable.addCell(new Phrase(transaction.getTransactionType()));
            transactionTable.addCell(new Phrase(transaction.getAmount().toString()));
            transactionTable.addCell(new Phrase(transaction.getStatus()));
        });

        // Add tables to document
        document.add(bankInfoTable);
        document.add(new Phrase("\n"));
        document.add(statementInfo);
        document.add(new Phrase("\n"));
        document.add(transactionTable);

        document.close();

        return transactions;
    }




}
