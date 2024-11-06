package edu.iuh.fit.v_banker.services;

import edu.iuh.fit.v_banker.dto.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
    void sendEmailWithAttachment(EmailDetails emailDetails);
}
